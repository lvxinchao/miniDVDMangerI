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
		selectJFrame.setTitle("����DVD����ϵͳ");
        selectJFrame.setSize(400, 280);
        setResizable(false);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        selectJFrame.setLocation((x - 400) / 2, (y - 280) / 2);
        
        JLabel selectlJLabel = new JLabel("��ѡ��������ݵ�¼");
        selectlJLabel.setFont(new Font("����",Font.ITALIC,36));
        JButton managerButton = new JButton("����Ա");
        managerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectJFrame.dispose();
				new ManagerdengluFrame();
			}
		});
        
        JButton userButton = new JButton("�û�");
        userButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectJFrame.dispose();
				new UserDengluJFrame();
			}
		});
        
        JButton zhuceButton = new JButton("ע��");
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
        selectJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ����������ע�� WindowListener �Ķ�����Զ����ز��ͷŸô��塣
        selectJFrame.setVisible(true);
	}
	
}