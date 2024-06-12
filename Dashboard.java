package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard {

	JFrame Dashboard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.Dashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dashboard = new JFrame("Dashboard | PageTurn");
		Dashboard.setBounds(100, 100, 1940, 2000);
		Dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dashboard.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 275, 1061);
		Dashboard.getContentPane().add(panel);
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
		
		JLabel lblDashboard = new JLabel("   Dashboard");
		lblDashboard.setForeground(new Color(0, 0, 0));
		lblDashboard.setOpaque(true);
		lblDashboard.setBackground(new Color(128, 128, 128));
		lblDashboard.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDashboard.setBounds(20, 192, 245, 40);
		panel.add(lblDashboard);
		
		JLabel lblSales = new JLabel("Sales");
		lblSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sales sales = new Sales();
				sales.Sales.setVisible(true);
				Dashboard.dispose();
			}
		});
		lblSales.setOpaque(true);
		lblSales.setBackground(new Color(192, 192, 192));
		lblSales.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSales.setBounds(20, 243, 245, 40);
		panel.add(lblSales);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inventory inventory = new Inventory();
				inventory.Inventory.setVisible(true);
				Dashboard.dispose();
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
				Dashboard.dispose();
			}
		});
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAccount.setBounds(20, 345, 245, 40);
		panel.add(lblAccount);
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(Color.GRAY);
		pnlHeader.setBounds(274, 0, 1650, 90);
		Dashboard.getContentPane().add(pnlHeader);
	}
}
