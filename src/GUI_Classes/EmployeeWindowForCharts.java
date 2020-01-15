package GUI_Classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import evaluateCandidates.Employee;
import javafx.embed.swing.JFXPanel;

/**
 * Creates the employee window for the Charts Shows the chart from the
 * evaluation
 * 
 * @author Michalis Dontas & Dimitris Vougioukos
 * @version 2.1 14 Jan 2020
 */
public class EmployeeWindowForCharts extends LoginMenu {

	private JFrame frame;
	private String firstname;
	private Employee employee;

	JLayeredPane panel;

	/**
	 * Create the application.
	 */
	public EmployeeWindowForCharts(String name, JFrame frame, Employee employee) {
		this.frame = frame;
		this.firstname = name;
		this.employee = employee;
		initialize();
	}

	/**
	 * initializes and creates the panel and includes actions when the buttons are
	 * used
	 */
	private void initialize() {
		final JLayeredPane choosePane = new JLayeredPane();
		frame.getContentPane().add(choosePane, BorderLayout.CENTER);
		choosePane.setLayout(new BorderLayout(0, 0));

		JPanel headlinePanel = new JPanel();
		choosePane.add(headlinePanel, BorderLayout.NORTH);
		headlinePanel.setLayout(new BorderLayout(0, 0));

		JLabel headlineLabel = new JLabel("Select the first and the last semester to see your peformance");
		headlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
				String[] dep = employee.getDepartment().split("\\s");
				if (dep[1].equals("Manager")) {
					new EvEmpMenuforHR(firstname, frame, employee);
				} else {
					new EmployeeMenu(firstname, frame, employee);
				}
			}
		});

		Component verticalStrut_1 = Box.createVerticalStrut(31);
		topPanel.add(verticalStrut_1, BorderLayout.SOUTH);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		headlinePanel.add(horizontalStrut, BorderLayout.WEST);

		JPanel errorPanel = new JPanel();
		headlinePanel.add(errorPanel, BorderLayout.SOUTH);
		errorPanel.setLayout(new BorderLayout(0, 0));

		final JLabel errorLabel = new JLabel("First semester can't be grater than the last.");
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

		Component verticalStrut_3 = Box.createVerticalStrut(27);
		textPanel1.add(verticalStrut_3, BorderLayout.NORTH);

		JPanel numberPanel1 = new JPanel();
		firstPanel.add(numberPanel1, BorderLayout.CENTER);
		numberPanel1.setLayout(new BorderLayout(0, 0));

		final JSpinner spinner1 = new JSpinner();
		spinner1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner1.setPreferredSize(new Dimension(29, 22));
		numberPanel1.add(spinner1);

		Component horizontalStrut_4 = Box.createHorizontalStrut(10);
		horizontalStrut_4.setPreferredSize(new Dimension(34, 0));
		numberPanel1.add(horizontalStrut_4, BorderLayout.WEST);

		Component verticalStrut_4 = Box.createVerticalStrut(41);
		numberPanel1.add(verticalStrut_4, BorderLayout.NORTH);

		Component horizontalStrut_5 = Box.createHorizontalStrut(173);
		numberPanel1.add(horizontalStrut_5, BorderLayout.EAST);

		Component verticalStrut_5 = Box.createVerticalStrut(28);
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

		Component verticalStrut_6 = Box.createVerticalStrut(35);
		verticalStrut_6.setPreferredSize(new Dimension(0, 23));
		textPanel2.add(verticalStrut_6, BorderLayout.SOUTH);

		Component verticalStrut_8 = Box.createVerticalStrut(9);
		textPanel2.add(verticalStrut_8, BorderLayout.NORTH);

		JPanel numberPanel2 = new JPanel();
		secondPanel.add(numberPanel2, BorderLayout.CENTER);
		numberPanel2.setLayout(new BorderLayout(0, 0));

		final JSpinner spinner2 = new JSpinner();
		spinner2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner2.setPreferredSize(new Dimension(29, 24));
		numberPanel2.add(spinner2);

		Component horizontalStrut_8 = Box.createHorizontalStrut(34);
		numberPanel2.add(horizontalStrut_8, BorderLayout.WEST);

		Component horizontalStrut_9 = Box.createHorizontalStrut(173);
		numberPanel2.add(horizontalStrut_9, BorderLayout.EAST);

		Component verticalStrut_7 = Box.createVerticalStrut(42);
		numberPanel2.add(verticalStrut_7, BorderLayout.SOUTH);

		Component verticalStrut_9 = Box.createVerticalStrut(26);
		numberPanel2.add(verticalStrut_9, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		choosePane.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new BorderLayout(0, 0));

		JButton okButton = new JButton("Ok");
		okButton.setPreferredSize(new Dimension(45, 30));
		buttonPanel.add(okButton, BorderLayout.CENTER);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int s1 = (Integer) spinner1.getValue();
					int s2 = (Integer) spinner2.getValue();
					if (s1 <= s2) {
						choosePane.setVisible(false);
						frame.validate();
						ArrayList<Integer> semesters = new ArrayList<Integer>();
						for (int i = s1; i <= s2; i++) {
							semesters.add(i);
						}
						String[] dep = employee.getDepartment().split("\\s");

						final JLayeredPane chartPane = new JLayeredPane();
						frame.getContentPane().add(chartPane, BorderLayout.CENTER);
						chartPane.setLayout(new BorderLayout(0, 0));

						JFXPanel fxPanel = new JFXPanel();
						chartPane.add(fxPanel, BorderLayout.CENTER);
						fxPanel.setScene(new LineChartEmployees(employee.getId(), semesters, dep[0]).generateChart());

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
					endMessage("An error has occured", "EmployeeMenu", firstname, frame, employee);
				}
			}
		});

		Component horizontalStrut_10 = Box.createHorizontalStrut(180);
		buttonPanel.add(horizontalStrut_10, BorderLayout.WEST);

		Component verticalStrut_10 = Box.createVerticalStrut(42);
		buttonPanel.add(verticalStrut_10, BorderLayout.SOUTH);

		Component horizontalStrut_11 = Box.createHorizontalStrut(176);
		buttonPanel.add(horizontalStrut_11, BorderLayout.EAST);

		Component verticalStrut_11 = Box.createVerticalStrut(2);
		buttonPanel.add(verticalStrut_11, BorderLayout.NORTH);

	}
}