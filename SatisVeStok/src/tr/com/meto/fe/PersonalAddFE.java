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

import tr.com.meto.dal.PersonalDAL;
import tr.com.meto.interfaces.IFe;
import tr.com.meto.types.PersonalContract;



public class PersonalAddFE extends JDialog implements IFe{

	public PersonalAddFE() {
		
		İnitWindow();
	}

	@Override
	public void İnitWindow() {
		
		JPanel panel = initPanel();	
		panel.setBorder(BorderFactory.createTitledBorder("Personel Ekle"));
		
		add(panel);
		setTitle("Personel Ekle");
		pack();
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		 
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3,2));
		
		JLabel nameLabel = new JLabel("Adı Soyadı: ",JLabel.RIGHT);
		panel.add(nameLabel);
		JTextField nameField = new JTextField(10);
		panel.add(nameField);		
		JLabel mailLabel = new JLabel("E-mail: ",JLabel.RIGHT);
		panel.add(mailLabel);
		JTextField mailField = new JTextField(10);
		panel.add(mailField);
		
		JButton saveButton = new JButton("Kaydet");
		panel.add(saveButton);
		JButton cancelButton = new JButton("İptal");
		panel.add(cancelButton);
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonalContract contract = new PersonalContract();
				contract.setNameSurname(nameField.getText());
				contract.setEmail(mailField.getText());
				
				new PersonalDAL().Insert(contract);
				JOptionPane.showMessageDialog( null,contract.getNameSurname()+" adlı personel eklenmiştir.");
				
				
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
