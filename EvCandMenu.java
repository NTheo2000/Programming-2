package GUI_Classes;


import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.Map.Entry;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import evaluateCandidates.Candidate;
import evaluateCandidates.Employee;
import evaluateCandidates.MakeCandidateEmployee;
import evaluateCandidates.Rankings;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Dimension;

public class EvCandMenu extends LoginMenu{

	private JFrame frame;
	JLayeredPane depMenuPane;
	private String department;
	private String firstname;
	Employee employee;
	ArrayList<Candidate> candidates = new ArrayList<Candidate>();
	private int[] rows;
	HashMap<Candidate, Double> chosens = new HashMap<Candidate, Double>(); // a list for the candidates chosen by the HR Manager
																		   //The key represents the candidate and the value the starting salary

	/**
	 * Create the application.
	 */
	public EvCandMenu(String name, JFrame frame, Employee employee) {
		this.frame = frame;
		this.firstname = name;
		this.employee = employee;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setVisible(true);

		depMenuPane = new JLayeredPane();
		frame.getContentPane().add(depMenuPane, BorderLayout.CENTER);
		depMenuPane.setLayout(new BorderLayout(0, 0));
		depMenuPane.setVisible(true);
		
		JPanel headlinePanel = new JPanel();
		depMenuPane.add(headlinePanel, BorderLayout.NORTH);
		headlinePanel.setLayout(new BorderLayout(0, 0));

		JLabel headlineLabel = new JLabel("Please select one of the following departments");
		headlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		headlinePanel.add(headlineLabel, BorderLayout.CENTER);
		
		JPanel topPanel = new JPanel();
		headlinePanel.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));
		
		JButton backButton = setBackButton(topPanel);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depMenuPane.setVisible(false);
				new HRMenu(firstname, frame, employee);
			}
		});
		
		Component verticalStrut = Box.createVerticalStrut(30);
		topPanel.add(verticalStrut, BorderLayout.SOUTH);
		
		JPanel optionsPanel = new JPanel();
		depMenuPane.add(optionsPanel, BorderLayout.CENTER);
		optionsPanel.setLayout(new BorderLayout(0, 0));
		
		Component verticalStrut_1 = Box.createVerticalStrut(79);
		optionsPanel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component verticalStrut_2 = Box.createVerticalStrut(29);
		optionsPanel.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(107);
		optionsPanel.add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(106);
		optionsPanel.add(horizontalStrut_1, BorderLayout.EAST);
		
		JPanel buttonPanel = new JPanel();
		optionsPanel.add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel buttonPanel1 = new JPanel();
		buttonPanel.add(buttonPanel1, BorderLayout.WEST);
		buttonPanel1.setLayout(new BorderLayout(0, 0));
		
		JButton marketingButton = new JButton("Marketing");
		marketingButton.setMinimumSize(new Dimension(95, 35));
		marketingButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		marketingButton.setMaximumSize(new Dimension(95, 35));
		marketingButton.setPreferredSize(new Dimension(95, 35));
		buttonPanel1.add(marketingButton, BorderLayout.NORTH);
		marketingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depMenuPane.setVisible(false);
				department = "Marketing";
				posMenu();
			}
		});
		
		JButton accountingButton = new JButton("Accounting");
		accountingButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		accountingButton.setMinimumSize(new Dimension(95, 35));
		accountingButton.setMaximumSize(new Dimension(95, 35));
		accountingButton.setPreferredSize(new Dimension(95, 35));
		buttonPanel1.add(accountingButton, BorderLayout.SOUTH);
		accountingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depMenuPane.setVisible(false);
				department = "Accounting";
				posMenu();
			}
		});
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel.add(buttonPanel2, BorderLayout.EAST);
		buttonPanel2.setLayout(new BorderLayout(0, 0));
		
		JButton itButton = new JButton("IT");
		itButton.setMinimumSize(new Dimension(95, 35));
		itButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itButton.setPreferredSize(new Dimension(95, 35));
		itButton.setMaximumSize(new Dimension(95, 35));
		buttonPanel2.add(itButton, BorderLayout.NORTH);
		itButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depMenuPane.setVisible(false);
				department = "IT";
				posMenu();
			}
		});
		
		JButton hrButton = new JButton("HR");
		hrButton.setMinimumSize(new Dimension(95, 35));
		hrButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		hrButton.setMaximumSize(new Dimension(95, 35));
		hrButton.setPreferredSize(new Dimension(95, 35));
		buttonPanel2.add(hrButton, BorderLayout.SOUTH);
		hrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depMenuPane.setVisible(false);
				department = "HR";
				posMenu();
			}
		});
	}
	public void posMenu() {
		
		final JLayeredPane posMenuPane = new JLayeredPane();
		frame.getContentPane().add(posMenuPane, BorderLayout.CENTER);
		posMenuPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headlinePanel = new JPanel();
		posMenuPane.add(headlinePanel, BorderLayout.NORTH);
		headlinePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel headlineLabel = new JLabel("Please select a position for the department");
		headlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		headlinePanel.add(headlineLabel, BorderLayout.CENTER);
		
		JPanel topPanel = new JPanel();
		headlinePanel.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));
		
		JButton backButton = setBackButton(topPanel);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posMenuPane.setVisible(false);
				depMenuPane.setVisible(true);
				frame.validate();
				department = "";
			}
		});
		
		Component verticalStrut = Box.createVerticalStrut(30);
		topPanel.add(verticalStrut, BorderLayout.SOUTH);
		
		JPanel optionsPanel = new JPanel();
		posMenuPane.add(optionsPanel, BorderLayout.CENTER);
		optionsPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel optionsPanel1 = new JPanel();
		optionsPanel.add(optionsPanel1, BorderLayout.NORTH);
		optionsPanel1.setLayout(new BorderLayout(0, 0));
		
		JButton directorButton = new JButton("Director");
		directorButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		directorButton.setPreferredSize(new Dimension(95, 35));
		directorButton.setMaximumSize(new Dimension(95, 35));
		directorButton.setMinimumSize(new Dimension(95, 35));
		optionsPanel1.add(directorButton, BorderLayout.CENTER);
		directorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posMenuPane.setVisible(false);
				department += "_Director_Candidate";
				showList();
			}
		});
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(139);
		optionsPanel1.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(143);
		optionsPanel1.add(horizontalStrut_3, BorderLayout.EAST);
		
		Component verticalStrut_2 = Box.createVerticalStrut(27);
		optionsPanel1.add(verticalStrut_2, BorderLayout.NORTH);
		
		JPanel optionsPanel2 = new JPanel();
		optionsPanel.add(optionsPanel2, BorderLayout.SOUTH);
		optionsPanel2.setLayout(new BorderLayout(0, 0));
		
		JButton employeeButton = new JButton("Employee");
		employeeButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		employeeButton.setMinimumSize(new Dimension(95, 35));
		employeeButton.setMaximumSize(new Dimension(95, 35));
		employeeButton.setPreferredSize(new Dimension(95, 35));
		optionsPanel2.add(employeeButton, BorderLayout.CENTER);
		employeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posMenuPane.setVisible(false);
				department += "_Employee_Candidate";
				showList();
			}
		});
		
		Component verticalStrut_1 = Box.createVerticalStrut(75);
		optionsPanel2.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(139);
		optionsPanel2.add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(144);
		optionsPanel2.add(horizontalStrut_1, BorderLayout.EAST);
	}
	public void showList() {
		JSONParser parser = new JSONParser();
		JSONArray json_candidates;
		try {
			json_candidates = (JSONArray) parser.parse(new FileReader("Candidates.json"));
			candidates = Rankings.sortByDepartment(json_candidates, department);
			Vector<String> columnNames = new Vector<String>();
			columnNames.add("Name");
			columnNames.add("Age");
			columnNames.add("Years of experience");
			columnNames.add("Master");
			columnNames.add("PhD");
			if (department.equals("IT_Employee_Candidate") || department.equals("IT_Director_Candidate")) {
				columnNames.add("Programming languages");
			}	
			columnNames.add("Recommendation letter");
			columnNames.add("Languages");
			columnNames.add("Level of computer handling");
			columnNames.add("Total score");
			
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			for (Candidate c : candidates) {
				if (department.equals("IT_Employee_Candidate") || department.equals("IT_Director_Candidate")) {
					Vector<String> row = new Vector<String>();
					row.add(c.getFull_Name());
					row.add(String.valueOf(c.getAge()));
					row.add(String.valueOf(c.getFormer_experience()));
					row.add(c.getMaster());
					row.add(c.getPhD());
					row.add(String.valueOf(c.getNumber_of_programming_languages()));
					row.add(c.isRecommendation_letter() ? "Yes" : "No");
					row.add(c.getLanguages());
					row.add(String.valueOf(c.getLevel_of_computer_handling()));
					row.add(String.valueOf(c.getTotal_points()));
					data.add(row);
				} else {
					Vector<String> row = new Vector<String>();
					row.add(c.getFull_Name());
					row.add(String.valueOf(c.getAge()));
					row.add(String.valueOf(c.getFormer_experience()));
					row.add(c.getMaster());
					row.add(c.getPhD());
					row.add(c.isRecommendation_letter() ? "Yes" : "No");
					row.add(c.getLanguages());
					row.add(String.valueOf(c.getLevel_of_computer_handling()));
					row.add(String.valueOf(c.getTotal_points()));
					data.add(row);
				}
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
			select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			
			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(SystemColor.control);
			tablePanel.add(buttonPanel, BorderLayout.SOUTH);
			buttonPanel.setLayout(new BorderLayout(0, 0));
			
			JButton okButton = new JButton("Ok");
			okButton.setPreferredSize(new Dimension(45, 35));
			buttonPanel.add(okButton, BorderLayout.CENTER);
			okButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			Component horizontalStrut = Box.createHorizontalStrut(151);
			buttonPanel.add(horizontalStrut, BorderLayout.WEST);
			
			Component verticalStrut = Box.createVerticalStrut(17);
			buttonPanel.add(verticalStrut, BorderLayout.SOUTH);
			
			Component horizontalStrut_1 = Box.createHorizontalStrut(152);
			buttonPanel.add(horizontalStrut_1, BorderLayout.EAST);
			
			Component verticalStrut_1 = Box.createVerticalStrut(11);
			buttonPanel.add(verticalStrut_1, BorderLayout.NORTH);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rows = jt.getSelectedRows();
					if (rows.length != 0) {
						tablePane.setVisible(false);
						hireOrCall(candidates, rows);
					}
				}
			});
			
			JPanel headlinePanel = new JPanel();
			tablePane.add(headlinePanel, BorderLayout.NORTH);
			headlinePanel.setLayout(new BorderLayout(0, 0));
			
			JLabel headlineLabel = new JLabel("Ranking of the 10 candidates with the highest score");
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
					depMenuPane.setVisible(true);
					frame.validate();
				}
			});
			
			Component verticalStrut_2 = Box.createVerticalStrut(11);
			headlinePanel.add(verticalStrut_2, BorderLayout.SOUTH);
		} catch (Exception e) {
			endMessage("An error has occured.", "HRMenu", firstname, frame, employee);
		}	
	}
	public void hireOrCall(final ArrayList<Candidate> candidates, final int[] rows) {
		final Candidate candidate = candidates.get(rows[0]);
		
		final JLayeredPane hirePane = new JLayeredPane();
		frame.getContentPane().add(hirePane, BorderLayout.CENTER);
		hirePane.setLayout(new BorderLayout(0, 0));
		hirePane.setVisible(true);
		
		JPanel menuPanel = new JPanel();
		hirePane.add(menuPanel, BorderLayout.CENTER);
		menuPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel candidateLabel = new JLabel(candidate.getFull_Name() + ", " + candidate.getTotal_points() + " points");
		candidateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		candidateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuPanel.add(candidateLabel, BorderLayout.NORTH);
		
		JPanel interviewPanel = new JPanel();
		menuPanel.add(interviewPanel, BorderLayout.WEST);
		interviewPanel.setLayout(new BorderLayout(0, 0));
		
		final JButton interviewButton = new JButton("Call for Interview");
		interviewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		interviewPanel.add(interviewButton, BorderLayout.CENTER);
		interviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosens.put(candidate, (double) -1); // salary is set to -1 to represent that candidate is called for interview 
				hirePane.setVisible(false);
				frame.validate();
				int[] new_rows = new int[rows.length - 1];
				if (new_rows.length == 0) {
					finalstep(chosens);
				} else {
					for (int i = 1; i < rows.length; i++) {
						new_rows[i - 1] = rows[i];
					}
					hireOrCall(candidates, new_rows);
				}
			}
		});
		
		Component horizontalStrut = Box.createHorizontalStrut(82);
		interviewPanel.add(horizontalStrut, BorderLayout.WEST);
		
		Component verticalStrut_1 = Box.createVerticalStrut(38);
		interviewPanel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component verticalStrut_2 = Box.createVerticalStrut(26);
		interviewPanel.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(17);
		interviewPanel.add(horizontalStrut_1, BorderLayout.EAST);
		
		JPanel hirePanel = new JPanel();
		menuPanel.add(hirePanel, BorderLayout.EAST);
		hirePanel.setLayout(new BorderLayout(0, 0));
		
		final JButton hireButton = new JButton("Hire");
		hireButton.setPreferredSize(new Dimension(115, 23));
		hireButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		hirePanel.add(hireButton, BorderLayout.CENTER);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(15);
		hirePanel.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(91);
		hirePanel.add(horizontalStrut_3, BorderLayout.EAST);
		
		Component verticalStrut_3 = Box.createVerticalStrut(38);
		hirePanel.add(verticalStrut_3, BorderLayout.SOUTH);
		
		Component verticalStrut_4 = Box.createVerticalStrut(26);
		hirePanel.add(verticalStrut_4, BorderLayout.NORTH);
		
		JPanel setSalaryPanel = new JPanel();
		setSalaryPanel.setPreferredSize(new Dimension(10, 100));
		menuPanel.add(setSalaryPanel, BorderLayout.SOUTH);
		setSalaryPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel salaryLabelPanel = new JPanel();
		setSalaryPanel.add(salaryLabelPanel, BorderLayout.WEST);
		salaryLabelPanel.setLayout(new BorderLayout(0, 0));
		
		final JLabel salaryLabel = new JLabel("Set initial salary");
		salaryLabel.setPreferredSize(new Dimension(90, 19));
		salaryLabel.setMinimumSize(new Dimension(90, 19));
		salaryLabel.setMaximumSize(new Dimension(90, 19));
		salaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaryLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		salaryLabelPanel.add(salaryLabel);
		salaryLabel.setVisible(false);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(109);
		salaryLabelPanel.add(horizontalStrut_4, BorderLayout.WEST);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(22);
		salaryLabelPanel.add(horizontalStrut_5, BorderLayout.EAST);
		
		final JSpinner salarySpinner = new JSpinner();
		double starting_salary = candidate.getSTARTING_SALARY();
		salarySpinner.setModel(new SpinnerNumberModel(starting_salary, starting_salary, 1000000.0, 50.0));
		salarySpinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setSalaryPanel.add(salarySpinner, BorderLayout.CENTER);
		salarySpinner.setVisible(false);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(122);
		setSalaryPanel.add(horizontalStrut_6, BorderLayout.EAST);
		
		JPanel buttonPanel = new JPanel();
		setSalaryPanel.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new BorderLayout(0, 0));
		
		final JButton okButton = new JButton("Ok");
		okButton.setPreferredSize(new Dimension(45, 27));
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonPanel.add(okButton, BorderLayout.CENTER);
		okButton.setVisible(false);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(160);
		buttonPanel.add(horizontalStrut_7, BorderLayout.WEST);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		buttonPanel.add(verticalStrut_5, BorderLayout.NORTH);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(167);
		buttonPanel.add(horizontalStrut_9, BorderLayout.EAST);
		
		Component verticalStrut_6 = Box.createVerticalStrut(26);
		buttonPanel.add(verticalStrut_6, BorderLayout.SOUTH);
		
		JPanel headlinePanel = new JPanel();
		hirePane.add(headlinePanel, BorderLayout.NORTH);
		headlinePanel.setLayout(new BorderLayout(0, 0));
		
		JButton backButton = setBackButton(headlinePanel);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hirePane.setVisible(false);
				showList();
			}
		});
		
		Component verticalStrut = Box.createVerticalStrut(35);
		headlinePanel.add(verticalStrut, BorderLayout.SOUTH);
		
		hireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salaryLabel.setVisible(true);
				salarySpinner.setVisible(true);
				okButton.setVisible(true);
				interviewButton.setEnabled(false);
				hireButton.setEnabled(false);
				frame.validate();
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						hirePane.setVisible(false);
						double salary = (Double) salarySpinner.getValue();
						chosens.put(candidate, salary);
						int[] new_rows = new int[rows.length - 1];
						if (new_rows.length == 0) {
							finalstep(chosens);
						} else {
							for (int i = 1; i < rows.length; i++) {
								new_rows[i - 1] = rows[i];
							}
							hireOrCall(candidates, new_rows);
						}
					};
				});
			}
		});
	}
	public void finalstep(HashMap<Candidate, Double> chosens) {
		String[] columnNames = {"Name", "State", "Salary"};
		Iterator<Entry<Candidate, Double>> itr = chosens.entrySet().iterator(); 
		final String[][] data = new String[chosens.size()][3];
		final ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		int i = 0;
        while (itr.hasNext()) { 
			Entry<Candidate, Double> pair = itr.next(); 
			Candidate cand = pair.getKey();
            double salary = pair.getValue();
            candidates.add(cand);
            if (salary == (double) -1) {
            	String[] row = {cand.getFull_Name(), "Call for interview", "-"};
            	data[i] = row;
            } else {
            	String[] row = {cand.getFull_Name(), "Hire", String.valueOf(salary)};
            	data[i] = row;
            }
            i++;
        }

        final JLayeredPane finalPane = new JLayeredPane();
		frame.getContentPane().add(finalPane, BorderLayout.CENTER);
		finalPane.setLayout(new BorderLayout(0, 0));
		finalPane.setVisible(true);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(Color.LIGHT_GRAY);
		finalPane.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		JTable jt = new JTable(data, columnNames);
		jt.setBackground(SystemColor.control);
		jt.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		jt.setColumnSelectionAllowed(false);
		jt.setRowSelectionAllowed(false);
		jt.setModel(new DefaultTableModel(data, columnNames) {
			/**
			 * 
			 **/
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		JScrollPane scrollPane = new JScrollPane(jt);
		jt.setFillsViewportHeight(true);
		tablePanel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel confirmPanel = new JPanel();
		confirmPanel.setBackground(SystemColor.control);
		tablePanel.add(confirmPanel, BorderLayout.SOUTH);
		confirmPanel.setLayout(new BorderLayout(0, 0));
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setPreferredSize(new Dimension(45, 35));
		confirmPanel.add(confirmButton, BorderLayout.CENTER);
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		Component horizontalStrut = Box.createHorizontalStrut(151);
		confirmPanel.add(horizontalStrut, BorderLayout.WEST);
		
		Component verticalStrut = Box.createVerticalStrut(17);
		confirmPanel.add(verticalStrut, BorderLayout.SOUTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(152);
		confirmPanel.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut_1 = Box.createVerticalStrut(9);
		
		confirmPanel.add(verticalStrut_1, BorderLayout.NORTH);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalPane.setVisible(false);
				try {
					for (int i = 0; i < data.length; i++) {
						if (data[i][1].equals("Hire")) {
							MakeCandidateEmployee.hire(candidates.get(i), Double.valueOf(data[i][2]), department);
						}
		        	}
					endMessage("The actions have been successfully executed!", "HRMenu", firstname, frame, employee);
				} catch (Exception e1) {
						endMessage("An error has occured", "HRMenu", firstname, frame, employee);
				}
			}
		});
		
		JPanel headlinePanel = new JPanel();
		finalPane.add(headlinePanel, BorderLayout.NORTH);
		headlinePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel headlineLabel = new JLabel("State of the candidates");
		headlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		headlinePanel.add(headlineLabel, BorderLayout.CENTER);
		
		Component verticalStrut_2 = Box.createVerticalStrut(14);
		headlinePanel.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component verticalStrut_4 = Box.createVerticalStrut(7);
		headlinePanel.add(verticalStrut_4, BorderLayout.SOUTH);
		
		JPanel cancelPanel = new JPanel();
		cancelPanel.setPreferredSize(new Dimension(10, 53));
		finalPane.add(cancelPanel, BorderLayout.SOUTH);
		cancelPanel.setLayout(new BorderLayout(0, 0));
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cancelPanel.add(cancelButton, BorderLayout.CENTER);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalPane.setVisible(false);
				showList();
			}
		});
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(151);
		cancelPanel.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(154);
		cancelPanel.add(horizontalStrut_3, BorderLayout.EAST);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		cancelPanel.add(verticalStrut_3, BorderLayout.SOUTH);
	}
}
