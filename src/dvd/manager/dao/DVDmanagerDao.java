package dvd.manager.dao;

import java.sql.ResultSet;

import dvd.manager.po.DVD;

public interface DVDmanagerDao {
	
	//����Ա��¼
	public int dengluDVDmanager(String name,String password);
		
	//�û���¼
	public int dengluDVDuser(String name,String password);
	
	//����Աע��
	public int saveManager(String name,String password);
	
	//�û�ע��
	public int saveUser(String name,String password);
	
	//�鿴DVD
	public ResultSet checkDVDList();
	
	//����DVD
	public int managerAddDVD(DVD dvd);
	
	//ɾ��DVD
	public int managerDeleteDVD(String name);
	
	//���DVD
	public int userLendDVD(String name);
	
	//�黹DVD
	public int userReturnDVD(String name);
	
}
