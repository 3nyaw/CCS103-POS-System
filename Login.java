package Frames;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Login {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setTitle("Page Turn | Login");
                    window.frame.setVisible(true);
                    window.frame.setResizable(false);
                    window.frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(30, 78, 76, 17);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 126, 76, 17);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().add(lblPassword);
		
		usernameField = new JTextField("Username");
		usernameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				usernameField.setText("");
			}
		});
		usernameField.setBounds(30, 95, 230, 20);
		usernameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.requestFocusInWindow();
			}
		});
		usernameField.setColumns(10);
		frame.getContentPane().add(usernameField);
		
		passwordField = new JPasswordField("Password");
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passwordField.setText("");
				passwordField.setEchoChar('*');

				
			}
		});
		passwordField.setEchoChar((char)0);
		passwordField.setBounds(30, 144, 230, 20);
		frame.getContentPane().add(passwordField);
		
		String user = "admin123";
		String pass = "secret123";
		
		JLabel lblPasswordReset = new JLabel("Reset password");
		lblPasswordReset.setBounds(183, 164, 77, 20);
		lblPasswordReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "Your request has been sent.", "Page Turn | Reset password", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lblPasswordReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPasswordReset.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().add(lblPasswordReset);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(309, 0, 325, 311);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBackground(new Color(0, 0, 0));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(10, 11, 305, 289);
		panel.add(lblIcon);
		lblIcon.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\POSSystem\\img\\logo.png"));
		
		JPanel pnlBorder = new JPanel();
		pnlBorder.setBorder(null);
		pnlBorder.setBounds(0, 0, 309, 311);
		frame.getContentPane().add(pnlBorder);
		pnlBorder.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(87, 207, 120, 37);
		pnlBorder.add(btnLogin);
		btnLogin.setForeground(SystemColor.textHighlightText);
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                boolean loginSuccess = username.equals(user) && password.equals(pass);

                if (loginSuccess) {
                    Dashboard dashboard = new Dashboard();
                    dashboard.Dashboard.setVisible(true);
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(frame, "Login successfully!", "Page Turn | Login", JOptionPane.INFORMATION_MESSAGE);
                    logLoginAttempt(username, true);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid input!", "Page Turn | Login", JOptionPane.INFORMATION_MESSAGE);
                }
                usernameField.setText("");
                passwordField.setText("");
            }
        });
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setSelected(true);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(0, 0, 309, 61);
		pnlBorder.add(lblLogin);
	}

    private void logLoginAttempt(String username, boolean success) {
        if (success) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("login_history.txt", true))) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                writer.write(dtf.format(now) + " - Username: " + username + " - Status: SUCCESS");
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}