package util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * JNDI API를 이용해서 DataSource를 리턴받아 온다.
 * 싱글톤 구사
 */
public class DataSourceManager {
	private DataSource ds;
	//싱글톤
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		//InitialContext 객체의 lookup()을 이용해서 ds하나 받아오는 로직..
		try {
			//단위테스트 할 때는 DriveManager 사용
			InitialContext ic = new InitialContext();	
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource Lookup OK...");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup Fail...");
		}
		
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	//
	public DataSource getConnection() {
		return ds;
	}
	
}
