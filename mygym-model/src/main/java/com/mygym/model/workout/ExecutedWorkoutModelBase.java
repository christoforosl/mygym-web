package com.mygym.model.workout;
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
        comments = "Model Object mapped to table workout ",
        date = "Wed Jan 20 12:07:47 EET 2021"
    )
@DefaultMapper(mapperclass=ExecutedWorkoutDBMapper.class)
@ManagedDatabaseTable(		tableName="workout" , 
							modelObjectIdentifyBy=EnumModelObjectIdentifyBy.INTEGER_PRIMARY_KEY	)
@JsonIgnoreProperties(value = {"stale","loading","children","parents","initialKeyValue","allowIdChange","empty","keyFieldIndex","validators","selfOrRelatedDirty"},ignoreUnknown = true)
public class ExecutedWorkoutModelBase extends com.netu.lib.JsonModelObject implements com.netu.lib.Model.IAuditable  {
	
	public static final String STR_FLD_WORKOUT_ID = "WorkoutId";
	public static final String STR_FLD_USER_ID = "UserId";
	public static final String STR_FLD_WORKOUT_START = "WorkoutStart";
	public static final String STR_FLD_WORKOUT_END = "WorkoutEnd";
	public static final String STR_FLD_NOTES = "Notes";
	public static final String STR_FLD_SCHEDULED_WORKOUT_ID = "ScheduledWorkoutId";
	public static final String STR_FLD_WORKOUT_DEFINITION_ID = "WorkoutDefinitionId";
	public static final String STR_FLD_CREATE_DATE = "CreateDate";
	public static final String STR_FLD_UPDATE_DATE = "UpdateDate";
	public static final String STR_FLD_CREATE_USER = "CreateUser";
	public static final String STR_FLD_UPDATE_USER = "UpdateUser";

	/** Association constants **/


	public static final int FLD_WORKOUT_ID = 1;
	public static final int FLD_USER_ID = 2;
	public static final int FLD_WORKOUT_START = 3;
	public static final int FLD_WORKOUT_END = 4;
	public static final int FLD_NOTES = 5;
	public static final int FLD_SCHEDULED_WORKOUT_ID = 6;
	public static final int FLD_WORKOUT_DEFINITION_ID = 7;
	public static final int FLD_CREATE_DATE = 8;
	public static final int FLD_UPDATE_DATE = 9;
	public static final int FLD_CREATE_USER = 10;
	public static final int FLD_UPDATE_USER = 11;


	@KeyField
	@MOColumn(fieldName=STR_FLD_WORKOUT_ID,fieldType=Integer.class,dbFieldName="workout_id")
	private Integer workoutId;
	@MOColumn(fieldName=STR_FLD_USER_ID,fieldType=Integer.class,dbFieldName="user_id")
	private Integer userId;
	@MOColumn(fieldName=STR_FLD_WORKOUT_START,fieldType=java.util.Date.class,dbFieldName="workout_start")
	private java.util.Date workoutStart;
	@MOColumn(fieldName=STR_FLD_WORKOUT_END,fieldType=java.util.Date.class,dbFieldName="workout_end")
	private java.util.Date workoutEnd;
	@MOColumn(fieldName=STR_FLD_NOTES,fieldType=String.class,dbFieldName="notes")
	private String notes;
	@MOColumn(fieldName=STR_FLD_SCHEDULED_WORKOUT_ID,fieldType=Integer.class,dbFieldName="scheduled_workout_id")
	private Integer scheduledWorkoutId;
	@MOColumn(fieldName=STR_FLD_WORKOUT_DEFINITION_ID,fieldType=Integer.class,dbFieldName="workout_definition_id")
	private Integer workoutDefinitionId;
	@MOColumn(fieldName=STR_FLD_CREATE_DATE,fieldType=java.util.Date.class,dbFieldName="create_date")
	private java.util.Date createDate;
	@MOColumn(fieldName=STR_FLD_UPDATE_DATE,fieldType=java.util.Date.class,dbFieldName="update_date")
	private java.util.Date updateDate;
	@MOColumn(fieldName=STR_FLD_CREATE_USER,fieldType=String.class,dbFieldName="create_user")
	private String createUser;
	@MOColumn(fieldName=STR_FLD_UPDATE_USER,fieldType=String.class,dbFieldName="update_user")
	private String updateUser;

    
   /**
    * ExecutedWorkoutModelBase Constructor
    */
	public ExecutedWorkoutModelBase() {
        super();
		this.setId( com.netu.lib.Model.ModelObjectKeyGen.nextId() );

	}

	@JsonProperty
	public void setWorkoutId(final Integer workoutId) {
		if (valueChanged(this.workoutId,workoutId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_WORKOUT_ID,ONE);
			this.workoutId = workoutId;
		}
	}

	@JsonIgnore
	public void setWorkoutId(final String workoutId) {
		if (org.apache.commons.lang.StringUtils.isBlank(workoutId)){return;} //we do not want to allow null primary key
		this.setWorkoutId(NetuUtils.parseInt(workoutId));

	}
	@JsonProperty
	public Integer getWorkoutId() {
		return this.workoutId;
	}

	@JsonIgnore
public int getWorkoutIdInt() {
		if (this.getWorkoutId()==null){return 0;}
		return this.getWorkoutId();
	}

	@JsonProperty
	public void setUserId(final Integer userId) {
		if (valueChanged(this.userId,userId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_USER_ID,ONE);
			this.userId = userId;
		}
	}

	@JsonIgnore
	public void setUserId(final String userId) {
		this.setUserId(NetuUtils.parseInt(userId));

	}
	@JsonProperty
	public Integer getUserId() {
		return this.userId;
	}

	@JsonIgnore
public int getUserIdInt() {
		if (this.getUserId()==null){return 0;}
		return this.getUserId();
	}

	@JsonProperty
	public void setWorkoutStart(final java.util.Date workoutStart) {
		if (valueChanged(this.workoutStart,workoutStart)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_WORKOUT_START,ONE);
			this.workoutStart = workoutStart;
		}
	}

	@JsonIgnore
	public void setWorkoutStart(final String workoutStart) {
		this.setWorkoutStart(NetuUtils.parseDateTime(workoutStart));

	}
	@JsonProperty
	public java.util.Date getWorkoutStart() {
		return this.workoutStart;
	}

	@JsonProperty
	public void setWorkoutEnd(final java.util.Date workoutEnd) {
		if (valueChanged(this.workoutEnd,workoutEnd)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_WORKOUT_END,ONE);
			this.workoutEnd = workoutEnd;
		}
	}

	@JsonIgnore
	public void setWorkoutEnd(final String workoutEnd) {
		this.setWorkoutEnd(NetuUtils.parseDateTime(workoutEnd));

	}
	@JsonProperty
	public java.util.Date getWorkoutEnd() {
		return this.workoutEnd;
	}

	@JsonProperty
	public void setNotes(final String notes) {
		if (notes!=null && notes.length()>2000){
			throw new IllegalArgumentException("Too Large Value for field->Notes.  max length:2000");
		}
		if (valueChanged(this.notes,notes)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_NOTES,ONE);
			this.notes = notes;
		}
	}

	@JsonProperty
	public String getNotes() {
		return this.notes;
	}

	@JsonProperty
	public void setScheduledWorkoutId(final Integer scheduledWorkoutId) {
		if (valueChanged(this.scheduledWorkoutId,scheduledWorkoutId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_SCHEDULED_WORKOUT_ID,ONE);
			this.scheduledWorkoutId = scheduledWorkoutId;
		}
	}

	@JsonIgnore
	public void setScheduledWorkoutId(final String scheduledWorkoutId) {
		this.setScheduledWorkoutId(NetuUtils.parseInt(scheduledWorkoutId));

	}
	@JsonProperty
	public Integer getScheduledWorkoutId() {
		return this.scheduledWorkoutId;
	}

	@JsonIgnore
public int getScheduledWorkoutIdInt() {
		if (this.getScheduledWorkoutId()==null){return 0;}
		return this.getScheduledWorkoutId();
	}

	@JsonProperty
	public void setWorkoutDefinitionId(final Integer workoutDefinitionId) {
		if (valueChanged(this.workoutDefinitionId,workoutDefinitionId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_WORKOUT_DEFINITION_ID,ONE);
			this.workoutDefinitionId = workoutDefinitionId;
		}
	}

	@JsonIgnore
	public void setWorkoutDefinitionId(final String workoutDefinitionId) {
		this.setWorkoutDefinitionId(NetuUtils.parseInt(workoutDefinitionId));

	}
	@JsonProperty
	public Integer getWorkoutDefinitionId() {
		return this.workoutDefinitionId;
	}

	@JsonIgnore
public int getWorkoutDefinitionIdInt() {
		if (this.getWorkoutDefinitionId()==null){return 0;}
		return this.getWorkoutDefinitionId();
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
		this.setWorkoutId(((Long)val).intValue());
		this.broadcastIdChange(); //also broadcast id changed to children objects
	}
	@Override
	@JsonProperty
	public Object getId() {
		return this.getWorkoutId();
	}

	
	@Override
	public void setAttribute(final String fieldKey, final Object val){
		if (fieldKey==null) {
			
		} else if ( fieldKey.equals(STR_FLD_WORKOUT_ID)){
			if(val instanceof String ) {
				this.setWorkoutId((String)val);
			} else {
				this.setWorkoutId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_USER_ID)){
			if(val instanceof String ) {
				this.setUserId((String)val);
			} else {
				this.setUserId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_WORKOUT_START)){
			if(val instanceof String ) {
				this.setWorkoutStart((String)val);
			} else {
				this.setWorkoutStart((java.util.Date)val);
			}
		} else if ( fieldKey.equals(STR_FLD_WORKOUT_END)){
			if(val instanceof String ) {
				this.setWorkoutEnd((String)val);
			} else {
				this.setWorkoutEnd((java.util.Date)val);
			}
		} else if ( fieldKey.equals(STR_FLD_NOTES)){
			this.setNotes((String)val);
		} else if ( fieldKey.equals(STR_FLD_SCHEDULED_WORKOUT_ID)){
			if(val instanceof String ) {
				this.setScheduledWorkoutId((String)val);
			} else {
				this.setScheduledWorkoutId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_WORKOUT_DEFINITION_ID)){
			if(val instanceof String ) {
				this.setWorkoutDefinitionId((String)val);
			} else {
				this.setWorkoutDefinitionId((Integer)val);
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
		case FLD_WORKOUT_ID:
			if(val instanceof String ) {
				this.setWorkoutId((String)val);
			} else {
				this.setWorkoutId((Integer)val);
			}
			break;
		case FLD_USER_ID:
			if(val instanceof String ) {
				this.setUserId((String)val);
			} else {
				this.setUserId((Integer)val);
			}
			break;
		case FLD_WORKOUT_START:
			if(val instanceof String ) {
				this.setWorkoutStart((String)val);
			} else {
				this.setWorkoutStart((java.util.Date)val);
			}
			break;
		case FLD_WORKOUT_END:
			if(val instanceof String ) {
				this.setWorkoutEnd((String)val);
			} else {
				this.setWorkoutEnd((java.util.Date)val);
			}
			break;
		case FLD_NOTES:
			this.setNotes((String)val);
			break;
		case FLD_SCHEDULED_WORKOUT_ID:
			if(val instanceof String ) {
				this.setScheduledWorkoutId((String)val);
			} else {
				this.setScheduledWorkoutId((Integer)val);
			}
			break;
		case FLD_WORKOUT_DEFINITION_ID:
			if(val instanceof String ) {
				this.setWorkoutDefinitionId((String)val);
			} else {
				this.setWorkoutDefinitionId((Integer)val);
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

		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_WORKOUT_ID)){
			return this.getWorkoutId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_USER_ID)){
			return this.getUserId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_WORKOUT_START)){
			return this.getWorkoutStart();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_WORKOUT_END)){
			return this.getWorkoutEnd();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_NOTES)){
			return this.getNotes();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_SCHEDULED_WORKOUT_ID)){
			return this.getScheduledWorkoutId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_WORKOUT_DEFINITION_ID)){
			return this.getWorkoutDefinitionId();
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
            
		case FLD_WORKOUT_ID:
			return this.getWorkoutId();
		case FLD_USER_ID:
			return this.getUserId();
		case FLD_WORKOUT_START:
			return this.getWorkoutStart();
		case FLD_WORKOUT_END:
			return this.getWorkoutEnd();
		case FLD_NOTES:
			return this.getNotes();
		case FLD_SCHEDULED_WORKOUT_ID:
			return this.getScheduledWorkoutId();
		case FLD_WORKOUT_DEFINITION_ID:
			return this.getWorkoutDefinitionId();
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
		return ExecutedWorkoutModelBase.FLD_WORKOUT_ID;
	}


	
	public void copy(final ExecutedWorkoutModelBase newMo) {
		
newMo.setUserId(this.getUserId());
			newMo.setWorkoutStart(this.getWorkoutStart());
			newMo.setWorkoutEnd(this.getWorkoutEnd());
			newMo.setNotes(this.getNotes());
			newMo.setScheduledWorkoutId(this.getScheduledWorkoutId());
			newMo.setWorkoutDefinitionId(this.getWorkoutDefinitionId());
			newMo.setCreateDate(this.getCreateDate());
			newMo.setUpdateDate(this.getUpdateDate());
			newMo.setCreateUser(this.getCreateUser());
			newMo.setUpdateUser(this.getUpdateUser());

		
	}
	
   @Override
    public boolean isEmpty() {
		return (this.getUserId() == null  && 
				this.getWorkoutStart() == null  && 
				this.getWorkoutEnd() == null  && 
				this.getNotes() == null  && 
				this.getScheduledWorkoutId() == null  && 
				this.getWorkoutDefinitionId() == null  && 
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
		if (  !(aThat instanceof ExecutedWorkout)  && !(aThat instanceof ExecutedWorkoutModelBase) ) {
			return false;
		}
		//Alternative to the above line :
		//if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

		//cast to native object is now safe
		ExecutedWorkoutModelBase that = (ExecutedWorkoutModelBase)aThat;
		
		// below we do a field-by-field evaluation, including array lists
		return  EqualsUtil.areEqual(this.userId, that.userId)
			 && EqualsUtil.areEqual(this.workoutStart, that.workoutStart)
			 && EqualsUtil.areEqual(this.workoutEnd, that.workoutEnd)
			 && EqualsUtil.areEqual(this.notes, that.notes)
			 && EqualsUtil.areEqual(this.scheduledWorkoutId, that.scheduledWorkoutId)
			 && EqualsUtil.areEqual(this.workoutDefinitionId, that.workoutDefinitionId)
			 && EqualsUtil.areEqual(this.createDate, that.createDate)
			 && EqualsUtil.areEqual(this.updateDate, that.updateDate)
			 && EqualsUtil.areEqual(this.createUser, that.createUser)
			 && EqualsUtil.areEqual(this.updateUser, that.updateUser)
			;

	  }
	  
	@Override
	public int hashCode() {
		int hash = 5;
	hash = 11 * hash + (this.userId != null ? this.userId.hashCode() : 0);
	hash = 11 * hash + (this.workoutStart != null ? this.workoutStart.hashCode() : 0);
	hash = 11 * hash + (this.workoutEnd != null ? this.workoutEnd.hashCode() : 0);
	hash = 11 * hash + (this.notes != null ? this.notes.hashCode() : 0);
	hash = 11 * hash + (this.scheduledWorkoutId != null ? this.scheduledWorkoutId.hashCode() : 0);
	hash = 11 * hash + (this.workoutDefinitionId != null ? this.workoutDefinitionId.hashCode() : 0);
	hash = 11 * hash + (this.createDate != null ? this.createDate.hashCode() : 0);
	hash = 11 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
	hash = 11 * hash + (this.createUser != null ? this.createUser.hashCode() : 0);
	hash = 11 * hash + (this.updateUser != null ? this.updateUser.hashCode() : 0);

		return hash;
	}

	
}
