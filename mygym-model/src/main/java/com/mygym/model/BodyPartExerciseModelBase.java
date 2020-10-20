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
        comments = "Model Object mapped to table body_part_exercise ",
        date = "Tue Oct 20 21:24:13 EEST 2020"
    )
@DefaultMapper(mapperclass=BodyPartExerciseDBMapper.class)
@ManagedDatabaseTable(		tableName="body_part_exercise" , 
							modelObjectIdentifyBy=EnumModelObjectIdentifyBy.INTEGER_PRIMARY_KEY	)
@JsonIgnoreProperties(value = {"stale","loading","children","parents","initialKeyValue","allowIdChange","empty","keyFieldIndex","validators","selfOrRelatedDirty"},ignoreUnknown = true)
public class BodyPartExerciseModelBase extends com.mygym.model.base.JsonModelObject  {
	
	public static final String STR_FLD_BODY_PART_EXERCISE_ID = "BodyPartExerciseId";
	public static final String STR_FLD_BODY_PART_ID = "BodyPartId";
	public static final String STR_FLD_EXERCISE_ID = "ExerciseId";

	/** Association constants **/


	public static final int FLD_BODY_PART_EXERCISE_ID = 1;
	public static final int FLD_BODY_PART_ID = 2;
	public static final int FLD_EXERCISE_ID = 3;


	@KeyField
	@MOColumn(fieldName=STR_FLD_BODY_PART_EXERCISE_ID,fieldType=Integer.class,dbFieldName="body_part_exercise_id")
	private Integer bodyPartExerciseId;
	@MOColumn(fieldName=STR_FLD_BODY_PART_ID,fieldType=Integer.class,dbFieldName="body_part_id")
	private Integer bodyPartId;
	@MOColumn(fieldName=STR_FLD_EXERCISE_ID,fieldType=Integer.class,dbFieldName="exercise_id")
	private Integer exerciseId;

    
   /**
    * BodyPartExerciseModelBase Constructor
    */
	public BodyPartExerciseModelBase() {
        super();
		this.setId( com.netu.lib.Model.ModelObjectKeyGen.nextId() );

	}

	@JsonProperty
	public void setBodyPartExerciseId(final Integer bodyPartExerciseId) {
		if (valueChanged(this.bodyPartExerciseId,bodyPartExerciseId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_BODY_PART_EXERCISE_ID,ONE);
			this.bodyPartExerciseId = bodyPartExerciseId;
		}
	}

	@JsonIgnore
	public void setBodyPartExerciseId(final String bodyPartExerciseId) {
		if (org.apache.commons.lang.StringUtils.isBlank(bodyPartExerciseId)){return;} //we do not want to allow null primary key
		this.setBodyPartExerciseId(NetuUtils.parseInt(bodyPartExerciseId));

	}
	@JsonProperty
	public Integer getBodyPartExerciseId() {
		return this.bodyPartExerciseId;
	}

	@JsonIgnore
public int getBodyPartExerciseIdInt() {
		if (this.getBodyPartExerciseId()==null){return 0;}
		return this.getBodyPartExerciseId();
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

	@Override
	@JsonIgnore
	public final void setId(final Object val) {
		this.setBodyPartExerciseId(((Long)val).intValue());
		this.broadcastIdChange(); //also broadcast id changed to children objects
	}
	@Override
	@JsonProperty
	public Object getId() {
		return this.getBodyPartExerciseId();
	}

	
	@Override
	public void setAttribute(final String fieldKey, final Object val){
		if (fieldKey==null) {
			
		} else if ( fieldKey.equals(STR_FLD_BODY_PART_EXERCISE_ID)){
			if(val instanceof String ) {
				this.setBodyPartExerciseId((String)val);
			} else {
				this.setBodyPartExerciseId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_BODY_PART_ID)){
			if(val instanceof String ) {
				this.setBodyPartId((String)val);
			} else {
				this.setBodyPartId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_EXERCISE_ID)){
			if(val instanceof String ) {
				this.setExerciseId((String)val);
			} else {
				this.setExerciseId((Integer)val);
			}

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
		case FLD_BODY_PART_EXERCISE_ID:
			if(val instanceof String ) {
				this.setBodyPartExerciseId((String)val);
			} else {
				this.setBodyPartExerciseId((Integer)val);
			}
			break;
		case FLD_BODY_PART_ID:
			if(val instanceof String ) {
				this.setBodyPartId((String)val);
			} else {
				this.setBodyPartId((Integer)val);
			}
			break;
		case FLD_EXERCISE_ID:
			if(val instanceof String ) {
				this.setExerciseId((String)val);
			} else {
				this.setExerciseId((Integer)val);
			}
			break;

			default:
	           
		}
	}
	
	@Override 
    public Object getAttribute(final String fieldKey){
		if (fieldKey==null) {
			return null;

		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_BODY_PART_EXERCISE_ID)){
			return this.getBodyPartExerciseId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_BODY_PART_ID)){
			return this.getBodyPartId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EXERCISE_ID)){
			return this.getExerciseId();

		} else {
			return null;
		}
		
	}
	
	@Override
	public Object getAttribute(final int fieldKey){
		
		switch (fieldKey) {
            
		case FLD_BODY_PART_EXERCISE_ID:
			return this.getBodyPartExerciseId();
		case FLD_BODY_PART_ID:
			return this.getBodyPartId();
		case FLD_EXERCISE_ID:
			return this.getExerciseId();

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
		return BodyPartExerciseModelBase.FLD_BODY_PART_EXERCISE_ID;
	}


	
	public void copy(final BodyPartExerciseModelBase newMo) {
		
newMo.setBodyPartId(this.getBodyPartId());
			newMo.setExerciseId(this.getExerciseId());

		
	}
	
   @Override
    public boolean isEmpty() {
		return (this.getBodyPartId() == null  && 
				this.getExerciseId() == null );
 
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
		if (  !(aThat instanceof BodyPartExercise)  && !(aThat instanceof BodyPartExerciseModelBase) ) {
			return false;
		}
		//Alternative to the above line :
		//if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

		//cast to native object is now safe
		BodyPartExerciseModelBase that = (BodyPartExerciseModelBase)aThat;
		
		// below we do a field-by-field evaluation, including array lists
		return  EqualsUtil.areEqual(this.bodyPartId, that.bodyPartId)
			 && EqualsUtil.areEqual(this.exerciseId, that.exerciseId)
			;

	  }
	  
	@Override
	public int hashCode() {
		int hash = 5;
	hash = 11 * hash + (this.bodyPartId != null ? this.bodyPartId.hashCode() : 0);
	hash = 11 * hash + (this.exerciseId != null ? this.exerciseId.hashCode() : 0);

		return hash;
	}

	
}
