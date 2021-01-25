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
import com.netu.lib.Model.annotations.MOParentGetter;


/**
 * WARNING: Do not change the generated code. Instead use the class
 * that extends this class and put custom code there, overriding any methods
 * that you need to override
 */
@Generated(
        value = {"com.netu.codeGen.XMLModelGenerator, Version 3"},
        comments = "Model Object mapped to table body_part ",
        date = "Mon Jan 25 15:04:43 EET 2021"
    )
@DefaultMapper(mapperclass=BodyPartDBMapper.class)
@ManagedDatabaseTable(		tableName="body_part" , 
							modelObjectIdentifyBy=EnumModelObjectIdentifyBy.INTEGER_PRIMARY_KEY	)
@JsonIgnoreProperties(value = {"stale","loading","children","parents","initialKeyValue","allowIdChange","empty","keyFieldIndex","validators","selfOrRelatedDirty"},ignoreUnknown = true)
public class BodyPartModelBase extends com.netu.lib.JsonModelObject implements com.netu.lib.Model.IAuditable  {
	
	public static final String STR_FLD_BODY_PART_ID = "BodyPartId";
	public static final String STR_FLD_BODY_PART_NAME = "BodyPartName";
	public static final String STR_FLD_CREATE_DATE = "CreateDate";
	public static final String STR_FLD_UPDATE_DATE = "UpdateDate";
	public static final String STR_FLD_CREATE_USER = "CreateUser";
	public static final String STR_FLD_UPDATE_USER = "UpdateUser";

	/** Association constants **/
	public static final String ASSOC_BODYPART = "BodyPart";


	public static final int FLD_BODY_PART_ID = 1;
	public static final int FLD_BODY_PART_NAME = 2;
	public static final int FLD_CREATE_DATE = 3;
	public static final int FLD_UPDATE_DATE = 4;
	public static final int FLD_CREATE_USER = 5;
	public static final int FLD_UPDATE_USER = 6;


	@KeyField
	@MOColumn(fieldName=STR_FLD_BODY_PART_ID,fieldType=Integer.class,dbFieldName="body_part_id")
	private Integer bodyPartId;
	@MOColumn(fieldName=STR_FLD_BODY_PART_NAME,fieldType=String.class,dbFieldName="body_part_name")
	private String bodyPartName;
	@MOColumn(fieldName=STR_FLD_CREATE_DATE,fieldType=java.util.Date.class,dbFieldName="create_date")
	private java.util.Date createDate;
	@MOColumn(fieldName=STR_FLD_UPDATE_DATE,fieldType=java.util.Date.class,dbFieldName="update_date")
	private java.util.Date updateDate;
	@MOColumn(fieldName=STR_FLD_CREATE_USER,fieldType=String.class,dbFieldName="create_user")
	private String createUser;
	@MOColumn(fieldName=STR_FLD_UPDATE_USER,fieldType=String.class,dbFieldName="update_user")
	private String updateUser;

	// ****** CHILD/PARENT variables ********************
	@com.fasterxml.jackson.annotation.JsonManagedReference
	private BodyPart bodyPart=null; // initialize PARENT to null.

	// ****** END CHILD/PARENT variables ********************

	@Override
	public java.util.HashMap<String, Object> getParents() {
		java.util.HashMap<String, Object> ret = new java.util.HashMap<String, Object>();

			ret.put(ASSOC_BODYPART,bodyPart);
		return ret;
	}

    
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
	public void setBodyPartName(final String bodyPartName) {
		if (bodyPartName!=null && bodyPartName.length()>500){
			throw new IllegalArgumentException("Too Large Value for field->BodyPartName.  max length:500");
		}
		if (valueChanged(this.bodyPartName,bodyPartName)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_BODY_PART_NAME,ONE);
			this.bodyPartName = bodyPartName;
		}
	}

	@JsonProperty
	public String getBodyPartName() {
		return this.bodyPartName;
	}

	@Override
	@JsonProperty
	public void setCreateDate(final java.util.Date createDate) {
		if (valueChanged(this.createDate,createDate)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_CREATE_DATE,ONE);
			this.createDate = createDate;
		}
	}

	@JsonIgnore
	public void setCreateDate(final String createDate) {
		this.setCreateDate(NetuUtils.parseDateTime(createDate));

	}
	@Override
	@JsonProperty
	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	@Override
	@JsonProperty
	public void setUpdateDate(final java.util.Date updateDate) {
		if (valueChanged(this.updateDate,updateDate)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_UPDATE_DATE,ONE);
			this.updateDate = updateDate;
		}
	}

	@JsonIgnore
	public void setUpdateDate(final String updateDate) {
		this.setUpdateDate(NetuUtils.parseDateTime(updateDate));

	}
	@Override
	@JsonProperty
	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}

	@Override
	@JsonProperty
	public void setCreateUser(final String createUser) {
		if (createUser!=null && createUser.length()>50){
			throw new IllegalArgumentException("Too Large Value for field->CreateUser.  max length:50");
		}
		if (valueChanged(this.createUser,createUser)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_CREATE_USER,ONE);
			this.createUser = createUser;
		}
	}

	@Override
	@JsonProperty
	public String getCreateUser() {
		return this.createUser;
	}

	@Override
	@JsonProperty
	public void setUpdateUser(final String updateUser) {
		if (updateUser!=null && updateUser.length()>50){
			throw new IllegalArgumentException("Too Large Value for field->UpdateUser.  max length:50");
		}
		if (valueChanged(this.updateUser,updateUser)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_UPDATE_USER,ONE);
			this.updateUser = updateUser;
		}
	}

	@Override
	@JsonProperty
	public String getUpdateUser() {
		return this.updateUser;
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

	// ASSOCIATIONS GETTERS/SETTERS BELOW!

	public boolean bodyPartLoaded() {
	//returns true if associated object or object list has been loaded.
		return this.bodyPart != null;
	}
	public BodyPart createBodyPart() { // association create prnt
		BodyPart var = new BodyPart();
		this.setBodyPart(var);
		return var;

	}

	public void setBodyPart(BodyPart bodyPart) {
		this.bodyPart = bodyPart;
		if(bodyPart != null){
			this.setBodyPartId(bodyPart.getBodyPartId()); //@@check parent->child!!
		}
		this.addChild(this.bodyPart, "bodyPart"); // add object to the children collection
	}

	@MOParentGetter
	public BodyPart getBodyPart() {
		//lazy load!!!!
		if(this.bodyPart==null) {
			if (this.getBodyPartId()==null) {
				return null;
			} else {
				this.setBodyPart(
				BodyPartDBMapper.get("body_part_id=?",
							new Object[]{this.getBodyPartId()} ));//cardinality 1, parent lazy load.
			}
		}
		return this.bodyPart;
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
			this.setBodyPartName((String)val);
		} else if ( fieldKey.equals(STR_FLD_CREATE_DATE)){
			if(val instanceof String ) {
				this.setCreateDate((String)val);
			} else {
				this.setCreateDate((java.util.Date)val);
			}
		} else if ( fieldKey.equals(STR_FLD_UPDATE_DATE)){
			if(val instanceof String ) {
				this.setUpdateDate((String)val);
			} else {
				this.setUpdateDate((java.util.Date)val);
			}
		} else if ( fieldKey.equals(STR_FLD_CREATE_USER)){
			this.setCreateUser((String)val);
		} else if ( fieldKey.equals(STR_FLD_UPDATE_USER)){
			this.setUpdateUser((String)val);
		} else if ( fieldKey.equalsIgnoreCase(ASSOC_BODYPART)){
			this.setBodyPart((BodyPart)val);

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
		if(ASSOC_BODYPART.equalsIgnoreCase(relationName)) {
			ret = this.createBodyPart();
		}

		return ret;
	}
	
	/**
	 * Retirns an associated (related) object class
	 * @param relationName The name of the association
	 * @return Class
	 */
	@Override
	public Class<? extends ModelObject> getRelatedModelObjectDataType(final String relationName) {

		if(ASSOC_BODYPART.equalsIgnoreCase(relationName)) {
			return BodyPart.class;
		}
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
			this.setBodyPartName((String)val);
			break;
		case FLD_CREATE_DATE:
			if(val instanceof String ) {
				this.setCreateDate((String)val);
			} else {
				this.setCreateDate((java.util.Date)val);
			}
			break;
		case FLD_UPDATE_DATE:
			if(val instanceof String ) {
				this.setUpdateDate((String)val);
			} else {
				this.setUpdateDate((java.util.Date)val);
			}
			break;
		case FLD_CREATE_USER:
			this.setCreateUser((String)val);
			break;
		case FLD_UPDATE_USER:
			this.setUpdateUser((String)val);
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
			return this.getBodyPartName();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_CREATE_DATE)){
			return this.getCreateDate();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_UPDATE_DATE)){
			return this.getUpdateDate();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_CREATE_USER)){
			return this.getCreateUser();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_UPDATE_USER)){
			return this.getUpdateUser();
		} else if ( fieldKey.equalsIgnoreCase(ASSOC_BODYPART)){
			return this.getBodyPart();

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
			return this.getBodyPartName();
		case FLD_CREATE_DATE:
			return this.getCreateDate();
		case FLD_UPDATE_DATE:
			return this.getUpdateDate();
		case FLD_CREATE_USER:
			return this.getCreateUser();
		case FLD_UPDATE_USER:
			return this.getUpdateUser();

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

	@Override
	public void parentIdChanged(ModelObject parentMo){
		if(parentMo instanceof BodyPart){
			this.setBodyPartId(((BodyPart)parentMo).getBodyPartId());
		}
	}

	
	public void copy(final BodyPartModelBase newMo) {
		
newMo.setBodyPartName(this.getBodyPartName());
			newMo.setCreateDate(this.getCreateDate());
			newMo.setUpdateDate(this.getUpdateDate());
			newMo.setCreateUser(this.getCreateUser());
			newMo.setUpdateUser(this.getUpdateUser());

		
	}
	
   @Override
    public boolean isEmpty() {
		return (this.getBodyPartName() == null  && 
				this.getCreateDate() == null  && 
				this.getUpdateDate() == null  && 
				this.getCreateUser() == null  && 
				this.getUpdateUser() == null );
 
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
		return  EqualsUtil.areEqual(this.bodyPartName, that.bodyPartName)
			 && EqualsUtil.areEqual(this.createDate, that.createDate)
			 && EqualsUtil.areEqual(this.updateDate, that.updateDate)
			 && EqualsUtil.areEqual(this.createUser, that.createUser)
			 && EqualsUtil.areEqual(this.updateUser, that.updateUser)
			;

	  }
	  
	@Override
	public int hashCode() {
		int hash = 5;
	hash = 11 * hash + (this.bodyPartName != null ? this.bodyPartName.hashCode() : 0);
	hash = 11 * hash + (this.createDate != null ? this.createDate.hashCode() : 0);
	hash = 11 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
	hash = 11 * hash + (this.createUser != null ? this.createUser.hashCode() : 0);
	hash = 11 * hash + (this.updateUser != null ? this.updateUser.hashCode() : 0);

		return hash;
	}

	
}
