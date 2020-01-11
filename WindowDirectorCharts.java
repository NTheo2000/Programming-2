package GUI_Classes;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import EvaluateCandidates.Employee;
import javafx.embed.swing.JFXPanel;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class WindowDirectorCharts extends LoginMenu {

	private JFrame frame;
	private String firstname;
	private Employee employee;
	private JLayeredPane layeredPane;

	/**
	 * Create the application.
	 */
	public WindowDirectorCharts(String name, JFrame frame, Employee employee) {
		this.frame = frame;
		this.firstname = name;
		this.employee = employee;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblChooseYourChart = new JLabel("Choose the type of Chart");
		lblChooseYourChart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChooseYourChart.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblChooseYourChart, BorderLayout.CENTER);
		
		Component horizontalStrut = Box.createHorizontalStrut(142);
		panel.add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(123);
		panel.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		JPanel topPanel = new JPanel();
		panel.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));
		
		JButton backButton = setBackButton(topPanel);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(false);
				String[] dep = employee.getDepartment().split("\\s");
				if (dep[1].equals("Manager")) {
					new EvEmpMenuforHR(firstname, frame, employee);
				} else {
					new DirectorMenu(firstname, frame, employee);
				}
			}
		});
		
		Component verticalStrut = Box.createVerticalStrut(31);
		topPanel.add(verticalStrut, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnBarChart = new JButton("Score per question (Bar Chart)");
		btnBarChart.setPreferredSize(new Dimension(185, 23));
		panel_1.add(btnBarChart, BorderLayout.CENTER);
		btnBarChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(false);
				showChart("Bar");			
			}
		});
		
		Component verticalStrut_2 = Box.createVerticalStrut(15);
		panel_1.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component verticalStrut_3 = Box.createVerticalStrut(108);
		panel_1.add(verticalStrut_3, BorderLayout.SOUTH);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(15);
		panel_1.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(0);
		panel_1.add(horizontalStrut_3, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		layeredPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnPieChart = new JButton("Employee satisfaction level (Pie Chart)");
		btnPieChart.setPreferredSize(new Dimension(220, 23));
		panel_2.add(btnPieChart, BorderLayout.CENTER);
		btnPieChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(false);
				showChart("Pie");
			}
		});
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(26);
		panel_2.add(horizontalStrut_4, BorderLayout.WEST);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(10);
		panel_2.add(horizontalStrut_5, BorderLayout.EAST);
		
		Component verticalStrut_4 = Box.createVerticalStrut(16);
		panel_2.add(verticalStrut_4, BorderLayout.NORTH);
		
		Component verticalStrut_5 = Box.createVerticalStrut(108);
		panel_2.add(verticalStrut_5, BorderLayout.SOUTH);
	}
	public void showChart(String chartType) {
		JLayeredPane chartPane = new JLayeredPane();
		frame.getContentPane().add(chartPane, BorderLayout.CENTER);
		chartPane.setLayout(new BorderLayout(0, 0));
		try {	
				JFXPanel fxPanel = new JFXPanel();
				chartPane.add(fxPanel, BorderLayout.CENTER);
				if (chartType.equals("Bar")) {
					fxPanel.setScene((new BarChartDirector(employee.getId())).generateChart());
	        } else {
				fxPanel.setScene((new PieChartEmployee(employee.getId())).generateChart());
	        }
	        JPanel topPanel = new JPanel();
	        chartPane.add(topPanel, BorderLayout.NORTH);
	        topPanel.setLayout(new BorderLayout(0, 0));
	       				   		
	   		JButton backButton = setBackButton(topPanel);
	   		backButton.addActionListener(new ActionListener() {
	   			public void actionPerformed(ActionEvent e) {
	   				chartPane.setVisible(false);
	   				layeredPane.setVisible(true);
	   				frame.validate();
	   			}
	   		});
		} catch (Exception e) {
			endMessage("An error has occured", "DirectorMenu", frame);
		}
	}
}
