package dvd.manager.view.controller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class SelectVeiw {

	public static void main(String[] args) {
		new selectFrame();
	}
}
class selectFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JFrame selectJFrame = new JFrame();
	JPanel selectJPanel = new JPanel();
	public selectFrame() {
		selectJFrame.setResizable(false);
		selectJFrame.setTitle("迷你DVD管理系统");
        selectJFrame.setSize(400, 280);
        setResizable(false);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        selectJFrame.setLocation((x - 400) / 2, (y - 280) / 2);
        
        JLabel selectlJLabel = new JLabel("请选择您的身份登录");
        selectlJLabel.setFont(new Font("宋体",Font.ITALIC,36));
        JButton managerButton = new JButton("管理员");
        managerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectJFrame.dispose();
				new ManagerdengluFrame();
			}
		});
        
        JButton userButton = new JButton("用户");
        userButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectJFrame.dispose();
				new UserDengluJFrame();
			}
		});
        
        JButton zhuceButton = new JButton("注册");
        zhuceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectJFrame.dispose();
				new ZhuceJFrame();
				
			}
		});
        
        selectJPanel.add(selectlJLabel);
        selectJPanel.add(managerButton);
        selectJPanel.add(userButton);
        selectJPanel.add(zhuceButton);
        selectJFrame.add(selectJPanel);
        selectJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。
        selectJFrame.setVisible(true);
	}
	
}