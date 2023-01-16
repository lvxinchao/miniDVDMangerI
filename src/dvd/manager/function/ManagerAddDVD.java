package dvd.manager.function;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dvd.manager.dao.impl.DVDmanagerDaoImpl;
import dvd.manager.po.DVD;

public class ManagerAddDVD extends JFrame{

	private static final long serialVersionUID = 1L;

	public ManagerAddDVD() {
		JFrame addDVDFrame = new JFrame();
		addDVDFrame.setResizable(false);
		addDVDFrame.setTitle("���DVD");
        addDVDFrame.setSize(400, 300);
        setResizable(false);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        addDVDFrame.setLocation((x - 400) / 2, (y - 300) / 2);
		
        JPanel addPanel = new JPanel();
        addPanel.setLayout(null);
        JLabel idLabel = new JLabel("DVD��:");
        idLabel.setBounds(60, 40, 80, 30);
        JTextField idTextField = new JTextField(15);
        idTextField.setBounds(130,40, 180, 30);
        JLabel nameLabel = new JLabel("����:");
        nameLabel.setBounds(60, 80, 80, 30);
        JTextField nameTextField = new JTextField(15);
        nameTextField.setBounds(130,80, 180, 30);
        JLabel stateLabel = new JLabel("״̬:");
        stateLabel.setBounds(60, 120, 80, 30);
        String[]state = {"1.�ڿ�","0.���"};
        JComboBox stateBox=new JComboBox(state);
        stateBox.setBounds(130, 120, 180, 30);
        stateBox.setEditable(true);
        JLabel countLabel = new JLabel("����:");
        countLabel.setBounds(60, 160, 80, 30);
        JTextField countTextField = new JTextField(15);
        countTextField.setBounds(130, 160, 180, 30);
        JButton addButton=new JButton("���");
        addButton.setBounds(90, 200, 80, 30);
        addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DVD dvd = new DVD();
				dvd.setId(idTextField.getText());
				dvd.setName(nameTextField.getText());
				if(String.valueOf(stateBox.getSelectedItem())=="1.�ڿ�"){
					dvd.setState("1"); 
				}else {dvd.setState("0");}
				dvd.setCount(countTextField.getText());
				if(new DVDmanagerDaoImpl().managerAddDVD(dvd)==1) {
					JOptionPane.showMessageDialog(addPanel,"��ӳɹ���");
					idTextField.setText("");
	   		    	nameTextField.setText("");
	   		    	countTextField.setText("");
				}
			}
		});
        JButton chongzheButton=new JButton("����");
        chongzheButton.setBounds(200, 200, 80, 30);
        chongzheButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
   		    	idTextField.setText("");
   		    	nameTextField.setText("");
   		    	countTextField.setText("");
   		    	System.out.println("���óɹ���");
			}
		});
        addPanel.add(idLabel);
        addPanel.add(idTextField);
        addPanel.add(nameLabel);
        addPanel.add(nameTextField);
        addPanel.add(stateLabel);
        addPanel.add(stateBox);
        addPanel.add(countLabel);
        addPanel.add(countTextField);
        addPanel.add(addButton);
        addPanel.add(chongzheButton);
        addDVDFrame.add(addPanel);
        addDVDFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ����������ע�� WindowListener �Ķ�����Զ����ز��ͷŸô��塣
        addDVDFrame.setVisible(true);
	}
}
