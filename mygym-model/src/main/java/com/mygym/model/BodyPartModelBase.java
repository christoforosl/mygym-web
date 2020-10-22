package com.mygym.model;
import com.netu.lib.Model.ModelObject;
import com.netu.lib.Model.OracleModelObject;


import com.netu.lib.NetuUtils;
import com.netu.lib.EqualsUtil;
import com.netu.lib.Model.annotations.KeyField;
import com.netu.lib.Model.annotations.DefaultMapper;
import com.netu.lib.Model.annotations.MOColumn;
import com.netu.lib.Model.annotations.ManagedDatabaseTable;
import com.netu.lib.Model.annotations.EnumModelObjectIdentifyBy;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * WARNING: Do not change the generated code. Instead use the class
 * that extends this class and put custom code there, overriding any methods
 * that you need to override
 */
@Generated(
        value = {"com.netu.codeGen.XMLModelGenerator, Version 3"},
        comments = "Model Object mapped to table body_part ",
        date = "Thu Oct 22 12:40:06 EEST 2020"
    )
@DefaultMapper(mapperclass=BodyPartDBMapper.class)
@ManagedDatabaseTable(		tableName="body_part" , 
							modelObjectIdentifyBy=EnumModelObjectIdentifyBy.INTEGER_PRIMARY_KEY	)
@JsonIgnoreProperties(value = {"stale","loading","children","parents","initialKeyValue","allowIdChange","empty","keyFieldIndex","validators","selfOrRelatedDirty"},ignoreUnknown = true)
public class BodyPartModelBase extends com.netu.lib.JsonModelObject  {
	
	public static final String STR_FLD_BODY_PART_ID = "BodyPartId";
	public static final String STR_FLD_BODY_PART_NAME = "BodyPartNAME";

	/** Association constants **/


	public static final int FLD_BODY_PART_ID = 1;
	public static final int FLD_BODY_PART_NAME = 2;


	@KeyField
	@MOColumn(fieldName=STR_FLD_BODY_PART_ID,fieldType=Integer.class,dbFieldName="body_part_id")
	private Integer bodyPartId;
	@MOColumn(fieldName=STR_FLD_BODY_PART_NAME,fieldType=String.class,dbFieldName="body_part_NAME")
	private String bodyPartNAME;

    
   /**
    * BodyPartModelBase Constructor
    */
	public BodyPartModelBase() {
        super();
		this.setId( com.netu.lib.Model.ModelObjectKeyGen.nextId() );

	}

	@JsonProperty
	public void setBodyPartId(final Integer bodyPartId) {
		if (valueChanged(this.bodyPartId,bodyPartId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_BODY_PART_ID,ONE);
			this.bodyPartId = bodyPartId;
		}
	}

	@JsonIgnore
	public void setBodyPartId(final String bodyPartId) {
		if (org.apache.commons.lang.StringUtils.isBlank(bodyPartId)){return;} //we do not want to allow null primary key
		this.setBodyPartId(NetuUtils.parseInt(bodyPartId));

	}
	@JsonProperty
	public Integer getBodyPartId() {
		return this.bodyPartId;
	}

	@JsonIgnore
public int getBodyPartIdInt() {
		if (this.getBodyPartId()==null){return 0;}
		return this.getBodyPartId();
	}

	@JsonProperty
	public void setBodyPartNAME(final String bodyPartNAME) {
		if (bodyPartNAME!=null && bodyPartNAME.length()>500){
			throw new IllegalArgumentException("Too Large Value for field->BodyPartNAME.  max length:500");
		}
		if (valueChanged(this.bodyPartNAME,bodyPartNAME)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_BODY_PART_NAME,ONE);
			this.bodyPartNAME = bodyPartNAME;
		}
	}

	@JsonProperty
	public String getBodyPartNAME() {
		return this.bodyPartNAME;
	}

	@Override
	@JsonIgnore
	public final void setId(final Object val) {
		this.setBodyPartId(((Long)val).intValue());
		this.broadcastIdChange(); //also broadcast id changed to children objects
	}
	@Override
	@JsonProperty
	public Object getId() {
		return this.getBodyPartId();
	}

	
	@Override
	public void setAttribute(final String fieldKey, final Object val){
		if (fieldKey==null) {
			
		} else if ( fieldKey.equals(STR_FLD_BODY_PART_ID)){
			if(val instanceof String ) {
				this.setBodyPartId((String)val);
			} else {
				this.setBodyPartId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_BODY_PART_NAME)){
			this.setBodyPartNAME((String)val);

		}
	}
	
	/**
	 * Creates a related object and returns it to the caller.
	 * It does not add it the new object the associated collection
	 * @param relationName The name of the association
	 * @return ModelObject
	 */
	@Override
	public ModelObject createRelatedModelObject(final String relationName) {
		ModelObject ret = null;

		return ret;
	}
	
	/**
	 * Retirns an associated (related) object class
	 * @param relationName The name of the association
	 * @return Class
	 */
	@Override
	public Class<? extends ModelObject> getRelatedModelObjectDataType(final String relationName) {

		return null;


	}


	@Override
	public void setAttribute(final int fieldKey, final Object val){
	
	    switch (fieldKey) {
		case FLD_BODY_PART_ID:
			if(val instanceof String ) {
				this.setBodyPartId((String)val);
			} else {
				this.setBodyPartId((Integer)val);
			}
			break;
		case FLD_BODY_PART_NAME:
			this.setBodyPartNAME((String)val);
			break;

			default:
	           
		}
	}
	
	@Override 
    public Object getAttribute(final String fieldKey){
		if (fieldKey==null) {
			return null;

		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_BODY_PART_ID)){
			return this.getBodyPartId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_BODY_PART_NAME)){
			return this.getBodyPartNAME();

		} else {
			return null;
		}
		
	}
	
	@Override
	public Object getAttribute(final int fieldKey){
		
		switch (fieldKey) {
            
		case FLD_BODY_PART_ID:
			return this.getBodyPartId();
		case FLD_BODY_PART_NAME:
			return this.getBodyPartNAME();

			default:
				return null;
		}
	}
	
	/**
	 * Returns the key field index, ie an integer constant that corresponds
	 * to the primary key field, and when passed to getAttribute or setAttribute
	 * will get/set the primary key of the object
	 * @return integer
	 */
	 @Override
	public int getKeyFieldIndex() {
		return BodyPartModelBase.FLD_BODY_PART_ID;
	}


	
	public void copy(final BodyPartModelBase newMo) {
		
newMo.setBodyPartNAME(this.getBodyPartNAME());

		
	}
	
   @Override
    public boolean isEmpty() {
		return (this.getBodyPartNAME() == null );
 
    }
	
	@Override 
	public boolean equals(final Object aThat) {
		//check for self-comparison
		if ( this == aThat ) {return true;}

		//use instanceof instead of getClass here for two reasons
		//1. if need be, it can match any supertype, and not just one class;
		//2. it renders an explict check for "that == null" redundant, since
		//it does the check for null already - "null instanceof [type]" always
		//returns false. (See Effective Java by Joshua Bloch.)
		if (  !(aThat instanceof BodyPart)  && !(aThat instanceof BodyPartModelBase) ) {
			return false;
		}
		//Alternative to the above line :
		//if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

		//cast to native object is now safe
		BodyPartModelBase that = (BodyPartModelBase)aThat;
		
		// below we do a field-by-field evaluation, including array lists
		return  EqualsUtil.areEqual(this.bodyPartNAME, that.bodyPartNAME)
			;

	  }
	  
	@Override
	public int hashCode() {
		int hash = 5;
	hash = 11 * hash + (this.bodyPartNAME != null ? this.bodyPartNAME.hashCode() : 0);

		return hash;
	}

	
}
