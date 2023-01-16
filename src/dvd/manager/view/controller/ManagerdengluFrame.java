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


public class ManagerdengluFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JFrame dengluJFrame = new JFrame();
	JPanel dengluJPanel = new JPanel();
	public ManagerdengluFrame() {
		dengluJFrame.setResizable(false);
        JLabel userLabel = new JLabel("�û�����");
        JLabel mimaLabel = new JLabel("��    �룺");
        JTextField userText = new JTextField(15);
        JTextField mimaText = new JTextField(15);
        JButton dengluJButton = new JButton("��¼");
        JButton chongzhiJButton = new JButton("����");
        JButton backJButton = new JButton("����");
        
        dengluJFrame.setTitle("����DVD-����Ա��¼����");
        dengluJFrame.setSize(400, 270);
        setResizable(false);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        dengluJFrame.setLocation((x - 400) / 2, (y - 270) / 2);
        dengluJPanel.setLayout(null);
        userLabel.setBounds(60, 40, 70, 40);
        userText.setBounds(120, 45, 200, 30);
        mimaLabel.setBounds(60, 80, 70, 40);
        mimaText.setBounds(120, 85, 200, 30);
        backJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dengluJFrame.dispose();
				new selectFrame();
			}
		});
        
        dengluJButton.setBounds(80, 140, 70, 30);
        dengluJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n=0;
				if(userText.getText().equals("")||mimaText.getText().equals("")){
    				JOptionPane.showMessageDialog(dengluJPanel,"�������û��������룡");
    			}else {
	    			String username1=userText.getText();
	    			String password1=mimaText.getText();
	    			n=new DVDmanagerDaoImpl().dengluDVDmanager(username1,password1);
	    			if(n==1) {
	    				dengluJFrame.dispose();
	    				new ManagerSystemJFrame();
	    			}else {
	    				JOptionPane.showMessageDialog(dengluJPanel,"��������ȷ���û��������룡");
	    			}
    			}
			}
		});
        
        backJButton.setBounds(160, 140, 70, 30);
        chongzhiJButton.setBounds(240, 140, 70, 30);
        chongzhiJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
   		    	userText.setText("");
   		    	mimaText.setText("");
   		    	System.out.println("���óɹ���");
			}
		});
        dengluJPanel.add(userLabel);
        dengluJPanel.add(userText);
        dengluJPanel.add(mimaLabel);
        dengluJPanel.add(mimaText);
        dengluJPanel.add(dengluJButton);
        dengluJPanel.add(backJButton);
        dengluJPanel.add(chongzhiJButton);
        dengluJFrame.add(dengluJPanel);
        dengluJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ����������ע�� WindowListener �Ķ�����Զ����ز��ͷŸô��塣
        dengluJFrame.setVisible(true);
	}
}