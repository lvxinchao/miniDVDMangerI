package dvd.manager.function;

import java.awt.Dimension;
import java.awt.Font;
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

public class UserLendDVD extends JFrame{
	private static final long serialVersionUID = 1L;

	public UserLendDVD() {
		JFrame lendFrame=new JFrame();
		JPanel lendPanel = new JPanel();
		lendFrame.setResizable(false);
		lendFrame.setTitle("借阅DVD");
        lendFrame.setSize(400, 300);
        setResizable(false);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        lendFrame.setLocation((x - 300) / 2, (y - 300) / 2);
        lendPanel.setLayout(null);
        JLabel nameLabel = new JLabel("请输入要借阅的DVD名称:");
        nameLabel.setFont(new Font("宋体",Font.ITALIC,26));
        nameLabel.setBounds(50, 20, 300, 40);
        JTextField nameTextField = new JTextField(15);
        nameTextField.setBounds(100,70, 200, 40);
		JButton lendButton = new JButton("确认借阅");
		lendButton.setBounds(160,130, 100, 40);
		lendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=nameTextField.getText();
				if(new DVDmanagerDaoImpl().userLendDVD(name)==1) {
					JOptionPane.showMessageDialog(lendPanel,"借阅成功！");
					nameTextField.setText("");
				}
				
			}
		});
		
		lendPanel.add(lendButton);
        lendPanel.add(nameLabel);
        lendPanel.add(nameTextField);
		lendFrame.add(lendPanel);
        lendFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。
        lendFrame.setVisible(true);
		
	}
}
