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

public class ManagerDeleteDVD extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public ManagerDeleteDVD() {
		JFrame deleteFrame=new JFrame();
		JPanel deletePanel = new JPanel();
		deleteFrame.setResizable(false);
		deleteFrame.setTitle("ɾ��DVD");
        deleteFrame.setSize(400, 300);
        setResizable(false);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        deleteFrame.setLocation((x - 300) / 2, (y - 300) / 2);
        deletePanel.setLayout(null);
        JLabel nameLabel = new JLabel("������Ҫɾ����DVD����:");
        nameLabel.setFont(new Font("����",Font.ITALIC,26));
        nameLabel.setBounds(50, 20, 300, 40);
        JTextField nameTextField = new JTextField(15);
        nameTextField.setBounds(100,70, 200, 40);
		JButton deleteButton = new JButton("ȷ��ɾ��");
		deleteButton.setBounds(160,130, 100, 40);
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=nameTextField.getText();
				if(new DVDmanagerDaoImpl().managerDeleteDVD(name)==1) {
					JOptionPane.showMessageDialog(deletePanel,"ɾ���ɹ���");
					nameTextField.setText("");
				}
				
			}
		});
		
		deletePanel.add(deleteButton);
        deletePanel.add(nameLabel);
        deletePanel.add(nameTextField);
		deleteFrame.add(deletePanel);
        deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ����������ע�� WindowListener �Ķ�����Զ����ز��ͷŸô��塣
        deleteFrame.setVisible(true);
	}
}
