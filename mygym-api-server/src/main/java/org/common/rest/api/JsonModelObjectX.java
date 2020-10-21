package org.common.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.netu.lib.ApplicationService;
import com.netu.lib.Model.ModelObject;
import com.netu.lib.Model.ModelObjectList;
import com.netu.lib.Model.OracleModelObject;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.Validate;

import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Base class of all modelobjects in the system
 *
 * @author christoforosl
 */
public abstract class JsonModelObjectX extends OracleModelObject {

	private static final Logger LOGGER = Logger.getLogger(JsonModelObjectX.class.getName());

	private Map<String, Object[]> deletedAssociationObjects;

	public JsonModelObjectX() {
		super();
	}

	public Map<String, Object[]> getDeletedAssociationObjects() {
		if(deletedAssociationObjects==null){
			deletedAssociationObjects = new HashMap<>();
		}
		return deletedAssociationObjects;
	}

	@JsonProperty("deletedItems")
	public void setDeletedAssociationObjects(Map<String, Object[]> deletedAssociationObjects) {
		this.deletedAssociationObjects = deletedAssociationObjects;
	}

	private boolean removeAssociatedObject(final String associationKeyName, final Object id) throws Exception {

		final Object association = this.getAttribute(associationKeyName);
		Validate.isTrue(association instanceof ModelObjectList, 
				MessageFormat.format("Association with name \"{0}\"must be an instance of ModelObjectList", associationKeyName));
		final ModelObjectList assList = (ModelObjectList) association;
		if(assList.getModelObjectById(id)!=null) {
			assList.removeModelObjectById(id);
			return true;
		}
		final Class<? extends ModelObject> relatedModelObjectDataType = this.getRelatedModelObjectDataType(associationKeyName);
		Validate.notNull(relatedModelObjectDataType,
				MessageFormat.format("relatedModelObjectDataType of Association \"{0}\" returned null",
						associationKeyName));
		
		// now load the model object
		final ModelObject deletedModelObject = ApplicationService.Current().
				getModelObjectById(relatedModelObjectDataType, id);

		if (deletedModelObject == null) {
			LOGGER.severe(
					MessageFormat.format("removeAssociatedObject Could not find object of type \"{0}\" with id: \"{1}\"",
							relatedModelObjectDataType.getName(), id));
			return false;
		} else {

			// in the angular site deletion means that the model object list no longer contains the object. So we just add it 
			// to the collection of deleted items 
			assList.getDeletedItems().add(deletedModelObject);
			
			LOGGER.info(MessageFormat.format("Found object for delete of type \"{0}\" with id: \"{1}\". Number of Deleted Items: {2}",
					relatedModelObjectDataType, id, assList.getDeletedItems().size()));
			return true;
		}
	}

	/**
	 * handles deleted child items from angular site
	 *
	 */
	public void prepareDeletedItems() {
		if (this.getDeletedAssociationObjects() != null) {
			this.getDeletedAssociationObjects().forEach(new BiConsumer<String, Object[]>() {
				@Override
				public void accept(String t, Object[] di) {

					for (final Object deletedChildPk : di) {
						final String normalizedname = t.substring(0, 1).toUpperCase()
								+ t.substring(1);

						LOGGER.log(Level.FINE, MessageFormat.format("-->>deleting item {0} with id:{1}",
								normalizedname, deletedChildPk));
						try {
							removeAssociatedObject(normalizedname, deletedChildPk);
						} catch (Exception ex) {
							LOGGER.log(Level.SEVERE, null, ex);
							throw new RuntimeException(ex);
						}
					}
				}
			});
		}
		this.checkChildDeletedItems();
	}

	/**
	 * Recursively checks deleted items for child objects
	 */
	private void checkChildDeletedItems() {

		final HashMap chlds = this.getChildren();
		final Set ks = chlds.keySet();
		final Iterator ir = ks.iterator();

		while (ir.hasNext()) {

			final String skey = (String) ir.next();
			final Object mo = chlds.get(skey);

			if (mo instanceof JsonModelObjectX) {
				((JsonModelObjectX) mo).prepareDeletedItems();

			} else if (mo instanceof ModelObjectList) {
				final ModelObjectList molist = (ModelObjectList) mo;
				for (Object o : molist) {
					((JsonModelObjectX) o).prepareDeletedItems();
				}

			}
		}
	}

//	private boolean jsonDirty = false;
//	
//	@JsonSetter(value = "jsonDirty")
//	public void setJsonDirty(boolean jsonDirty) {
//		this.jsonDirty = jsonDirty;
//		super.setDirty(jsonDirty); 
//	}
//	
//	@JsonGetter(value = "jsonDirty")
//	public boolean isJsonDirty() {
//		return this.jsonDirty;
//	}
//	
//	@Override
//	public boolean isDirty() {
//		if (! isLoading() && super.isDirty()) {
//			LOGGER.info("save dirty object:" + this.getClass().getSimpleName() + ":" + super.isDirty()  + " id: " + this.getId());
//		}
//		return super.isDirty() ;
//	}
	

}
