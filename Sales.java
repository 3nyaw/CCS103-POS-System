package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Sales {

	JFrame Sales;
	private JTable tblPurchase;
	private JTextField textField;
	private JLabel lblTotal;
	private boolean purchaseMade = false;

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
	 * Methods.
	 */
	public void addTable(int id, String name, int quantity, Double price) {
        DefaultTableModel tableModel = (DefaultTableModel) tblPurchase.getModel();
        boolean itemExists = false;

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if ((int) tableModel.getValueAt(i, 0) == id) {
                int currentQuantity = (int) tableModel.getValueAt(i, 2);
                tableModel.setValueAt(currentQuantity + quantity, i, 2);
                tableModel.setValueAt((currentQuantity + quantity) * price, i, 3);
                itemExists = true;
                break;
            }
        }

        if (!itemExists) {
            Vector<Object> v = new Vector<>();
            v.add(id);
            v.add(name);
            v.add(quantity);
            v.add(price * quantity);
            tableModel.addRow(v);
        }
        updateTotal();
	}
	
    public void updateTotal() {
        DefaultTableModel tableModel = (DefaultTableModel) tblPurchase.getModel();
        double total = 0;

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double price = (Double) tableModel.getValueAt(i, 3);
            total += price;
        }

        DecimalFormat df = new DecimalFormat("#.00");
        String formattedTotal = df.format(total);

        lblTotal.setText("TOTAL: $" + formattedTotal);
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
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(128, 128, 128));
		pnlHeader.setBounds(274, 0, 1650, 90);
		Sales.getContentPane().add(pnlHeader);
		
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
		lblInventory.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInventory.setBounds(20, 294, 245, 40);
		menu.add(lblInventory);
		
		JLabel lblAccount = new JLabel("Account");

		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAccount.setBounds(20, 345, 245, 40);
		menu.add(lblAccount);
		
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
		
		JLabel lblDune = new JLabel("Dune \t");
		lblDune.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDune.setBounds(143, 11, 62, 29);
		pnlDune.add(lblDune);
		
		JLabel lblDuneAuthor = new JLabel("by Frank Herbet");
		lblDuneAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuneAuthor.setBounds(143, 41, 99, 17);
		pnlDune.add(lblDuneAuthor);
		
		JLabel lblDunePrice = new JLabel("$5.99");
		lblDunePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblDunePrice.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblDunePrice.setBounds(143, 130, 113, 49);
		pnlDune.add(lblDunePrice);
		
		JLabel lblDuneQuantity = new JLabel("1");
		lblDuneQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDuneQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuneQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDuneQuantity.setBounds(317, 94, 53, 30);
		pnlDune.add(lblDuneQuantity);
		
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
		
		JLabel lblCrimeAuthor = new JLabel("by Fyodor Dostoevsky");
		lblCrimeAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrimeAuthor.setBounds(143, 41, 267, 20);
		pnlCrime.add(lblCrimeAuthor);
		
		JLabel lblCrimePrice = new JLabel("$13.99");
		lblCrimePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrimePrice.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCrimePrice.setBounds(143, 130, 113, 49);
		pnlCrime.add(lblCrimePrice);
		
		JLabel lblCrimeQuantity = new JLabel("1");
		lblCrimeQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrimeQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrimeQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCrimeQuantity.setBounds(317, 94, 53, 30);
		pnlCrime.add(lblCrimeQuantity);
		
		JButton btnCrimeMinus = new JButton("-");
		btnCrimeMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCrimeMinus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCrimeMinus.setBounds(277, 94, 30, 30);
		pnlCrime.add(btnCrimeMinus);
		
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
		
		JLabel lblAchillesCover = new JLabel();
		lblAchillesCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\songOfAchilles.png"));
		lblAchillesCover.setBounds(0, 0, 133, 200);
		pnlAchilles.add(lblAchillesCover);
		
		JLabel lblAchilles = new JLabel("The Song of Achilles");
		lblAchilles.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAchilles.setBounds(143, 11, 267, 30);
		pnlAchilles.add(lblAchilles);
		
		JLabel lblAchillesAuthor = new JLabel("by Madelline Miller");
		lblAchillesAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAchillesAuthor.setBounds(143, 41, 267, 20);
		pnlAchilles.add(lblAchillesAuthor);
		
		JLabel lblAchillesPrice = new JLabel("$12.68");
		lblAchillesPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblAchillesPrice.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAchillesPrice.setBounds(143, 130, 113, 49);
		pnlAchilles.add(lblAchillesPrice);
		
		JLabel lblAchillesQuantity = new JLabel("1");
		lblAchillesQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblAchillesQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAchillesQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAchillesQuantity.setBounds(317, 94, 53, 30);
		pnlAchilles.add(lblAchillesQuantity);
		
		JButton btnAchillesMinus = new JButton("-");
		btnAchillesMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAchillesMinus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAchillesMinus.setBounds(277, 94, 30, 30);
		pnlAchilles.add(btnAchillesMinus);
		
		JButton btnAchillesPlus = new JButton("+");
		btnAchillesPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAchillesPlus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAchillesPlus.setBounds(380, 94, 30, 30);
		pnlAchilles.add(btnAchillesPlus);
		
		JButton btnAchillesScan = new JButton("SCAN");
		btnAchillesScan.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAchillesScan.setBounds(277, 135, 133, 54);
		pnlAchilles.add(btnAchillesScan);
		
		JLabel lblSelfHelp = new JLabel("Self-help");
		lblSelfHelp.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSelfHelp.setBounds(10, 273, 410, 30);
		pnlBooks.add(lblSelfHelp);
		
		JPanel pnlMeditations = new JPanel();
		pnlMeditations.setBounds(0, 314, 420, 200);
		pnlBooks.add(pnlMeditations);
		pnlMeditations.setLayout(null);
		
		JLabel lblMeditationsCover = new JLabel("");
		lblMeditationsCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\meditations.png"));
		lblMeditationsCover.setBounds(0, 0, 133, 200);
		pnlMeditations.add(lblMeditationsCover);
		
		JLabel lblMeditations = new JLabel("Meditations \t");
		lblMeditations.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMeditations.setBounds(143, 11, 267, 30);
		pnlMeditations.add(lblMeditations);
		
		JLabel lblMeditationsAuthor = new JLabel("by Marcus Aurelius");
		lblMeditationsAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMeditationsAuthor.setBounds(143, 41, 267, 20);
		pnlMeditations.add(lblMeditationsAuthor);
		
		JLabel lblMeditationsPrice = new JLabel("$9.99");
		lblMeditationsPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeditationsPrice.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblMeditationsPrice.setBounds(143, 130, 113, 49);
		pnlMeditations.add(lblMeditationsPrice);
		
		JLabel lblMeditationsQuantity = new JLabel("1");
		lblMeditationsQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeditationsQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMeditationsQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMeditationsQuantity.setBounds(317, 94, 53, 30);
		pnlMeditations.add(lblMeditationsQuantity);
		
		JButton btnMeditationsMinus = new JButton("-");
		btnMeditationsMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMeditationsMinus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnMeditationsMinus.setBounds(277, 94, 30, 30);
		pnlMeditations.add(btnMeditationsMinus);
		
		JButton btnMeditationsPlus = new JButton("+");
		btnMeditationsPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMeditationsPlus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnMeditationsPlus.setBounds(380, 94, 30, 30);
		pnlMeditations.add(btnMeditationsPlus);
		
		JButton btnMeditationsScan = new JButton("SCAN");
		btnMeditationsScan.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMeditationsScan.setBounds(277, 135, 133, 54);
		pnlMeditations.add(btnMeditationsScan);
		
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
		
		JLabel lblEgoAuthor = new JLabel("by Ryan Holiday");
		lblEgoAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEgoAuthor.setBounds(143, 41, 267, 20);
		pnlEgo.add(lblEgoAuthor);
		
		JLabel lblEgoPrice = new JLabel("$14.39");
		lblEgoPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblEgoPrice.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblEgoPrice.setBounds(143, 130, 113, 49);
		pnlEgo.add(lblEgoPrice);
		
		JLabel lblEgoQuantity = new JLabel("1");
		lblEgoQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblEgoQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEgoQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEgoQuantity.setBounds(317, 94, 53, 30);
		pnlEgo.add(lblEgoQuantity);
		
		JButton btnEgoMinus = new JButton("-");
		btnEgoMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEgoMinus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEgoMinus.setBounds(277, 94, 30, 30);
		pnlEgo.add(btnEgoMinus);
		
		JButton btnEgoPlus = new JButton("+");
		btnEgoPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEgoPlus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEgoPlus.setBounds(380, 94, 30, 30);
		pnlEgo.add(btnEgoPlus);
		
		JButton btnEgoScan = new JButton("SCAN");
		btnEgoScan.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEgoScan.setBounds(277, 135, 133, 54);
		pnlEgo.add(btnEgoScan);
		
		JPanel pnlMountain = new JPanel();
		pnlMountain.setBounds(859, 314, 420, 200);
		pnlBooks.add(pnlMountain);
		pnlMountain.setLayout(null);
		
		JLabel lblMountainCover = new JLabel("");
		lblMountainCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\theMountainIsYou.png"));
		lblMountainCover.setBounds(0, 0, 133, 200);
		pnlMountain.add(lblMountainCover);
		
		JLabel lblMountain = new JLabel("The Mountain is You");
		lblMountain.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMountain.setBounds(143, 11, 267, 30);
		pnlMountain.add(lblMountain);
		
		JLabel lblMountainAuthor = new JLabel("by Brianna West");
		lblMountainAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMountainAuthor.setBounds(143, 41, 267, 20);
		pnlMountain.add(lblMountainAuthor);
		
		JLabel lblMountainPrice = new JLabel("$17.99");
		lblMountainPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblMountainPrice.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMountainPrice.setBounds(143, 130, 113, 49);
		pnlMountain.add(lblMountainPrice);
		
		JLabel lblMountainQuantity = new JLabel("1");
		lblMountainQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblMountainQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMountainQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMountainQuantity.setBounds(317, 94, 53, 30);
		pnlMountain.add(lblMountainQuantity);
		
		JButton btnMountainMinus = new JButton("-");
		btnMountainMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMountainMinus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnMountainMinus.setBounds(277, 94, 30, 30);
		pnlMountain.add(btnMountainMinus);
		
		JButton btnMountainPlus = new JButton("+");
		btnMountainPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMountainPlus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnMountainPlus.setBounds(380, 94, 30, 30);
		pnlMountain.add(btnMountainPlus);
		
		JButton btnMountainScan = new JButton("SCAN");
		btnMountainScan.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMountainScan.setBounds(277, 135, 133, 54);
		pnlMountain.add(btnMountainScan);
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHistory.setBounds(10, 535, 410, 30);
		pnlBooks.add(lblHistory);
		
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
		
		JLabel lblDiaryAuthor = new JLabel("by Anne Frank");
		lblDiaryAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaryAuthor.setBounds(143, 41, 267, 20);
		pnlDiary.add(lblDiaryAuthor);
		
		JLabel lblDiaryPrice = new JLabel("$7.19");
		lblDiaryPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaryPrice.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblDiaryPrice.setBounds(143, 130, 113, 49);
		pnlDiary.add(lblDiaryPrice);
		
		JLabel lblDiaryQuantity = new JLabel("1");
		lblDiaryQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaryQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiaryQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDiaryQuantity.setBounds(317, 94, 53, 30);
		pnlDiary.add(lblDiaryQuantity);
		
		JButton btnDiaryMinus = new JButton("-");
		btnDiaryMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDiaryMinus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDiaryMinus.setBounds(277, 94, 30, 30);
		pnlDiary.add(btnDiaryMinus);
		
		JButton btnDiaryPlus = new JButton("+");
		btnDiaryPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDiaryPlus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDiaryPlus.setBounds(380, 94, 30, 30);
		pnlDiary.add(btnDiaryPlus);
		
		JButton btnDiaryScan = new JButton("SCAN");
		btnDiaryScan.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDiaryScan.setBounds(277, 135, 133, 54);
		pnlDiary.add(btnDiaryScan);
		
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
		
		JLabel lblNoliAuthor = new JLabel("by Jose Rizal");
		lblNoliAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNoliAuthor.setBounds(143, 41, 267, 20);
		pnlNoli.add(lblNoliAuthor);
		
		JLabel lblNoliPrice = new JLabel("$15.49");
		lblNoliPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoliPrice.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNoliPrice.setBounds(143, 130, 113, 49);
		pnlNoli.add(lblNoliPrice);
		
		JLabel lblNoliQuantity = new JLabel("1");
		lblNoliQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoliQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNoliQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNoliQuantity.setBounds(317, 94, 53, 30);
		pnlNoli.add(lblNoliQuantity);
		
		JButton btnNoliMinus = new JButton("-");
		btnNoliMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNoliMinus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNoliMinus.setBounds(277, 94, 30, 30);
		pnlNoli.add(btnNoliMinus);
		
		JButton btnNoliPlus = new JButton("+");
		btnNoliPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNoliPlus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNoliPlus.setBounds(380, 94, 30, 30);
		pnlNoli.add(btnNoliPlus);
		
		JButton btnNoliScan = new JButton("SCAN");
		btnNoliScan.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNoliScan.setBounds(277, 135, 133, 54);
		pnlNoli.add(btnNoliScan);
		
		JPanel pnlVoyage = new JPanel();
		pnlVoyage.setBounds(859, 576, 420, 200);
		pnlBooks.add(pnlVoyage);
		pnlVoyage.setLayout(null);
		
		JLabel lblVoyageCover = new JLabel("");
		lblVoyageCover.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\theFirstVoyageAroundTheWorld.png"));
		lblVoyageCover.setBounds(0, 0, 133, 200);
		pnlVoyage.add(lblVoyageCover);
		
		JLabel lblVoyage = new JLabel("The First Voyage");
		lblVoyage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVoyage.setBounds(143, 11, 267, 30);
		pnlVoyage.add(lblVoyage);
		
		JLabel lblVoyageAuthor = new JLabel("by Antonio Pigafetta");
		lblVoyageAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVoyageAuthor.setBounds(143, 41, 267, 20);
		pnlVoyage.add(lblVoyageAuthor);
		
		JLabel lblVoyagePrice = new JLabel("$47.26");
		lblVoyagePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoyagePrice.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblVoyagePrice.setBounds(143, 130, 113, 49);
		pnlVoyage.add(lblVoyagePrice);
		
		JLabel lblVoyageQuantity = new JLabel("1");
		lblVoyageQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoyageQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVoyageQuantity.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblVoyageQuantity.setBounds(317, 94, 53, 30);
		pnlVoyage.add(lblVoyageQuantity);
		
		JButton btnVoyageMinus = new JButton("-");
		btnVoyageMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVoyageMinus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnVoyageMinus.setBounds(277, 94, 30, 30);
		pnlVoyage.add(btnVoyageMinus);
		
		JButton btnVoyagePlus = new JButton("+");
		btnVoyagePlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVoyagePlus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnVoyagePlus.setBounds(380, 94, 30, 30);
		pnlVoyage.add(btnVoyagePlus);
		
		JButton btnVoyageScan = new JButton("SCAN");
		btnVoyageScan.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVoyageScan.setBounds(277, 135, 133, 54);
		pnlVoyage.add(btnVoyageScan);
		
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
			},
			new String[] {
				"ID", "ITEM", "QTY", "PRICE"
			}
		));
		tblPurchase.getColumnModel().getColumn(0).setPreferredWidth(25);
		tblPurchase.getColumnModel().getColumn(1).setPreferredWidth(150);
		tblPurchase.getColumnModel().getColumn(2).setPreferredWidth(50);
		tblPurchase.getColumnModel().getColumn(3).setPreferredWidth(50);
		
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
		
		lblTotal = new JLabel("TOTAL: $00.00");
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
		
		/**
		 * Events.
		 */
		lblInventory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inventory inventory = new Inventory();
				inventory.Inventory.setVisible(true);
				Sales.dispose();
			}
		});

		lblAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Account account = new Account();
				account.Account.setVisible(true);
				Sales.dispose();
			}
		});

		//dune
		btnDunePlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblDuneQuantity.getText());
                quantity++;
                lblDuneQuantity.setText(String.valueOf(quantity));
			}
		});

		btnDuneMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblDuneQuantity.getText());
                if (quantity > 1) {
                    quantity--;
                }
                lblDuneQuantity.setText(String.valueOf(quantity));
			}
		});

		btnDuneScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTable(101, lblDune.getText(), Integer.parseInt(lblDuneQuantity.getText()), Double.parseDouble(lblDunePrice.getText().replace("$", "")));
			}
		});
		
		//crime and punishment
		btnCrimeMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblCrimeQuantity.getText());
                if (quantity > 1) {
                    quantity--;
                }
                lblCrimeQuantity.setText(String.valueOf(quantity));
			}
		});

		btnCrimePlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblCrimeQuantity.getText());
                quantity++;
                lblCrimeQuantity.setText(String.valueOf(quantity));
			}
		});

		btnCrimeScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTable(202, lblCrime.getText(), Integer.parseInt(lblCrimeQuantity.getText()), Double.parseDouble(lblCrimePrice.getText().replace("$", "")));
			}
		});

		//the songs of achilles
		btnAchillesMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblAchillesQuantity.getText());
                if (quantity > 1) {
                    quantity--;
                }
                lblAchillesQuantity.setText(String.valueOf(quantity));
			}
		});
		
		btnAchillesPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblAchillesQuantity.getText());
                quantity++;
                lblAchillesQuantity.setText(String.valueOf(quantity));
			}
		});

		btnAchillesScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTable(303, lblAchilles.getText(), Integer.parseInt(lblAchillesQuantity.getText()), Double.parseDouble(lblAchillesPrice.getText().replace("$", "")));
			}
		});

		//meditations
		btnMeditationsMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblMeditationsQuantity.getText());
                if (quantity > 1) {
                    quantity--;
                }
                lblMeditationsQuantity.setText(String.valueOf(quantity));
			}
		});

		btnMeditationsPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblMeditationsQuantity.getText());
                quantity++;
                lblMeditationsQuantity.setText(String.valueOf(quantity));
			}
		});

		btnMeditationsScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTable(404, lblMeditations.getText(), Integer.parseInt(lblMeditationsQuantity.getText()), Double.parseDouble(lblMeditationsPrice.getText().replace("$", "")));
			}
		});

		//ego is the enemy
		btnEgoMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblEgoQuantity.getText());
                if (quantity > 1) {
                    quantity--;
                }
                lblEgoQuantity.setText(String.valueOf(quantity));
			}
		});

		btnEgoPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblEgoQuantity.getText());
                quantity++;
                lblEgoQuantity.setText(String.valueOf(quantity));
			}
		});

		btnEgoScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTable(505, lblEgo.getText(), Integer.parseInt(lblEgoQuantity.getText()), Double.parseDouble(lblEgoPrice.getText().replace("$", "")));
			}
		});

		//the mountain is you
		btnMountainMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblMountainQuantity.getText());
                if (quantity > 1) {
                    quantity--;
                }
                lblMountainQuantity.setText(String.valueOf(quantity));
			}
		});

		btnMountainPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblMountainQuantity.getText());
                quantity++;
                lblMountainQuantity.setText(String.valueOf(quantity));
			}
		});

		btnMountainScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTable(606, lblMountain.getText(), Integer.parseInt(lblMountainQuantity.getText()), Double.parseDouble(lblMountainPrice.getText().replace("$", "")));
			}
		});

		//the diary of a young girl
		btnDiaryMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblDiaryQuantity.getText());
                if (quantity > 1) {
                    quantity--;
                }
                lblDiaryQuantity.setText(String.valueOf(quantity));
			}
		});

		btnDiaryPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblDiaryQuantity.getText());
                quantity++;
                lblDiaryQuantity.setText(String.valueOf(quantity));
			}
		});

		btnDiaryScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTable(707, lblDiary.getText(), Integer.parseInt(lblDiaryQuantity.getText()), Double.parseDouble(lblDiaryPrice.getText().replace("$", "")));
			}
		});
	
		//noli me tangere
		btnNoliMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblNoliQuantity.getText());
                if (quantity > 1) {
                    quantity--;
                }
                lblNoliQuantity.setText(String.valueOf(quantity));
			}
		});

		btnNoliPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblNoliQuantity.getText());
                quantity++;
                lblNoliQuantity.setText(String.valueOf(quantity));
			}
		});

		btnNoliScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTable(808, lblNoli.getText(), Integer.parseInt(lblNoliQuantity.getText()), Double.parseDouble(lblNoliPrice.getText().replace("$", "")));
			}
		});

		//the first voyage around the world
		btnVoyageMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblVoyageQuantity.getText());
                if (quantity > 1) {
                    quantity--;
                }
                lblVoyageQuantity.setText(String.valueOf(quantity));
			}
		});

		btnVoyagePlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(lblVoyageQuantity.getText());
                quantity++;
                lblVoyageQuantity.setText(String.valueOf(quantity));
			}
		});

		btnVoyageScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTable(909, lblVoyage.getText(), Integer.parseInt(lblVoyageQuantity.getText()), Double.parseDouble(lblVoyagePrice.getText().replace("$", "")));
			}
		});
		
		//delete button
		 btnDelete.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 int selectedRow = tblPurchase.getSelectedRow();
				 if (selectedRow != -1) {
					 DefaultTableModel tableModel = (DefaultTableModel) tblPurchase.getModel();
					 tableModel.removeRow(selectedRow);
					 updateTotal();
				 } else {
					 JOptionPane.showMessageDialog(Sales, "Please select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
				 }
			 }
		 });
		 
		 //purchase button
		 btnPurchse.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if (textField.getText().trim().isEmpty()) {
		                JOptionPane.showMessageDialog(Sales, "Please enter cash amount", "Error", JOptionPane.ERROR_MESSAGE);
				 } else {
					 try {
						 double cash = Double.parseDouble(textField.getText().trim());
						 double total = Double.parseDouble(lblTotal.getText().replace("TOTAL: $", ""));

						 if (cash < total) {
		                        JOptionPane.showMessageDialog(Sales, "Insufficient cash", "Error", JOptionPane.ERROR_MESSAGE);
						 } else {
							 double balance = cash - total;
							 DecimalFormat df = new DecimalFormat("#.00");
							 lblBalance.setText("BALANCE: $" + df.format(balance));
							 JOptionPane.showMessageDialog(Sales, "Purchase successful", "Success", JOptionPane.INFORMATION_MESSAGE);
							 purchaseMade = true;
						 }
					 } catch (NumberFormatException ex) {
		                    JOptionPane.showMessageDialog(Sales, "Invalid cash amount", "Error", JOptionPane.ERROR_MESSAGE);
					 }
				 }
			 }
		 });
		 
		 //print button
		 btnPrint.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			     DefaultTableModel tableModel = (DefaultTableModel) tblPurchase.getModel();
				 if (!purchaseMade) {
					 JOptionPane.showMessageDialog(Sales, "No purchase has been made", "Error", JOptionPane.ERROR_MESSAGE);
				 }
				 else {
					 try {
						 txtaReceipt.setText("\t                 TurnPage \n");
						 txtaReceipt.setText(txtaReceipt.getText() + "\tKatapatan Homes, Banay-banay \n");
						 txtaReceipt.setText(txtaReceipt.getText() + "\t         Cabuyao City, Laguna \n");
						 txtaReceipt.setText(txtaReceipt.getText() + "\t            0912-350-8966 \n");
						 txtaReceipt.setText(txtaReceipt.getText() + "  --------------------------------------------------------------------------------  \n");
						 txtaReceipt.setText(txtaReceipt.getText() + String.format("   %-45s %5s %25s \n", "Item", "Quantity", "Price"));					 txtaReceipt.setText(txtaReceipt.getText() + "  --------------------------------------------------------------------------------  \n");
						 for (int i = 0; i < tblPurchase.getRowCount(); i++) {
							 String name = tableModel.getValueAt(i, 1).toString();
							 String quantity = tableModel.getValueAt(i, 2).toString();
							 String price = tableModel.getValueAt(i, 3).toString();
				             txtaReceipt.setText(txtaReceipt.getText() + "  " + name + "\t" + quantity + "\t" + price + "\n");
						 }
						 
						 txtaReceipt.setText(txtaReceipt.getText() + "  --------------------------------------------------------------------------------  \n");
						 txtaReceipt.setText(txtaReceipt.getText() + "SUB " + lblTotal.getText() + "\n");
						 txtaReceipt.setText(txtaReceipt.getText() + "CASH: " +textField.getText() + "\n");
						 txtaReceipt.setText(txtaReceipt.getText() + lblBalance.getText() + "\n");
					 } catch (Exception ex) {
						 ex.printStackTrace();
					 }
				 }
			 }
		 });
	}
}