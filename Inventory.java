package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inventory {

    JFrame Inventory;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField searchBar;
    private JTextField addCategoryField, addProductField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Inventory window = new Inventory();
                    window.Inventory.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Inventory() {
        initialize();
    }

    private void initialize() {
        Inventory = new JFrame("Inventory | PageTurn");
        Inventory.setBounds(100, 100, 1940, 2000);
        Inventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Inventory.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Inventory.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(0, 0, 275, 1061);
        Inventory.getContentPane().add(panel);
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
                Inventory.dispose();
            }
        });
        lblDashboard.setOpaque(true);
        lblDashboard.setBackground(new Color(192, 192, 192));
        lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblDashboard.setBounds(20, 192, 245, 40);
        panel.add(lblDashboard);

        JLabel lblSales = new JLabel("Sales");
        lblSales.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sales sales = new Sales();
                sales.Sales.setVisible(true);
                Inventory.dispose();
            }
        });
        lblSales.setOpaque(true);
        lblSales.setBackground(new Color(192, 192, 192));
        lblSales.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblSales.setBounds(20, 243, 245, 40);
        panel.add(lblSales);

        JLabel lblInventory = new JLabel("   Inventory");
        lblInventory.setForeground(new Color(0, 0, 0));
        lblInventory.setOpaque(true);
        lblInventory.setBackground(new Color(128, 128, 128));
        lblInventory.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblInventory.setBounds(20, 294, 245, 40);
        panel.add(lblInventory);

        JLabel lblAccount = new JLabel("Account");
        lblAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Account account = new Account();
                account.Account.setVisible(true);
                Inventory.dispose();
            }
        });
        lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblAccount.setBounds(20, 345, 245, 40);
        panel.add(lblAccount);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(280, 0, 1660, 1061);
        Inventory.getContentPane().add(contentPanel);
        contentPanel.setLayout(null);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 1660, 30);
        contentPanel.add(topPanel);
        topPanel.setLayout(null);
        
        searchBar = new JTextField();
        searchBar.setBounds(60, 5, 200, 20);
        topPanel.add(new JLabel("Search:")).setBounds(10, 5, 50, 20);
        topPanel.add(searchBar);

        // Table
        String[] columnNames = {"Category", "Product", "Price", "Stock"};
        Object[][] initialData = {
                {"NOVEL", "Crime and Punishment", 0.0, 0},
                {"NOVEL", "The Songs of Achilles", 0.0, 0},
                {"NOVEL", "Dune", 0.0, 0},
                {"SELF-HELP/PHILOSOPHY", "Ego is the Enemy", 0.0, 0},
                {"SELF-HELP/PHILOSOPHY", "Meditations", 0.0, 0},
                {"SELF-HELP/PHILOSOPHY", "The Mountain is You", 0.0, 0},
                {"HISTORY", "The Diary of a Girl", 0.0, 0},
                {"HISTORY", "Noli me Tangere", 0.0, 0},
                {"HISTORY", "The First Voyage", 0.0, 0}
        };

        tableModel = new DefaultTableModel(initialData, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return column == 2 || column == 3;
            }

            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) return Double.class;
                if (columnIndex == 3) return Integer.class;
                return super.getColumnClass(columnIndex);
            }
        };

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 30, 1660, 500);
        contentPanel.add(scrollPane);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 530, 1660, 100);
        contentPanel.add(bottomPanel);
        bottomPanel.setLayout(null);

        addCategoryField = new JTextField();
        addCategoryField.setBounds(100, 10, 150, 20);
        bottomPanel.add(new JLabel("Category:")).setBounds(30, 10, 70, 20);
        bottomPanel.add(addCategoryField);

        addProductField = new JTextField();
        addProductField.setBounds(400, 10, 150, 20);
        bottomPanel.add(new JLabel("Product:")).setBounds(330, 10, 70, 20);
        bottomPanel.add(addProductField);

        JButton addButton = new JButton("Add Item");
        addButton.setBounds(600, 10, 150, 30);
        bottomPanel.add(addButton);

        JButton removeButton = new JButton("Remove Product");
        removeButton.setBounds(800, 10, 150, 30);
        bottomPanel.add(removeButton);

        JButton requestRestockButton = new JButton("Request Re-stock");
        requestRestockButton.setBounds(1000, 10, 150, 30);
        bottomPanel.add(requestRestockButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            }
        });
    }
}
