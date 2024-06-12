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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import javax.swing.SwingConstants;

public class Dashboard {

    JFrame Dashboard;
    private JTable tblSales;
    private JPanel barChartPlaceholder; // Placeholder for the bar chart panel

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
        pnlComponents.setBounds(340, 116, 935, 246);
        Dashboard.getContentPane().add(pnlComponents);
        pnlComponents.setLayout(null);
        
        JLabel lblRevenue = new JLabel("Total Revenue");
        lblRevenue.setBounds(343, 2, 250, 35);
        pnlComponents.add(lblRevenue);
        lblRevenue.setFont(new Font("Tahoma", Font.PLAIN, 24));
        
        JLabel lblNewLabel = new JLabel("1000");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setBounds(342, 52, 250, 160);
        pnlComponents.add(lblNewLabel);
        
        JLabel lblCustomer = new JLabel("1000");
        lblCustomer.setOpaque(true);
        lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
        lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 36));
        lblCustomer.setBackground(Color.WHITE);
        lblCustomer.setBounds(684, 52, 250, 160);
        pnlComponents.add(lblCustomer);
        
        JLabel lblTotalCustomer = new JLabel("Number of Customers");
        lblTotalCustomer.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblTotalCustomer.setBounds(685, 2, 250, 35);
        pnlComponents.add(lblTotalCustomer);
        
        JLabel lblBooksSold = new JLabel("1000");
        lblBooksSold.setOpaque(true);
        lblBooksSold.setHorizontalAlignment(SwingConstants.CENTER);
        lblBooksSold.setFont(new Font("Tahoma", Font.BOLD, 36));
        lblBooksSold.setBackground(Color.WHITE);
        lblBooksSold.setBounds(0, 52, 250, 160);
        pnlComponents.add(lblBooksSold);
        
        JLabel lblSoldBooks = new JLabel("Sold Books");
        lblSoldBooks.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblSoldBooks.setBounds(1, 2, 250, 35);
        pnlComponents.add(lblSoldBooks);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(340, 459, 935, 435);
        Dashboard.getContentPane().add(scrollPane);

        tblSales = new JTable();
        scrollPane.setViewportView(tblSales);
        tblSales.setRowHeight(30);
        tblSales.setModel(new DefaultTableModel(
            new Object[][] {
                {"BOM", "BOM", "BOM", "BOM", "BOM", "BOM"},
                {"BOM", "BOM", "BOM", "BOM", "BOM", "BOM"},
                {"BOM", "BOM", "BOM", "BOM", "BOM", "BOM"},
                {"BOM", "BOM", "BOM", "BOM", "BOM", "BOM"},
                {"BOM", "BOM", "BOM", "BOM", "BOM", "BOM"},
                {"BOM", "BOM", "BOM", "BOM", "BOM", "BOM"},
                {"BOM", "BOM", "BOM", "BOM", "BOM", "BOM"},
                {"BOM", "BOM", "BOM", "BOM", "BOM", "BOM"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
            },
            new String[] {
                "Book ID", "Book Title", "Genre", "Quantity Sold", "Price Per Unit", "Total Sales"
            }
        ));

        JLabel salesLbl = new JLabel("Sales Overview");
        salesLbl.setHorizontalAlignment(SwingConstants.CENTER);
        salesLbl.setFont(new Font("Tahoma", Font.PLAIN, 24));
        salesLbl.setBounds(340, 416, 935, 35);
        Dashboard.getContentPane().add(salesLbl);

        JPanel pieChartPanel = createPieChartPanel();
        pieChartPanel.setBounds(1338, 116, 524, 353);
        Dashboard.getContentPane().add(pieChartPanel);
        
        barChartPlaceholder = new JPanel();  // Initialize the placeholder
        barChartPlaceholder.setBounds(1338, 500, 524, 394);
        Dashboard.getContentPane().add(barChartPlaceholder);
        
        JPanel barChartPanel = createBarChartPanel();
        barChartPlaceholder.setLayout(new java.awt.BorderLayout());
        barChartPlaceholder.add(barChartPanel, BorderLayout.CENTER);
        
        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(new Color(128, 128, 128));
        pnlHeader.setBounds(275, -1, 1650, 90);
        Dashboard.getContentPane().add(pnlHeader);
        barChartPlaceholder.validate();
    }

    private JPanel createPieChartPanel() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Crime and Punishment", 20);
        dataset.setValue("The Songs of Achilles", 15);
        dataset.setValue("Dune", 30);
        dataset.setValue("Ego is the Enemy", 25);
        dataset.setValue("Meditations", 10);
        dataset.setValue("The Mountain is You", 18);
        dataset.setValue("The Diary of a Girl", 12);
        dataset.setValue("Noli me Tangere", 10);
        dataset.setValue("The First Voyage Around the World", 5);

        JFreeChart chart = ChartFactory.createPieChart(
                "Books Sales Distribution", dataset, true, true, false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Crime and Punishment", Color.RED);
        plot.setSectionPaint("The Songs of Achilles", Color.BLUE);
        plot.setSectionPaint("Dune", Color.GREEN);
        plot.setSectionPaint("Ego is the Enemy", Color.YELLOW);
        plot.setSectionPaint("Meditations", Color.ORANGE);
        plot.setSectionPaint("The Mountain is You", Color.PINK);
        plot.setSectionPaint("The Diary of a Girl", Color.MAGENTA);
        plot.setSectionPaint("Noli me Tangere", Color.CYAN);
        plot.setSectionPaint("The First Voyage Around the World", Color.GRAY);
        plot.setSimpleLabels(true);

        return new ChartPanel(chart);
    }

    private JPanel createBarChartPanel() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Book> topBooks = getTopSellingBooks();
        for (Book book : topBooks) {
            dataset.addValue(book.getQuantitySold(), "Books", book.getTitle());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Top 3 Best Selling Books",
                "Book Title",
                "Quantity Sold",
                dataset);

        return new ChartPanel(barChart);
    }

    private List<Book> getTopSellingBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Dune", 500));
        books.add(new Book("The Songs of Achilles", 300));
        books.add(new Book("Crime and Punishment", 200));
        return books;
    }

    class Book {
        private String title;
        private int quantitySold;

        public Book(String title, int quantitySold) {
            this.title = title;
            this.quantitySold = quantitySold;
        }

        public String getTitle() {
            return title;
        }

        public int getQuantitySold() {
            return quantitySold;
        }
    }
}