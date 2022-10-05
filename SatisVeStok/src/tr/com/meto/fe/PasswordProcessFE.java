package tr.com.meto.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import tr.com.meto.dal.AccountsDAL;
import tr.com.meto.dal.AuthoryDAL;
import tr.com.meto.dal.PersonalDAL;
import tr.com.meto.interfaces.IFe;
import tr.com.meto.types.AccountsContract;
import tr.com.meto.types.AuthorysContract;
import tr.com.meto.types.PersonalContract;

public class PasswordProcessFE extends JDialog implements IFe {

	public PasswordProcessFE() {
		İnitWindow();
	}

	@Override
	public void İnitWindow() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Şifre Belirleme İşlemleri"));
		
		add(panel);
		setTitle("Şifre Belirleme İşlemleri");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new GridLayout(5,2));
		JLabel personalLabel = new JLabel("Personel Seç: ",JLabel.RIGHT);
		panel.add(personalLabel);
		JComboBox personalBox = new JComboBox(new PersonalDAL().GetAll().toArray());
		panel.add(personalBox);
		JLabel authoryLabel = new JLabel("Yetki Seç: ",JLabel.RIGHT);
		panel.add(authoryLabel);
		JComboBox authoryBox = new JComboBox(new AuthoryDAL().GetAll().toArray());
		panel.add(authoryBox);
		JLabel passwordLabel = new JLabel("Şifre: ",JLabel.RIGHT);
		panel.add(passwordLabel);
		JPasswordField passwordField = new JPasswordField(10); 
		panel.add(passwordField);
		JLabel passwordRepeatLabel = new JLabel("Şifre Tekrar: ",JLabel.RIGHT);
		panel.add(passwordRepeatLabel);
		JPasswordField passwordRepeatField = new JPasswordField(10);
		panel.add(passwordRepeatField);
		
		JButton saveButton = new JButton("Kaydet");
		panel.add(saveButton);
		JButton cancelButton = new JButton("İptal");
		panel.add(cancelButton);
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AccountsContract contract = new AccountsContract();
				PersonalContract persContract=  (PersonalContract) personalBox.getSelectedItem();
				AuthorysContract authContract = (AuthorysContract) authoryBox.getSelectedItem();
				if(passwordField.getText().equals(passwordRepeatField.getText())) {
					
					contract.setPersonalId(persContract.getId());
					contract.setAuthorityId(authContract.getId());
					contract.setPassword(passwordField.getText());
					
					new AccountsDAL().Insert(contract);
					JOptionPane.showMessageDialog(null, 
							persContract.getNameSurname()+" adlı kişiye "
							+authContract.getName()+" başarılı bir şekilde eklendi.");
				}else {
					JOptionPane.showMessageDialog(null, "Şifreler uyuşmuyor lütfen tekrar deneyiniz.");
				}
				
				
				
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
