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
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Inventory {

    JFrame Inventory;
    private JTable tblList;
    private DefaultTableModel tableModel;
    private JTextField txtSearchBar;
    private JButton btnRestock;
    private JButton btnEditPrice;

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

        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(new Color(128, 128, 128));
        pnlHeader.setBounds(274, 0, 1650, 90);
        Inventory.getContentPane().add(pnlHeader);

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
        contentPanel.setBounds(277, 4, 1647, 700);
        Inventory.getContentPane().add(contentPanel);
        contentPanel.setLayout(null);

        JPanel pnlTop = new JPanel();
        pnlTop.setBounds(10, 125, 1660, 30);
        contentPanel.add(pnlTop);
        pnlTop.setLayout(null);

        txtSearchBar = new JTextField();
        txtSearchBar.setBounds(85, 11, 200, 20);
        pnlTop.add(txtSearchBar);

        JLabel lblSearch = new JLabel("Search:");
        lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSearch.setBounds(10, 12, 90, 14);
        pnlTop.add(lblSearch);

        // Table
        String[] columnNames = {"Category", "Product", "Price ($)"};

        // Data for the JTable
        Object[][] initialData = {
                {"NOVEL", "Dune", 5.99},
                {"NOVEL", "Crime and Punishment", 13.99},
                {"NOVEL", "The Song of Achilles", 12.68},
                {"SELF-HELP/PHILOSOPHY", "Meditations", 9.99},
                {"SELF-HELP/PHILOSOPHY", "Ego is the Enemy", 14.39},
                {"SELF-HELP/PHILOSOPHY", "The Mountain is You", 17.99},
                {"HISTORY", "The Diary of a Girl", 7.19},
                {"HISTORY", "Noli me Tangere", 15.49},
                {"HISTORY", "The First Voyage", 47.26}
        };

        tableModel = new DefaultTableModel(initialData, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return column == 2; // Make the Price column editable
            }

            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) return Double.class;
                return super.getColumnClass(columnIndex);
            }
        };

        tblList = new JTable(tableModel);
        tblList.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tblList.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(tblList);
        scrollPane.setBounds(0, 166, 1300, 696);
        contentPanel.add(scrollPane);

        JLabel lblStock = new JLabel("Stocks");
        lblStock.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblStock.setBounds(1449, 173, 49, 14);
        contentPanel.add(lblStock);

        JLabel lblNovel1 = new JLabel("72");
        lblNovel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNovel1.setBounds(1310, 191, 49, 25);
        contentPanel.add(lblNovel1);

        JLabel lblNovel2 = new JLabel("41");
        lblNovel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNovel2.setBounds(1310, 224, 49, 25);
        contentPanel.add(lblNovel2);

        JLabel lblNovel3 = new JLabel("47");
        lblNovel3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNovel3.setBounds(1310, 252, 49, 25);
        contentPanel.add(lblNovel3);

        JLabel lblPhilo1 = new JLabel("52");
        lblPhilo1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPhilo1.setBounds(1310, 282, 49, 25);
        contentPanel.add(lblPhilo1);

        JLabel lblPhilo2 = new JLabel("31");
        lblPhilo2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPhilo2.setBounds(1310, 313, 49, 25);
        contentPanel.add(lblPhilo2);

        JLabel lblPhilo3 = new JLabel("41");
        lblPhilo3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPhilo3.setBounds(1310, 344, 49, 25);
        contentPanel.add(lblPhilo3);

        JLabel lblHis1 = new JLabel("39");
        lblHis1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblHis1.setBounds(1310, 374, 49, 25);
        contentPanel.add(lblHis1);

        JLabel lblHis2 = new JLabel("30");
        lblHis2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblHis2.setBounds(1310, 403, 49, 25);
        contentPanel.add(lblHis2);

        JLabel lblHis3 = new JLabel("67");
        lblHis3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblHis3.setBounds(1310, 433, 49, 25);
        contentPanel.add(lblHis3);

        JPanel pnlBottom = new JPanel();
        pnlBottom.setBounds(280, 711, 1660, 100);
        Inventory.getContentPane().add(pnlBottom);
        pnlBottom.setLayout(null);

        btnRestock = new JButton("Request Re-stock");
        btnRestock.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnRestock.setBounds(21, 11, 246, 62);
        btnRestock.setEnabled(false); // Initially disable the button
        pnlBottom.add(btnRestock);

        btnRestock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblList.getSelectedRow();
                if (selectedRow != -1) {
                    JOptionPane.showMessageDialog(Inventory, "Your request was sent to the supplier!\nExpect an e-mail for the next 24 hours");
                    btnRestock.setEnabled(false); // Disable the button after it's clicked
                }
            }
        });

        btnEditPrice = new JButton("Edit Price");
        btnEditPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnEditPrice.setBounds(290, 11, 150, 62);
        btnEditPrice.setEnabled(false); // Initially disable the button
        pnlBottom.add(btnEditPrice);

        btnEditPrice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblList.getSelectedRow();
                if (selectedRow != -1) {
                    // Prompt the user for a new price
                    String newPriceStr = JOptionPane.showInputDialog(Inventory, "Enter the new price:");
                    if (newPriceStr != null && !newPriceStr.isEmpty()) {
                        try {
                            double newPrice = Double.parseDouble(newPriceStr);
                            // Update the price in the table model
                            tableModel.setValueAt(newPrice, selectedRow, 2);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(Inventory, "Invalid price format! Please enter a valid number.");
                        }
                    }
                }
            }
        });

        tblList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tblList.getSelectedRow();
                    btnRestock.setEnabled(selectedRow != -1);
                    btnEditPrice.setEnabled(selectedRow != -1);
                }
            }
        });
    }
}

