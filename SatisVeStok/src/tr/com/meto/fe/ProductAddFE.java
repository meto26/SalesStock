package tr.com.meto.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import tr.com.meto.dal.CategoryDAL;
import tr.com.meto.dal.ProductDAL;
import tr.com.meto.interfaces.IFe;
import tr.com.meto.types.CategoryContract;
import tr.com.meto.types.ProductsContract;

public class ProductAddFE extends JDialog implements IFe{

	public ProductAddFE() {
		İnitWindow();
	}

	@Override
	public void İnitWindow() {
		
		JPanel panel=initPanel();
		
		add(panel);		
		setTitle("Ürün Ekleyin");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(5, 2));
		JLabel label = new JLabel("Adı",JLabel.RIGHT);
		panel.add(label);
		JTextField field = new JTextField(10);
		panel.add(field);
		JLabel categoryLabel = new JLabel("Kategori Seç:",JLabel.RIGHT);
		panel.add(categoryLabel);
		JComboBox categoryBox = new JComboBox(new CategoryDAL().GetAll().toArray());
		panel.add(categoryBox);
		JLabel dateLabel= new JLabel("Tarih",JLabel.RIGHT);
		panel.add(dateLabel);
		JDateChooser date = new JDateChooser();
		panel.add(date);
		JLabel priceLabel =new JLabel("Fiyat",JLabel.RIGHT);
		panel.add(priceLabel);
		JTextField priceFields = new JTextField(10);
		panel.add(priceFields);
		
		JButton addButton = new JButton("Kaydet");
		panel.add(addButton);
		JButton cancelButton = new JButton("İptal");
		panel.add(cancelButton);
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProductsContract contract = new ProductsContract();
				CategoryContract saveContract = (CategoryContract) categoryBox.getSelectedItem();
				SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
				
				String dates = format.format(date.getDate());				
				contract.setName(field.getText());
				contract.setCategoryId(saveContract.getId());
				contract.setDate(dates);
				contract.setPrice(Float.parseFloat(priceFields.getText()));
				
				new ProductDAL().Insert(contract);
				JOptionPane.showMessageDialog(null,contract.getName()+" Ürün başarılı bir şekilde eklenmiştir.");
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
