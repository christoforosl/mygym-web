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
        comments = "Model Object mapped to table exercise_type ",
        date = "Tue Oct 20 21:24:13 EEST 2020"
    )
@DefaultMapper(mapperclass=ExerciseTypeDBMapper.class)
@ManagedDatabaseTable(		tableName="exercise_type" , 
							modelObjectIdentifyBy=EnumModelObjectIdentifyBy.INTEGER_PRIMARY_KEY	)
@JsonIgnoreProperties(value = {"stale","loading","children","parents","initialKeyValue","allowIdChange","empty","keyFieldIndex","validators","selfOrRelatedDirty"},ignoreUnknown = true)
public class ExerciseTypeModelBase extends com.mygym.model.base.JsonModelObject  {
	
	public static final String STR_FLD_EXERCISE_TYPE_ID = "ExerciseTypeId";
	public static final String STR_FLD_EXERCISE_TYPE = "ExerciseType";

	/** Association constants **/


	public static final int FLD_EXERCISE_TYPE_ID = 1;
	public static final int FLD_EXERCISE_TYPE = 2;


	@KeyField
	@MOColumn(fieldName=STR_FLD_EXERCISE_TYPE_ID,fieldType=Integer.class,dbFieldName="exercise_type_id")
	private Integer exerciseTypeId;
	@MOColumn(fieldName=STR_FLD_EXERCISE_TYPE,fieldType=String.class,dbFieldName="exercise_type")
	private String exerciseType;

    
   /**
    * ExerciseTypeModelBase Constructor
    */
	public ExerciseTypeModelBase() {
        super();
		this.setId( com.netu.lib.Model.ModelObjectKeyGen.nextId() );

	}

	@JsonProperty
	public void setExerciseTypeId(final Integer exerciseTypeId) {
		if (valueChanged(this.exerciseTypeId,exerciseTypeId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_EXERCISE_TYPE_ID,ONE);
			this.exerciseTypeId = exerciseTypeId;
		}
	}

	@JsonIgnore
	public void setExerciseTypeId(final String exerciseTypeId) {
		if (org.apache.commons.lang.StringUtils.isBlank(exerciseTypeId)){return;} //we do not want to allow null primary key
		this.setExerciseTypeId(NetuUtils.parseInt(exerciseTypeId));

	}
	@JsonProperty
	public Integer getExerciseTypeId() {
		return this.exerciseTypeId;
	}

	@JsonIgnore
public int getExerciseTypeIdInt() {
		if (this.getExerciseTypeId()==null){return 0;}
		return this.getExerciseTypeId();
	}

	@JsonProperty
	public void setExerciseType(final String exerciseType) {
		if (exerciseType!=null && exerciseType.length()>500){
			throw new IllegalArgumentException("Too Large Value for field->ExerciseType.  max length:500");
		}
		if (valueChanged(this.exerciseType,exerciseType)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_EXERCISE_TYPE,ONE);
			this.exerciseType = exerciseType;
		}
	}

	@JsonProperty
	public String getExerciseType() {
		return this.exerciseType;
	}

	@Override
	@JsonIgnore
	public final void setId(final Object val) {
		this.setExerciseTypeId(((Long)val).intValue());
		this.broadcastIdChange(); //also broadcast id changed to children objects
	}
	@Override
	@JsonProperty
	public Object getId() {
		return this.getExerciseTypeId();
	}

	
	@Override
	public void setAttribute(final String fieldKey, final Object val){
		if (fieldKey==null) {
			
		} else if ( fieldKey.equals(STR_FLD_EXERCISE_TYPE_ID)){
			if(val instanceof String ) {
				this.setExerciseTypeId((String)val);
			} else {
				this.setExerciseTypeId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_EXERCISE_TYPE)){
			this.setExerciseType((String)val);

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
		case FLD_EXERCISE_TYPE_ID:
			if(val instanceof String ) {
				this.setExerciseTypeId((String)val);
			} else {
				this.setExerciseTypeId((Integer)val);
			}
			break;
		case FLD_EXERCISE_TYPE:
			this.setExerciseType((String)val);
			break;

			default:
	           
		}
	}
	
	@Override 
    public Object getAttribute(final String fieldKey){
		if (fieldKey==null) {
			return null;

		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EXERCISE_TYPE_ID)){
			return this.getExerciseTypeId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EXERCISE_TYPE)){
			return this.getExerciseType();

		} else {
			return null;
		}
		
	}
	
	@Override
	public Object getAttribute(final int fieldKey){
		
		switch (fieldKey) {
            
		case FLD_EXERCISE_TYPE_ID:
			return this.getExerciseTypeId();
		case FLD_EXERCISE_TYPE:
			return this.getExerciseType();

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
		return ExerciseTypeModelBase.FLD_EXERCISE_TYPE_ID;
	}


	
	public void copy(final ExerciseTypeModelBase newMo) {
		
newMo.setExerciseType(this.getExerciseType());

		
	}
	
   @Override
    public boolean isEmpty() {
		return (this.getExerciseType() == null );
 
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
		if (  !(aThat instanceof ExerciseType)  && !(aThat instanceof ExerciseTypeModelBase) ) {
			return false;
		}
		//Alternative to the above line :
		//if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

		//cast to native object is now safe
		ExerciseTypeModelBase that = (ExerciseTypeModelBase)aThat;
		
		// below we do a field-by-field evaluation, including array lists
		return  EqualsUtil.areEqual(this.exerciseType, that.exerciseType)
			;

	  }
	  
	@Override
	public int hashCode() {
		int hash = 5;
	hash = 11 * hash + (this.exerciseType != null ? this.exerciseType.hashCode() : 0);

		return hash;
	}

	
}
