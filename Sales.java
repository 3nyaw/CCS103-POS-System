package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sales {

	JFrame Sales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales window = new Sales();
					window.Sales.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sales() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Sales = new JFrame("Sales | PageTurn");
		Sales.setBounds(100, 100, 1940, 2000);
		Sales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Sales.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Sales.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 275, 1061);
		Sales.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("PageTurn");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblTitle.setBounds(10, 5, 255, 89);
		panel.add(lblTitle);
		lblTitle.setBackground(new Color(255, 255, 255));
		
		JLabel lblPointOfSale = new JLabel("Point of Sale System");
		lblPointOfSale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPointOfSale.setBounds(10, 82, 245, 40);
		panel.add(lblPointOfSale);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dashboard dashboard = new Dashboard();
				dashboard.Dashboard.setVisible(true);
				Sales.dispose();
			}
		});
		lblDashboard.setOpaque(true);
		lblDashboard.setBackground(new Color(192, 192, 192));
		lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDashboard.setBounds(20, 192, 245, 40);
		panel.add(lblDashboard);
		
		JLabel lblSales = new JLabel("   Sales");
		lblSales.setOpaque(true);
		lblSales.setBackground(new Color(128, 128, 128));
		lblSales.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSales.setBounds(20, 243, 245, 40);
		panel.add(lblSales);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inventory inventory = new Inventory();
				inventory.Inventory.setVisible(true);
				Sales.dispose();
			}
		});
		lblInventory.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInventory.setBounds(20, 294, 245, 40);
		panel.add(lblInventory);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Account account = new Account();
				account.Account.setVisible(true);
				Sales.dispose();
			}
		});
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAccount.setBounds(20, 345, 245, 40);
		panel.add(lblAccount);
	}

}
