package com.mygym.model.security;
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
        comments = "Model Object mapped to table system_user ",
        date = "Wed Jan 20 12:07:47 EET 2021"
    )
@DefaultMapper(mapperclass=SystemUserDBMapper.class)
@ManagedDatabaseTable(		tableName="system_user" , 
							modelObjectIdentifyBy=EnumModelObjectIdentifyBy.INTEGER_PRIMARY_KEY	)
@JsonIgnoreProperties(value = {"stale","loading","children","parents","initialKeyValue","allowIdChange","empty","keyFieldIndex","validators","selfOrRelatedDirty"},ignoreUnknown = true)
public class SystemUserModelBase extends com.netu.lib.JsonModelObject implements com.netu.lib.Model.IAuditable  {
	
	public static final String STR_FLD_SYSTEM_USER_ID = "SystemUserId";
	public static final String STR_FLD_EMAIL = "Email";
	public static final String STR_FLD_PASSWORD = "Password";
	public static final String STR_FLD_IS_ACTIVE = "IsActive";
	public static final String STR_FLD_CREATE_DATE = "CreateDate";
	public static final String STR_FLD_UPDATE_DATE = "UpdateDate";
	public static final String STR_FLD_CREATE_USER = "CreateUser";
	public static final String STR_FLD_UPDATE_USER = "UpdateUser";

	/** Association constants **/


	public static final int FLD_SYSTEM_USER_ID = 1;
	public static final int FLD_EMAIL = 2;
	public static final int FLD_PASSWORD = 3;
	public static final int FLD_IS_ACTIVE = 4;
	public static final int FLD_CREATE_DATE = 5;
	public static final int FLD_UPDATE_DATE = 6;
	public static final int FLD_CREATE_USER = 7;
	public static final int FLD_UPDATE_USER = 8;


	@KeyField
	@MOColumn(fieldName=STR_FLD_SYSTEM_USER_ID,fieldType=Integer.class,dbFieldName="system_user_id")
	private Integer systemUserId;
	@MOColumn(fieldName=STR_FLD_EMAIL,fieldType=String.class,dbFieldName="email")
	private String email;
	@MOColumn(fieldName=STR_FLD_PASSWORD,fieldType=String.class,dbFieldName="password")
	private String password;
	@MOColumn(fieldName=STR_FLD_IS_ACTIVE,fieldType=Integer.class,dbFieldName="is_active")
	private Integer isActive;
	@MOColumn(fieldName=STR_FLD_CREATE_DATE,fieldType=java.util.Date.class,dbFieldName="create_date")
	private java.util.Date createDate;
	@MOColumn(fieldName=STR_FLD_UPDATE_DATE,fieldType=java.util.Date.class,dbFieldName="update_date")
	private java.util.Date updateDate;
	@MOColumn(fieldName=STR_FLD_CREATE_USER,fieldType=String.class,dbFieldName="create_user")
	private String createUser;
	@MOColumn(fieldName=STR_FLD_UPDATE_USER,fieldType=String.class,dbFieldName="update_user")
	private String updateUser;

    
   /**
    * SystemUserModelBase Constructor
    */
	public SystemUserModelBase() {
        super();
		this.setId( com.netu.lib.Model.ModelObjectKeyGen.nextId() );

	}

	@JsonProperty
	public void setSystemUserId(final Integer systemUserId) {
		if (valueChanged(this.systemUserId,systemUserId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_SYSTEM_USER_ID,ONE);
			this.systemUserId = systemUserId;
		}
	}

	@JsonIgnore
	public void setSystemUserId(final String systemUserId) {
		if (org.apache.commons.lang.StringUtils.isBlank(systemUserId)){return;} //we do not want to allow null primary key
		this.setSystemUserId(NetuUtils.parseInt(systemUserId));

	}
	@JsonProperty
	public Integer getSystemUserId() {
		return this.systemUserId;
	}

	@JsonIgnore
public int getSystemUserIdInt() {
		if (this.getSystemUserId()==null){return 0;}
		return this.getSystemUserId();
	}

	@JsonProperty
	public void setEmail(final String email) {
		if (email!=null && email.length()>50){
			throw new IllegalArgumentException("Too Large Value for field->Email.  max length:50");
		}
		if (valueChanged(this.email,email)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_EMAIL,ONE);
			this.email = email;
		}
	}

	@JsonProperty
	public String getEmail() {
		return this.email;
	}

	@JsonProperty
	public void setPassword(final String password) {
		if (password!=null && password.length()>50){
			throw new IllegalArgumentException("Too Large Value for field->Password.  max length:50");
		}
		if (valueChanged(this.password,password)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_PASSWORD,ONE);
			this.password = password;
		}
	}

	@JsonProperty
	public String getPassword() {
		return this.password;
	}

	@JsonProperty
	public void setIsActive(final Integer isActive) {
		if (valueChanged(this.isActive,isActive)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_IS_ACTIVE,ONE);
			this.isActive = isActive;
		}
	}

	@JsonIgnore
	public void setIsActive(final String isActive) {
		this.setIsActive(NetuUtils.parseInt(isActive));

	}
	@JsonProperty
	public Integer getIsActive() {
		return this.isActive;
	}

	@JsonIgnore
public int getIsActiveInt() {
		if (this.getIsActive()==null){return 0;}
		return this.getIsActive();
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
		this.setSystemUserId(((Long)val).intValue());
		this.broadcastIdChange(); //also broadcast id changed to children objects
	}
	@Override
	@JsonProperty
	public Object getId() {
		return this.getSystemUserId();
	}

	
	@Override
	public void setAttribute(final String fieldKey, final Object val){
		if (fieldKey==null) {
			
		} else if ( fieldKey.equals(STR_FLD_SYSTEM_USER_ID)){
			if(val instanceof String ) {
				this.setSystemUserId((String)val);
			} else {
				this.setSystemUserId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_EMAIL)){
			this.setEmail((String)val);
		} else if ( fieldKey.equals(STR_FLD_PASSWORD)){
			this.setPassword((String)val);
		} else if ( fieldKey.equals(STR_FLD_IS_ACTIVE)){
			if(val instanceof String ) {
				this.setIsActive((String)val);
			} else {
				this.setIsActive((Integer)val);
			}
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
		case FLD_SYSTEM_USER_ID:
			if(val instanceof String ) {
				this.setSystemUserId((String)val);
			} else {
				this.setSystemUserId((Integer)val);
			}
			break;
		case FLD_EMAIL:
			this.setEmail((String)val);
			break;
		case FLD_PASSWORD:
			this.setPassword((String)val);
			break;
		case FLD_IS_ACTIVE:
			if(val instanceof String ) {
				this.setIsActive((String)val);
			} else {
				this.setIsActive((Integer)val);
			}
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

		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_SYSTEM_USER_ID)){
			return this.getSystemUserId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EMAIL)){
			return this.getEmail();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_PASSWORD)){
			return this.getPassword();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_IS_ACTIVE)){
			return this.getIsActive();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_CREATE_DATE)){
			return this.getCreateDate();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_UPDATE_DATE)){
			return this.getUpdateDate();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_CREATE_USER)){
			return this.getCreateUser();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_UPDATE_USER)){
			return this.getUpdateUser();

		} else {
			return null;
		}
		
	}
	
	@Override
	public Object getAttribute(final int fieldKey){
		
		switch (fieldKey) {
            
		case FLD_SYSTEM_USER_ID:
			return this.getSystemUserId();
		case FLD_EMAIL:
			return this.getEmail();
		case FLD_PASSWORD:
			return this.getPassword();
		case FLD_IS_ACTIVE:
			return this.getIsActive();
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
		return SystemUserModelBase.FLD_SYSTEM_USER_ID;
	}


	
	public void copy(final SystemUserModelBase newMo) {
		
newMo.setEmail(this.getEmail());
			newMo.setPassword(this.getPassword());
			newMo.setIsActive(this.getIsActive());
			newMo.setCreateDate(this.getCreateDate());
			newMo.setUpdateDate(this.getUpdateDate());
			newMo.setCreateUser(this.getCreateUser());
			newMo.setUpdateUser(this.getUpdateUser());

		
	}
	
   @Override
    public boolean isEmpty() {
		return (this.getEmail() == null  && 
				this.getPassword() == null  && 
				this.getIsActive() == null  && 
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
		if (  !(aThat instanceof SystemUser)  && !(aThat instanceof SystemUserModelBase) ) {
			return false;
		}
		//Alternative to the above line :
		//if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

		//cast to native object is now safe
		SystemUserModelBase that = (SystemUserModelBase)aThat;
		
		// below we do a field-by-field evaluation, including array lists
		return  EqualsUtil.areEqual(this.email, that.email)
			 && EqualsUtil.areEqual(this.password, that.password)
			 && EqualsUtil.areEqual(this.isActive, that.isActive)
			 && EqualsUtil.areEqual(this.createDate, that.createDate)
			 && EqualsUtil.areEqual(this.updateDate, that.updateDate)
			 && EqualsUtil.areEqual(this.createUser, that.createUser)
			 && EqualsUtil.areEqual(this.updateUser, that.updateUser)
			;

	  }
	  
	@Override
	public int hashCode() {
		int hash = 5;
	hash = 11 * hash + (this.email != null ? this.email.hashCode() : 0);
	hash = 11 * hash + (this.password != null ? this.password.hashCode() : 0);
	hash = 11 * hash + (this.isActive != null ? this.isActive.hashCode() : 0);
	hash = 11 * hash + (this.createDate != null ? this.createDate.hashCode() : 0);
	hash = 11 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
	hash = 11 * hash + (this.createUser != null ? this.createUser.hashCode() : 0);
	hash = 11 * hash + (this.updateUser != null ? this.updateUser.hashCode() : 0);

		return hash;
	}

	
}
