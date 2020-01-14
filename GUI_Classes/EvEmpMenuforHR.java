package GUI_Classes;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import evaluateCandidates.Employee;

import org.json.simple.JSONObject;

public class EvEmpMenuforHR extends LoginMenu {

	private JFrame frame;
	private String name;
	private Employee employee;
	ArrayList<Employee> employees = new ArrayList<Employee>();

	/**
	 * Create the application.
	 */
	public EvEmpMenuforHR(String name, JFrame frame, Employee employee) {
		this.name = name;
		this.frame = frame;
		this.employee = employee;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setVisible(true);
		JSONParser parser = new JSONParser();
		try {
			JSONArray json_employees = (JSONArray) parser.parse(new FileReader("WorkersDatabase.json"));
			String[] columnNames = {"Name", "Nationality", "Age", "City", "Salary", "Department"};
			String data[][] = new String[json_employees.size()-1][6]; // the data must contain all the employees except the HR Manager 
			Employee worker;
			int i = 0;
			for (Object obj : json_employees) {
				worker = new Employee((JSONObject) obj);
				if (worker.getDepartment().equals("HR Manager")) continue;
				employees.add(worker);
				data[i][0] = worker.getFull_name();
				data[i][1] = worker.getNationality();
				data[i][2] = String.valueOf(worker.getAge());
				data[i][3] = worker.getCity_of_residence();
				data[i][4] = String.valueOf(worker.getSalary());
				data[i++][5] = worker.getDepartment();
			}

			final JLayeredPane tablePane = new JLayeredPane();
			frame.getContentPane().add(tablePane, BorderLayout.CENTER);
			tablePane.setLayout(new BorderLayout(0, 0));
			tablePane.setVisible(true);
			
			JPanel tablePanel = new JPanel();
			tablePanel.setBackground(Color.LIGHT_GRAY);
			tablePane.add(tablePanel, BorderLayout.CENTER);
			tablePanel.setLayout(new BorderLayout(0, 0));
			
			final JTable jt = new JTable(data, columnNames);
			jt.setBackground(SystemColor.control);
			jt.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
			jt.setColumnSelectionAllowed(false);
			jt.setRowSelectionAllowed(true);
			jt.setModel(new DefaultTableModel(data, columnNames) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
	
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
			JScrollPane scrollPane = new JScrollPane(jt);
			jt.setFillsViewportHeight(true);
			tablePanel.add(scrollPane, BorderLayout.CENTER);
			
			ListSelectionModel select = jt.getSelectionModel();
			select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(SystemColor.control);
			tablePanel.add(buttonPanel, BorderLayout.SOUTH);
			buttonPanel.setLayout(new BorderLayout(0, 0));
			
			JButton okButton = new JButton("Ok");
			okButton.setPreferredSize(new Dimension(45, 35));
			buttonPanel.add(okButton, BorderLayout.CENTER);
			okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			Component horizontalStrut = Box.createHorizontalStrut(165);
			buttonPanel.add(horizontalStrut, BorderLayout.WEST);
			
			Component verticalStrut = Box.createVerticalStrut(17);
			buttonPanel.add(verticalStrut, BorderLayout.SOUTH);
			
			Component horizontalStrut_1 = Box.createHorizontalStrut(184);
			buttonPanel.add(horizontalStrut_1, BorderLayout.EAST);
			
			Component verticalStrut_1 = Box.createVerticalStrut(11);
			buttonPanel.add(verticalStrut_1, BorderLayout.NORTH);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = jt.getSelectedRow();
					if (row != -1) {
						tablePane.setVisible(false);
						String[] dep = employees.get(row).getDepartment().split("\\s");
						if (dep[1].equals("Director")) {
							new WindowDirectorCharts(name, frame, employee);
						} else {
							new EmployeeWindowForCharts(name, frame, employee);
						}
					}
				}
			});
			
			JPanel headlinePanel = new JPanel();
			tablePane.add(headlinePanel, BorderLayout.NORTH);
			headlinePanel.setLayout(new BorderLayout(0, 0));
			
			JLabel headlineLabel = new JLabel("Choose one or more employees to check their performance");
			headlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
			headlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			headlinePanel.add(headlineLabel, BorderLayout.CENTER);
			
			JPanel topPanel = new JPanel();
			headlinePanel.add(topPanel, BorderLayout.WEST);
			topPanel.setLayout(new BorderLayout(0, 0));
			
			JButton backButton = setBackButton(topPanel);
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tablePane.setVisible(false);
					new HRMenu(name, frame, employee);
				}
			});
			
			Component verticalStrut_2 = Box.createVerticalStrut(11);
			headlinePanel.add(verticalStrut_2, BorderLayout.SOUTH);
		} catch (Exception e) {
			endMessage("An error has occured.", "HRMenu", name, frame, employee);
		}	
	}
}
