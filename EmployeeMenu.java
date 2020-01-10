package GUI_Classes;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import EvaluateCandidates.Employee;
import evaluateEmployees.EvaluationAccountingEmployees;
import evaluateEmployees.EvaluationHrEmployees;
import evaluateEmployees.EvaluationItEmployees;
import evaluateEmployees.EvaluationMarketingEmployees;
import javafx.embed.swing.JFXPanel;


public class EmployeeMenu extends LoginMenu{

	private JFrame frame;
	private String firstname;
	private Employee employee;
	
	JLayeredPane panel;

	/**
	 * Create the application.
	 */
	public EmployeeMenu(String name, JFrame frame, Employee employee) {
		this.frame = frame;
		this.firstname = name;
		this.employee = employee;
		initialize();
	}
	public void initialize() {
		frame.setVisible(true);

		panel = new JLayeredPane();
		panel.setBounds(10, 5, 382, 25);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setVisible(true);
		
		JPanel headlinePanel = new JPanel();
		panel.add(headlinePanel, BorderLayout.NORTH);
		headlinePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel welcomeLabel = new JLabel("Welcome, " + firstname + "!");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		headlinePanel.add(welcomeLabel, BorderLayout.CENTER);
		
		JPanel menuPanel = new JPanel();
		panel.add(menuPanel, BorderLayout.CENTER);
		menuPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel candPanel = new JPanel();
		menuPanel.add(candPanel, BorderLayout.WEST);
		candPanel.setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(12);
		candPanel.add(horizontalStrut_1, BorderLayout.WEST);
		
		Component verticalStrut_1 = Box.createVerticalStrut(53);
		candPanel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component verticalStrut_2 = Box.createVerticalStrut(13);
		candPanel.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(4);
		candPanel.add(horizontalStrut_2, BorderLayout.EAST);
		
		JButton ev_candButton = new JButton("Your performance");
		ev_candButton.setMinimumSize(new Dimension(149, 23));
		ev_candButton.setMaximumSize(new Dimension(149, 23));
		ev_candButton.setPreferredSize(new Dimension(149, 12));
		candPanel.add(ev_candButton, BorderLayout.WEST);
		ev_candButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ev_candButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				showChart();
			}
		});
		JPanel empPanel = new JPanel();
		empPanel.setPreferredSize(new Dimension(150, 10));
		menuPanel.add(empPanel, BorderLayout.CENTER);
		empPanel.setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(2);
		empPanel.add(horizontalStrut_4, BorderLayout.EAST);
		
		Component verticalStrut_3 = Box.createVerticalStrut(13);
		empPanel.add(verticalStrut_3, BorderLayout.NORTH);
		
		Component verticalStrut_4 = Box.createVerticalStrut(53);
		empPanel.add(verticalStrut_4, BorderLayout.SOUTH);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(0);
		empPanel.add(horizontalStrut_3, BorderLayout.WEST);
		
		JButton ev_empButton = new JButton("Evaluate Director");
		empPanel.add(ev_empButton, BorderLayout.CENTER);
		ev_empButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ev_empButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JPanel chatPanel = new JPanel();
		menuPanel.add(chatPanel, BorderLayout.EAST);
		chatPanel.setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(2);
		chatPanel.add(horizontalStrut_5, BorderLayout.WEST);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(10);
		chatPanel.add(horizontalStrut_6, BorderLayout.EAST);
		
		Component verticalStrut_5 = Box.createVerticalStrut(53);
		chatPanel.add(verticalStrut_5, BorderLayout.SOUTH);
		
		Component verticalStrut_6 = Box.createVerticalStrut(13);
		chatPanel.add(verticalStrut_6, BorderLayout.NORTH);
		
		JButton chatButton = new JButton("Chat");
		chatButton.setMinimumSize(new Dimension(130, 23));
		chatButton.setMaximumSize(new Dimension(130, 23));
		chatButton.setPreferredSize(new Dimension(130, 23));
		chatPanel.add(chatButton, BorderLayout.EAST);
		chatButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel menuLabel = new JLabel("Please select one of the following actions");
		menuLabel.setPreferredSize(new Dimension(197, 30));
		menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuPanel.add(menuLabel, BorderLayout.NORTH);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		headlinePanel.add(verticalStrut, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(71);
		headlinePanel.add(horizontalStrut, BorderLayout.WEST);
		
		JPanel eastPanel = new JPanel();
		headlinePanel.add(eastPanel, BorderLayout.EAST);
		eastPanel.setLayout(new BorderLayout(0, 0));
		
		JButton settingsButton = new JButton("Settings");
		eastPanel.add(settingsButton, BorderLayout.SOUTH);
		settingsButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton logoutButton = new JButton("Log Out");
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eastPanel.add(logoutButton, BorderLayout.NORTH);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int choice = JOptionPane.showOptionDialog(null, 
					      "Are you sure you want to log out?", 
					      "Log Out", 
					      JOptionPane.YES_NO_OPTION, 
					      JOptionPane.QUESTION_MESSAGE, 
					      null, null, null);
				  if (choice == JOptionPane.YES_OPTION) {
					panel.setVisible(false);
					new LoginMenu(frame);
				  }
			}
		});
		
		Component verticalStrut_7 = Box.createVerticalStrut(3);
		eastPanel.add(verticalStrut_7, BorderLayout.CENTER);
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				new Settings(firstname, frame, employee);
			}
		});
	}
	private void showChart() {
		JLayeredPane choosePane = new JLayeredPane();
		frame.getContentPane().add(choosePane, BorderLayout.CENTER);
		choosePane.setLayout(new BorderLayout(0, 0));
		
		JPanel headlinePanel = new JPanel();
		choosePane.add(headlinePanel, BorderLayout.NORTH);
		headlinePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel headlineLabel = new JLabel("Select the first and the last semester to see your peformance");
		headlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		headlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headlinePanel.add(headlineLabel, BorderLayout.CENTER);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		headlinePanel.add(horizontalStrut_1, BorderLayout.EAST);
		
		JPanel topPanel = new JPanel();
		headlinePanel.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));
		
		JButton backButton = setBackButton(topPanel);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choosePane.setVisible(false);
				frame.validate();
				new EmployeeMenu(firstname, frame, employee);
			}
		});
		
		Component verticalStrut_1 = Box.createVerticalStrut(22);
		topPanel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		headlinePanel.add(horizontalStrut, BorderLayout.WEST);
		
		JPanel errorPanel = new JPanel();
		headlinePanel.add(errorPanel, BorderLayout.SOUTH);
		errorPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel errorLabel = new JLabel("First semester can't be grater than the last.");
		errorLabel.setForeground(SystemColor.control);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		errorPanel.add(errorLabel, BorderLayout.CENTER);
		
		Component verticalStrut = Box.createVerticalStrut(14);
		errorPanel.add(verticalStrut, BorderLayout.NORTH);
		
		JPanel menuPanel = new JPanel();
		choosePane.add(menuPanel, BorderLayout.CENTER);
		menuPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel firstPanel = new JPanel();
		menuPanel.add(firstPanel);
		firstPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel textPanel1 = new JPanel();
		firstPanel.add(textPanel1, BorderLayout.WEST);
		textPanel1.setLayout(new BorderLayout(0, 0));
		
		JLabel textLabel1 = new JLabel("Select first semester");
		textLabel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPanel1.add(textLabel1, BorderLayout.CENTER);
		
		Component verticalStrut_2 = Box.createVerticalStrut(14);
		textPanel1.add(verticalStrut_2, BorderLayout.SOUTH);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(114);
		textPanel1.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		textPanel1.add(horizontalStrut_3, BorderLayout.EAST);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		textPanel1.add(verticalStrut_3, BorderLayout.NORTH);
		
		JPanel numberPanel1 = new JPanel();
		firstPanel.add(numberPanel1, BorderLayout.CENTER);
		numberPanel1.setLayout(new BorderLayout(0, 0));
		
		JSpinner spinner1 = new JSpinner();
		spinner1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner1.setPreferredSize(new Dimension(29, 22));
		numberPanel1.add(spinner1);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(10);
		numberPanel1.add(horizontalStrut_4, BorderLayout.WEST);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		numberPanel1.add(verticalStrut_4, BorderLayout.NORTH);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(133);
		numberPanel1.add(horizontalStrut_5, BorderLayout.EAST);
		
		Component verticalStrut_5 = Box.createVerticalStrut(11);
		numberPanel1.add(verticalStrut_5, BorderLayout.SOUTH);
		
		JPanel secondPanel = new JPanel();
		menuPanel.add(secondPanel, BorderLayout.SOUTH);
		secondPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel textPanel2 = new JPanel();
		secondPanel.add(textPanel2, BorderLayout.WEST);
		textPanel2.setLayout(new BorderLayout(0, 0));
		
		JLabel textLabel2 = new JLabel("Select last semester");
		textLabel2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPanel2.add(textLabel2, BorderLayout.CENTER);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(114);
		textPanel2.add(horizontalStrut_6, BorderLayout.WEST);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		textPanel2.add(horizontalStrut_7, BorderLayout.EAST);
		
		Component verticalStrut_6 = Box.createVerticalStrut(24);
		verticalStrut_6.setPreferredSize(new Dimension(0, 23));
		textPanel2.add(verticalStrut_6, BorderLayout.SOUTH);
		
		Component verticalStrut_8 = Box.createVerticalStrut(9);
		textPanel2.add(verticalStrut_8, BorderLayout.NORTH);
		
		JPanel numberPanel2 = new JPanel();
		secondPanel.add(numberPanel2, BorderLayout.CENTER);
		numberPanel2.setLayout(new BorderLayout(0, 0));
		
		JSpinner spinner2 = new JSpinner();
		spinner2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner2.setPreferredSize(new Dimension(29, 22));
		numberPanel2.add(spinner2);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(10);
		numberPanel2.add(horizontalStrut_8, BorderLayout.WEST);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(134);
		numberPanel2.add(horizontalStrut_9, BorderLayout.EAST);
		
		Component verticalStrut_7 = Box.createVerticalStrut(24);
		numberPanel2.add(verticalStrut_7, BorderLayout.SOUTH);
		
		Component verticalStrut_9 = Box.createVerticalStrut(11);
		numberPanel2.add(verticalStrut_9, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel();
		choosePane.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new BorderLayout(0, 0));
		
		JButton okButton = new JButton("Ok");
		buttonPanel.add(okButton, BorderLayout.CENTER);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int s1 = (int) spinner1.getValue();
					int s2 = (int) spinner2.getValue();
					if (s1 <= s2) {
						choosePane.setVisible(false);
						frame.validate();
						ArrayList<Integer> semesters = new ArrayList<Integer>();
						for (int i = s1; i <= s2; i++) {
							semesters.add(i);
						}
						Object obj;
						if (employee.getDepartment().equals("Marketing Employee")) {
							obj = new EvaluationMarketingEmployees();
						} else if (employee.getDepartment().equals("Accounting Employee")) {
							obj = new EvaluationAccountingEmployees();
						} else if (employee.getDepartment().equals("IT Employee")) {
							obj = new EvaluationItEmployees();
						} else {
							obj = new EvaluationHrEmployees();
						}
						JLayeredPane chartPane = new JLayeredPane();
						frame.getContentPane().add(chartPane, BorderLayout.CENTER);
						chartPane.setLayout(new BorderLayout(0, 0));
							
				        JFXPanel fxPanel = new JFXPanel();
				        chartPane.add(fxPanel, BorderLayout.CENTER);
				   		fxPanel.setScene(new LineChartEmployees(employee.getId(), semesters, obj).generateChart());
				        
				        JPanel topPanel = new JPanel();
				        chartPane.add(topPanel, BorderLayout.NORTH);
				        topPanel.setLayout(new BorderLayout(0, 0));
				       				   		
				   		JButton backButton = setBackButton(topPanel);
				   		backButton.addActionListener(new ActionListener() {
				   			public void actionPerformed(ActionEvent e) {
				   				chartPane.setVisible(false);
				   				choosePane.setVisible(true);
				   				frame.validate();
				   			}
				   		});
					} else {
						errorLabel.setForeground(Color.RED);
					}
				} catch (Exception e) {
					e.printStackTrace();
					endMessage("An error has occured", "EmployeeMenu", frame);
				}
			}
		});
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(172);
		buttonPanel.add(horizontalStrut_10, BorderLayout.WEST);
		
		Component verticalStrut_10 = Box.createVerticalStrut(37);
		buttonPanel.add(verticalStrut_10, BorderLayout.SOUTH);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(165);
		buttonPanel.add(horizontalStrut_11, BorderLayout.EAST);
		
		Component verticalStrut_11 = Box.createVerticalStrut(2);
		buttonPanel.add(verticalStrut_11, BorderLayout.NORTH);
		
	}
}