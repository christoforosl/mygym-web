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
        comments = "Model Object mapped to table exercise_definition ",
        date = "Thu Oct 22 12:40:06 EEST 2020"
    )
@DefaultMapper(mapperclass=ExerciseDefinitionDBMapper.class)
@ManagedDatabaseTable(		tableName="exercise_definition" , 
							modelObjectIdentifyBy=EnumModelObjectIdentifyBy.INTEGER_PRIMARY_KEY	)
@JsonIgnoreProperties(value = {"stale","loading","children","parents","initialKeyValue","allowIdChange","empty","keyFieldIndex","validators","selfOrRelatedDirty"},ignoreUnknown = true)
public class ExerciseDefinitionModelBase extends com.netu.lib.JsonModelObject  {
	
	public static final String STR_FLD_EXERCISE_DEFINITION_ID = "ExerciseDefinitionId";
	public static final String STR_FLD_NAME = "Name";
	public static final String STR_FLD_VIDEO_URL = "VideoUrl";

	/** Association constants **/


	public static final int FLD_EXERCISE_DEFINITION_ID = 1;
	public static final int FLD_NAME = 2;
	public static final int FLD_VIDEO_URL = 3;


	@KeyField
	@MOColumn(fieldName=STR_FLD_EXERCISE_DEFINITION_ID,fieldType=Integer.class,dbFieldName="EXERCISE_DEFINITION_ID")
	private Integer exerciseDefinitionId;
	@MOColumn(fieldName=STR_FLD_NAME,fieldType=String.class,dbFieldName="NAME")
	private String name;
	@MOColumn(fieldName=STR_FLD_VIDEO_URL,fieldType=String.class,dbFieldName="VIDEO_URL")
	private String videoUrl;

    
   /**
    * ExerciseDefinitionModelBase Constructor
    */
	public ExerciseDefinitionModelBase() {
        super();
		this.setId( com.netu.lib.Model.ModelObjectKeyGen.nextId() );

	}

	@JsonProperty
	public void setExerciseDefinitionId(final Integer exerciseDefinitionId) {
		if (valueChanged(this.exerciseDefinitionId,exerciseDefinitionId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_EXERCISE_DEFINITION_ID,ONE);
			this.exerciseDefinitionId = exerciseDefinitionId;
		}
	}

	@JsonIgnore
	public void setExerciseDefinitionId(final String exerciseDefinitionId) {
		if (org.apache.commons.lang.StringUtils.isBlank(exerciseDefinitionId)){return;} //we do not want to allow null primary key
		this.setExerciseDefinitionId(NetuUtils.parseInt(exerciseDefinitionId));

	}
	@JsonProperty
	public Integer getExerciseDefinitionId() {
		return this.exerciseDefinitionId;
	}

	@JsonIgnore
public int getExerciseDefinitionIdInt() {
		if (this.getExerciseDefinitionId()==null){return 0;}
		return this.getExerciseDefinitionId();
	}

	@JsonProperty
	public void setName(final String name) {
		if (name!=null && name.length()>500){
			throw new IllegalArgumentException("Too Large Value for field->Name.  max length:500");
		}
		if (valueChanged(this.name,name)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_NAME,ONE);
			this.name = name;
		}
	}

	@JsonProperty
	public String getName() {
		return this.name;
	}

	@JsonProperty
	public void setVideoUrl(final String videoUrl) {
		if (videoUrl!=null && videoUrl.length()>500){
			throw new IllegalArgumentException("Too Large Value for field->VideoUrl.  max length:500");
		}
		if (valueChanged(this.videoUrl,videoUrl)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_VIDEO_URL,ONE);
			this.videoUrl = videoUrl;
		}
	}

	@JsonProperty
	public String getVideoUrl() {
		return this.videoUrl;
	}

	@Override
	@JsonIgnore
	public final void setId(final Object val) {
		this.setExerciseDefinitionId(((Long)val).intValue());
		this.broadcastIdChange(); //also broadcast id changed to children objects
	}
	@Override
	@JsonProperty
	public Object getId() {
		return this.getExerciseDefinitionId();
	}

	
	@Override
	public void setAttribute(final String fieldKey, final Object val){
		if (fieldKey==null) {
			
		} else if ( fieldKey.equals(STR_FLD_EXERCISE_DEFINITION_ID)){
			if(val instanceof String ) {
				this.setExerciseDefinitionId((String)val);
			} else {
				this.setExerciseDefinitionId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_NAME)){
			this.setName((String)val);
		} else if ( fieldKey.equals(STR_FLD_VIDEO_URL)){
			this.setVideoUrl((String)val);

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
		case FLD_EXERCISE_DEFINITION_ID:
			if(val instanceof String ) {
				this.setExerciseDefinitionId((String)val);
			} else {
				this.setExerciseDefinitionId((Integer)val);
			}
			break;
		case FLD_NAME:
			this.setName((String)val);
			break;
		case FLD_VIDEO_URL:
			this.setVideoUrl((String)val);
			break;

			default:
	           
		}
	}
	
	@Override 
    public Object getAttribute(final String fieldKey){
		if (fieldKey==null) {
			return null;

		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EXERCISE_DEFINITION_ID)){
			return this.getExerciseDefinitionId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_NAME)){
			return this.getName();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_VIDEO_URL)){
			return this.getVideoUrl();

		} else {
			return null;
		}
		
	}
	
	@Override
	public Object getAttribute(final int fieldKey){
		
		switch (fieldKey) {
            
		case FLD_EXERCISE_DEFINITION_ID:
			return this.getExerciseDefinitionId();
		case FLD_NAME:
			return this.getName();
		case FLD_VIDEO_URL:
			return this.getVideoUrl();

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
		return ExerciseDefinitionModelBase.FLD_EXERCISE_DEFINITION_ID;
	}


	
	public void copy(final ExerciseDefinitionModelBase newMo) {
		
newMo.setName(this.getName());
			newMo.setVideoUrl(this.getVideoUrl());

		
	}
	
   @Override
    public boolean isEmpty() {
		return (this.getName() == null  && 
				this.getVideoUrl() == null );
 
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
		if (  !(aThat instanceof ExerciseDefinition)  && !(aThat instanceof ExerciseDefinitionModelBase) ) {
			return false;
		}
		//Alternative to the above line :
		//if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

		//cast to native object is now safe
		ExerciseDefinitionModelBase that = (ExerciseDefinitionModelBase)aThat;
		
		// below we do a field-by-field evaluation, including array lists
		return  EqualsUtil.areEqual(this.name, that.name)
			 && EqualsUtil.areEqual(this.videoUrl, that.videoUrl)
			;

	  }
	  
	@Override
	public int hashCode() {
		int hash = 5;
	hash = 11 * hash + (this.name != null ? this.name.hashCode() : 0);
	hash = 11 * hash + (this.videoUrl != null ? this.videoUrl.hashCode() : 0);

		return hash;
	}

	
}
