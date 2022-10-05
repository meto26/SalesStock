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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.meto.dal.CategoryDAL;
import tr.com.meto.interfaces.IFe;
import tr.com.meto.types.CategoryContract;

public class CategoryAddFE extends JDialog implements IFe{

	public CategoryAddFE() {
		İnitWindow();
	}

	@Override
	public void İnitWindow() {	
		JPanel panel = initPanel();
		
		panel.setBorder(BorderFactory.createTitledBorder("Kategori Ekle"));
		add(panel);
		setTitle("Kategori Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
	}

	@Override
	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new GridLayout(3,2));
		JLabel label= new JLabel("Kategori Adı:",JLabel.RIGHT);
		panel.add(label);
		JTextField field= new JTextField(10);
		panel.add(field);
		JLabel catgoryLabel = new JLabel("Kategori Seç:",JLabel.RIGHT);
		panel.add(catgoryLabel);
		JComboBox categoryBox = new JComboBox(new CategoryDAL().GetAllParentId().toArray());
		panel.add(categoryBox);
		categoryBox.insertItemAt("--Kategori Seçiniz--", 0);
		categoryBox.setSelectedIndex(0);
		
		JButton saveButton = new JButton("Kaydet");
		panel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CategoryContract contract = new CategoryContract();				
				
				if(categoryBox.getSelectedIndex() !=0 ) {
					CategoryContract  saveContract = (CategoryContract) categoryBox.getSelectedItem();
					contract.setName(field.getText());
					contract.setParentId(saveContract.getId());		
					
					new CategoryDAL().Insert(contract);
					JOptionPane.showMessageDialog(null,contract.getName()+" adlı kategori başarılı bir şekilde eklenmiştir.");
					
				}else {
					contract.setName(field.getText());
					contract.setParentId(categoryBox.getSelectedIndex());
					
					new CategoryDAL().Insert(contract);
					JOptionPane.showMessageDialog(null,contract.getName()+" adlı kategori başarılı bir şekilde eklenmiştir.");
					
					
					
			}
				
			}
		});
		JButton cancelButton = new JButton("İptal");
		panel.add(cancelButton);
		
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
