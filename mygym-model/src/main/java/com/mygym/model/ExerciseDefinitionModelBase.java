package com.mygym.model;
import com.netu.lib.Model.ModelObject;
import com.netu.lib.Model.OracleModelObject;

import com.netu.lib.Model.ModelObjectList;
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
import com.netu.lib.Model.annotations.MOManyChildGetter;
import com.netu.lib.Model.annotations.MOParentGetter;


/**
 * WARNING: Do not change the generated code. Instead use the class
 * that extends this class and put custom code there, overriding any methods
 * that you need to override
 */
@Generated(
        value = {"com.netu.codeGen.XMLModelGenerator, Version 3"},
        comments = "Model Object mapped to table exercise_definition ",
        date = "Mon Jan 25 15:04:43 EET 2021"
    )
@DefaultMapper(mapperclass=ExerciseDefinitionDBMapper.class)
@ManagedDatabaseTable(		tableName="exercise_definition" , 
							modelObjectIdentifyBy=EnumModelObjectIdentifyBy.INTEGER_PRIMARY_KEY	)
@JsonIgnoreProperties(value = {"stale","loading","children","parents","initialKeyValue","allowIdChange","empty","keyFieldIndex","validators","selfOrRelatedDirty"},ignoreUnknown = true)
public class ExerciseDefinitionModelBase extends com.netu.lib.JsonModelObject implements com.netu.lib.Model.IAuditable  {
	
	public static final String STR_FLD_EXERCISE_DEFINITION_ID = "ExerciseDefinitionId";
	public static final String STR_FLD_NAME = "Name";
	public static final String STR_FLD_VIDEO_URL = "VideoUrl";
	public static final String STR_FLD_DESCRIPTION = "Description";
	public static final String STR_FLD_EQUIPMENT_ID = "EquipmentId";
	public static final String STR_FLD_CREATE_DATE = "CreateDate";
	public static final String STR_FLD_UPDATE_DATE = "UpdateDate";
	public static final String STR_FLD_CREATE_USER = "CreateUser";
	public static final String STR_FLD_UPDATE_USER = "UpdateUser";

	/** Association constants **/
	public static final String ASSOC_BODYPARTSAFFECTED = "BodyPartsAffected";
	public static final String ASSOC_EXERCISETYPES = "ExerciseTypes";
	public static final String ASSOC_EQUIPMENTNEEDED = "EquipmentNeeded";


	public static final int FLD_EXERCISE_DEFINITION_ID = 1;
	public static final int FLD_NAME = 2;
	public static final int FLD_VIDEO_URL = 3;
	public static final int FLD_DESCRIPTION = 4;
	public static final int FLD_EQUIPMENT_ID = 5;
	public static final int FLD_CREATE_DATE = 6;
	public static final int FLD_UPDATE_DATE = 7;
	public static final int FLD_CREATE_USER = 8;
	public static final int FLD_UPDATE_USER = 9;


	@KeyField
	@MOColumn(fieldName=STR_FLD_EXERCISE_DEFINITION_ID,fieldType=Integer.class,dbFieldName="exercise_definition_id")
	private Integer exerciseDefinitionId;
	@MOColumn(fieldName=STR_FLD_NAME,fieldType=String.class,dbFieldName="name")
	private String name;
	@MOColumn(fieldName=STR_FLD_VIDEO_URL,fieldType=String.class,dbFieldName="video_url")
	private String videoUrl;
	@MOColumn(fieldName=STR_FLD_DESCRIPTION,fieldType=String.class,dbFieldName="description")
	private String description;
	@MOColumn(fieldName=STR_FLD_EQUIPMENT_ID,fieldType=Integer.class,dbFieldName="equipment_id")
	private Integer equipmentId;
	@MOColumn(fieldName=STR_FLD_CREATE_DATE,fieldType=java.util.Date.class,dbFieldName="create_date")
	private java.util.Date createDate;
	@MOColumn(fieldName=STR_FLD_UPDATE_DATE,fieldType=java.util.Date.class,dbFieldName="update_date")
	private java.util.Date updateDate;
	@MOColumn(fieldName=STR_FLD_CREATE_USER,fieldType=String.class,dbFieldName="create_user")
	private String createUser;
	@MOColumn(fieldName=STR_FLD_UPDATE_USER,fieldType=String.class,dbFieldName="update_user")
	private String updateUser;

	// ****** CHILD/PARENT variables ********************
	@JsonIgnore
	private ModelObjectList<BodyPartExercise> bodyPartsAffected=null; // initialize CHILD to null.
	@JsonIgnore
	private ModelObjectList<ExerciseTypeLink> exerciseTypes=null; // initialize CHILD to null.
	@JsonIgnore
	private Equipment equipmentNeeded=null; // initialize PARENT to null.

	// ****** END CHILD/PARENT variables ********************

	@Override
	public java.util.HashMap<String, Object> getChildren() {
		java.util.HashMap<String, Object> ret = new java.util.HashMap<String, Object>();

			ret.put(ASSOC_BODYPARTSAFFECTED,bodyPartsAffected);
			ret.put(ASSOC_EXERCISETYPES,exerciseTypes);
		return ret;
	}

	@Override
	public java.util.HashMap<String, Object> getParents() {
		java.util.HashMap<String, Object> ret = new java.util.HashMap<String, Object>();

			ret.put(ASSOC_EQUIPMENTNEEDED,equipmentNeeded);
		return ret;
	}

    
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

	@JsonProperty
	public void setDescription(final String description) {
		if (description!=null && description.length()>1500){
			throw new IllegalArgumentException("Too Large Value for field->Description.  max length:1500");
		}
		if (valueChanged(this.description,description)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_DESCRIPTION,ONE);
			this.description = description;
		}
	}

	@JsonProperty
	public String getDescription() {
		return this.description;
	}

	@JsonProperty
	public void setEquipmentId(final Integer equipmentId) {
		if (valueChanged(this.equipmentId,equipmentId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_EQUIPMENT_ID,ONE);
			this.equipmentId = equipmentId;
		}
	}

	@JsonIgnore
	public void setEquipmentId(final String equipmentId) {
		this.setEquipmentId(NetuUtils.parseInt(equipmentId));

	}
	@JsonProperty
	public Integer getEquipmentId() {
		return this.equipmentId;
	}

	@JsonIgnore
public int getEquipmentIdInt() {
		if (this.getEquipmentId()==null){return 0;}
		return this.getEquipmentId();
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
		this.setExerciseDefinitionId(((Long)val).intValue());
		this.broadcastIdChange(); //also broadcast id changed to children objects
	}
	@Override
	@JsonProperty
	public Object getId() {
		return this.getExerciseDefinitionId();
	}

	// ASSOCIATIONS GETTERS/SETTERS BELOW!

	public boolean bodyPartsAffectedLoaded() {
	//returns true if associated object or object list has been loaded.
		return this.bodyPartsAffected != null;
	}
	public BodyPartExercise createBodyPartsAffected() { // association create child
		BodyPartExercise var = new BodyPartExercise();
		this.addBodyPartsAffected(var);
		return var;

	}

	public void setBodyPartsAffected(ModelObjectList<BodyPartExercise> _bodyPartsAffected) {
		this.bodyPartsAffected = _bodyPartsAffected;
		this.addChild(this.bodyPartsAffected, "bodyPartsAffected"); // add object to the children collection
	}

	@MOManyChildGetter
	public ModelObjectList<BodyPartExercise> getBodyPartsAffected() {
		//lazy load!!!!
		if(this.bodyPartsAffected==null) {
			if (this.isNew()) {
				this.setBodyPartsAffected(new ModelObjectList<BodyPartExercise>());
			} else {
				this.setBodyPartsAffected( 
					 this.getExerciseDefinitionId()==null ? null :
					BodyPartExerciseDBMapper.getAll( "exercise_id=?", this.getExerciseDefinitionId() ));//cardinality * lazy load v3
			}
		}
		return this.bodyPartsAffected;
	}

	public void addBodyPartsAffected(BodyPartExercise _var) {
		_var.setExerciseId(this.getExerciseDefinitionId());// check@ getterChild @
		this.getBodyPartsAffected().add(_var);
	}
	public void removeBodyPartsAffected(BodyPartExercise _var) {
		this.getBodyPartsAffected().remove(_var);
	}

	public boolean exerciseTypesLoaded() {
	//returns true if associated object or object list has been loaded.
		return this.exerciseTypes != null;
	}
	public ExerciseTypeLink createExerciseTypes() { // association create child
		ExerciseTypeLink var = new ExerciseTypeLink();
		this.addExerciseTypes(var);
		return var;

	}

	public void setExerciseTypes(ModelObjectList<ExerciseTypeLink> _exerciseTypes) {
		this.exerciseTypes = _exerciseTypes;
		this.addChild(this.exerciseTypes, "exerciseTypes"); // add object to the children collection
	}

	@MOManyChildGetter
	public ModelObjectList<ExerciseTypeLink> getExerciseTypes() {
		//lazy load!!!!
		if(this.exerciseTypes==null) {
			if (this.isNew()) {
				this.setExerciseTypes(new ModelObjectList<ExerciseTypeLink>());
			} else {
				this.setExerciseTypes( 
					 this.getExerciseDefinitionId()==null ? null :
					ExerciseTypeLinkDBMapper.getAll( "exercise_id=?", this.getExerciseDefinitionId() ));//cardinality * lazy load v3
			}
		}
		return this.exerciseTypes;
	}

	public void addExerciseTypes(ExerciseTypeLink _var) {
		_var.setExerciseId(this.getExerciseDefinitionId());// check@ getterChild @
		this.getExerciseTypes().add(_var);
	}
	public void removeExerciseTypes(ExerciseTypeLink _var) {
		this.getExerciseTypes().remove(_var);
	}

	public boolean equipmentNeededLoaded() {
	//returns true if associated object or object list has been loaded.
		return this.equipmentNeeded != null;
	}
	public Equipment createEquipmentNeeded() { // association create prnt
		Equipment var = new Equipment();
		this.setEquipmentNeeded(var);
		return var;

	}

	public void setEquipmentNeeded(Equipment equipmentNeeded) {
		this.equipmentNeeded = equipmentNeeded;
		if(equipmentNeeded != null){
			this.setEquipmentId(equipmentNeeded.getEquipmentId()); //@@check parent->child!!
		}
		this.addChild(this.equipmentNeeded, "equipmentNeeded"); // add object to the children collection
	}

	@MOParentGetter
	public Equipment getEquipmentNeeded() {
		//lazy load!!!!
		if(this.equipmentNeeded==null) {
			if (this.getEquipmentId()==null) {
				return null;
			} else {
				this.setEquipmentNeeded(
				EquipmentDBMapper.get("Equipment_id=?",
							new Object[]{this.getEquipmentId()} ));//cardinality 1, parent lazy load.
			}
		}
		return this.equipmentNeeded;
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
		} else if ( fieldKey.equals(STR_FLD_DESCRIPTION)){
			this.setDescription((String)val);
		} else if ( fieldKey.equals(STR_FLD_EQUIPMENT_ID)){
			if(val instanceof String ) {
				this.setEquipmentId((String)val);
			} else {
				this.setEquipmentId((Integer)val);
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
		} else if ( fieldKey.equalsIgnoreCase(ASSOC_BODYPARTSAFFECTED)){
			this.setBodyPartsAffected((ModelObjectList<BodyPartExercise>)val);
		} else if ( fieldKey.equalsIgnoreCase(ASSOC_EXERCISETYPES)){
			this.setExerciseTypes((ModelObjectList<ExerciseTypeLink>)val);
		} else if ( fieldKey.equalsIgnoreCase(ASSOC_EQUIPMENTNEEDED)){
			this.setEquipmentNeeded((Equipment)val);

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
		if(ASSOC_BODYPARTSAFFECTED.equalsIgnoreCase(relationName)) {
			ret = this.createBodyPartsAffected();
		}
		if(ASSOC_EXERCISETYPES.equalsIgnoreCase(relationName)) {
			ret = this.createExerciseTypes();
		}
		if(ASSOC_EQUIPMENTNEEDED.equalsIgnoreCase(relationName)) {
			ret = this.createEquipmentNeeded();
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

		if(ASSOC_BODYPARTSAFFECTED.equalsIgnoreCase(relationName)) {
			return BodyPartExercise.class;
		}
		if(ASSOC_EXERCISETYPES.equalsIgnoreCase(relationName)) {
			return ExerciseTypeLink.class;
		}
		if(ASSOC_EQUIPMENTNEEDED.equalsIgnoreCase(relationName)) {
			return Equipment.class;
		}
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
		case FLD_DESCRIPTION:
			this.setDescription((String)val);
			break;
		case FLD_EQUIPMENT_ID:
			if(val instanceof String ) {
				this.setEquipmentId((String)val);
			} else {
				this.setEquipmentId((Integer)val);
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

		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EXERCISE_DEFINITION_ID)){
			return this.getExerciseDefinitionId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_NAME)){
			return this.getName();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_VIDEO_URL)){
			return this.getVideoUrl();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_DESCRIPTION)){
			return this.getDescription();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EQUIPMENT_ID)){
			return this.getEquipmentId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_CREATE_DATE)){
			return this.getCreateDate();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_UPDATE_DATE)){
			return this.getUpdateDate();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_CREATE_USER)){
			return this.getCreateUser();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_UPDATE_USER)){
			return this.getUpdateUser();
		} else if ( fieldKey.equalsIgnoreCase(ASSOC_BODYPARTSAFFECTED)){
			return this.getBodyPartsAffected();
		} else if ( fieldKey.equalsIgnoreCase(ASSOC_EXERCISETYPES)){
			return this.getExerciseTypes();
		} else if ( fieldKey.equalsIgnoreCase(ASSOC_EQUIPMENTNEEDED)){
			return this.getEquipmentNeeded();

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
		case FLD_DESCRIPTION:
			return this.getDescription();
		case FLD_EQUIPMENT_ID:
			return this.getEquipmentId();
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
		return ExerciseDefinitionModelBase.FLD_EXERCISE_DEFINITION_ID;
	}

	@Override
	public void parentIdChanged(ModelObject parentMo){
		if(parentMo instanceof Equipment){
			this.setEquipmentId(((Equipment)parentMo).getEquipmentId());
		}
	}

	
	public void copy(final ExerciseDefinitionModelBase newMo) {
		
newMo.setName(this.getName());
			newMo.setVideoUrl(this.getVideoUrl());
			newMo.setDescription(this.getDescription());
			newMo.setEquipmentId(this.getEquipmentId());
			newMo.setCreateDate(this.getCreateDate());
			newMo.setUpdateDate(this.getUpdateDate());
			newMo.setCreateUser(this.getCreateUser());
			newMo.setUpdateUser(this.getUpdateUser());

		
	}
	
   @Override
    public boolean isEmpty() {
		return (this.getName() == null  && 
				this.getVideoUrl() == null  && 
				this.getDescription() == null  && 
				this.getEquipmentId() == null  && 
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
			 && EqualsUtil.areEqual(this.description, that.description)
			 && EqualsUtil.areEqual(this.equipmentId, that.equipmentId)
			 && EqualsUtil.areEqual(this.createDate, that.createDate)
			 && EqualsUtil.areEqual(this.updateDate, that.updateDate)
			 && EqualsUtil.areEqual(this.createUser, that.createUser)
			 && EqualsUtil.areEqual(this.updateUser, that.updateUser)
			;

	  }
	  
	@Override
	public int hashCode() {
		int hash = 5;
	hash = 11 * hash + (this.name != null ? this.name.hashCode() : 0);
	hash = 11 * hash + (this.videoUrl != null ? this.videoUrl.hashCode() : 0);
	hash = 11 * hash + (this.description != null ? this.description.hashCode() : 0);
	hash = 11 * hash + (this.equipmentId != null ? this.equipmentId.hashCode() : 0);
	hash = 11 * hash + (this.createDate != null ? this.createDate.hashCode() : 0);
	hash = 11 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
	hash = 11 * hash + (this.createUser != null ? this.createUser.hashCode() : 0);
	hash = 11 * hash + (this.updateUser != null ? this.updateUser.hashCode() : 0);

		return hash;
	}

	
}
