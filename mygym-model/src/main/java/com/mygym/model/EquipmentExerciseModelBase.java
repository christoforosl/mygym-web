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
        comments = "Model Object mapped to table equipment_exercise ",
        date = "Wed Jan 20 11:11:46 EET 2021"
    )
@DefaultMapper(mapperclass=EquipmentExerciseDBMapper.class)
@ManagedDatabaseTable(		tableName="equipment_exercise" , 
							modelObjectIdentifyBy=EnumModelObjectIdentifyBy.INTEGER_PRIMARY_KEY	)
@JsonIgnoreProperties(value = {"stale","loading","children","parents","initialKeyValue","allowIdChange","empty","keyFieldIndex","validators","selfOrRelatedDirty"},ignoreUnknown = true)
public class EquipmentExerciseModelBase extends com.netu.lib.JsonModelObject  {
	
	public static final String STR_FLD_EQUIPMENT_EXERCISE_ID = "EquipmentExerciseId";
	public static final String STR_FLD_EQUIPMENT_ID = "EquipmentId";
	public static final String STR_FLD_EXERCISE_ID = "ExerciseId";

	/** Association constants **/
	public static final String ASSOC_EQUIPMENT = "Equipment";


	public static final int FLD_EQUIPMENT_EXERCISE_ID = 1;
	public static final int FLD_EQUIPMENT_ID = 2;
	public static final int FLD_EXERCISE_ID = 3;


	@KeyField
	@MOColumn(fieldName=STR_FLD_EQUIPMENT_EXERCISE_ID,fieldType=Integer.class,dbFieldName="equipment_exercise_id")
	private Integer equipmentExerciseId;
	@MOColumn(fieldName=STR_FLD_EQUIPMENT_ID,fieldType=Integer.class,dbFieldName="equipment_id")
	private Integer equipmentId;
	@MOColumn(fieldName=STR_FLD_EXERCISE_ID,fieldType=Integer.class,dbFieldName="exercise_id")
	private Integer exerciseId;

	// ****** CHILD/PARENT variables ********************
	private Equipment equipment=null; // initialize PARENT to null.

	// ****** END CHILD/PARENT variables ********************

	@Override
	public java.util.HashMap<String, Object> getParents() {
		java.util.HashMap<String, Object> ret = new java.util.HashMap<String, Object>();

			ret.put(ASSOC_EQUIPMENT,equipment);
		return ret;
	}

    
   /**
    * EquipmentExerciseModelBase Constructor
    */
	public EquipmentExerciseModelBase() {
        super();
		this.setId( com.netu.lib.Model.ModelObjectKeyGen.nextId() );

	}

	@JsonProperty
	public void setEquipmentExerciseId(final Integer equipmentExerciseId) {
		if (valueChanged(this.equipmentExerciseId,equipmentExerciseId)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_EQUIPMENT_EXERCISE_ID,ONE);
			this.equipmentExerciseId = equipmentExerciseId;
		}
	}

	@JsonIgnore
	public void setEquipmentExerciseId(final String equipmentExerciseId) {
		if (org.apache.commons.lang.StringUtils.isBlank(equipmentExerciseId)){return;} //we do not want to allow null primary key
		this.setEquipmentExerciseId(NetuUtils.parseInt(equipmentExerciseId));

	}
	@JsonProperty
	public Integer getEquipmentExerciseId() {
		return this.equipmentExerciseId;
	}

	@JsonIgnore
public int getEquipmentExerciseIdInt() {
		if (this.getEquipmentExerciseId()==null){return 0;}
		return this.getEquipmentExerciseId();
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
		this.setEquipmentExerciseId(((Long)val).intValue());
		this.broadcastIdChange(); //also broadcast id changed to children objects
	}
	@Override
	@JsonProperty
	public Object getId() {
		return this.getEquipmentExerciseId();
	}

	// ASSOCIATIONS GETTERS/SETTERS BELOW!

	public boolean equipmentLoaded() {
	//returns true if associated object or object list has been loaded.
		return this.equipment != null;
	}
	public Equipment createEquipment() { // association create prnt
		Equipment var = new Equipment();
		this.setEquipment(var);
		return var;

	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
		if(equipment != null){
			this.setEquipmentId(equipment.getEquipmentId()); //@@check parent->child!!
		}
		this.addChild(this.equipment, "equipment"); // add object to the children collection
	}

	public Equipment getEquipment() {
		//lazy load!!!!
		if(this.equipment==null) {
			if (this.getEquipmentId()==null) {
				return null;
			} else {
				this.setEquipment(
				EquipmentDBMapper.get("equipment_id=?",
							new Object[]{this.getEquipmentId()} ));//cardinality 1, parent lazy load.
			}
		}
		return this.equipment;
	}


	
	@Override
	public void setAttribute(final String fieldKey, final Object val){
		if (fieldKey==null) {
			
		} else if ( fieldKey.equals(STR_FLD_EQUIPMENT_EXERCISE_ID)){
			if(val instanceof String ) {
				this.setEquipmentExerciseId((String)val);
			} else {
				this.setEquipmentExerciseId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_EQUIPMENT_ID)){
			if(val instanceof String ) {
				this.setEquipmentId((String)val);
			} else {
				this.setEquipmentId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_EXERCISE_ID)){
			if(val instanceof String ) {
				this.setExerciseId((String)val);
			} else {
				this.setExerciseId((Integer)val);
			}
		} else if ( fieldKey.equalsIgnoreCase(ASSOC_EQUIPMENT)){
			this.setEquipment((Equipment)val);

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
		if(ASSOC_EQUIPMENT.equalsIgnoreCase(relationName)) {
			ret = this.createEquipment();
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

		if(ASSOC_EQUIPMENT.equalsIgnoreCase(relationName)) {
			return Equipment.class;
		}
		return null;


	}


	@Override
	public void setAttribute(final int fieldKey, final Object val){
	
	    switch (fieldKey) {
		case FLD_EQUIPMENT_EXERCISE_ID:
			if(val instanceof String ) {
				this.setEquipmentExerciseId((String)val);
			} else {
				this.setEquipmentExerciseId((Integer)val);
			}
			break;
		case FLD_EQUIPMENT_ID:
			if(val instanceof String ) {
				this.setEquipmentId((String)val);
			} else {
				this.setEquipmentId((Integer)val);
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

		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EQUIPMENT_EXERCISE_ID)){
			return this.getEquipmentExerciseId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EQUIPMENT_ID)){
			return this.getEquipmentId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EXERCISE_ID)){
			return this.getExerciseId();
		} else if ( fieldKey.equalsIgnoreCase(ASSOC_EQUIPMENT)){
			return this.getEquipment();

		} else {
			return null;
		}
		
	}
	
	@Override
	public Object getAttribute(final int fieldKey){
		
		switch (fieldKey) {
            
		case FLD_EQUIPMENT_EXERCISE_ID:
			return this.getEquipmentExerciseId();
		case FLD_EQUIPMENT_ID:
			return this.getEquipmentId();
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
		return EquipmentExerciseModelBase.FLD_EQUIPMENT_EXERCISE_ID;
	}

	@Override
	public void parentIdChanged(ModelObject parentMo){
		if(parentMo instanceof Equipment){
			this.setEquipmentId(((Equipment)parentMo).getEquipmentId());
		}
	}

	
	public void copy(final EquipmentExerciseModelBase newMo) {
		
newMo.setEquipmentId(this.getEquipmentId());
			newMo.setExerciseId(this.getExerciseId());

		
	}
	
   @Override
    public boolean isEmpty() {
		return (this.getEquipmentId() == null  && 
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
		if (  !(aThat instanceof EquipmentExercise)  && !(aThat instanceof EquipmentExerciseModelBase) ) {
			return false;
		}
		//Alternative to the above line :
		//if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

		//cast to native object is now safe
		EquipmentExerciseModelBase that = (EquipmentExerciseModelBase)aThat;
		
		// below we do a field-by-field evaluation, including array lists
		return  EqualsUtil.areEqual(this.equipmentId, that.equipmentId)
			 && EqualsUtil.areEqual(this.exerciseId, that.exerciseId)
			;

	  }
	  
	@Override
	public int hashCode() {
		int hash = 5;
	hash = 11 * hash + (this.equipmentId != null ? this.equipmentId.hashCode() : 0);
	hash = 11 * hash + (this.exerciseId != null ? this.exerciseId.hashCode() : 0);

		return hash;
	}

	
}
