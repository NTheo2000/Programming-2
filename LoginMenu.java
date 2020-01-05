package GUI_Classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import EvaluateCandidates.Employee;
import EvaluateCandidates.WorkersDatabase;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginMenu {

	protected JFrame frame;
	private final JLayeredPane panel = new JLayeredPane();
	private final JLayeredPane blockedpanel = new JLayeredPane();
	private JTextField usernameField;
	private JPasswordField passwordField;
	private Employee employee;
	private JLabel error;
	private JLabel blockmessage;
	private JLabel errorHeadline;
	private JLabel nullerror;
	private JLabel guiCorrection;
	private int count = 4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMenu window = new LoginMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginMenu() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}

	public LoginMenu(JFrame frame) {
		this.frame = frame;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel.setBackground(SystemColor.menu);
		panel.setForeground(SystemColor.menuText);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Welcome to HumanMasteR");
		lblNewLabel.setBounds(75, 11, 286, 36);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel username = new JLabel("Username");
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setForeground(Color.BLACK);
		username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		username.setBounds(112, 82, 78, 14);
		panel.add(username);
		
		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.LEFT);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.setBounds(201, 81, 104, 20);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel password = new JLabel("Password");
		password.setForeground(Color.BLACK);
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		password.setBounds(112, 147, 78, 14);
		panel.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 146, 104, 20);
		panel.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setForeground(Color.BLACK);
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginButton.setBounds(157, 202, 89, 23);
		panel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (error != null) panel.remove(error);
				if (nullerror != null) {
					nullerror.setText(null);
					panel.remove(nullerror);
					guiCorrection = new JLabel("                                                           ");
					guiCorrection.setBounds(70, 44, 320, 30);
					panel.add(guiCorrection);
				}
				if (usernameField.getText().isEmpty() || passwordField.getPassword().length == 0) {
					usernameField.setText(null);
					passwordField.setText(null);
					nullerror = new JLabel("You must type at least one caracter in every field.");
					nullerror.setBounds(70, 44, 320, 30);
					panel.add(nullerror);
					nullerror.setFont(new Font("Tahoma", Font.PLAIN, 14));
					nullerror.setForeground(Color.RED);
					nullerror.setHorizontalAlignment(SwingConstants.CENTER);
					return;
				}
				employee = WorkersDatabase.checkCredentials(usernameField.getText(), passwordField.getPassword());
				if (employee.getId() == null) {
					count--;
					if (count == 0) {
						panel.setVisible(false);
						
						blockedpanel.setBackground(SystemColor.menu);
						blockedpanel.setForeground(SystemColor.menuText);
						frame.getContentPane().add(blockedpanel, BorderLayout.CENTER);
						blockedpanel.setLayout(null);
						blockedpanel.setVisible(true);
						
						errorHeadline = new JLabel("You have exceeded all remaining attempts");
						blockedpanel.add(errorHeadline);
						errorHeadline.setBounds(20, 20, 400, 30);
						errorHeadline.setFont(new Font("Tahoma", Font.BOLD, 18));
						errorHeadline.setForeground(Color.BLACK);
						errorHeadline.setHorizontalAlignment(SwingConstants.CENTER);
							
						blockmessage = new JLabel("Your access has been blocked");
						blockedpanel.add(blockmessage);
						blockmessage.setBounds(50, 70, 330, 30);
						blockmessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
						blockmessage.setForeground(Color.RED);
						blockmessage.setHorizontalAlignment(SwingConstants.CENTER);
						return;
					}
					if (count == 1) {
						error = new JLabel("Login failed.You have " + count + " attempt remaining.");
					} else {
							error = new JLabel("Login failed.You have " + count + " attempts remaining.");
					}
					error.setBounds(90, 44, 270, 30);
					panel.add(error);
					error.setFont(new Font("Tahoma", Font.PLAIN, 14));
					error.setForeground(Color.RED);
					error.setHorizontalAlignment(SwingConstants.CENTER);
					usernameField.setText(null);
					passwordField.setText(null);
				} else {
					int dep_id = employee.getDepartmentId();
					String[] name = employee.getFull_name().split("\\s");
					switch (dep_id) {
					case 0 :
						panel.setVisible(false);
						new HRMenu(name[0], frame, employee);
						break;
					case 1 :
					case 2 :
					case 3 :
					case 4 :
						panel.setVisible(false);
						new DirectorMenu(name[0]);
						break;
					case 5 :
					case 6 :
					case 7 :
					case 8 :
						panel.setVisible(false);
						new EmployeeMenu(name[0]);
						break;
					}
				}
			}
		});
	}
	public JButton setBackButton(JPanel headlinePanel) {
		JButton backButton = new JButton("Back");
		backButton.setIconTextGap(6);
		backButton.setHorizontalAlignment(SwingConstants.LEFT);
		backButton.setIcon(new ImageIcon(Settings.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/backspace-icon.png")));
		backButton.setPreferredSize(new Dimension(100, 23));
		headlinePanel.add(backButton, BorderLayout.WEST);
		return backButton;
	}
}
