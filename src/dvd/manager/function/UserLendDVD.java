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
		lendFrame.setTitle("����DVD");
        lendFrame.setSize(400, 300);
        setResizable(false);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        lendFrame.setLocation((x - 300) / 2, (y - 300) / 2);
        lendPanel.setLayout(null);
        JLabel nameLabel = new JLabel("������Ҫ���ĵ�DVD����:");
        nameLabel.setFont(new Font("����",Font.ITALIC,26));
        nameLabel.setBounds(50, 20, 300, 40);
        JTextField nameTextField = new JTextField(15);
        nameTextField.setBounds(100,70, 200, 40);
		JButton lendButton = new JButton("ȷ�Ͻ���");
		lendButton.setBounds(160,130, 100, 40);
		lendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=nameTextField.getText();
				if(new DVDmanagerDaoImpl().userLendDVD(name)==1) {
					JOptionPane.showMessageDialog(lendPanel,"���ĳɹ���");
					nameTextField.setText("");
				}
				
			}
		});
		
		lendPanel.add(lendButton);
        lendPanel.add(nameLabel);
        lendPanel.add(nameTextField);
		lendFrame.add(lendPanel);
        lendFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ����������ע�� WindowListener �Ķ�����Զ����ز��ͷŸô��塣
        lendFrame.setVisible(true);
		
	}
}
