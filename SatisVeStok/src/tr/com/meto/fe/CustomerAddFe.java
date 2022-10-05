package tr.com.meto.fe;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import tr.com.meto.interfaces.IFe;

public class CustomerAddFe extends JDialog implements IFe{

	public CustomerAddFe() {
		İnitWindow();
	}

	@Override
	public void İnitWindow() {
		JPanel panel =initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Müşteri Ekle"));
		
		add(panel);
		setTitle("Müşteri Ekle");
		pack();
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel fieldPanel = new JPanel(new GridLayout(5,2));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		
		JLabel nameLabel = new JLabel("Adı Soyadı: ",JLabel.RIGHT);
		fieldPanel.add(nameLabel);
		JTextField nameField = new JTextField(10);
		fieldPanel.add(nameField);
		
		JLabel telephoneLabel = new JLabel("Telefon: ",JLabel.RIGHT);
		fieldPanel.add(telephoneLabel);
		JTextField telephoneField = new JTextField(10);
		fieldPanel.add(telephoneField);
		
		JLabel cityLabel = new JLabel("Şehir: ",JLabel.RIGHT);
		fieldPanel.add(cityLabel);
		JComboBox cityBox = new JComboBox();
		fieldPanel.add(cityBox);
		
		JLabel adressLabel = new JLabel("Adres: ");
		fieldPanel.add(adressLabel);		
		
		JTextArea adressArea = new JTextArea(7,1);		
		JScrollPane pane = new JScrollPane(adressArea);
		pane.setBorder(BorderFactory.createTitledBorder("Adres Bilgisi"));
		
		JButton saveButton = new JButton("Kaydet");
		buttonPanel.add(saveButton);
		JButton cancelutton = new JButton("İptal");
		buttonPanel.add(cancelutton);
		
		panel.add(fieldPanel, BorderLayout.NORTH);
		panel.add(pane, BorderLayout.CENTER);
		panel.add(buttonPanel ,BorderLayout.SOUTH);
		
		
		
		
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
