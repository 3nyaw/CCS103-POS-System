package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Sales {

	JFrame Sales;
	private JTable tblPurchase;
	private JTextField textField;

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
		Sales.getContentPane().setBackground(new Color(255, 255, 255));
		Sales.setBounds(100, 100, 1940, 2000);
		Sales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Sales.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Sales.getContentPane().setLayout(null);
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(192, 192, 192));
		menu.setBounds(0, 0, 275, 1061);
		Sales.getContentPane().add(menu);
		menu.setLayout(null);
		
		JLabel lblTitle = new JLabel("PageTurn");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblTitle.setBounds(10, 5, 255, 89);
		menu.add(lblTitle);
		lblTitle.setBackground(new Color(255, 255, 255));
		
		JLabel lblPointOfSale = new JLabel("Point of Sale System");
		lblPointOfSale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPointOfSale.setBounds(10, 82, 245, 40);
		menu.add(lblPointOfSale);
		
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
		menu.add(lblDashboard);
		
		JLabel lblSales = new JLabel("   Sales");
		lblSales.setForeground(new Color(0, 0, 0));
		lblSales.setOpaque(true);
		lblSales.setBackground(new Color(128, 128, 128));
		lblSales.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSales.setBounds(20, 243, 245, 40);
		menu.add(lblSales);
		
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
		menu.add(lblInventory);
		
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
		menu.add(lblAccount);
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(128, 128, 128));
		pnlHeader.setBounds(274, 0, 1650, 90);
		Sales.getContentPane().add(pnlHeader);
		
		JPanel pnlBooks = new JPanel();
		pnlBooks.setBackground(new Color(255, 255, 255));
		pnlBooks.setBounds(285, 90, 1279, 774);
		Sales.getContentPane().add(pnlBooks);
		pnlBooks.setLayout(null);
		
		JLabel lblNovel = new JLabel("Novel");
		lblNovel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNovel.setBounds(10, 11, 410, 30);
		pnlBooks.add(lblNovel);
		
		JPanel pnlDune = new JPanel();
		pnlDune.setBounds(0, 52, 420, 200);
		pnlBooks.add(pnlDune);
		pnlDune.setLayout(null);
		
		JLabel lblDuneCover = new JLabel("");
		lblDuneCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\dune.png"));
		lblDuneCover.setBounds(0, 0, 133, 200);
		pnlDune.add(lblDuneCover);
		
		JLabel lblDune = new JLabel("Dune");
		lblDune.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDune.setBounds(143, 11, 62, 29);
		pnlDune.add(lblDune);
		
		JLabel lblByFrankHerbet = new JLabel("by Frank Herbet");
		lblByFrankHerbet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByFrankHerbet.setBounds(143, 41, 99, 17);
		pnlDune.add(lblByFrankHerbet);
		
		JLabel lblDunePrice = new JLabel("$5.99");
		lblDunePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblDunePrice.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblDunePrice.setBounds(143, 130, 113, 49);
		pnlDune.add(lblDunePrice);
		
		JButton btnDunePlus = new JButton("+");
		btnDunePlus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDunePlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDunePlus.setBounds(380, 94, 30, 30);
		pnlDune.add(btnDunePlus);
		
		JButton btnDuneMinus = new JButton("-");
		btnDuneMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDuneMinus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDuneMinus.setBounds(277, 94, 30, 30);
		pnlDune.add(btnDuneMinus);
		
		JLabel lblDuneQuantity = new JLabel("1");
		lblDuneQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDuneQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuneQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDuneQuantity.setBounds(317, 94, 53, 30);
		pnlDune.add(lblDuneQuantity);
		
		JButton btnDuneScan = new JButton("SCAN");
		btnDuneScan.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDuneScan.setBounds(277, 135, 133, 54);
		pnlDune.add(btnDuneScan);
		
		JPanel pnlCrime = new JPanel();
		pnlCrime.setBounds(429, 51, 420, 200);
		pnlBooks.add(pnlCrime);
		pnlCrime.setLayout(null);
		
		JLabel lblCrimeCover = new JLabel("");
		lblCrimeCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\C&P.png"));
		lblCrimeCover.setBounds(0, 0, 133, 200);
		pnlCrime.add(lblCrimeCover);
		
		JLabel lblCrime = new JLabel("Crime and Punishment");
		lblCrime.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCrime.setBounds(143, 11, 267, 30);
		pnlCrime.add(lblCrime);
		
		JLabel lblByFrankHerbet_1 = new JLabel("by Frank Herbet");
		lblByFrankHerbet_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByFrankHerbet_1.setBounds(143, 41, 267, 20);
		pnlCrime.add(lblByFrankHerbet_1);
		
		JLabel lblCrimePrice = new JLabel("$13.99");
		lblCrimePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrimePrice.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCrimePrice.setBounds(143, 130, 113, 49);
		pnlCrime.add(lblCrimePrice);
		
		JButton btnCrimeMinus = new JButton("-");
		btnCrimeMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCrimeMinus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCrimeMinus.setBounds(277, 94, 30, 30);
		pnlCrime.add(btnCrimeMinus);
		
		JLabel lblCrimeQuantity = new JLabel("1");
		lblCrimeQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrimeQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrimeQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCrimeQuantity.setBounds(317, 94, 53, 30);
		pnlCrime.add(lblCrimeQuantity);
		
		JButton btnCrimePlus = new JButton("+");
		btnCrimePlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCrimePlus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCrimePlus.setBounds(380, 94, 30, 30);
		pnlCrime.add(btnCrimePlus);
		
		JButton btnCrimeScan = new JButton("SCAN");
		btnCrimeScan.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCrimeScan.setBounds(277, 135, 133, 54);
		pnlCrime.add(btnCrimeScan);
		
		JPanel pnlAchilles = new JPanel();
		pnlAchilles.setBounds(859, 52, 420, 200);
		pnlBooks.add(pnlAchilles);
		pnlAchilles.setLayout(null);
		
		JLabel lblAchillesCover = new JLabel("");
		lblAchillesCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\songOfAchilles.png"));
		lblAchillesCover.setBounds(0, 0, 133, 200);
		pnlAchilles.add(lblAchillesCover);
		
		JLabel lblAchilles = new JLabel("The Song of Achilles");
		lblAchilles.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAchilles.setBounds(143, 11, 267, 30);
		pnlAchilles.add(lblAchilles);
		
		JLabel lblByFrankHerbet_1_1 = new JLabel("by Madelline Miller");
		lblByFrankHerbet_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByFrankHerbet_1_1.setBounds(143, 41, 267, 20);
		pnlAchilles.add(lblByFrankHerbet_1_1);
		
		JLabel lblDunePrice_2 = new JLabel("$12.68");
		lblDunePrice_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDunePrice_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDunePrice_2.setBounds(143, 130, 113, 49);
		pnlAchilles.add(lblDunePrice_2);
		
		JButton btnDuneMinus_2 = new JButton("-");
		btnDuneMinus_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDuneMinus_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDuneMinus_2.setBounds(277, 94, 30, 30);
		pnlAchilles.add(btnDuneMinus_2);
		
		JLabel lblDuneQuantity_2 = new JLabel("1");
		lblDuneQuantity_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuneQuantity_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDuneQuantity_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDuneQuantity_2.setBounds(317, 94, 53, 30);
		pnlAchilles.add(lblDuneQuantity_2);
		
		JButton btnDunePlus_2 = new JButton("+");
		btnDunePlus_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDunePlus_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDunePlus_2.setBounds(380, 94, 30, 30);
		pnlAchilles.add(btnDunePlus_2);
		
		JButton btnDuneScan_2 = new JButton("SCAN");
		btnDuneScan_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDuneScan_2.setBounds(277, 135, 133, 54);
		pnlAchilles.add(btnDuneScan_2);
		
		JLabel lblHistory = new JLabel("Self-help");
		lblHistory.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHistory.setBounds(10, 273, 410, 30);
		pnlBooks.add(lblHistory);
		
		JPanel pnlMeditations = new JPanel();
		pnlMeditations.setBounds(0, 314, 420, 200);
		pnlBooks.add(pnlMeditations);
		pnlMeditations.setLayout(null);
		
		JLabel lblMeditationsCover = new JLabel("");
		lblMeditationsCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\meditations.png"));
		lblMeditationsCover.setBounds(0, 0, 133, 200);
		pnlMeditations.add(lblMeditationsCover);
		
		JLabel lblMeditations = new JLabel("Meditations");
		lblMeditations.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMeditations.setBounds(143, 11, 267, 30);
		pnlMeditations.add(lblMeditations);
		
		JLabel lblByFrankHerbet_1_1_1_1_1 = new JLabel("by Marcus Aurelius");
		lblByFrankHerbet_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByFrankHerbet_1_1_1_1_1.setBounds(143, 41, 267, 20);
		pnlMeditations.add(lblByFrankHerbet_1_1_1_1_1);
		
		JLabel lblDunePrice_3 = new JLabel("$9.99");
		lblDunePrice_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDunePrice_3.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblDunePrice_3.setBounds(143, 130, 113, 49);
		pnlMeditations.add(lblDunePrice_3);
		
		JButton btnDuneMinus_3 = new JButton("-");
		btnDuneMinus_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDuneMinus_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDuneMinus_3.setBounds(277, 94, 30, 30);
		pnlMeditations.add(btnDuneMinus_3);
		
		JLabel lblDuneQuantity_3 = new JLabel("1");
		lblDuneQuantity_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuneQuantity_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDuneQuantity_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDuneQuantity_3.setBounds(317, 94, 53, 30);
		pnlMeditations.add(lblDuneQuantity_3);
		
		JButton btnDunePlus_3 = new JButton("+");
		btnDunePlus_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDunePlus_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDunePlus_3.setBounds(380, 94, 30, 30);
		pnlMeditations.add(btnDunePlus_3);
		
		JButton btnDuneScan_3 = new JButton("SCAN");
		btnDuneScan_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDuneScan_3.setBounds(277, 135, 133, 54);
		pnlMeditations.add(btnDuneScan_3);
		
		JPanel pnlEgo = new JPanel();
		pnlEgo.setBounds(429, 314, 420, 200);
		pnlBooks.add(pnlEgo);
		pnlEgo.setLayout(null);
		
		JLabel lblEgoCover = new JLabel("");
		lblEgoCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\egoIsTheEnemy.png"));
		lblEgoCover.setBounds(0, 0, 133, 200);
		pnlEgo.add(lblEgoCover);
		
		JLabel lblEgo = new JLabel("Ego is the Enemy");
		lblEgo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEgo.setBounds(143, 11, 267, 30);
		pnlEgo.add(lblEgo);
		
		JLabel lblByFrankHerbet_1_1_1_1 = new JLabel("by Ryan Holiday");
		lblByFrankHerbet_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByFrankHerbet_1_1_1_1.setBounds(143, 41, 267, 20);
		pnlEgo.add(lblByFrankHerbet_1_1_1_1);
		
		JLabel lblDunePrice_4 = new JLabel("$14.39");
		lblDunePrice_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDunePrice_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDunePrice_4.setBounds(143, 130, 113, 49);
		pnlEgo.add(lblDunePrice_4);
		
		JButton btnDuneMinus_4 = new JButton("-");
		btnDuneMinus_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDuneMinus_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDuneMinus_4.setBounds(277, 94, 30, 30);
		pnlEgo.add(btnDuneMinus_4);
		
		JLabel lblDuneQuantity_4 = new JLabel("1");
		lblDuneQuantity_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuneQuantity_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDuneQuantity_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDuneQuantity_4.setBounds(317, 94, 53, 30);
		pnlEgo.add(lblDuneQuantity_4);
		
		JButton btnDunePlus_4 = new JButton("+");
		btnDunePlus_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDunePlus_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDunePlus_4.setBounds(380, 94, 30, 30);
		pnlEgo.add(btnDunePlus_4);
		
		JButton btnDuneScan_4 = new JButton("SCAN");
		btnDuneScan_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDuneScan_4.setBounds(277, 135, 133, 54);
		pnlEgo.add(btnDuneScan_4);
		
		JPanel pnlMountain = new JPanel();
		pnlMountain.setBounds(859, 314, 420, 200);
		pnlBooks.add(pnlMountain);
		pnlMountain.setLayout(null);
		
		JLabel lblMountainCover = new JLabel("");
		lblMountainCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\theMountainIsYou.png"));
		lblMountainCover.setBounds(0, 0, 133, 200);
		pnlMountain.add(lblMountainCover);
		
		JLabel lblTheMountainIs = new JLabel("The Mountain is You");
		lblTheMountainIs.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTheMountainIs.setBounds(143, 11, 267, 30);
		pnlMountain.add(lblTheMountainIs);
		
		JLabel lblByFrankHerbet_1_1_1 = new JLabel("by Brianna West");
		lblByFrankHerbet_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByFrankHerbet_1_1_1.setBounds(143, 41, 267, 20);
		pnlMountain.add(lblByFrankHerbet_1_1_1);
		
		JLabel lblDunePrice_5 = new JLabel("$17.99");
		lblDunePrice_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblDunePrice_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDunePrice_5.setBounds(143, 130, 113, 49);
		pnlMountain.add(lblDunePrice_5);
		
		JButton btnDuneMinus_5 = new JButton("-");
		btnDuneMinus_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDuneMinus_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDuneMinus_5.setBounds(277, 94, 30, 30);
		pnlMountain.add(btnDuneMinus_5);
		
		JLabel lblDuneQuantity_5 = new JLabel("1");
		lblDuneQuantity_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuneQuantity_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDuneQuantity_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDuneQuantity_5.setBounds(317, 94, 53, 30);
		pnlMountain.add(lblDuneQuantity_5);
		
		JButton btnDunePlus_5 = new JButton("+");
		btnDunePlus_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDunePlus_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDunePlus_5.setBounds(380, 94, 30, 30);
		pnlMountain.add(btnDunePlus_5);
		
		JButton btnDuneScan_5 = new JButton("SCAN");
		btnDuneScan_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDuneScan_5.setBounds(277, 135, 133, 54);
		pnlMountain.add(btnDuneScan_5);
		
		JLabel lblHistory_1 = new JLabel("History");
		lblHistory_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHistory_1.setBounds(10, 535, 410, 30);
		pnlBooks.add(lblHistory_1);
		
		JPanel pnlDiary = new JPanel();
		pnlDiary.setBounds(0, 576, 420, 200);
		pnlBooks.add(pnlDiary);
		pnlDiary.setLayout(null);
		
		JLabel lblDiaryCover = new JLabel("");
		lblDiaryCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\anneFrank.png"));
		lblDiaryCover.setBounds(0, 0, 133, 200);
		pnlDiary.add(lblDiaryCover);
		
		JLabel lblDiary = new JLabel("Diary of a Young Girl");
		lblDiary.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDiary.setBounds(143, 11, 267, 30);
		pnlDiary.add(lblDiary);
		
		JLabel lblByFrankHerbet_1_1_1_1_1_1 = new JLabel("by Anne Frank");
		lblByFrankHerbet_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByFrankHerbet_1_1_1_1_1_1.setBounds(143, 41, 267, 20);
		pnlDiary.add(lblByFrankHerbet_1_1_1_1_1_1);
		
		JLabel lblDunePrice_6 = new JLabel("$7.19");
		lblDunePrice_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblDunePrice_6.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblDunePrice_6.setBounds(143, 130, 113, 49);
		pnlDiary.add(lblDunePrice_6);
		
		JButton btnDuneMinus_6 = new JButton("-");
		btnDuneMinus_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDuneMinus_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDuneMinus_6.setBounds(277, 94, 30, 30);
		pnlDiary.add(btnDuneMinus_6);
		
		JLabel lblDuneQuantity_6 = new JLabel("1");
		lblDuneQuantity_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuneQuantity_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDuneQuantity_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDuneQuantity_6.setBounds(317, 94, 53, 30);
		pnlDiary.add(lblDuneQuantity_6);
		
		JButton btnDunePlus_6 = new JButton("+");
		btnDunePlus_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDunePlus_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDunePlus_6.setBounds(380, 94, 30, 30);
		pnlDiary.add(btnDunePlus_6);
		
		JButton btnDuneScan_6 = new JButton("SCAN");
		btnDuneScan_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDuneScan_6.setBounds(277, 135, 133, 54);
		pnlDiary.add(btnDuneScan_6);
		
		JPanel pnlNoli = new JPanel();
		pnlNoli.setBounds(430, 576, 420, 200);
		pnlBooks.add(pnlNoli);
		pnlNoli.setLayout(null);
		
		JLabel lblNoliCover = new JLabel("");
		lblNoliCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\noliMeTangere.png"));
		lblNoliCover.setBounds(0, 0, 133, 200);
		pnlNoli.add(lblNoliCover);
		
		JLabel lblNoli = new JLabel("Noli Me Tangere");
		lblNoli.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNoli.setBounds(143, 11, 267, 30);
		pnlNoli.add(lblNoli);
		
		JLabel lblByFrankHerbet_1_1_1_1_1_1_1 = new JLabel("by Jose Rizal");
		lblByFrankHerbet_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByFrankHerbet_1_1_1_1_1_1_1.setBounds(143, 41, 267, 20);
		pnlNoli.add(lblByFrankHerbet_1_1_1_1_1_1_1);
		
		JLabel lblDunePrice_7 = new JLabel("$15.49");
		lblDunePrice_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblDunePrice_7.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDunePrice_7.setBounds(143, 130, 113, 49);
		pnlNoli.add(lblDunePrice_7);
		
		JButton btnDuneMinus_7 = new JButton("-");
		btnDuneMinus_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDuneMinus_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDuneMinus_7.setBounds(277, 94, 30, 30);
		pnlNoli.add(btnDuneMinus_7);
		
		JLabel lblDuneQuantity_7 = new JLabel("1");
		lblDuneQuantity_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuneQuantity_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDuneQuantity_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDuneQuantity_7.setBounds(317, 94, 53, 30);
		pnlNoli.add(lblDuneQuantity_7);
		
		JButton btnDunePlus_7 = new JButton("+");
		btnDunePlus_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDunePlus_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDunePlus_7.setBounds(380, 94, 30, 30);
		pnlNoli.add(btnDunePlus_7);
		
		JButton btnDuneScan_7 = new JButton("SCAN");
		btnDuneScan_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDuneScan_7.setBounds(277, 135, 133, 54);
		pnlNoli.add(btnDuneScan_7);
		
		JPanel pnlVoyage = new JPanel();
		pnlVoyage.setBounds(859, 576, 420, 200);
		pnlBooks.add(pnlVoyage);
		pnlVoyage.setLayout(null);
		
		JLabel lblVoyageCover = new JLabel("");
		lblVoyageCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\theFirstVoyageAroundTheWorld.png"));
		lblVoyageCover.setBounds(0, 0, 133, 200);
		pnlVoyage.add(lblVoyageCover);
		
		JLabel lblVoyage = new JLabel("The First Voyage Around the World");
		lblVoyage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVoyage.setBounds(143, 11, 267, 30);
		pnlVoyage.add(lblVoyage);
		
		JLabel lblByFrankHerbet_1_1_1_1_1_1_1_1 = new JLabel("by Antonio Pigafetta");
		lblByFrankHerbet_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblByFrankHerbet_1_1_1_1_1_1_1_1.setBounds(143, 41, 267, 20);
		pnlVoyage.add(lblByFrankHerbet_1_1_1_1_1_1_1_1);
		
		JLabel lblDunePrice_8 = new JLabel("$47.26");
		lblDunePrice_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblDunePrice_8.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDunePrice_8.setBounds(143, 130, 113, 49);
		pnlVoyage.add(lblDunePrice_8);
		
		JButton btnDuneMinus_8 = new JButton("-");
		btnDuneMinus_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDuneMinus_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDuneMinus_8.setBounds(277, 94, 30, 30);
		pnlVoyage.add(btnDuneMinus_8);
		
		JLabel lblDuneQuantity_8 = new JLabel("1");
		lblDuneQuantity_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuneQuantity_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDuneQuantity_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDuneQuantity_8.setBounds(317, 94, 53, 30);
		pnlVoyage.add(lblDuneQuantity_8);
		
		JButton btnDunePlus_8 = new JButton("+");
		btnDunePlus_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDunePlus_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDunePlus_8.setBounds(380, 94, 30, 30);
		pnlVoyage.add(btnDunePlus_8);
		
		JButton btnDuneScan_8 = new JButton("SCAN");
		btnDuneScan_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDuneScan_8.setBounds(277, 135, 133, 54);
		pnlVoyage.add(btnDuneScan_8);
		
		JPanel pnlPay = new JPanel();
		pnlPay.setBackground(new Color(192, 192, 192));
		pnlPay.setBounds(1574, 90, 350, 450);
		Sales.getContentPane().add(pnlPay);
		pnlPay.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 11, 330, 387);
		pnlPay.add(scrollPane);
		
		tblPurchase = new JTable();
		tblPurchase.setGridColor(new Color(192, 192, 192));
		tblPurchase.setSelectionBackground(new Color(192, 192, 192));
		scrollPane.setViewportView(tblPurchase);
		tblPurchase.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "ITEM", "QTY", "PRICE"
			}
		));
		
		JButton btnPurchse = new JButton("PURCHASE");
		btnPurchse.setBounds(10, 409, 160, 30);
		pnlPay.add(btnPurchse);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(180, 409, 160, 30);
		pnlPay.add(btnDelete);
		
		JPanel pnlPrint = new JPanel();
		pnlPrint.setBackground(new Color(192, 192, 192));
		pnlPrint.setBounds(1574, 551, 350, 450);
		Sales.getContentPane().add(pnlPrint);
		pnlPrint.setLayout(null);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.setBounds(10, 409, 330, 30);
		pnlPrint.add(btnPrint);
		
		JTextArea txtaReceipt = new JTextArea();
		txtaReceipt.setBounds(10, 11, 330, 387);
		pnlPrint.add(txtaReceipt);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTotal.setBounds(1252, 875, 312, 30);
		Sales.getContentPane().add(lblTotal);
		
		JLabel lblCash = new JLabel("CASH:");
		lblCash.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCash.setBounds(1266, 916, 298, 29);
		Sales.getContentPane().add(lblCash);
		
		JLabel lblBalance = new JLabel("BALANCE:");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBalance.setBounds(1219, 957, 345, 30);
		Sales.getContentPane().add(lblBalance);
		
		textField = new JTextField();
		textField.setBounds(1350, 916, 214, 29);
		Sales.getContentPane().add(textField);
		textField.setColumns(10);
	}
}