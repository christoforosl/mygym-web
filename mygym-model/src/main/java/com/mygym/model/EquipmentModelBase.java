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
        comments = "Model Object mapped to table equipment ",
        date = "Wed Jan 20 11:11:45 EET 2021"
    )
@DefaultMapper(mapperclass=EquipmentDBMapper.class)
@ManagedDatabaseTable(		tableName="equipment" , 
							modelObjectIdentifyBy=EnumModelObjectIdentifyBy.INTEGER_PRIMARY_KEY	)
@JsonIgnoreProperties(value = {"stale","loading","children","parents","initialKeyValue","allowIdChange","empty","keyFieldIndex","validators","selfOrRelatedDirty"},ignoreUnknown = true)
public class EquipmentModelBase extends com.netu.lib.JsonModelObject  {
	
	public static final String STR_FLD_EQUIPMENT_ID = "EquipmentId";
	public static final String STR_FLD_EQUIPMENT_NAME = "EquipmentName";

	/** Association constants **/


	public static final int FLD_EQUIPMENT_ID = 1;
	public static final int FLD_EQUIPMENT_NAME = 2;


	@KeyField
	@MOColumn(fieldName=STR_FLD_EQUIPMENT_ID,fieldType=Integer.class,dbFieldName="equipment_id")
	private Integer equipmentId;
	@MOColumn(fieldName=STR_FLD_EQUIPMENT_NAME,fieldType=String.class,dbFieldName="equipment_name")
	private String equipmentName;

    
   /**
    * EquipmentModelBase Constructor
    */
	public EquipmentModelBase() {
        super();
		this.setId( com.netu.lib.Model.ModelObjectKeyGen.nextId() );

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
		if (org.apache.commons.lang.StringUtils.isBlank(equipmentId)){return;} //we do not want to allow null primary key
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
	public void setEquipmentName(final String equipmentName) {
		if (equipmentName!=null && equipmentName.length()>500){
			throw new IllegalArgumentException("Too Large Value for field->EquipmentName.  max length:500");
		}
		if (valueChanged(this.equipmentName,equipmentName)){
			this.setDirty(true);
			this.changedFields.put(STR_FLD_EQUIPMENT_NAME,ONE);
			this.equipmentName = equipmentName;
		}
	}

	@JsonProperty
	public String getEquipmentName() {
		return this.equipmentName;
	}

	@Override
	@JsonIgnore
	public final void setId(final Object val) {
		this.setEquipmentId(((Long)val).intValue());
		this.broadcastIdChange(); //also broadcast id changed to children objects
	}
	@Override
	@JsonProperty
	public Object getId() {
		return this.getEquipmentId();
	}

	
	@Override
	public void setAttribute(final String fieldKey, final Object val){
		if (fieldKey==null) {
			
		} else if ( fieldKey.equals(STR_FLD_EQUIPMENT_ID)){
			if(val instanceof String ) {
				this.setEquipmentId((String)val);
			} else {
				this.setEquipmentId((Integer)val);
			}
		} else if ( fieldKey.equals(STR_FLD_EQUIPMENT_NAME)){
			this.setEquipmentName((String)val);

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
		case FLD_EQUIPMENT_ID:
			if(val instanceof String ) {
				this.setEquipmentId((String)val);
			} else {
				this.setEquipmentId((Integer)val);
			}
			break;
		case FLD_EQUIPMENT_NAME:
			this.setEquipmentName((String)val);
			break;

			default:
	           
		}
	}
	
	@Override 
    public Object getAttribute(final String fieldKey){
		if (fieldKey==null) {
			return null;

		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EQUIPMENT_ID)){
			return this.getEquipmentId();
		} else if ( fieldKey.equalsIgnoreCase(STR_FLD_EQUIPMENT_NAME)){
			return this.getEquipmentName();

		} else {
			return null;
		}
		
	}
	
	@Override
	public Object getAttribute(final int fieldKey){
		
		switch (fieldKey) {
            
		case FLD_EQUIPMENT_ID:
			return this.getEquipmentId();
		case FLD_EQUIPMENT_NAME:
			return this.getEquipmentName();

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
		return EquipmentModelBase.FLD_EQUIPMENT_ID;
	}


	
	public void copy(final EquipmentModelBase newMo) {
		
newMo.setEquipmentName(this.getEquipmentName());

		
	}
	
   @Override
    public boolean isEmpty() {
		return (this.getEquipmentName() == null );
 
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
		if (  !(aThat instanceof Equipment)  && !(aThat instanceof EquipmentModelBase) ) {
			return false;
		}
		//Alternative to the above line :
		//if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

		//cast to native object is now safe
		EquipmentModelBase that = (EquipmentModelBase)aThat;
		
		// below we do a field-by-field evaluation, including array lists
		return  EqualsUtil.areEqual(this.equipmentName, that.equipmentName)
			;

	  }
	  
	@Override
	public int hashCode() {
		int hash = 5;
	hash = 11 * hash + (this.equipmentName != null ? this.equipmentName.hashCode() : 0);

		return hash;
	}

	
}
