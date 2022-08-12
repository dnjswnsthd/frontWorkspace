package com.bnk.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import util.DataSourceManager;

public class ItemDao implements  ItemDaoTemplate{
	private DataSource ds;
	
	private static ItemDao dao = new ItemDao();
	private ItemDao() {
		//이전 코드는 DataSourceManager로 가져갔다.--->DataSourceManager에서 ds를 받아와야 한다.
		ds = DataSourceManager.getInstance().getConnection();		
	}
	
	
	public static ItemDao getInstance() {
		return dao;
	}

	//공통적인 로직	
	public Connection getConnection() throws SQLException {		
		System.out.println("디비연결 성공....");
		
//		Connection conn = DriverManager.getConnection(ServerInfo.URL, "root", "1234");
//		return conn;	
		return ds.getConnection(); //인자값은 이미  Context.xml에 다 들어가있기 떄문에 필요없다...공장에서 Connection 하나씩 빌려온다.
	}

	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}
		
	//비지니스 로직	
	@Override
	public ArrayList<Item> getAllItem() throws SQLException {
		ArrayList<Item> list = new ArrayList<Item>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM item";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Item(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getString(4),
						rs.getString(5), 
						rs.getInt(6)));
				
				
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public Item getItem(int itemid) throws SQLException {
		Item item = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM item WHERE item_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, itemid);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				item = new Item(
						itemid, 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getString(4),
						rs.getString(5), 
						rs.getInt(6));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return item;
	}

	@Override
	public boolean updateRecordCount(int itemid) throws SQLException {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "UPDATE item SET count=count+1 WHERE item_id=?";
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, itemid);
			
			int row = ps.executeUpdate();
			if(row>0) result = true;
		}finally {
			closeAll(ps, conn);
		}
		return result;
	}
	

}
