package com.mygym.model;

import com.netu.lib.ApplicationService;
import com.netu.lib.DBUtils;
import com.netu.lib.Model.MODeleteViolationException;
import com.netu.lib.Model.MOTranslatedValidationException;
import com.netu.lib.Model.ModelObject;

import com.netu.lib.db.ConnectionPool;

import com.netu.lib.db.DBMapper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import com.netu.lib.Model.ModelObjectList;
import com.netu.lib.db.MySQLDBMapper;
import com.netu.lib.Model.annotations.DMLQueries;

import javax.annotation.Generated;

/**
 * Gen: Version 3, MapperBase.mysql.txt
 * Class autogenerated on <DATE>Wed Jan 20 11:11:45 EET 2021</DATE> by com.netu.codeGen.XMLModelGenerator.<br>
 * Class for Database Data Mapper Pattern for table <b>equipment</b>.<br>
 * <b>!!!!!!!! DO NOT MODIFY CODE OF THIS CLASS!!!!!!!!</b><br>
 * This class has the responsibility of loading 
 * data into Model Objects, and saving them back to 
 * the Database
 */
@Generated(
        value = {"com.netu.codeGen.XMLModelGenerator"},
        comments = "Mapper Object for table equipment ",
        date = "Wed Jan 20 11:11:45 EET 2021"
    )
@DMLQueries(
	update="update equipment set equipment_name=? where equipment_id=?",
	updateRowid="",
	delete="DELETE FROM equipment WHERE equipment_id=?",
	deleteRowid="",
	insert="insert into equipment (equipment_name) values (?)",
	selectone="SELECT t.equipment_id, t.equipment_name FROM  equipment t  WHERE equipment_id=?",
	selectall="SELECT t.equipment_id, t.equipment_name FROM  equipment t ",
	pagingSelect="SELECT t.equipment_id, t.equipment_name FROM  equipment t  {criteria} LIMIT {offset}, {pageSize}")
public class EquipmentDBMapper extends MySQLDBMapper  {
	
	public EquipmentDBMapper(Connection c) {
		super(c);
	}
	public EquipmentDBMapper() {
                // empty constructor, used in dynamic instantiations
		// will get a connection from the ApplicationService
		super();
	}
	
	/**
	* Clients can override this to return a custom class for loading
	*/
	public Equipment getInstanceForLoad() {
		
		return new Equipment();
		
	}
		
	public ModelObject load(Object ors) {
		
		ResultSet rs = (ResultSet)ors;
		
		Equipment ret = this.getInstanceForLoad();
		try {
			ret.setLoading(true);
			
			ret.setEquipmentId(readInt(rs,Equipment.FLD_EQUIPMENT_ID));
			ret.setEquipmentName(rs.getString(Equipment.FLD_EQUIPMENT_NAME));

			
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());		
		
		}
		ret.setLoading(false);
		ret.setNew(false); // since we load from database, we mark as "old"
		return ret;
    
    }
	 
	
	



	
	@Override
	public void fillStatement(ModelObject obj, CallableStatement stmt, boolean bForInsert) throws Exception {
		
		Equipment o = (Equipment)obj;
		
		if (o.getEquipmentName()==null){
			stmt.setNull(1, Types.VARCHAR);
		}else{
			stmt.setString(1,o.getEquipmentName());
		}


		/* PRIMARY KEY FIELD HANDLED BELOW AND SHOULD ALAWAYS BE THE LAST PARAMETER IN THE SQL */
		if (bForInsert){
		 /* No Need to pass anything For INSERTS.  MySQL will assign an autoincrement value, and the MySQLDBMapper will receive it.*/
		} else {
		 /* For Update statement*/
			stmt.setInt(2,o.getEquipmentId().intValue());
		}


	}
	

	
	
	/**
	 * Method used by generated accessor methods of 1-many associations.
	 * It retrieves the object collection using the ApplicationService connection, or 
	 * if that is null, it opens and closes a connection
	 * @param swhere SQL where clause
	 * @param params Parameter array
	 * @return a ModelObjectList of Equipment objects loaded from database
	 */
	 public static ModelObjectList<Equipment> getAll(String swhere, Object ... params)  {
		// for static methods w/o connections, we try to get a connection from 
		// the ApplicationService.getCurrentConn().  if we do not find one there, 
		// then we get from the connection pool
		boolean bCloseConn = false;
		Connection c = ApplicationService.getCurrentConn();
		
		try {
			if(c==null) {
				bCloseConn = true;  // since we open a connection from the pool, set the flag to close it.
				c = ConnectionPool.getConn();
				
			}
			EquipmentDBMapper adb = new EquipmentDBMapper(c);
			return adb.findWhere(swhere, params);
		
		}catch (MOTranslatedValidationException moe) {
			throw moe;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(bCloseConn)DBUtils.closeQuietly(c);
			//// only close the connection if we opened it.
		}
		
	}
	
	/**
	 * Method used by generated accessor methods of 1-1 associations.
	 * It retrieves the object using the ApplicationService connection, or 
	 * if that is null, it opens and closes a connection
	 * @param swhere SQL where clause
	 * @param params Parameter array
	 * @return a single Equipment object loaded from database
	 */
	public static Equipment get(String swhere, Object ... params)  {
		
		// for static methods w/o connections, we try to get a connection from 
		// the ApplicationService.getCurrentConn().  if we do not find one there, 
		// then we get from the connection pool
		boolean bCloseConn = false;
		Connection c = ApplicationService.getCurrentConn();
		
		try {
			if(c==null) {
				bCloseConn = true;  // since we open a connection from the pool, set the flag to close it.
				c = ConnectionPool.getConn();
				
			}
			EquipmentDBMapper adb = new EquipmentDBMapper(c);
			return (Equipment)adb.findOne(swhere, params);
		
		}catch (MOTranslatedValidationException moe) {
			throw moe;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(bCloseConn)DBUtils.closeQuietly(c);
			//// only close the connection if we opened it.
		}
	}
	
	
	public static Equipment getByKey(final Object pkey)  {
		
		// for static methods w/o connections, we try to get a connection from 
		// the ApplicationService.getCurrentConn().  if we do not find one there, 
		// then we get from the connection pool
		boolean bCloseConn = false;
		Connection c = ApplicationService.getCurrentConn();
		
		try {
			if(c==null) {
				bCloseConn = true;  // since we open a connection from the pool, set the flag to close it.
				c = ConnectionPool.getConn();
				
			}

			EquipmentDBMapper adb = new EquipmentDBMapper(c);
			return (Equipment)adb.find(pkey);
		
		}catch (MOTranslatedValidationException moe) {
			throw moe;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(bCloseConn)DBUtils.closeQuietly(c);
			//// only close the connection if we opened it.
		}
	}
	
	
}