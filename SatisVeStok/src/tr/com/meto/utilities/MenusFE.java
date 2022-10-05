package tr.com.meto.utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import tr.com.meto.fe.AuthoryAddFE;
import tr.com.meto.fe.CategoryAddFE;
import tr.com.meto.fe.CustomerAddFe;
import tr.com.meto.fe.PasswordProcessFE;
import tr.com.meto.fe.PersonalAddFE;
import tr.com.meto.fe.ProductAddFE;

public class MenusFE {
	
	public static JMenuBar initBar() {
		JMenuBar bar = new JMenuBar();
		
		JMenu folderMenu= new JMenu("Dosya");
		bar.add(folderMenu);
		
		JMenuItem exitItem=new JMenuItem("Çıkış");
		folderMenu.add(exitItem);
		
		/*Products Menu*/
		JMenu productsMenu = new JMenu("Ürünler");
		bar.add(productsMenu);
		
		JMenuItem productAddItem= new JMenuItem("Ürün Ekle");
		productsMenu.add(productAddItem);		
		JMenuItem categoryAddItem = new JMenuItem("Kategori Ekle");
		productsMenu.add(categoryAddItem);
		productsMenu.addSeparator();		
		JMenuItem productUpdateItem= new JMenuItem("Ürünü Düzenle");
		productsMenu.add(productUpdateItem);		
		JMenuItem categoryUpdateItem= new JMenuItem("Kategoriyi Düzenle");
		productsMenu.add(categoryUpdateItem);	
		/* Personal Menu*/	
		
		JMenu personalMenu = new JMenu("Personel İşlemleri");
		bar.add(personalMenu);
		
		JMenuItem personalAddItem = new JMenuItem("Personel Ekle");
		personalMenu.add(personalAddItem);		
		JMenuItem authoryAddItem = new JMenuItem("Yetki Ekle");
		personalMenu.add(authoryAddItem);		
		JMenuItem passwordCreateItem = new JMenuItem("Şifre Belirleme");
		personalMenu.add(passwordCreateItem);
		personalMenu.addSeparator();
		
		JMenuItem personalUpdateItem= new JMenuItem("Personel Düzenle");
		personalMenu.add(personalUpdateItem);
		JMenuItem authoryUpdateItem = new JMenuItem("Yetki Düzenle");
		personalMenu.add(authoryUpdateItem);
		JMenuItem passwordUpdateItem = new JMenuItem("Şifre Düzenle");
		personalMenu.add(passwordUpdateItem);
		/*Customer Menu*/
		
		JMenu customerMenu= new JMenu("Müşteriler");
		bar.add(customerMenu);
		JMenuItem customerAddItem = new JMenuItem("Müşteri Ekle");
		customerMenu.add(customerAddItem);
		JMenuItem cityAddItem = new JMenuItem("Şehir Ekle");
		customerMenu.add(cityAddItem);
		customerMenu.addSeparator();
		
		JMenuItem customerUpdateItem = new JMenuItem("Müşteri Düzenle");
		customerMenu.add(customerUpdateItem);
		JMenuItem cityUpdateItem = new JMenuItem("Şehir Düzenle");
		customerMenu.add(cityUpdateItem);
		
		
		
		
		
		
		
		productAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new ProductAddFE();
						
					}
				});
				
			}
		});
		categoryAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CategoryAddFE();
				
			}
		});
		
		personalAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new PersonalAddFE();
						
					}
				});
				
			}
		});
		
		authoryAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new AuthoryAddFE();
						
					}
				});
				
			}
		});
		
		passwordCreateItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new PasswordProcessFE();
						
					}
				});
				
			}
		});
		
		customerAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new CustomerAddFe();
						
					}
				});
				
			}
		});
		
		return bar;
	}
}
