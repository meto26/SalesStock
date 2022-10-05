package tr.com.meto.fe;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.meto.dal.AuthoryDAL;
import tr.com.meto.interfaces.IFe;
import tr.com.meto.types.AuthorysContract;

public class AuthoryAddFE extends JDialog implements IFe{

	public AuthoryAddFE() {
		İnitWindow();
	}

	@Override
	public void İnitWindow() {
		JPanel panel=initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Yetki Ekle"));
		
		add(panel);
		setTitle("Yetki Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new GridLayout(2,2));
		JLabel nameLabel = new JLabel("Yetki Adı: ",JLabel.RIGHT);
		panel.add(nameLabel);		
		JTextField nameField = new JTextField(10);
		panel.add(nameField);
		
		JButton saveButton= new JButton("Kaydet");
		panel.add(saveButton);
		JButton cancelButton = new JButton("İptal");
		panel.add(cancelButton);
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AuthorysContract contract = new AuthorysContract();				
				contract.setName(nameField.getText());				
				new AuthoryDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getName()+"Adlı yetki başarılı bir şekilde eklenmiştir.");
			}
		});
		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
