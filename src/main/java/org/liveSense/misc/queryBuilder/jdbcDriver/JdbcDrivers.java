package org.liveSense.misc.queryBuilder.jdbcDriver;


public enum JdbcDrivers {
	MYSQL ("com.mysql.jdbc.Driver"),
	FIREBIRD ("org.firebirdsql.jdbc.FBDriver"),
	HSQLDB ("org.hsqldb.jdbcDriver"),
	ORACLE ("oracle.jdbc.OracleDriver"),
	ORACLE2 ("oracle.jdbc.driver.OracleDriver");
	
	//TODO: Adding support for following drivers:
	// postgresql.Driver
	// com.microsoft.sqlserver.jdbc.SQLServerDriver
	private final String driverClass;
	
	private JdbcDrivers(String driverClass) {
		this.driverClass = driverClass;
	}
	
	public String getDriverClass() {
		return this.driverClass;
	}
}
