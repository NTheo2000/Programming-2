package GUI_Classes;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import evaluateCandidates.Employee;
import evaluateCandidates.WorkersDatabase;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;

public class Settings extends LoginMenu{

	private JFrame frame;
	private String firstname;
	private Employee employee;
	private JLayeredPane settingsPane;
	private JLabel errorLabel;
	private String[] dep;
	/**
	 * Create the application.
	 */
	public Settings(String name, JFrame frame, Employee employee) {
		this.frame = frame;
		this.firstname = name;
		this.employee = employee;
		this.dep = employee.getDepartment().split("\\s");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame.setVisible(true);
		
		settingsPane = new JLayeredPane();
		frame.getContentPane().add(settingsPane, BorderLayout.CENTER);
		settingsPane.setLayout(new BorderLayout(0, 0));
		settingsPane.setVisible(true);
		
		JPanel headlinePanel = new JPanel();
		settingsPane.add(headlinePanel, BorderLayout.NORTH);
		headlinePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		headlinePanel.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut_5 = Box.createVerticalStrut(28);
		topPanel.add(verticalStrut_5);
		
		JLabel lblNewLabel = new JLabel("Settings");
		headlinePanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton backButton = setBackButton(topPanel);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingsPane.setVisible(false);
				if (dep[1].equals("Manager")) {
					new HRMenu(firstname, frame, employee);
				} else if (dep[1].equals("Director")) {
					new DirectorMenu(firstname, frame, employee);
				} else {
					new EmployeeMenu(firstname, frame, employee);
				}
			}
		});
		
		JPanel menuPanel = new JPanel();
		settingsPane.add(menuPanel, BorderLayout.CENTER);
		menuPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel usernamePanel = new JPanel();
		menuPanel.add(usernamePanel, BorderLayout.WEST);
		usernamePanel.setLayout(new BorderLayout(0, 0));
		
		JButton usernameButton = new JButton("Change Username");
		usernameButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernamePanel.add(usernameButton);
		usernameButton.setPreferredSize(new Dimension(180, 23));
		usernameButton.setMinimumSize(new Dimension(218, 23));
		usernameButton.setMaximumSize(new Dimension(218, 23));
		
		Component verticalStrut_1 = Box.createVerticalStrut(138);
		usernamePanel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(53);
		usernamePanel.add(horizontalStrut_1, BorderLayout.WEST);
		
		Component verticalStrut_2 = Box.createVerticalStrut(47);
		usernamePanel.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		usernamePanel.add(horizontalStrut_2, BorderLayout.EAST);
		
		JPanel passwordPanel = new JPanel();
		menuPanel.add(passwordPanel, BorderLayout.EAST);
		passwordPanel.setLayout(new BorderLayout(0, 0));
		
		JButton passwordButton = new JButton("Change Password");
		passwordButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordPanel.add(passwordButton);
		passwordButton.setMinimumSize(new Dimension(120, 23));
		passwordButton.setMaximumSize(new Dimension(120, 23));
		passwordButton.setPreferredSize(new Dimension(180, 23));
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(43);
		passwordPanel.add(horizontalStrut_4, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(58);
		passwordPanel.add(horizontalStrut_3, BorderLayout.EAST);
		
		Component verticalStrut_3 = Box.createVerticalStrut(138);
		passwordPanel.add(verticalStrut_3, BorderLayout.SOUTH);
		
		Component verticalStrut_4 = Box.createVerticalStrut(47);
		passwordPanel.add(verticalStrut_4, BorderLayout.NORTH);
		passwordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingsPane.setVisible(false);
				changeUsernameorPasswordMenu("password");
			}
		});
		usernameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingsPane.setVisible(false);
				changeUsernameorPasswordMenu("username");	
			}
		});
	}
	public void changeUsernameorPasswordMenu(final String usernameOrPassword) {
		final JLayeredPane usernamePane = new JLayeredPane();
		frame.getContentPane().add(usernamePane, BorderLayout.CENTER);
		usernamePane.setLayout(new BorderLayout(0, 0));
		usernamePane.setVisible(true);
		
		JPanel headlinePanel = new JPanel();
		usernamePane.add(headlinePanel, BorderLayout.NORTH);
		headlinePanel.setLayout(new BorderLayout(0, 0));
		
		JButton backButton = setBackButton(headlinePanel);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernamePane.setVisible(false);
				settingsPane.setVisible(true);
			}
		});
		
		JPanel errorPanel = new JPanel();
		headlinePanel.add(errorPanel, BorderLayout.SOUTH);
		errorPanel.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut = Box.createVerticalStrut(19);
		errorPanel.add(verticalStrut, BorderLayout.SOUTH);
		
		errorLabel = new JLabel("The credentials you provided are not valid. Please try again.");
		errorLabel.setForeground(SystemColor.control);
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorPanel.add(errorLabel, BorderLayout.CENTER);
		
		Component verticalStrut_4 = Box.createVerticalStrut(47);
		errorPanel.add(verticalStrut_4, BorderLayout.NORTH);
		
		JPanel menuPanel = new JPanel();
		usernamePane.add(menuPanel, BorderLayout.CENTER);
		menuPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel usernamePanel = new JPanel();
		menuPanel.add(usernamePanel, BorderLayout.NORTH);
		usernamePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel usernameLabel = new JLabel("Please enter your current username");
		usernameLabel.setPreferredSize(new Dimension(230, 14));
		usernameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		usernamePanel.add(usernameLabel, BorderLayout.WEST);
		
		JPanel usernameboxPanel = new JPanel();
		usernameboxPanel.setMaximumSize(new Dimension(10, 10));
		usernamePanel.add(usernameboxPanel, BorderLayout.CENTER);
		usernameboxPanel.setLayout(new BorderLayout(0, 0));
		
		final JTextField usernameField = new JTextField();
		usernameboxPanel.add(usernameField, BorderLayout.CENTER);
		usernameField.setHorizontalAlignment(SwingConstants.LEFT);
		usernameField.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(54);
		usernameboxPanel.add(horizontalStrut, BorderLayout.EAST);
		
		Component rigidArea = Box.createRigidArea(new Dimension(31, 30));
		usernameboxPanel.add(rigidArea, BorderLayout.WEST);
		
		JPanel passwordPanel = new JPanel();
		menuPanel.add(passwordPanel, BorderLayout.CENTER);
		passwordPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel passwordLabel = new JLabel("Please enter your current password\r\n");
		passwordLabel.setPreferredSize(new Dimension(230, 14));
		passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordPanel.add(passwordLabel, BorderLayout.WEST);
		
		JPanel passwordBoxPanel = new JPanel();
		passwordBoxPanel.setMaximumSize(new Dimension(10, 10));
		passwordPanel.add(passwordBoxPanel, BorderLayout.CENTER);
		passwordBoxPanel.setLayout(new BorderLayout(0, 0));
		
		final JPasswordField passwordField = new JPasswordField();
		passwordBoxPanel.add(passwordField, BorderLayout.CENTER);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(54);
		passwordBoxPanel.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(30);
		passwordBoxPanel.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component verticalStrut_2 = Box.createVerticalStrut(56);
		passwordBoxPanel.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(64);
		passwordBoxPanel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		JPanel enterPanel = new JPanel();
		menuPanel.add(enterPanel, BorderLayout.SOUTH);
		enterPanel.setLayout(new BorderLayout(0, 0));
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(194, 44));
		enterPanel.add(rigidArea_1, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(190);
		enterPanel.add(horizontalStrut_3, BorderLayout.EAST);
		
		Component verticalStrut_3 = Box.createVerticalStrut(55);
		enterPanel.add(verticalStrut_3, BorderLayout.SOUTH);
		
		JButton enterButton = new JButton("Enter");
		enterPanel.add(enterButton, BorderLayout.CENTER);
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				char[] password = passwordField.getPassword();
				usernameField.setText(null);
				passwordField.setText(null);
				if (WorkersDatabase.checkCredentials(username, password).toString().equals(employee.toString())) {
					password = null; // delete content of variable after checking credentials for security reasons
					usernamePane.setVisible(false);
					final JLayeredPane newCredentialPane = new JLayeredPane();
					frame.getContentPane().add(newCredentialPane, BorderLayout.CENTER);
					newCredentialPane.setLayout(new BorderLayout(0, 0));
					newCredentialPane.setVisible(true);
					frame.validate();
					
					JPanel headlinePanel = new JPanel();
					newCredentialPane.add(headlinePanel, BorderLayout.NORTH);
					headlinePanel.setLayout(new BorderLayout(0, 0));
					
					JButton backButton = setBackButton(headlinePanel);
					backButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							newCredentialPane.setVisible(false);
							usernamePane.setVisible(true);
							frame.validate();
						}
					});
					
					final JPanel errorPanel = new JPanel();
					headlinePanel.add(errorPanel, BorderLayout.SOUTH);
					errorPanel.setLayout(new BorderLayout(0, 0));
					
					Component verticalStrut = Box.createVerticalStrut(16);
					errorPanel.add(verticalStrut, BorderLayout.SOUTH);
					
					errorLabel = new JLabel("The 2 inputs do not match. Please try again.");
					errorLabel.setForeground(SystemColor.control);
					errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
					errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
					errorPanel.add(errorLabel, BorderLayout.CENTER);
					
					Component verticalStrut_4 = Box.createVerticalStrut(16);
					errorPanel.add(verticalStrut_4, BorderLayout.NORTH);
					
					JPanel menuPanel = new JPanel();
					newCredentialPane.add(menuPanel, BorderLayout.CENTER);
					menuPanel.setLayout(new BorderLayout(0, 0));
					
					JPanel credentialPanel = new JPanel();
					menuPanel.add(credentialPanel, BorderLayout.NORTH);
					credentialPanel.setLayout(new BorderLayout(0, 0));
					
					JLabel credentialLabel = new JLabel("Please enter your new " + usernameOrPassword);
					credentialLabel.setPreferredSize(new Dimension(230, 14));
					credentialLabel.setHorizontalAlignment(SwingConstants.TRAILING);
					credentialLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
					credentialPanel.add(credentialLabel, BorderLayout.WEST);
					
					JPanel credentialboxPanel = new JPanel();
					credentialboxPanel.setMaximumSize(new Dimension(10, 10));
					credentialPanel.add(credentialboxPanel, BorderLayout.CENTER);
					credentialboxPanel.setLayout(new BorderLayout(0, 0));
					
					final JPasswordField credentialField = new JPasswordField();
					credentialboxPanel.add(credentialField, BorderLayout.CENTER);
					credentialField.setHorizontalAlignment(SwingConstants.LEFT);
					credentialField.setColumns(10);
					
					Component horizontalStrut = Box.createHorizontalStrut(54);
					credentialboxPanel.add(horizontalStrut, BorderLayout.EAST);
					
					Component rigidArea = Box.createRigidArea(new Dimension(31, 22));
					credentialboxPanel.add(rigidArea, BorderLayout.WEST);
					
					JPanel confirmPanel = new JPanel();
					menuPanel.add(confirmPanel, BorderLayout.CENTER);
					confirmPanel.setLayout(new BorderLayout(0, 0));
					
					JLabel confirmLabel = new JLabel("Please confirm your new " + usernameOrPassword);
					confirmLabel.setPreferredSize(new Dimension(230, 14));
					confirmLabel.setHorizontalAlignment(SwingConstants.TRAILING);
					confirmLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
					confirmPanel.add(confirmLabel, BorderLayout.WEST);
					
					JPanel confirmBoxPanel = new JPanel();
					confirmBoxPanel.setMaximumSize(new Dimension(10, 10));
					confirmPanel.add(confirmBoxPanel, BorderLayout.CENTER);
					confirmBoxPanel.setLayout(new BorderLayout(0, 0));
					
					final JPasswordField confirmField = new JPasswordField();
					confirmBoxPanel.add(confirmField, BorderLayout.CENTER);
					
					Component horizontalStrut_1 = Box.createHorizontalStrut(54);
					confirmBoxPanel.add(horizontalStrut_1, BorderLayout.EAST);
					
					Component horizontalStrut_2 = Box.createHorizontalStrut(30);
					confirmBoxPanel.add(horizontalStrut_2, BorderLayout.WEST);
					
					Component verticalStrut_2 = Box.createVerticalStrut(39);
					confirmBoxPanel.add(verticalStrut_2, BorderLayout.NORTH);
					
					Component verticalStrut_1 = Box.createVerticalStrut(41);
					confirmBoxPanel.add(verticalStrut_1, BorderLayout.SOUTH);
					
					JPanel enterPanel = new JPanel();
					menuPanel.add(enterPanel, BorderLayout.SOUTH);
					enterPanel.setLayout(new BorderLayout(0, 0));
					
					Component rigidArea_1 = Box.createRigidArea(new Dimension(180, 33));
					enterPanel.add(rigidArea_1, BorderLayout.WEST);
					
					Component horizontalStrut_3 = Box.createHorizontalStrut(170);
					enterPanel.add(horizontalStrut_3, BorderLayout.EAST);
					
					Component verticalStrut_3 = Box.createVerticalStrut(32);
					enterPanel.add(verticalStrut_3, BorderLayout.SOUTH);
					
					JButton enterButton = new JButton("Enter");
					enterPanel.add(enterButton, BorderLayout.CENTER);
					enterButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							StringBuilder cred = new StringBuilder(); 
							StringBuilder confirmcred = new StringBuilder();
							cred.append(credentialField.getPassword());
							confirmcred.append(confirmField.getPassword());
							credentialField.setText(null);
							confirmField.setText(null);
							if (!(cred.toString()).equals(confirmcred.toString())) {
								errorLabel.setForeground(Color.RED);
								frame.validate();
							} else if (usernameOrPassword.equals("username") && !WorkersDatabase.isUsernameUnique(cred.toString())) {
								errorPanel.remove(errorLabel);
								errorLabel = new JLabel("This username already exists. Please try again.");
								errorLabel.setForeground(Color.RED);
								errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
								errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
								errorPanel.add(errorLabel, BorderLayout.CENTER);
								frame.validate();
							} else {
								try {
									WorkersDatabase.changeUsernameorPassword(employee, usernameOrPassword, cred.toString());
									newCredentialPane.setVisible(false);
									String message = "Your " + usernameOrPassword + " has been changed successfully!";
									if (dep[1].equals("Manager")) {
										endMessage(message, "HRMenu", firstname, frame, employee);
									} else if (dep[1].equals("Director")) {
										endMessage(message, "DirectorMenu", firstname, frame, employee);
									} else {
										endMessage(message, "EmployeeMenu", firstname, frame, employee);
									}
								} catch (Exception e1) {
									errorPanel.remove(errorLabel);
									errorLabel = new JLabel("An error has occured. Please try again.");
									errorLabel.setForeground(Color.RED);
									errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
									errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
									errorPanel.add(errorLabel, BorderLayout.CENTER);
									frame.validate();
								}
							}
						}
					});
				} else {
					password = null; // delete content of variable after checking credentials for security reasons
					errorLabel.setForeground(Color.RED);
					frame.validate();
				}
			}
		});
	}
}
