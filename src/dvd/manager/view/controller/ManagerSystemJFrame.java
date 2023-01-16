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
		setTitle("����DVD����ϵͳ");
        setSize(600, 400);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        setLocation((x - 600) / 2, (y - 400) / 2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JMenuBar menuBar=new JMenuBar();
        JMenu menu1=new JMenu("����DVD");
        menu1.setFont(new Font("����",Font.PLAIN,16));
        JMenu menu2=new JMenu("ɾ��DVD");
        menu2.setFont(new Font("����",Font.PLAIN,16));
        JMenu menu3=new JMenu("�鿴DVD");
        menu3.setFont(new Font("����",Font.PLAIN,16));
        JMenu menu4=new JMenu("�˳�");
        menu4.setFont(new Font("����",Font.PLAIN,16));
        
        JMenuItem addItems=new JMenuItem("����DVD");
		addItems.setFont(new Font("����",Font.PLAIN,16));
        addItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerAddDVD();
			}
		});
        
        JMenuItem deleteItems=new JMenuItem("ɾ��DVD");
        deleteItems.setFont(new Font("����",Font.PLAIN,16));
        deleteItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerDeleteDVD();
			}
		});
        
        JMenuItem checkItems=new JMenuItem("�鿴DVD");
        checkItems.setFont(new Font("����",Font.PLAIN,16));
        checkItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CheckDVD();
			}
		});
        JMenuItem exitItems=new JMenuItem("�˳�");
        exitItems.setFont(new Font("����",Font.PLAIN,16));
        exitItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//��ֹ����
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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �رմ����˳�����
        setVisible(true);
	}
	
	
	
	
}
