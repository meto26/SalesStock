package tr.com.meto.fe;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import tr.com.meto.interfaces.IFe;
import tr.com.meto.utilities.MenusFE;

public class MainWindowFE extends JFrame implements IFe {

	public MainWindowFE() {
		İnitWindow();
	}

	@Override
	public void İnitWindow() {
		JPanel panel = initPanel();
		JMenuBar bar = initBar();

		add(panel);
		setJMenuBar(bar);
		setTitle("Satış ve Stok Programı");
		setSize(600, 250);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());

		JTabbedPane pane = initTabs();
		panel.add(pane, BorderLayout.CENTER);
		panel.add(pane);

		return panel;
	}

	@Override
	public JMenuBar initBar() {
		JMenuBar bar = MenusFE.initBar();

		return bar;
	}

	@Override
	public JTabbedPane initTabs() {
		JTabbedPane pane = new JTabbedPane();
		ImageIcon icon = new ImageIcon("icons/stock_icon.png");
		ImageIcon icon2 = new ImageIcon("icons/stock_icon.png");

		JPanel stockPanel = new JPanel(new BorderLayout());
		JPanel salesPanel = new JPanel(new BorderLayout());

		/* Stock Items */
		JPanel stockLeftPanel = new JPanel(new BorderLayout());
		JPanel stockLeftUpPanel = new JPanel(new GridLayout(4, 2));
		JPanel stockLeftDownPanel = new JPanel();

		stockLeftPanel.setBorder(BorderFactory.createTitledBorder("Stok İşlemleri"));
		Object[] stockColumns = { "Id", "Personel Adı", "Ürün Adı", "Adet", "Tarih" };
		DefaultTableModel model = new DefaultTableModel(stockColumns, 0);
		JTable table = new JTable(model);

		JScrollPane stockTablePane = new JScrollPane(table);

		JLabel stockProductNameLabel = new JLabel("Ürün Adı: ", JLabel.RIGHT);
		stockLeftUpPanel.add(stockProductNameLabel);
		JComboBox stockProductNameBox = new JComboBox();
		stockLeftUpPanel.add(stockProductNameBox);
		JLabel stockPieceLabel = new JLabel("Adet: ", JLabel.RIGHT);
		stockLeftUpPanel.add(stockPieceLabel);
		JTextField stockPieceField = new JTextField(10);
		stockLeftUpPanel.add(stockPieceField);
		JLabel stockDateLabel = new JLabel("Stok Tarihi: ", JLabel.RIGHT);
		stockLeftUpPanel.add(stockDateLabel);
		JDateChooser stockDate = new JDateChooser();
		stockLeftUpPanel.add(stockDate);

		JButton stockAddButton = new JButton("Stok Ekle");
		stockLeftUpPanel.add(stockAddButton);
		JButton stockRefreshButton = new JButton("Yenile");
		stockLeftUpPanel.add(stockRefreshButton);

		/* Sale Items */
		JPanel salesRightPanel = new JPanel(new BorderLayout());
		JPanel salesRightUpPanel = new JPanel(new GridLayout(4, 2));
		JPanel salesRightDownPanel = new JPanel();

		Object[] salesColumns = { "Id", "Personel Adı", "Müşteri Adı", "Ürün Adı", "Adet", "Tarih" };
		DefaultTableModel salesModel = new DefaultTableModel(salesColumns, 0);
		JTable salesTable = new JTable(salesModel);
		JScrollPane salesTablePane = new JScrollPane(salesTable);

		JLabel salesProductNameLabel = new JLabel("Ürün Adı: ", JLabel.RIGHT);
		salesRightUpPanel.add(salesProductNameLabel);
		JComboBox salesProductNameBox = new JComboBox();
		salesRightUpPanel.add(salesProductNameBox);
		JLabel salesPieceLabel = new JLabel("Adet: ", JLabel.RIGHT);
		salesRightUpPanel.add(salesPieceLabel);
		JTextField salesPieceField = new JTextField(10);
		salesRightUpPanel.add(salesPieceField);
		JLabel salesDateLabel = new JLabel("Satış Tarihi: ", JLabel.RIGHT);
		salesRightUpPanel.add(salesDateLabel);
		JDateChooser salesDate = new JDateChooser();
		salesRightUpPanel.add(salesDate);

		JButton salesAddButton = new JButton("Satış Yap");
		salesRightUpPanel.add(salesAddButton);
		JButton salesRefreshButton = new JButton("Yenile");
		salesRightUpPanel.add(salesRefreshButton);

		stockPanel.add(stockLeftPanel, BorderLayout.WEST);
		stockPanel.add(stockTablePane, BorderLayout.CENTER);
		
		salesPanel.add(salesRightPanel, BorderLayout.EAST);
		salesPanel.add(salesTablePane, BorderLayout.CENTER);
		
		salesRightPanel.add(salesRightDownPanel, BorderLayout.SOUTH);
		salesRightPanel.add(salesRightUpPanel, BorderLayout.NORTH);
		

		stockLeftPanel.add(stockLeftUpPanel, BorderLayout.NORTH);
		stockLeftPanel.add(stockLeftDownPanel, BorderLayout.SOUTH);

		pane.addTab("Stoklar", icon, stockPanel, "Does Nothing");
		pane.addTab("Satışlar", icon2, salesPanel, "Does Nothing");

		return pane;
	}

}
