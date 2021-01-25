package com.mygym.model.db;

import com.netu.dbupdater.DBUpgrader;

/**
 *
 * @author christoforosl
 */
public class DBVersion {

	public static final int DB_VERSION = 9;
	public static final String JAWSDB_URL_FULL = "JAWSDB_URL_FULL";

	public static void main(String[] args) throws Exception {
		
		DBUpgrader.createMySQLDBUpgrader().setJdbcUrlString("xxx").
				setFilesPackagePath("/dbupdate").upgradeDatabase(DB_VERSION);

	
	}

}
