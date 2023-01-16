package dvd.manager.dao;

import java.sql.ResultSet;

import dvd.manager.po.DVD;

public interface DVDmanagerDao {
	
	//管理员登录
	public int dengluDVDmanager(String name,String password);
		
	//用户登录
	public int dengluDVDuser(String name,String password);
	
	//管理员注册
	public int saveManager(String name,String password);
	
	//用户注册
	public int saveUser(String name,String password);
	
	//查看DVD
	public ResultSet checkDVDList();
	
	//增加DVD
	public int managerAddDVD(DVD dvd);
	
	//删除DVD
	public int managerDeleteDVD(String name);
	
	//借出DVD
	public int userLendDVD(String name);
	
	//归还DVD
	public int userReturnDVD(String name);
	
}
