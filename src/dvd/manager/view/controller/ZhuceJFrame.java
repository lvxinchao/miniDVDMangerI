package dvd.manager.view.controller;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dvd.manager.dao.impl.DVDmanagerDaoImpl;


public class ZhuceJFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JPanel zhucePanel = new JPanel();
	public ZhuceJFrame() {
		setTitle("注册界面");
		setSize(400, 300);
		setResizable(false);
		Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        setLocation((x - 400) / 2, (y - 300) / 2);
        
        setResizable(false);
		JLabel userLabel = new JLabel("用 户 名：");
        JLabel mimaLabel = new JLabel("密     码：");
        JLabel querenLabel = new JLabel("确认密码:");
        JTextField userText = new JTextField(15);
        JTextField mimaText = new JTextField(15);
        JTextField querenText = new JTextField(15);
        JButton managerzhuceJButton = new JButton("注册管理员");
        managerzhuceJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n=0;
				if(userText.getText().equals("")||mimaText.getText().equals("")||querenText.getText().equals("")){
    				JOptionPane.showMessageDialog(zhucePanel,"请先输入用户名或密码！");
    			}else if(!mimaText.getText().equals(querenText.getText())) {	
    				JOptionPane.showMessageDialog(zhucePanel,"两次密码不一致！");
    			}else{
    				String username1=userText.getText();
	    			String password1=mimaText.getText();
	    			n=new DVDmanagerDaoImpl().saveManager(username1, password1);
	    			if(n!=0) {
	    				JOptionPane.showMessageDialog(zhucePanel,"注册成功！");
	    				dispose();
	    				new selectFrame();
	    			}
    			}
			}
		});
		JButton userzhuceJButton = new JButton("注册用户");
		userzhuceJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n=0;
				if(userText.getText().equals("")||mimaText.getText().equals("")||querenText.getText().equals("")){
    				JOptionPane.showMessageDialog(zhucePanel,"请先输入用户名或密码！");
    			}else if(!mimaText.getText().equals(querenText.getText())) {	
    				JOptionPane.showMessageDialog(zhucePanel,"两次密码不一致！");
    			}else{
    				String username1=userText.getText();
	    			String password1=mimaText.getText();
	    			n=new DVDmanagerDaoImpl().saveUser(username1, password1);
	    			if(n!=0) {
	    				JOptionPane.showMessageDialog(zhucePanel,"注册成功！");
	    				dispose();
	    				new selectFrame();
	    			}
    			}
			}
		});
		
		JButton chongzhiJButton = new JButton("重置");
		chongzhiJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
   		    	mimaText.setText("");
   		    	querenText.setText("");
   		    	System.out.println("重置成功！");
			}
		});
        
		zhucePanel.setLayout(null);
		userLabel.setBounds(70, 30,70,40);
		userText.setBounds(130, 35,180,30);
    	mimaLabel.setBounds(70, 80,70,40);
		mimaText.setBounds(130, 85,180,30);
		querenLabel.setBounds(70, 130,70,40);
		querenText.setBounds(130, 130,180,30);
		managerzhuceJButton.setBounds(50,180,100,30);
		userzhuceJButton.setBounds(160,180,90,30);
		chongzhiJButton.setBounds(260,180,80,30);
		JButton backButton=new JButton("返回");
		backButton.setBounds(50, 220, 290, 30);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new selectFrame();
			}
		});
		
		zhucePanel.add(backButton);
		zhucePanel.add(userLabel);
        zhucePanel.add(userText);
        zhucePanel.add(mimaLabel);
        zhucePanel.add(mimaText);
        zhucePanel.add(querenLabel);
        zhucePanel.add(querenText);
		zhucePanel.add(managerzhuceJButton);
		zhucePanel.add(userzhuceJButton);
        zhucePanel.add(chongzhiJButton);
        add(zhucePanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。
        setVisible(true);
        
	}
	

}
