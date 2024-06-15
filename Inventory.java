
package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Inventory {

    JFrame Inventory;
    private DefaultTableModel tableModel;

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

        JLabel lblEmail = new JLabel("   Email");
        lblEmail.setForeground(new Color(0, 0, 0));
        lblEmail.setOpaque(true);
        lblEmail.setBackground(new Color(128, 128, 128));
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblEmail.setBounds(20, 294, 245, 40);
        panel.add(lblEmail);

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
        contentPanel.setBounds(277, 87, 1647, 700);
        Inventory.getContentPane().add(contentPanel);
        contentPanel.setLayout(null);
        
        JLabel lblEmailTitle = new JLabel("Email");
        lblEmailTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblEmailTitle.setBounds(10, 11, 347, 72);
        contentPanel.add(lblEmailTitle);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 94, 1627, 595);
        contentPanel.add(scrollPane_1);
        
        JTextArea salesHistoryArea = new JTextArea();
        scrollPane_1.setViewportView(salesHistoryArea);
        salesHistoryArea.setEditable(false);
        salesHistoryArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        salesHistoryArea.setText(readEmail());
        
        JButton btnClearEmail = new JButton("Clear Email");
        btnClearEmail.setBounds(1659, 798, 255, 52);
        Inventory.getContentPane().add(btnClearEmail);
        btnClearEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnClearEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(Inventory, "Are you sure?", "Clear Email History", JOptionPane.YES_NO_OPTION); {
                    clearFileContent("email.txt");
                    salesHistoryArea.setText("");
                }
            }
        });

      
    }

    
    private String readEmail() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("email.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return content.toString();
    }

private boolean clearFileContent(String fileName) {
    try (PrintWriter writer = new PrintWriter(fileName)) {
        writer.print("");
        return true;
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
        return false;
    	}
	}
}
