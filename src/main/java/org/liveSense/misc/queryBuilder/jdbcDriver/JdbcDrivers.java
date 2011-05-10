package org.liveSense.misc.queryBuilder.jdbcDriver;


public enum JdbcDrivers {
	MYSQL ("com.mysql.jdbc.Driver"),
	FIREBIRD ("org.firebirdsql.jdbc.FBDriver"),
	HSQLDB ("org.hsqldb.jdbcDriver");
	
	private final String driverClass;
	
	private JdbcDrivers(String driverClass) {
		this.driverClass = driverClass;
	}
	
	public String getDriverClass() {
		return this.driverClass;
	}
}
