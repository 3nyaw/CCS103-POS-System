package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 400, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(158, 11, 55, 23);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(30, 61, 76, 20);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(30, 105, 76, 20);
		frame.getContentPane().add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.requestFocusInWindow();
			}
		});
		usernameField.setColumns(10);
		usernameField.setBounds(131, 63, 209, 20);
		frame.getContentPane().add(usernameField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 107, 209, 20);
		frame.getContentPane().add(passwordField);
		
		String user = "1234";
		String pass = "1234";
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
			       if (username.equals(user) && password.equals(pass)) {
						Dashboard dashboard = new Dashboard();
						dashboard.Dashboard.setVisible(true);
	                	frame.setVisible(false);
	                	JOptionPane.showMessageDialog(frame, "Login successfully!", "Page Turn | Login", JOptionPane.INFORMATION_MESSAGE);

	                } else {
	                	JOptionPane.showMessageDialog(frame, "Invalid input!", "Page Turn | Login", JOptionPane.INFORMATION_MESSAGE );
	                }
	                usernameField.setText("");
	                passwordField.setText("");
				}
			});
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setSelected(true);
		btnLogin.setBounds(148, 173, 76, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblPasswordReset = new JLabel("Reset password");
		lblPasswordReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "Your request has been sent.", "Page Turn | Reset password", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lblPasswordReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPasswordReset.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPasswordReset.setBounds(263, 134, 77, 20);
		frame.getContentPane().add(lblPasswordReset);
	}
}