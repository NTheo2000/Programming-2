package GUI_Classes;

import javax.swing.Box;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import evaluateCandidates.Employee;

/**
 * Creates the window for the directors menu
 * 
 * @author Michalis Dontas
 * @version 3.1 15 Jan 2020
 *
 */
public class DirectorMenu extends LoginMenu {

	private JFrame frame;
	private String firstname = null;
	private Employee employee;

	/**
	 * Create the application.
	 */
	public DirectorMenu(String name, JFrame frame, Employee employee) {
		this.frame = frame;
		this.firstname = name;
		this.employee = employee;
		initialize();
	}

	/**
	 * initialize and create the frames
	 */
	public void initialize() {
		frame.setVisible(true);

		final JLayeredPane panel = new JLayeredPane();
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
				new WindowDirectorCharts(firstname, frame, employee);
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

		JButton ev_empButton = new JButton("Evaluate Employees");
		empPanel.add(ev_empButton, BorderLayout.CENTER);
		ev_empButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ev_empButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				new EvaluateOperation(firstname, frame, employee);
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
				int choice = JOptionPane.showOptionDialog(null, "Are you sure you want to log out?", "Log Out",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
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
}
