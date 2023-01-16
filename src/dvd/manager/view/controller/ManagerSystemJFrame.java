package dvd.manager.view.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import dvd.manager.function.CheckDVD;
import dvd.manager.function.ManagerAddDVD;
import dvd.manager.function.ManagerDeleteDVD;

public class ManagerSystemJFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel managerJPanel=new JPanel();
	
	public ManagerSystemJFrame() {
		setTitle("迷你DVD管理系统");
        setSize(600, 400);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        setLocation((x - 600) / 2, (y - 400) / 2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JMenuBar menuBar=new JMenuBar();
        JMenu menu1=new JMenu("新增DVD");
        menu1.setFont(new Font("楷体",Font.PLAIN,16));
        JMenu menu2=new JMenu("删除DVD");
        menu2.setFont(new Font("楷体",Font.PLAIN,16));
        JMenu menu3=new JMenu("查看DVD");
        menu3.setFont(new Font("楷体",Font.PLAIN,16));
        JMenu menu4=new JMenu("退出");
        menu4.setFont(new Font("楷体",Font.PLAIN,16));
        
        JMenuItem addItems=new JMenuItem("新增DVD");
		addItems.setFont(new Font("楷体",Font.PLAIN,16));
        addItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerAddDVD();
			}
		});
        
        JMenuItem deleteItems=new JMenuItem("删除DVD");
        deleteItems.setFont(new Font("楷体",Font.PLAIN,16));
        deleteItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerDeleteDVD();
			}
		});
        
        JMenuItem checkItems=new JMenuItem("查看DVD");
        checkItems.setFont(new Font("楷体",Font.PLAIN,16));
        checkItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CheckDVD();
			}
		});
        JMenuItem exitItems=new JMenuItem("退出");
        exitItems.setFont(new Font("楷体",Font.PLAIN,16));
        exitItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//终止程序
			}
		});
        
        menu1.add(addItems);
        menu2.add(deleteItems);
        menu3.add(checkItems);
        menu4.add(exitItems);
        
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        setJMenuBar(menuBar);
        
        ImageIcon img = new ImageIcon("src/image/img.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        managerJPanel.add(imgLabel);
        add(managerJPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口退出程序
        setVisible(true);
	}
	
	
	
	
}
