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
	//	final String appstring = "jdbc:mysql://uxxxx:xxxx@localhost:3306/lm26uio74mv84l73?useSSL=false&zeroDateTimeBehavior=convertToNull&useOldAliasMetadataBehavior=true&allowMultiQueries=true&serverTimezone=UTC";
		final String appstring = "jdbc:mysql://zaheai3jklgk2ltf:cvh6rk2hcvll98hw@h40lg7qyub2umdvb.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/tsy1ng4y7q19kwvs?useSSL=false&zeroDateTimeBehavior=convertToNull&useOldAliasMetadataBehavior=true&allowMultiQueries=true&serverTimezone=UTC";
		DBUpgrader.createMySQLDBUpgrader().setJdbcUrlString(appstring).
				setFilesPackagePath("/dbupdate").upgradeDatabase(DB_VERSION);

	
	}

}
