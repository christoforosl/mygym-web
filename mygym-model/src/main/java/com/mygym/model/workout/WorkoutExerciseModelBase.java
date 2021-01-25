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
        comments = "Model Object mapped to table workout_exercise ",
        date = "Wed Jan 20 12:07:47 EET 2021"
    )
@DefaultMapper(mapperclass=WorkoutExerciseDBMapper.class)
@ManagedDatabaseTable(		tableName="workout_exercise" , 
							modelObjectIdentifyBy=EnumModelObjectIdentifyBy.INTEGER_PRIMARY_KEY	)
@JsonIgnoreProperties(value = {"stale","loading","children","parents","initialKeyValue","allowIdChange","empty","keyFieldIndex","validators","selfOrRelatedDirty"},ignoreUnknown = true)
public class WorkoutExerciseModelBase extends com.netu.lib.JsonModelObject implements com.netu.lib.Model.IAuditable  {
	
	public static final String STR_FLD_WORKOUT_EXERCISE_ID = "WorkoutExerciseId";
	public static final String STR_FLD_WORKOUT_ID = "WorkoutId";
	public static final String STR_FLD_SEQUENCE = "Sequence";
	public static final String STR_FLD_EXERCISE_ID = "ExerciseId";
	public static final String STR_FLD_NUMBER_OF_SETS = "NumberOfSets";
	public static final String STR_FLD_REPETITIONS_EACH_SET = "RepetitionsEachSet";
	public static final String STR_FLD_DURATION_SECONDS = "DurationSeconds";
	public static final String STR_FLD_REST_SECONDS = "RestSeconds";
	public static final String STR_FLD_CREATE_DATE = "CreateDate";
	public static final String STR_FLD_UPDATE_DATE = "UpdateDate";
	public static final String STR_FLD_CREATE_USER = "CreateUser";
	public static final String STR_FLD_UPDATE_USER = "UpdateUser";

	/** Association constants **/


	public static final int FLD_WORKOUT_EXERCISE_ID = 1;
	public static final int FLD_WORKOUT_ID = 2;
	public static final int FLD_SEQUENCE = 3;
	public static final int FLD_EXERCISE_ID = 4;
	public static final int FLD_NUMBER_OF_SETS = 5;
	public static final int FLD_REPETITIONS_EACH_SET = 6;
	public static final int FLD_DURATION_SECONDS = 7;
	public static final int FLD_REST_SECONDS = 8;
	public static final int FLD_CREATE_DATE = 9;
	public static final int FLD_UPDATE_DATE = 10;
	public static final int FLD_CREATE_USER = 11;
	public static final int FLD_UPDATE_USER = 12;


	@KeyField
	@MOColumn(fieldName=STR_FLD_WORKOUT_EXERCISE_ID,fieldType=Integer.class,dbFieldName="workout_exercise_id")
	private Integer workoutExerciseId;
	@MOColumn(fieldName=STR_FLD_WORKOUT_ID,fieldType=Integer.class,dbFieldName="workout_id")
	private Integer workoutId;
	@MOColumn(fieldName=STR_FLD_SEQUENCE,fieldType=Integer.class,dbFieldName="sequence")
	private Integer sequence;
	@MOColumn(fieldName=STR_FLD_EXERCISE_ID,fieldType=Integer.class,dbFieldName="exercise_id")
	private Integer exerciseId;
	@MOColumn(fieldName=STR_FLD_NUMBER_OF_SETS,fieldType=Integer.class,dbFieldName="number_of_sets")
	private Integer numberOfSets;
	@MOColumn(fieldName=STR_FLD_REPETITIONS_EACH_SET,fieldType=Integer.class,dbFieldName="repetitions_each_set")
	private Integer repetitionsEachSet;
	@MOColumn(fieldName=STR_FLD_DURATION_SECONDS,fieldType=Integer.class,dbFieldName="duration_seconds")
	private Integer durationSeconds;
	@MOColumn(fieldName=STR_FLD_REST_SECONDS,fieldType=Integer.class,dbFieldName="rest_seconds")
	private Integer restSeconds;
	@MOColumn(fieldName=STR_FLD_CREATE_DATE,fieldType=java.util.Date.class,dbFieldName="create_date")
	private java.util.Date createDate;
	@MOColumn(fieldName=STR_FLD_UPDATE_DATE,fieldType=java.util.Date.class,dbFieldName="update_date")
	private java.util.Date updateDate;
	@MOColumn(fieldName=STR_FLD_CREATE_USER,fieldType=String.class,dbFieldName="create_user")
	private String createUser;
	@MOColumn(fieldName=STR_FLD_UPDATE_USER,fieldType=String.class,dbFieldName="update_user")
	private String updateUser;

    
   /**
    * WorkoutExerciseModelBase Constructor
    */
	public WorkoutExerciseModelBase() {
        super();
		this.setId( com.netu.lib.Model.ModelObjectKeyGen.nextId() );

	}

	@JsonProperty
	public void setWorkoutExerciseId(final Integer workoutExerciseId) {
		if (valueChanged(this.workoutExerciseId,workoutExerciseId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_WORKOUT_EXERCISE_ID,ONE);
			this.workoutExerciseId = workoutExerciseId;
		}
	}

	@JsonIgnore
	public void setWorkoutExerciseId(final String workoutExerciseId) {
		if (org.apache.commons.lang.StringUtils.isBlank(workoutExerciseId)){return;} //we do not want to allow null primary key
		this.setWorkoutExerciseId(NetuUtils.parseInt(workoutExerciseId));

	}
	@JsonProperty
	public Integer getWorkoutExerciseId() {
		return this.workoutExerciseId;
	}

	@JsonIgnore
public int getWorkoutExerciseIdInt() {
		if (this.getWorkoutExerciseId()==null){return 0;}
		return this.getWorkoutExerciseId();
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
	public void setSequence(final Integer sequence) {
		if (valueChanged(this.sequence,sequence)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_SEQUENCE,ONE);
			this.sequence = sequence;
		}
	}

	@JsonIgnore
	public void setSequence(final String sequence) {
		this.setSequence(NetuUtils.parseInt(sequence));

	}
	@JsonProperty
	public Integer getSequence() {
		return this.sequence;
	}

	@JsonIgnore
public int getSequenceInt() {
		if (this.getSequence()==null){return 0;}
		return this.getSequence();
	}

	@JsonProperty
	public void setExerciseId(final Integer exerciseId) {
		if (valueChanged(this.exerciseId,exerciseId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_EXERCISE_ID,ONE);
			this.exerciseId = exerciseId;
		}
	}

	@JsonIgnore
	public void setExerciseId(final String exerciseId) {
		this.setExerciseId(NetuUtils.parseInt(exerciseId));

	}
	@JsonProperty
	public Integer getExerciseId() {
		return this.exerciseId;
	}

	@JsonIgnore
public int getExerciseIdInt() {
		if (this.getExerciseId()==null){return 0;}
		return this.getExerciseId();
	}

	@JsonProperty
	public void setNumberOfSets(final Integer numberOfSets) {
		if (valueChanged(this.numberOfSets,numberOfSets)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_NUMBER_OF_SETS,ONE);
			this.numberOfSets = numberOfSets;
		}
	}

	@JsonIgnore
	public void setNumberOfSets(final String numberOfSets) {
		this.setNumberOfSets(NetuUtils.parseInt(numberOfSets));

	}
	@JsonProperty
	public Integer getNumberOfSets() {
		return this.numberOfSets;
	}

	@JsonIgnore
public int getNumberOfSetsInt() {
		if (this.getNumberOfSets()==null){return 0;}
		return this.getNumberOfSets();
	}

	@JsonProperty
	public void setRepetitionsEachSet(final Integer repetitionsEachSet) {
		if (valueChanged(this.repetitionsEachSet,repetitionsEachSet)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_REPETITIONS_EACH_SET,ONE);
			this.repetitionsEachSet = repetitionsEachSet;
		}
	}

	@JsonIgnore
	public void setRepetitionsEachSet(final String repetitionsEachSet) {
		this.setRepetitionsEachSet(NetuUtils.parseInt(repetitionsEachSet));

	}
	@JsonProperty
	public Integer getRepetitionsEachSet() {
		return this.repetitionsEachSet;
	}

	@JsonIgnore
public int getRepetitionsEachSetInt() {
		if (this.getRepetitionsEachSet()==null){return 0;}
		return this.getRepetitionsEachSet();
	}

	@JsonProperty
	public void setDurationSeconds(final Integer durationSeconds) {
		if (valueChanged(this.durationSeconds,durationSeconds)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_DURATION_SECONDS,ONE);
			this.durationSeconds = durationSeconds;
		}
	}

	@JsonIgnore
	public void setDurationSeconds(final String durationSeconds) {
		this.setDurationSeconds(NetuUtils.parseInt(durationSeconds));

	}
	@JsonProperty
	public Integer getDurationSeconds() {
		return this.durationSeconds;
	}

	@JsonIgnore
public int getDurationSecondsInt() {
		if (this.getDurationSeconds()==null){return 0;}
		return this.getDurationSeconds();
	}

	@JsonProperty
	public void setRestSeconds(final Integer restSeconds) {
		if (valueChanged(this.restSeconds,restSeconds)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_REST_SECONDS,ONE);
			this.restSeconds = restSeconds;
		}
	}

	@JsonIgnore
	public void setRestSeconds(final String restSeconds) {
		this.setRestSeconds(NetuUtils.parseInt(restSeconds));

	}
	@JsonProperty
	public Integer getRestSeconds() {
		return this.restSeconds;
	}

	@JsonIgnore
public int getRestSecondsInt() {
		if (this.getRestSeconds()==null){return 0;}
		return this.getRestSeconds();
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
		this.setWorkoutExerciseId(((Long)val).intValue());
		this.broadcastIdChange(); //also broadcast id changed to children objects
	}
	@Override
	@JsonProperty
	public Object getId() {
		return this.getWorkoutExerciseId();
	}

	
	@Override
	public void setAttribute(final String fieldKey, final Object val){
		if (fieldKey==null) {
			
		} else if ( fieldKey.equals(STR_FLD_WORKOUT_EXERCISE_ID)){
			if(val instanceof String ) {
				this.setWorkoutExerciseId((String)val);
			} else {
				this.setWorkoutExerciseId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_WORKOUT_ID)){
			if(val instanceof String ) {
				this.setWorkoutId((String)val);
			} else {
				this.setWorkoutId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_SEQUENCE)){
			if(val instanceof String ) {
				this.setSequence((String)val);
			} else {
				this.setSequence((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_EXERCISE_ID)){
			if(val instanceof String ) {
				this.setExerciseId((String)val);
			} else {
				this.setExerciseId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_NUMBER_OF_SETS)){
			if(val instanceof String ) {
				this.setNumberOfSets((String)val);
			} else {
				this.setNumberOfSets((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_REPETITIONS_EACH_SET)){
			if(val instanceof String ) {
				this.setRepetitionsEachSet((String)val);
			} else {
				this.setRepetitionsEachSet((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_DURATION_SECONDS)){
			if(val instanceof String ) {
				this.setDurationSeconds((String)val);
			} else {
				this.setDurationSeconds((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_REST_SECONDS)){
			if(val instanceof String ) {
				this.setRestSeconds((String)val);
			} else {
				this.setRestSeconds((Integer)val);
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
		case FLD_WORKOUT_EXERCISE_ID:
			if(val instanceof String ) {
				this.setWorkoutExerciseId((String)val);
			} else {
				this.setWorkoutExerciseId((Integer)val);
			}
			break;
		case FLD_WORKOUT_ID:
			if(val instanceof String ) {
				this.setWorkoutId((String)val);
			} else {
				this.setWorkoutId((Integer)val);
			}
			break;
		case FLD_SEQUENCE:
			if(val instanceof String ) {
				this.setSequence((String)val);
			} else {
				this.setSequence((Integer)val);
			}
			break;
		case FLD_EXERCISE_ID:
			if(val instanceof String ) {
				this.setExerciseId((String)val);
			} else {
				this.setExerciseId((Integer)val);
			}
			break;
		case FLD_NUMBER_OF_SETS:
			if(val instanceof String ) {
				this.setNumberOfSets((String)val);
			} else {
				this.setNumberOfSets((Integer)val);
			}
			break;
		case FLD_REPETITIONS_EACH_SET:
			if(val instanceof String ) {
				this.setRepetitionsEachSet((String)val);
			} else {
				this.setRepetitionsEachSet((Integer)val);
			}
			break;
		case FLD_DURATION_SECONDS:
			if(val instanceof String ) {
				this.setDurationSeconds((String)val);
			} else {
				this.setDurationSeconds((Integer)val);
			}
			break;
		case FLD_REST_SECONDS:
			if(val instanceof String ) {
				this.setRestSeconds((String)val);
			} else {
				this.setRestSeconds((Integer)val);
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

		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_WORKOUT_EXERCISE_ID)){
			return this.getWorkoutExerciseId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_WORKOUT_ID)){
			return this.getWorkoutId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_SEQUENCE)){
			return this.getSequence();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EXERCISE_ID)){
			return this.getExerciseId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_NUMBER_OF_SETS)){
			return this.getNumberOfSets();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_REPETITIONS_EACH_SET)){
			return this.getRepetitionsEachSet();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_DURATION_SECONDS)){
			return this.getDurationSeconds();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_REST_SECONDS)){
			return this.getRestSeconds();
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
            
		case FLD_WORKOUT_EXERCISE_ID:
			return this.getWorkoutExerciseId();
		case FLD_WORKOUT_ID:
			return this.getWorkoutId();
		case FLD_SEQUENCE:
			return this.getSequence();
		case FLD_EXERCISE_ID:
			return this.getExerciseId();
		case FLD_NUMBER_OF_SETS:
			return this.getNumberOfSets();
		case FLD_REPETITIONS_EACH_SET:
			return this.getRepetitionsEachSet();
		case FLD_DURATION_SECONDS:
			return this.getDurationSeconds();
		case FLD_REST_SECONDS:
			return this.getRestSeconds();
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
		return WorkoutExerciseModelBase.FLD_WORKOUT_EXERCISE_ID;
	}


	
	public void copy(final WorkoutExerciseModelBase newMo) {
		
newMo.setWorkoutId(this.getWorkoutId());
			newMo.setSequence(this.getSequence());
			newMo.setExerciseId(this.getExerciseId());
			newMo.setNumberOfSets(this.getNumberOfSets());
			newMo.setRepetitionsEachSet(this.getRepetitionsEachSet());
			newMo.setDurationSeconds(this.getDurationSeconds());
			newMo.setRestSeconds(this.getRestSeconds());
			newMo.setCreateDate(this.getCreateDate());
			newMo.setUpdateDate(this.getUpdateDate());
			newMo.setCreateUser(this.getCreateUser());
			newMo.setUpdateUser(this.getUpdateUser());

		
	}
	
   @Override
    public boolean isEmpty() {
		return (this.getWorkoutId() == null  && 
				this.getSequence() == null  && 
				this.getExerciseId() == null  && 
				this.getNumberOfSets() == null  && 
				this.getRepetitionsEachSet() == null  && 
				this.getDurationSeconds() == null  && 
				this.getRestSeconds() == null  && 
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
		if (  !(aThat instanceof WorkoutExercise)  && !(aThat instanceof WorkoutExerciseModelBase) ) {
			return false;
		}
		//Alternative to the above line :
		//if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

		//cast to native object is now safe
		WorkoutExerciseModelBase that = (WorkoutExerciseModelBase)aThat;
		
		// below we do a field-by-field evaluation, including array lists
		return  EqualsUtil.areEqual(this.workoutId, that.workoutId)
			 && EqualsUtil.areEqual(this.sequence, that.sequence)
			 && EqualsUtil.areEqual(this.exerciseId, that.exerciseId)
			 && EqualsUtil.areEqual(this.numberOfSets, that.numberOfSets)
			 && EqualsUtil.areEqual(this.repetitionsEachSet, that.repetitionsEachSet)
			 && EqualsUtil.areEqual(this.durationSeconds, that.durationSeconds)
			 && EqualsUtil.areEqual(this.restSeconds, that.restSeconds)
			 && EqualsUtil.areEqual(this.createDate, that.createDate)
			 && EqualsUtil.areEqual(this.updateDate, that.updateDate)
			 && EqualsUtil.areEqual(this.createUser, that.createUser)
			 && EqualsUtil.areEqual(this.updateUser, that.updateUser)
			;

	  }
	  
	@Override
	public int hashCode() {
		int hash = 5;
	hash = 11 * hash + (this.workoutId != null ? this.workoutId.hashCode() : 0);
	hash = 11 * hash + (this.sequence != null ? this.sequence.hashCode() : 0);
	hash = 11 * hash + (this.exerciseId != null ? this.exerciseId.hashCode() : 0);
	hash = 11 * hash + (this.numberOfSets != null ? this.numberOfSets.hashCode() : 0);
	hash = 11 * hash + (this.repetitionsEachSet != null ? this.repetitionsEachSet.hashCode() : 0);
	hash = 11 * hash + (this.durationSeconds != null ? this.durationSeconds.hashCode() : 0);
	hash = 11 * hash + (this.restSeconds != null ? this.restSeconds.hashCode() : 0);
	hash = 11 * hash + (this.createDate != null ? this.createDate.hashCode() : 0);
	hash = 11 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
	hash = 11 * hash + (this.createUser != null ? this.createUser.hashCode() : 0);
	hash = 11 * hash + (this.updateUser != null ? this.updateUser.hashCode() : 0);

		return hash;
	}

	
}
