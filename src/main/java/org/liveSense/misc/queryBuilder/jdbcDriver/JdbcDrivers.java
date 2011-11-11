package org.liveSense.misc.queryBuilder.jdbcDriver;

/*
IBM DB2
jdbc:db2://<HOST>:<PORT>/<DB>
COM.ibm.db2.jdbc.app.DB2Driver

JDBC-ODBC Bridge
jdbc:odbc:<DB>
sun.jdbc.odbc.JdbcOdbcDriver

Microsoft SQL Server
jdbc:weblogic:mssqlserver4:<DB>@<HOST>:<PORT>
weblogic.jdbc.mssqlserver4.Driver

Oracle Thin
jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
oracle.jdbc.driver.OracleDriver

PointBase Embedded Server
jdbc:pointbase://embedded[:<PORT>]/<DB>
com.pointbase.jdbc.jdbcUniversalDriver

Cloudscape
jdbc:cloudscape:<DB>
COM.cloudscape.core.JDBCDriver

Cloudscape RMI
jdbc:rmi://<HOST>:<PORT>/jdbc:cloudscape:<DB>
RmiJdbc.RJDriver

Firebird (JCA/JDBC Driver)
jdbc:firebirdsql:[//<HOST>[:<PORT>]/]<DB>
org.firebirdsql.jdbc.FBDriver

IDS Server
jdbc:ids://<HOST>:<PORT>/conn?dsn='<ODBC_DSN_NAME>'
ids.sql.IDSDriver

Informix Dynamic Server
jdbc:informix-sqli://<HOST>:<PORT>/<DB>:INFORMIXSERVER=<SERVER_NAME>
com.informix.jdbc.IfxDriver

InstantDB (v3.13 and earlier)
jdbc:idb:<DB>
jdbc.idbDriver

InstantDB (v3.14 and later)
jdbc:idb:<DB>
org.enhydra.instantdb.jdbc.idbDriver

Interbase (InterClient Driver)
jdbc:interbase://<HOST>/<DB>
interbase.interclient.Driver

Hypersonic SQL (v1.2 and earlier)
jdbc:HypersonicSQL:<DB>
hSql.hDriver

Hypersonic SQL (v1.3 and later)
jdbc:HypersonicSQL:<DB>
org.hsql.jdbcDriver

Microsoft SQL Server (JTurbo Driver)
jdbc:JTurbo://<HOST>:<PORT>/<DB>
com.ashna.jturbo.driver.Driver

Microsoft SQL Server (Sprinta Driver)
jdbc:inetdae:<HOST>:<PORT>?database=<DB>
com.inet.tds.TdsDriver

Microsoft SQL Server 2000 (Microsoft Driver)
jdbc:microsoft:sqlserver://<HOST>:<PORT>[;DatabaseName=<DB>]
com.microsoft.sqlserver.jdbc.SQLServerDriver

MySQL (MM.MySQL Driver)
jdbc:mysql://<HOST>:<PORT>/<DB>
org.gjt.mm.mysql.Driver

Oracle OCI 8i
jdbc:oracle:oci8:@<SID>
oracle.jdbc.driver.OracleDriver

Oracle OCI 9i
jdbc:oracle:oci:@<SID>
oracle.jdbc.driver.OracleDriver

PostgreSQL (v6.5 and earlier)
jdbc:postgresql://<HOST>:<PORT>/<DB>
postgresql.Driver

PostgreSQL (v7.0 and later)
jdbc:postgresql://<HOST>:<PORT>/<DB>
org.postgresql.Driver

Sybase (jConnect 4.2 and earlier)
jdbc:sybase:Tds:<HOST>:<PORT>
com.sybase.jdbc.SybDriver

Sybase (jConnect 5.2)
jdbc:sybase:Tds:<HOST>:<PORT>
com.sybase.jdbc2.jdbc.SybDriver	
*/

public enum JdbcDrivers {
	UNKNOWN, MYSQL, FIREBIRD, HSQLDB, ORACLE, DERBY, H2, MSSQL, POINTBASE, DB2, JDBC_ODBC_BRIDGE, CLOUDSCAPE, IDS, INFORMIX, INSTANTDB, INTERBASE, POSTGRE, SYBASE;

	public static  JdbcDrivers getJdbcDriverByMetaDataProductName(String metaData) throws Exception {
	    if (metaData.matches("(?i).*hsql.*")) {
	        return JdbcDrivers.HSQLDB;
	    } else if (metaData.matches("(?i).*derby.*")) {
	        return JdbcDrivers.DERBY;
	    } else if (metaData.matches("(?i).*mysql.*")) {
	        return JdbcDrivers.MYSQL;
	    } else if (metaData.matches("(?i).*oracle.*")) {
	        return JdbcDrivers.ORACLE;
	    } else if (metaData.matches("(?i).*microsoft.*")) {
	        return JdbcDrivers.MSSQL;
	    } else if (metaData.matches("(?i).*firebird.*")) {
	        return JdbcDrivers.FIREBIRD;
	    } else if (metaData.matches("(?i).*h2.*")) {
	    	return JdbcDrivers.H2;
	    } else {
	    	return JdbcDrivers.UNKNOWN;
	    }
	}


	public static JdbcDrivers getJdbcDriverByDriverClassName(String driverClassName) {

		if ("COM.ibm.db2.jdbc.app.DB2Driver".equals(driverClassName)) {
			return JdbcDrivers.DB2;
		} else if ("sun.jdbc.odbc.JdbcOdbcDriver".equals(driverClassName)) {
			return JdbcDrivers.JDBC_ODBC_BRIDGE;
		} else if ("weblogic.jdbc.mssqlserver4.Driver".equals(driverClassName)) {
			return JdbcDrivers.MSSQL;
		} else if ("oracle.jdbc.driver.OracleDriver".equals(driverClassName)) {
			return JdbcDrivers.ORACLE;
		} else if ("com.pointbase.jdbc.jdbcUniversalDriver".equals(driverClassName)) {
			return JdbcDrivers.POINTBASE;
		} else if ("COM.cloudscape.core.JDBCDriver".equals(driverClassName)) {
			return JdbcDrivers.CLOUDSCAPE;
		} else if ("RmiJdbc.RJDriver".equals(driverClassName)) {
			return JdbcDrivers.CLOUDSCAPE;
		} else if ("org.firebirdsql.jdbc.FBDriver".equals(driverClassName)) {
			return JdbcDrivers.FIREBIRD;
		} else if ("ids.sql.IDSDriver".equals(driverClassName)) {
			return JdbcDrivers.IDS;
		} else if ("com.informix.jdbc.IfxDriver".equals(driverClassName)) {
			return JdbcDrivers.INFORMIX;
		} else if ("jdbc.idbDriver".equals(driverClassName)) {
			return JdbcDrivers.INSTANTDB;
		} else if ("org.enhydra.instantdb.jdbc.idbDriver".equals(driverClassName)) {
			return JdbcDrivers.INSTANTDB;
		} else if ("interbase.interclient.Driver".equals(driverClassName)) {
			return JdbcDrivers.INTERBASE;
		} else if ("hSql.hDriver".equals(driverClassName)) {
			return JdbcDrivers.HSQLDB;
		} else if ("org.hsql.jdbcDriver".equals(driverClassName)) {
			return JdbcDrivers.HSQLDB;
		} else if ("com.ashna.jturbo.driver.Driver".equals(driverClassName)) {
			return JdbcDrivers.MSSQL;
		} else if ("com.inet.tds.TdsDriver".equals(driverClassName)) {
			return JdbcDrivers.MSSQL;
		} else if ("com.microsoft.sqlserver.jdbc.SQLServerDriver".equals(driverClassName)) {
			return JdbcDrivers.MSSQL;
		} else if ("org.gjt.mm.mysql.Driver".equals(driverClassName)) {
			return JdbcDrivers.MYSQL;
		} else if ("oracle.jdbc.driver.OracleDriver".equals(driverClassName)) {
			return JdbcDrivers.ORACLE;
		} else if ("oracle.jdbc.driver.OracleDriver".equals(driverClassName)) {
			return JdbcDrivers.ORACLE;
		} else if ("postgresql.Driver".equals(driverClassName)) {
			return JdbcDrivers.POSTGRE;
		} else if ("org.postgresql.Driver".equals(driverClassName)) {
			return JdbcDrivers.POSTGRE;
		} else if ("com.sybase.jdbc.SybDriver".equals(driverClassName)) {
			return JdbcDrivers.SYBASE;
		} else if ("com.sybase.jdbc2.jdbc.SybDriver".equals(driverClassName)) {
			return JdbcDrivers.SYBASE;
		} else return JdbcDrivers.UNKNOWN;
	}
	
}
