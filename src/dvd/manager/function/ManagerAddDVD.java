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
		addDVDFrame.setTitle("添加DVD");
        addDVDFrame.setSize(400, 300);
        setResizable(false);
        Toolkit tk = getToolkit();
        Dimension dim = tk.getScreenSize();
        int x = dim.width;
        int y = dim.height;
        addDVDFrame.setLocation((x - 400) / 2, (y - 300) / 2);
		
        JPanel addPanel = new JPanel();
        addPanel.setLayout(null);
        JLabel idLabel = new JLabel("DVD号:");
        idLabel.setBounds(60, 40, 80, 30);
        JTextField idTextField = new JTextField(15);
        idTextField.setBounds(130,40, 180, 30);
        JLabel nameLabel = new JLabel("名称:");
        nameLabel.setBounds(60, 80, 80, 30);
        JTextField nameTextField = new JTextField(15);
        nameTextField.setBounds(130,80, 180, 30);
        JLabel stateLabel = new JLabel("状态:");
        stateLabel.setBounds(60, 120, 80, 30);
        String[]state = {"1.在库","0.借出"};
        JComboBox stateBox=new JComboBox(state);
        stateBox.setBounds(130, 120, 180, 30);
        stateBox.setEditable(true);
        JLabel countLabel = new JLabel("数量:");
        countLabel.setBounds(60, 160, 80, 30);
        JTextField countTextField = new JTextField(15);
        countTextField.setBounds(130, 160, 180, 30);
        JButton addButton=new JButton("添加");
        addButton.setBounds(90, 200, 80, 30);
        addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DVD dvd = new DVD();
				dvd.setId(idTextField.getText());
				dvd.setName(nameTextField.getText());
				if(String.valueOf(stateBox.getSelectedItem())=="1.在库"){
					dvd.setState("1"); 
				}else {dvd.setState("0");}
				dvd.setCount(countTextField.getText());
				if(new DVDmanagerDaoImpl().managerAddDVD(dvd)==1) {
					JOptionPane.showMessageDialog(addPanel,"添加成功！");
					idTextField.setText("");
	   		    	nameTextField.setText("");
	   		    	countTextField.setText("");
				}
			}
		});
        JButton chongzheButton=new JButton("重置");
        chongzheButton.setBounds(200, 200, 80, 30);
        chongzheButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
   		    	idTextField.setText("");
   		    	nameTextField.setText("");
   		    	countTextField.setText("");
   		    	System.out.println("重置成功！");
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
        addDVDFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。
        addDVDFrame.setVisible(true);
	}
}
