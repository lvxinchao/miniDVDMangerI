package dvd.manager.view.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import dvd.manager.function.CheckDVD;
import dvd.manager.function.UserLendDVD;
import dvd.manager.function.UserReturnDVD;

public class UserSystemJFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel userJPanel=new JPanel();
	
	public UserSystemJFrame() {
		setTitle("迷你DVD用户系统");
        setSize(600, 400);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        setLocation((x - 600) / 2, (y - 400) / 2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JMenuBar menuBar=new JMenuBar();
        JMenu menu1=new JMenu("查看DVD");
        menu1.setFont(new Font("楷体",Font.PLAIN,16));
        JMenu menu2=new JMenu("借出DVD");
        menu2.setFont(new Font("楷体",Font.PLAIN,16));
        JMenu menu3=new JMenu("归还DVD");
        menu3.setFont(new Font("楷体",Font.PLAIN,16));
        JMenu menu4=new JMenu("退出");
        menu4.setFont(new Font("楷体",Font.PLAIN,16));
        
        JMenuItem checkItems=new JMenuItem("查看DVD");
        checkItems.setFont(new Font("楷体",Font.PLAIN,16));
        checkItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CheckDVD();
			}
		});
        JMenuItem lendItems=new JMenuItem("借阅DVD");
        lendItems.setFont(new Font("楷体",Font.PLAIN,16));
        lendItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserLendDVD();
			}
		});
        JMenuItem returnItem=new JMenuItem("归还DVD");
        returnItem.setFont(new Font("楷体",Font.PLAIN,16));
        returnItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserReturnDVD();
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
        
        menu1.add(checkItems);
        menu2.add(lendItems);
        menu3.add(returnItem);
        menu4.add(exitItems);
        
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        setJMenuBar(menuBar);
        
        userJPanel.setBackground(Color.green);
        add(userJPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口退出程序
        setVisible(true);
		
		
	}
	
	
	
	
}
