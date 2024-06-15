
package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class ActivityLog {

    JFrame ActivityLog;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ActivityLog window = new ActivityLog();
                    window.ActivityLog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ActivityLog() {
        initialize();
    }

    private void initialize() {
        ActivityLog = new JFrame("Inventory | PageTurn");
        ActivityLog.setTitle("Activity Log | PageTurn");
        ActivityLog.setBounds(100, 100, 1940, 2000);
        ActivityLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ActivityLog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ActivityLog.getContentPane().setLayout(null);

        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(new Color(128, 128, 128));
        pnlHeader.setBounds(274, 0, 1650, 90);
        ActivityLog.getContentPane().add(pnlHeader);

        JPanel pnlMenu = new JPanel();
        pnlMenu.setBackground(new Color(192, 192, 192));
        pnlMenu.setBounds(0, 0, 275, 1061);
        ActivityLog.getContentPane().add(pnlMenu);
        pnlMenu.setLayout(null);

        JLabel lblTitle = new JLabel("PageTurn");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 48));
        lblTitle.setBounds(10, 5, 255, 89);
        pnlMenu.add(lblTitle);
        lblTitle.setBackground(new Color(255, 255, 255));

        JLabel lblPointOfSale = new JLabel("Point of Sale System");
        lblPointOfSale.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPointOfSale.setBounds(10, 82, 245, 40);
        pnlMenu.add(lblPointOfSale);

        JLabel lblDashboard = new JLabel("Dashboard");
        lblDashboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Dashboard dashboard = new Dashboard();
                dashboard.Dashboard.setVisible(true);
                ActivityLog.dispose();
            }
        });
        lblDashboard.setOpaque(true);
        lblDashboard.setBackground(new Color(192, 192, 192));
        lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblDashboard.setBounds(20, 192, 245, 40);
        pnlMenu.add(lblDashboard);

        JLabel lblSales = new JLabel("Sales");
        lblSales.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sales sales = new Sales();
                sales.Sales.setVisible(true);
                ActivityLog.dispose();
            }
        });
        lblSales.setOpaque(true);
        lblSales.setBackground(new Color(192, 192, 192));
        lblSales.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblSales.setBounds(20, 243, 245, 40);
        pnlMenu.add(lblSales);

        JLabel lblActLog = new JLabel("   Acitivity Log");
        lblActLog.setForeground(new Color(0, 0, 0));
        lblActLog.setOpaque(true);
        lblActLog.setBackground(new Color(128, 128, 128));
        lblActLog.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblActLog.setBounds(20, 294, 245, 40);
        pnlMenu.add(lblActLog);

        JLabel lblAccount = new JLabel("Account");
        lblAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Account account = new Account();
                account.Account.setVisible(true);
                ActivityLog.dispose();
            }
        });
        lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblAccount.setBounds(20, 345, 245, 40);
        pnlMenu.add(lblAccount);

        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(277, 87, 1647, 700);
        ActivityLog.getContentPane().add(contentPanel);
        contentPanel.setLayout(null);
        
        JLabel lblActivityLog = new JLabel("Activity Log");
        lblActivityLog.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblActivityLog.setBounds(10, 11, 347, 72);
        contentPanel.add(lblActivityLog);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 94, 1627, 595);
        contentPanel.add(scrollPane_1);
        
        JTextArea salesHistoryArea = new JTextArea();
        scrollPane_1.setViewportView(salesHistoryArea);
        salesHistoryArea.setEditable(false);
        salesHistoryArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        salesHistoryArea.setText(readEmail());
        
        JButton btnClearNotif = new JButton("Clear Activity Log");
        btnClearNotif.setBounds(1659, 798, 255, 52);
        ActivityLog.getContentPane().add(btnClearNotif);
        btnClearNotif.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnClearNotif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(ActivityLog, "Are you sure?", "Clear Email History", JOptionPane.YES_NO_OPTION); {
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