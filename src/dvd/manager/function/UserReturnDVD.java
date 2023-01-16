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

public class UserReturnDVD extends JFrame{
	private static final long serialVersionUID = 1L;

	public UserReturnDVD() {
		JFrame returnFrame=new JFrame();
		JPanel returnPanel = new JPanel();
		returnFrame.setResizable(false);
		returnFrame.setTitle("归还DVD");
        returnFrame.setSize(400, 300);
        setResizable(false);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        returnFrame.setLocation((x - 300) / 2, (y - 300) / 2);
        returnPanel.setLayout(null);
        JLabel nameLabel = new JLabel("请输入要归还的DVD名称:");
        nameLabel.setFont(new Font("宋体",Font.ITALIC,26));
        nameLabel.setBounds(50, 20, 300, 40);
        JTextField nameTextField = new JTextField(15);
        nameTextField.setBounds(100,70, 200, 40);
		JButton returnButton = new JButton("确认归还");
		returnButton.setBounds(160,130, 100, 40);
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=nameTextField.getText();
				if(new DVDmanagerDaoImpl().userReturnDVD(name)==1) {
					JOptionPane.showMessageDialog(returnPanel,"归还成功！");
					nameTextField.setText("");
				}
				
			}
		});
		
		returnPanel.add(returnButton);
        returnPanel.add(nameLabel);
        returnPanel.add(nameTextField);
		returnFrame.add(returnPanel);
        returnFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。
        returnFrame.setVisible(true);
		
		
	}

}
