package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Dashboard {

    JFrame Dashboard;
    private JLabel lblBooksSold;
    private JLabel lblTotalRevenue;
    private JLabel lblCustomer;
    private JButton btnRefresh;
    private JTable table;
    
    private DefaultTableModel recentTransactionsTableModel;
    private JTable tblReference;
    
 

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
        lblDashboard.setOpaque(true);
        lblDashboard.setBackground(new Color(128, 128, 128));
        lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 24));
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
        
        JPanel pnlComponents = new JPanel();
        pnlComponents.setBounds(339, 148, 935, 252);
        Dashboard.getContentPane().add(pnlComponents);
        pnlComponents.setLayout(null);
        
        JLabel lblRevenue = new JLabel("Total Revenue");
        lblRevenue.setBounds(343, 2, 250, 35);
        pnlComponents.add(lblRevenue);
        lblRevenue.setFont(new Font("Tahoma", Font.PLAIN, 24));
        
        lblTotalRevenue = new JLabel("");
        lblTotalRevenue.setOpaque(true);
        lblTotalRevenue.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTotalRevenue.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotalRevenue.setBackground(new Color(255, 255, 255));
        lblTotalRevenue.setBounds(342, 52, 250, 190);
        pnlComponents.add(lblTotalRevenue);
        
        lblCustomer = new JLabel("");
        lblCustomer.setOpaque(true);
        lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
        lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCustomer.setBackground(Color.WHITE);
        lblCustomer.setBounds(684, 52, 250, 190);
        pnlComponents.add(lblCustomer);
        
        JLabel lblTotalCustomer = new JLabel("Number of Customers");
        lblTotalCustomer.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblTotalCustomer.setBounds(685, 2, 250, 35);
        pnlComponents.add(lblTotalCustomer);
        
        lblBooksSold = new JLabel("");
        lblBooksSold.setOpaque(true);
        lblBooksSold.setHorizontalAlignment(SwingConstants.CENTER);
        lblBooksSold.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBooksSold.setBackground(Color.WHITE);
        lblBooksSold.setBounds(0, 52, 250, 190);
        pnlComponents.add(lblBooksSold);
        
        JLabel lblSoldBooks = new JLabel("Sold Books");
        lblSoldBooks.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblSoldBooks.setBounds(1, 2, 250, 35);
        pnlComponents.add(lblSoldBooks);
        
    
        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(new Color(128, 128, 128));
        pnlHeader.setBounds(275, -1, 1650, 90);
        Dashboard.getContentPane().add(pnlHeader);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                        updateDashboard();
        	}
        });
        
        
        btnUpdate.setBounds(953, 439, 246, 44);
        Dashboard.getContentPane().add(btnUpdate);
        
        JPanel barChartPanel = new JPanel();
        barChartPanel.setBounds(339, 527, 935, 436);
        Dashboard.getContentPane().add(barChartPanel);
        
        ChartPanel chartPanel = (ChartPanel) createBarChartPanel();
        barChartPanel.add(chartPanel);
        
        JPanel pnlRecentTransaction = new JPanel();
        pnlRecentTransaction.setBounds(1386, 192, 480, 252);
        Dashboard.getContentPane().add(pnlRecentTransaction);
        pnlRecentTransaction.setLayout(new BorderLayout());
        
        JScrollPane scrollPane = new JScrollPane();
        pnlRecentTransaction.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        recentTransactionsTableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Book Id","Quantity", "Total Amount"}
        );
        table.setModel(recentTransactionsTableModel);
        
        JLabel lblRecent = new JLabel("Recent Transaction");
        lblRecent.setHorizontalAlignment(SwingConstants.CENTER);
        lblRecent.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblRecent.setBounds(1386, 148, 480, 35);
        Dashboard.getContentPane().add(lblRecent);
        
        JScrollPane scrollPaneRef = new JScrollPane();
        scrollPaneRef.setBounds(1386, 585, 480, 280);
        Dashboard.getContentPane().add(scrollPaneRef);
        
        tblReference = new JTable();
        scrollPaneRef.setViewportView(tblReference);
        tblReference.setRowHeight(30);
        tblReference.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"101","Frank Herbert", "Dune"},
        		{"202","Fyodor Dostoevsky", "Crime And Punishment"},
        		{"303","Madelline Miller", "The Song Of Achilles"},
        		{"404","Marcus Aurelius", "Meditions"},
        		{"505","Ryan Holiday", "Ego Is The Enemy"},
        		{"606","Brianna West", "The Mountain Is You"},
        		{"707","Anne Frank", "Diary Of A Young Girl"},
        		{"808","Jose Rizal", "Noli Me Tangere"},
        		{"909","Antonio Pigafetta", "The First Voyage"},
        	},
        	new String[] {
        		"Book Id", "Author", "Book Title"
        	}
        ));
        
        JLabel lblReferences = new JLabel("Book Details");
        lblReferences.setHorizontalAlignment(SwingConstants.CENTER);
        lblReferences.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblReferences.setBounds(1386, 545, 480, 35);
        Dashboard.getContentPane().add(lblReferences);
    }
    
    public void updateDashboard() {
   
    	 lblBooksSold.setText("Sold Books: " + SharedData.getSoldBooks());
    	 lblTotalRevenue.setText("Total Revenue: $" + SharedData.getTotalRevenue());
    	 lblCustomer.setText("Number of Customers: " + SharedData.getTotalCustomers());
    	 
    	 updateRecentTransactionsTable();
    }

    public static class SharedData {
        private static int soldBooks = 0;
        private static double totalRevenue = 0.0;
        private static int totalCustomers = 0;
        private static List<Transaction> recentTransactions = new ArrayList<>();
        
        public static int getSoldBooks() {
            return soldBooks;
        }

        public static void setSoldBooks(int soldBooks) {
            SharedData.soldBooks = soldBooks;
        }

        public static double getTotalRevenue() {
            return totalRevenue;
        }
        
        public static int getTotalCustomers() {
            return totalCustomers;
        }

        public static void setTotalRevenue(double totalRevenue) {
            SharedData.totalRevenue = totalRevenue;
        }

        public static void addBook(int quantity, double price, String bookName) {
            soldBooks += quantity;
            totalRevenue += (quantity * price);
            totalCustomers++;

            double totalAmount = quantity * price;
            recentTransactions.add(new Transaction(quantity, totalAmount, bookName));

            if (recentTransactions.size() > 10) {
                recentTransactions.remove(0);
            }
        }
        
        public static List<Transaction>getRecentTransactions(){
        	return recentTransactions;
        }
        
        public static class Transaction {
            private int quantity;
            private double totalAmount;
            private String bookName;
            
            public Transaction(int quantity, double totalAmount, String bookName) {
                this.quantity = quantity;
                this.totalAmount = totalAmount;
                this.bookName = bookName;
            }
            
            public int getQuantity() {
                return quantity;
            }
            
            public double getTotalAmount() {
                return totalAmount;
            }
            
            public String getBookName() {
                return bookName;
            }
        }
    }
    
    private void updateRecentTransactionsTable() {
        recentTransactionsTableModel.setRowCount(0);

        for (SharedData.Transaction transaction : SharedData.getRecentTransactions()) {
            Object[] row = {transaction.getBookName(), transaction.getQuantity(), transaction.getTotalAmount()};
            recentTransactionsTableModel.addRow(row);
        }
    }

    
    private ChartPanel createBarChartPanel() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

 
        dataset.addValue(500, "Sales Target", "Monday");
        dataset.addValue(600, "Sales Target", "Tuesday");
        dataset.addValue(700, "Sales Target", "Wednesday");
        dataset.addValue(800, "Sales Target", "Thursday");
        dataset.addValue(900, "Sales Target", "Friday");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Weekly Sales Target",
                "Day of the Week",
                "Sales Target",
                dataset);

        return new ChartPanel(barChart);
    }
}
