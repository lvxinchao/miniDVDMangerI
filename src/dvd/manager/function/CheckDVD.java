package dvd.manager.function;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import dvd.manager.dao.impl.DVDmanagerDaoImpl;

public class CheckDVD extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public CheckDVD() {
		JFrame checkDVDFrame = new JFrame();
		ResultSet rs=null;
		checkDVDFrame.setResizable(false);
		checkDVDFrame.setTitle("查看DVD");
        checkDVDFrame.setSize(500, 500);
        setResizable(false);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        checkDVDFrame.setLocation((x - 500) / 2, (y - 500) / 2);
        
        String [] title= { "DVD号", "名称", "状态","日期", "数量" };
		Object [][] info =null;
		
		rs=new DVDmanagerDaoImpl().checkDVDList();
		int count=0;
		try {
			while(rs.next()) {
				count++;
			}
			
			info =new Object[count][5];
			count=0;
			rs.beforeFirst();
			while(rs.next()) {
				info[count][0]= rs.getInt(1); 
				info[count][1]=	rs.getString(2);
				info[count][2]= rs.getInt(3); 
				info[count][3]= rs.getDate(4);
				info[count][4]= rs.getInt(5); 
				count++;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JScrollPane  scpDemo = new JScrollPane();
		JTable tabDemo = new JTable(info, title);
		tabDemo.getTableHeader();
		scpDemo.getViewport().add(tabDemo);
		
		JLabel titleLabel=new JLabel("显示全部DVD");
		JLabel dataLabel=new JLabel("共有"+info.length+"张DVD");
		JPanel titlePanel =new JPanel();
		JPanel dataPanel =new JPanel();
		titlePanel.add(titleLabel);
		dataPanel.add(dataLabel);
		checkDVDFrame.add(titlePanel,BorderLayout.NORTH);
		checkDVDFrame.add(dataPanel,BorderLayout.SOUTH);
		checkDVDFrame.add(scpDemo);
        checkDVDFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。
        checkDVDFrame.setVisible(true);
	}
}
