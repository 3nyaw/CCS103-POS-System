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
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

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
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(0, 0, 275, 1061);
        Account.getContentPane().add(panel);
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
                Account.dispose();
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
                Account.dispose();
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
                Account.dispose();
            }
        });
        lblInventory.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblInventory.setBounds(20, 294, 245, 40);
        panel.add(lblInventory);
        
        JLabel lblAccount = new JLabel("   Account");
        lblAccount.setOpaque(true);
        lblAccount.setBackground(new Color(128, 128, 128));
        lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblAccount.setBounds(20, 345, 245, 40);
        panel.add(lblAccount);
        
        JPanel contentPane = new JPanel();
        contentPane.setBounds(311, 0, 1293, 859);
        Account.getContentPane().add(contentPane);
        contentPane.setLayout(null);
        
        JLabel Title = new JLabel("User Profile");
        Title.setFont(new Font("Tahoma", Font.BOLD, 34));
        Title.setBounds(10, 11, 211, 42);
        contentPane.add(Title);
        
        JLabel loginHistoryLabel = new JLabel("Login History:");
        loginHistoryLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        loginHistoryLabel.setBounds(507, 93, 150, 42);
        contentPane.add(loginHistoryLabel);
        
        JPanel pInfoPanel = new JPanel();
        pInfoPanel.setBounds(10, 93, 360, 515);
        contentPane.add(pInfoPanel);
        pInfoPanel.setLayout(null);
        
        JLabel personalInfo = new JLabel("Personal Information");
        personalInfo.setBounds(17, 5, 290, 33);
        personalInfo.setHorizontalAlignment(SwingConstants.LEFT);
        personalInfo.setFont(new Font("Tahoma", Font.BOLD, 27));
        pInfoPanel.add(personalInfo);
        
        JLabel name = new JLabel("Name: ");
        name.setBounds(17, 283, 65, 22);
        name.setHorizontalAlignment(SwingConstants.LEFT);
        name.setFont(new Font("Tahoma", Font.BOLD, 18));
        pInfoPanel.add(name);
        
        JLabel nameContent = new JLabel("Felipe Lakandule");
        nameContent.setBounds(92, 283, 130, 22);
        nameContent.setHorizontalAlignment(SwingConstants.LEFT);
        nameContent.setFont(new Font("Tahoma", Font.PLAIN, 18));
        pInfoPanel.add(nameContent);
        
        JLabel position = new JLabel("Position:");
        position.setBounds(17, 316, 79, 22);
        position.setHorizontalAlignment(SwingConstants.LEFT);
        position.setFont(new Font("Tahoma", Font.BOLD, 18));
        pInfoPanel.add(position);
        
        JLabel positionContent = new JLabel("Staff");
        positionContent.setHorizontalAlignment(SwingConstants.LEFT);
        positionContent.setFont(new Font("Tahoma", Font.PLAIN, 18));
        positionContent.setBounds(102, 316, 130, 22);
        pInfoPanel.add(positionContent);
        
        JLabel Sex = new JLabel("Sex:");
        Sex.setHorizontalAlignment(SwingConstants.LEFT);
        Sex.setFont(new Font("Tahoma", Font.BOLD, 18));
        Sex.setBounds(17, 349, 46, 22);
        pInfoPanel.add(Sex);
        
        JLabel Age = new JLabel("Age:");
        Age.setHorizontalAlignment(SwingConstants.LEFT);
        Age.setFont(new Font("Tahoma", Font.BOLD, 18));
        Age.setBounds(17, 382, 79, 22);
        pInfoPanel.add(Age);
        
        JLabel profileImage = new JLabel("");
        ImageIcon icon = new ImageIcon(Account.class.getResource("/Images/den.png"));
        Image image = icon.getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
        profileImage.setIcon(new ImageIcon(image));
        profileImage.setBounds(39, 49, 250, 223); 
        pInfoPanel.add(profileImage);
        
        JLabel Birthday = new JLabel("Birthday:");
        Birthday.setHorizontalAlignment(SwingConstants.LEFT);
        Birthday.setFont(new Font("Tahoma", Font.BOLD, 18));
        Birthday.setBounds(17, 412, 99, 22);
        pInfoPanel.add(Birthday);
        
        JLabel Contact = new JLabel("Contact:");
        Contact.setHorizontalAlignment(SwingConstants.LEFT);
        Contact.setFont(new Font("Tahoma", Font.BOLD, 18));
        Contact.setBounds(17, 445, 99, 22);
        pInfoPanel.add(Contact);
        
        JLabel sexContent = new JLabel("Yes");
        sexContent.setHorizontalAlignment(SwingConstants.LEFT);
        sexContent.setFont(new Font("Tahoma", Font.PLAIN, 18));
        sexContent.setBounds(63, 349, 130, 22);
        pInfoPanel.add(sexContent);
        
        JLabel ageContent = new JLabel("35");
        ageContent.setHorizontalAlignment(SwingConstants.LEFT);
        ageContent.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ageContent.setBounds(63, 382, 130, 22);
        pInfoPanel.add(ageContent);

        
        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnLogout.setBounds(1102, 795, 120, 30);
        contentPane.add(btnLogout);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(507, 146, 582, 199);
        contentPane.add(scrollPane);
        
        JTextArea loginHistoryArea = new JTextArea();
        scrollPane.setViewportView(loginHistoryArea);
        loginHistoryArea.setEditable(false);
        loginHistoryArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        loginHistoryArea.setText(readLoginHistory());

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
}
