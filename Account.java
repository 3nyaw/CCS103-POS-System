package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Account {

    JFrame Account;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Account window = new Account();
                    window.Account.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Account() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        Account = new JFrame("Account | PageTurn");
        Account.setBounds(100, 100, 1940, 2000);
        Account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Account.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Account.getContentPane().setLayout(null);
        
        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(Color.GRAY);
        pnlHeader.setBounds(274, 0, 1650, 90);
        Account.getContentPane().add(pnlHeader);
        
        JPanel pnlMenu = new JPanel();
        pnlMenu.setBackground(new Color(192, 192, 192));
        pnlMenu.setBounds(0, 0, 275, 1061);
        Account.getContentPane().add(pnlMenu);
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
                Account.dispose();
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
                Account.dispose();
            }
        });
        lblSales.setOpaque(true);
        lblSales.setBackground(new Color(192, 192, 192));
        lblSales.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblSales.setBounds(20, 243, 245, 40);
        pnlMenu.add(lblSales);
        
        JLabel lblActLog = new JLabel("Activity Log");
        lblActLog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ActivityLog actlog = new ActivityLog();
                actlog.ActivityLog.setVisible(true);
                Account.dispose();
            }
        });
        lblActLog.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblActLog.setBounds(20, 294, 245, 40);
        pnlMenu.add(lblActLog);
        
        JLabel lblAccount = new JLabel("   Account");
        lblAccount.setForeground(new Color(0, 0, 0));
        lblAccount.setOpaque(true);
        lblAccount.setBackground(new Color(128, 128, 128));
        lblAccount.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblAccount.setBounds(20, 345, 245, 40);
        pnlMenu.add(lblAccount);
        
        JPanel contentPane = new JPanel();
        contentPane.setBounds(274, 90, 1650, 971);
        Account.getContentPane().add(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblUserProfile = new JLabel("User Profile");
        lblUserProfile.setFont(new Font("Tahoma", Font.BOLD, 34));
        lblUserProfile.setBounds(10, 11, 211, 42);
        contentPane.add(lblUserProfile);
        
        JPanel pInfoPanel = new JPanel();
        pInfoPanel.setBackground(new Color(192, 192, 192));
        pInfoPanel.setBounds(99, 93, 1450, 408);
        contentPane.add(pInfoPanel);
        pInfoPanel.setLayout(null);
        
        JLabel lblPersonalInfo = new JLabel("Personal Information");
        lblPersonalInfo.setBounds(10, 0, 290, 33);
        lblPersonalInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblPersonalInfo.setFont(new Font("Tahoma", Font.BOLD, 27));
        pInfoPanel.add(lblPersonalInfo);
        
        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(621, 55, 108, 37);
        lblName.setHorizontalAlignment(SwingConstants.LEFT);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 30));
        pInfoPanel.add(lblName);
        
        JLabel lblNameContent = new JLabel("Den Lawrence Uniforme");
        lblNameContent.setBounds(775, 55, 320, 37);
        lblNameContent.setHorizontalAlignment(SwingConstants.LEFT);
        lblNameContent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        pInfoPanel.add(lblNameContent);
        
        JLabel lblPosition = new JLabel("Position:");
        lblPosition.setBounds(621, 103, 133, 37);
        lblPosition.setHorizontalAlignment(SwingConstants.LEFT);
        lblPosition.setFont(new Font("Tahoma", Font.BOLD, 30));
        pInfoPanel.add(lblPosition);
        
        JLabel lblPositionContent = new JLabel("Staff");
        lblPositionContent.setHorizontalAlignment(SwingConstants.LEFT);
        lblPositionContent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblPositionContent.setBounds(775, 103, 63, 37);
        pInfoPanel.add(lblPositionContent);
        
        JLabel lblSex = new JLabel("Sex:");
        lblSex.setHorizontalAlignment(SwingConstants.LEFT);
        lblSex.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblSex.setBounds(621, 151, 66, 37);
        pInfoPanel.add(lblSex);
        
        JLabel lblAge = new JLabel("Age:");
        lblAge.setHorizontalAlignment(SwingConstants.LEFT);
        lblAge.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblAge.setBounds(621, 199, 69, 37);
        pInfoPanel.add(lblAge);
        
        JLabel profileImage = new JLabel("");
        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\den.png");
        Image image = icon.getImage().getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH);
        profileImage.setIcon(new ImageIcon(image));        
        profileImage.setBounds(80, 57, 340, 275); 
        pInfoPanel.add(profileImage);
        
        JLabel lblBirthday = new JLabel("Birthday:");
        lblBirthday.setHorizontalAlignment(SwingConstants.LEFT);
        lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblBirthday.setBounds(621, 247, 139, 37);
        pInfoPanel.add(lblBirthday);
        
        JLabel lblContact = new JLabel("Contact:");
        lblContact.setHorizontalAlignment(SwingConstants.LEFT);
        lblContact.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblContact.setBounds(621, 295, 127, 37);
        pInfoPanel.add(lblContact);
        
        JLabel lblSexContent = new JLabel("Male");
        lblSexContent.setHorizontalAlignment(SwingConstants.LEFT);
        lblSexContent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblSexContent.setBounds(776, 151, 62, 37);
        pInfoPanel.add(lblSexContent);
        
        JLabel lblAgeContent = new JLabel("18");
        lblAgeContent.setHorizontalAlignment(SwingConstants.LEFT);
        lblAgeContent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblAgeContent.setBounds(775, 199, 32, 37);
        pInfoPanel.add(lblAgeContent);
        
        JLabel lblBirthdayContent = new JLabel("September 7, 2003");
        lblBirthdayContent.setHorizontalAlignment(SwingConstants.LEFT);
        lblBirthdayContent.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblBirthdayContent.setBounds(775, 247, 304, 37);
        pInfoPanel.add(lblBirthdayContent);
        
        JLabel lblBirthdayContent_1 = new JLabel("+63 932 475 8972");
        lblBirthdayContent_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblBirthdayContent_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblBirthdayContent_1.setBounds(775, 295, 241, 37);
        pInfoPanel.add(lblBirthdayContent_1);
        
        JLabel lblLoginHistory = new JLabel("Login History:");
        lblLoginHistory.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblLoginHistory.setBounds(180, 540, 150, 42);
        contentPane.add(lblLoginHistory);
        
        JScrollPane spLoginHistory = new JScrollPane();
        spLoginHistory.setBounds(180, 596, 582, 199);
        contentPane.add(spLoginHistory);
        
        JTextArea loginHistoryArea = new JTextArea();
        spLoginHistory.setViewportView(loginHistoryArea);
        loginHistoryArea.setEditable(false);
        loginHistoryArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        loginHistoryArea.setText(readLoginHistory());
        
        JButton btnClearLoginHistory = new JButton("Clear Login History");
        btnClearLoginHistory.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnClearLoginHistory.setBounds(598, 806, 164, 30);
        contentPane.add(btnClearLoginHistory);
        btnClearLoginHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(Account, "Are you sure?", "Clear Login History", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    clearFileContent("login_history.txt");
                    loginHistoryArea.setText("");
                    sendEmail("Login", true);
                }
            }
        });
        
        JLabel lblSalesHistory = new JLabel("Sales History:");
        lblSalesHistory.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSalesHistory.setBounds(840, 540, 150, 42);
        contentPane.add(lblSalesHistory);
        

        
        JScrollPane spSalesHisotry = new JScrollPane();
        spSalesHisotry.setBounds(840, 596, 582, 199);
        contentPane.add(spSalesHisotry);
        
        JTextArea salesHistoryArea = new JTextArea();
        spSalesHisotry.setViewportView(salesHistoryArea);
        salesHistoryArea.setEditable(false);
        salesHistoryArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        salesHistoryArea.setText(readSalesHistory());
        
        JButton btnClearSalesHistory = new JButton("Clear Sales History");
        btnClearSalesHistory.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnClearSalesHistory.setBounds(1258, 806, 164, 30); 
        contentPane.add(btnClearSalesHistory);
        btnClearSalesHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(Account, "Are you sure?", "Clear Sales History", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    clearFileContent("sales.txt");
                    salesHistoryArea.setText("");
                    sendEmail("Sales", true);
                }
            }
        });
        
                
        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnLogout.setBounds(1460, 848, 175, 55);
        contentPane.add(btnLogout);
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int response = JOptionPane.showConfirmDialog(Account, "Are you sure you want to logout?", "Logout Confirmation",
        				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        		if (response == JOptionPane.YES_OPTION) {
        			Login.main(null);
        			Account.dispose();
        		}
        	}
        });
	}
    
    

    private String readLoginHistory() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("login_history.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading login history.";
        }
        return content.toString();
    }

	private String readSalesHistory() {
	    StringBuilder content = new StringBuilder();
	    try (BufferedReader reader = new BufferedReader(new FileReader("sales.txt"))) {
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
	
	private void clearFileContent(String fileName) {
	    try (PrintWriter writer = new PrintWriter(fileName)) {
	        writer.print("");
	    } catch (FileNotFoundException ex) {
	        ex.printStackTrace();
	    }
	}
	private void sendEmail(String choice, boolean success) {
        if (success) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("email.txt", true))) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                writer.write(dtf.format(now) + " " + choice + " History has been cleared.");
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}