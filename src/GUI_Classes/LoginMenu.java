package GUI_Classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import evaluateCandidates.CreateCandidate;
import evaluateCandidates.Employee;
import evaluateCandidates.WorkersDatabase;
import evaluateEmployees.CreatingFiles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Creates the first menu and includes the main method of the project
 * 
 * @author Michalis Dontas
 * @version 5.1 14 Jan 2020
 *
 */
public class LoginMenu {

	protected JFrame frame;
	private final JLayeredPane panel = new JLayeredPane();
	private final JLayeredPane blockedpanel = new JLayeredPane();
	private JTextField usernameField;
	private JPasswordField passwordField;
	private String firstname;
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
		try {
			(new JSONParser()).parse(new FileReader("WorkersDatabase.json"));
		} catch (ParseException e) {
			WorkersDatabase.createDatabase();
		} catch (FileNotFoundException e) {
			WorkersDatabase.createDatabase();
		} catch (IOException e) {
			System.exit(0);
		}
		try {
			(new JSONParser()).parse(new FileReader("Candidates.json"));
		} catch (ParseException e) {
			CreateCandidate.createDatabase();
		} catch (FileNotFoundException e) {
			CreateCandidate.createDatabase();
		} catch (IOException e) {
			System.exit(0);
		}
		try {
			new FileInputStream("MarketingDepartment.txt").close();
		} catch (FileNotFoundException e) {
			CreatingFiles.main(null);
		} catch (IOException e) {
			System.exit(0);
		}
		try {
			(new JSONParser()).parse(new FileReader("id_scores.json"));
		} catch (ParseException e) {
			try {
				new File("id_scores.json").createNewFile();
			} catch (IOException e1) {
				System.exit(0);
			}
		} catch (FileNotFoundException e) {
			try {
				new File("id_scores.json").createNewFile();
			} catch (IOException e1) {
				System.exit(0);
			}
		} catch (IOException e) {
			System.exit(0);
		}
		try {
			new FileInputStream("chatidf.txt").close();
		} catch (FileNotFoundException e) {
			try {
				new File("chatidf.txt").createNewFile();
			} catch (IOException e1) {
				System.exit(0);
			}
			try {
				new File("messagef.txt").createNewFile();
			} catch (IOException e1) {
				System.exit(0);
			}			
			try {
				new File("membersf.txt").createNewFile();
			} catch (IOException e1) {
				System.exit(0);
			}
			try {
				new File("cidf.txt").createNewFile();
			} catch (IOException e1) {
				System.exit(0);
			}		} catch (IOException e) {
			System.exit(0);
		}		
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
		frame.setBounds(400, 130, 520, 400);
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
		lblNewLabel.setBounds(107, 52, 286, 36);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel username = new JLabel("Username");
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setForeground(Color.BLACK);
		username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		username.setBounds(136, 138, 78, 14);
		panel.add(username);

		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.LEFT);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.setBounds(244, 135, 104, 20);
		panel.add(usernameField);
		usernameField.setColumns(10);

		JLabel password = new JLabel("Password");
		password.setForeground(Color.BLACK);
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		password.setBounds(136, 196, 78, 14);
		panel.add(password);

		passwordField = new JPasswordField();
		passwordField.setBounds(244, 195, 104, 20);
		panel.add(passwordField);

		JButton loginButton = new JButton("Login");
		loginButton.setForeground(Color.BLACK);
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginButton.setBounds(189, 254, 89, 23);
		panel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (error != null)
					panel.remove(error);
				if (nullerror != null) {
					nullerror.setText(null);
					panel.remove(nullerror);
					guiCorrection = new JLabel("                                                           ");
					guiCorrection.setBounds(85, 86, 320, 30);
					panel.add(guiCorrection);
				}
				if (usernameField.getText().isEmpty() || passwordField.getPassword().length == 0) {
					usernameField.setText(null);
					passwordField.setText(null);
					nullerror = new JLabel("You must type at least one caracter in every field.");
					nullerror.setBounds(85, 86, 320, 30);
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
						errorHeadline.setBounds(52, 99, 400, 30);
						errorHeadline.setFont(new Font("Tahoma", Font.BOLD, 18));
						errorHeadline.setForeground(Color.BLACK);
						errorHeadline.setHorizontalAlignment(SwingConstants.CENTER);

						blockmessage = new JLabel("Your access has been blocked");
						blockedpanel.add(blockmessage);
						blockmessage.setBounds(79, 140, 330, 30);
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
					error.setBounds(105, 86, 270, 30);
					panel.add(error);
					error.setFont(new Font("Tahoma", Font.PLAIN, 14));
					error.setForeground(Color.RED);
					error.setHorizontalAlignment(SwingConstants.CENTER);
					usernameField.setText(null);
					passwordField.setText(null);
				} else {
					int dep_id = employee.getDepartmentId();
					String[] name = employee.getFull_name().split("\\s");
					firstname = name[0];
					switch (dep_id) {
					case 0:
						panel.setVisible(false);
						new HRMenu(firstname, frame, employee);
						break;
					case 1:
					case 2:
					case 3:
					case 4:
						panel.setVisible(false);
						new EmployeeMenu(firstname, frame, employee);
						break;
					case 5:
					case 6:
					case 7:
					case 8:
						panel.setVisible(false);
						new DirectorMenu(firstname, frame, employee);
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
		backButton.setIcon(new ImageIcon(
				Settings.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/backspace-icon.png")));
		backButton.setPreferredSize(new Dimension(100, 23));
		headlinePanel.add(backButton, BorderLayout.WEST);
		return backButton;
	}

	public void endMessage(String message, final String errorinMenu, final String firstname, final JFrame frame,
			final Employee employee) {
		final JLayeredPane errorPane = new JLayeredPane();
		frame.getContentPane().add(errorPane, BorderLayout.CENTER);
		errorPane.setLayout(new BorderLayout(0, 0));

		JPanel showMessagePanel = new JPanel();
		errorPane.add(showMessagePanel, BorderLayout.CENTER);
		showMessagePanel.setLayout(new BorderLayout(0, 0));

		JPanel headlinepanel = new JPanel();
		showMessagePanel.add(headlinepanel, BorderLayout.NORTH);
		headlinepanel.setLayout(new BorderLayout(0, 0));

		JLabel messageLabel = new JLabel(message + "\r\n");
		messageLabel.setForeground(Color.BLACK);
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		headlinepanel.add(messageLabel, BorderLayout.CENTER);

		Component verticalStrut = Box.createVerticalStrut(65);
		headlinepanel.add(verticalStrut, BorderLayout.NORTH);

		JLabel returnLabel = new JLabel("Press go Back to return to the initial Menu");
		headlinepanel.add(returnLabel, BorderLayout.SOUTH);
		returnLabel.setForeground(Color.DARK_GRAY);
		returnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		returnLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JPanel enterPanel = new JPanel();
		showMessagePanel.add(enterPanel, BorderLayout.CENTER);
		enterPanel.setLayout(new BorderLayout(0, 0));

		JButton returnButton = new JButton("Go Back\r\n");
		returnButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		enterPanel.add(returnButton, BorderLayout.CENTER);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorPane.setVisible(false);
				if (errorinMenu.equals("HRMenu")) {
					new HRMenu(firstname, frame, employee);
				} else if (errorinMenu.equals("EmployeeMenu")) {
					new EmployeeMenu(firstname, frame, employee);
				} else if (errorinMenu.equals("DirectorMenu")) {
					new DirectorMenu(firstname, frame, employee);
				} else {
					System.exit(0);
				}
			}
		});

		Component horizontalStrut_1 = Box.createHorizontalStrut(168);
		enterPanel.add(horizontalStrut_1, BorderLayout.EAST);

		Component verticalStrut_1 = Box.createVerticalStrut(159);
		enterPanel.add(verticalStrut_1, BorderLayout.SOUTH);

		Component verticalStrut_2 = Box.createVerticalStrut(13);
		enterPanel.add(verticalStrut_2, BorderLayout.NORTH);

		Component horizontalStrut = Box.createHorizontalStrut(172);
		enterPanel.add(horizontalStrut, BorderLayout.WEST);
	}
}
