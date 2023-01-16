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
		returnFrame.setTitle("�黹DVD");
        returnFrame.setSize(400, 300);
        setResizable(false);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        returnFrame.setLocation((x - 300) / 2, (y - 300) / 2);
        returnPanel.setLayout(null);
        JLabel nameLabel = new JLabel("������Ҫ�黹��DVD����:");
        nameLabel.setFont(new Font("����",Font.ITALIC,26));
        nameLabel.setBounds(50, 20, 300, 40);
        JTextField nameTextField = new JTextField(15);
        nameTextField.setBounds(100,70, 200, 40);
		JButton returnButton = new JButton("ȷ�Ϲ黹");
		returnButton.setBounds(160,130, 100, 40);
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=nameTextField.getText();
				if(new DVDmanagerDaoImpl().userReturnDVD(name)==1) {
					JOptionPane.showMessageDialog(returnPanel,"�黹�ɹ���");
					nameTextField.setText("");
				}
				
			}
		});
		
		returnPanel.add(returnButton);
        returnPanel.add(nameLabel);
        returnPanel.add(nameTextField);
		returnFrame.add(returnPanel);
        returnFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ����������ע�� WindowListener �Ķ�����Զ����ز��ͷŸô��塣
        returnFrame.setVisible(true);
		
		
	}

}
