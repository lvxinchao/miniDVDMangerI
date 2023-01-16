package dvd.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import dvd.manager.dao.DVDmanagerDao;
import dvd.manager.jdbc.GetConn;
import dvd.manager.po.DVD;

public class DVDmanagerDaoImpl implements DVDmanagerDao {
	Connection conn = null;
	public DVDmanagerDaoImpl() {
		try {
			GetConn getConn=new GetConn();
			conn = getConn.getConnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int dengluDVDmanager(String name, String password) {
		int n=0;
		try {
            Statement stmt=conn.createStatement();
            String sqlQuery="select * from manager where managername='"+name+"' and password='"+password+"'";
            ResultSet rs=stmt.executeQuery(sqlQuery);
            if(rs.next()) {
                System.out.println("登录成功，欢迎您！"+name);
                n=1;
            }
            //4.关闭连接
            rs.close();
            stmt.close();
            conn.close();
       }catch (Exception e1) {
           e1.printStackTrace();
           }
		return n;
	}
	
	@Override
	public int dengluDVDuser(String name, String password) {
		int n=0;
		try {
            Statement stmt=conn.createStatement();
            String sqlQuery="select * from user where username='"+name+"' and password='"+password+"'";
            ResultSet rs=stmt.executeQuery(sqlQuery);
            if(rs.next()) {
                System.out.println("登录成功，欢迎您！"+name);
                n=1;
            }
            //4.关闭连接
            rs.close();
            stmt.close();
            conn.close();
       }catch (Exception e1) {
           e1.printStackTrace();
           }
		return n;
	}
	
	@Override
	public int saveManager(String name, String password) {
		int n=0;
		try {
			String sql="insert into manager(managername,password) value(?,?)";
			PreparedStatement stmtpt=conn.prepareStatement(sql);
			stmtpt.setString(1, name);
			stmtpt.setString(2, password);
			n=stmtpt.executeUpdate();
			//4.关闭连接
            stmtpt.close();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	@Override
	public int saveUser(String name, String password) {
		int n=0;
		try {
			String sql="insert into user(username,password) value(?,?)";
			PreparedStatement stmtpt=conn.prepareStatement(sql);
			stmtpt.setString(1, name);
			stmtpt.setString(2, password);
			n=stmtpt.executeUpdate();
			//4.关闭连接
            stmtpt.close();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	@Override
	public ResultSet checkDVDList() {
		ResultSet rs=null;
		try {
			String sql="select * from DVD";
			PreparedStatement stmtpt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmtpt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	@Override
	public int managerAddDVD(DVD dvd) {
		int n=0;
		try {
			Date utilDate = new Date();
			Timestamp sqlDate=new Timestamp(utilDate.getTime());
			String sql="insert into dvd(id,name,state,date,count) value(?,?,?,?,?)";
			PreparedStatement stmtpt=conn.prepareStatement(sql);
			stmtpt.setString(1,dvd.getId() );
			stmtpt.setString(2, dvd.getName());
			stmtpt.setString(3, dvd.getState());
			stmtpt.setTimestamp(4, sqlDate);
			stmtpt.setString(5, dvd.getCount());
			n=stmtpt.executeUpdate();
			//4.关闭连接
            stmtpt.close();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	@Override
	public int managerDeleteDVD(String name) {
		int n=0;
		String sqlString="delete from dvd where name=?";
		try {
			PreparedStatement stmtpt=conn.prepareStatement(sqlString);
			stmtpt.setString(1, name);
			n=stmtpt.executeUpdate();
			
			//4.关闭连接
            stmtpt.close();
            conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n;
	}
	
	@Override
	public int userLendDVD(String name) {
		int n=0;
		try {
			Date utilDate = new Date();
			Timestamp sqlDate=new Timestamp(utilDate.getTime());
			String sql="update dvd set state=? ,date=? where name=?";
			PreparedStatement stmtpt=conn.prepareStatement(sql);
			stmtpt.setInt(1, 0);
			stmtpt.setTimestamp(2, sqlDate);
			stmtpt.setString(3, name);
			n=stmtpt.executeUpdate();
			//4.关闭连接
            stmtpt.close();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	@Override
	public int userReturnDVD(String name) {
		int n=0;
		try {
			Date utilDate = new Date();
			Timestamp sqlDate=new Timestamp(utilDate.getTime());
			String sql="update dvd set state=? ,date=? where name=?";
			PreparedStatement stmtpt=conn.prepareStatement(sql);
			stmtpt.setInt(1, 1);
			stmtpt.setTimestamp(2, sqlDate);
			stmtpt.setString(3, name);
			n=stmtpt.executeUpdate();
			
			//4.关闭连接
            stmtpt.close();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
}
