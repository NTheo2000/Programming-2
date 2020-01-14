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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import evaluateCandidates.Employee;
import evaluateCandidates.WorkersDatabase;
import evaluateEmployees.EvaluationEmployee;

public class EvaluateOperation extends LoginMenu {

	private JFrame frame;
	private Employee employee;
	private String name;
	private String[] dep;
	static int sum;
	private int count = 0; // the number of the current question
	private int total_questions = 0;
	private JLayeredPane tablePane;
	private int[] answers;
	private int row;
	/**
	 * Create the application.
	 */
	public EvaluateOperation(String name, JFrame frame, Employee employee) {
		this.name = name;
		this.frame = frame;
		this.employee = employee;
		dep = employee.getDepartment().split("\\s");
		sum = 0;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setVisible(true);
		if (dep[1].equals("Director")) {
			try {
				ArrayList<Employee> employees = WorkersDatabase.getEmployeesbyDirectorsDepartment(employee.getId());
				String[] columns = { "name", "id" };
				final String[][] data = new String[employees.size()][2];
				for (int i = 0; i < employees.size(); i++) {
					data[i][0] = employees.get(i).getFull_name();
					data[i][1] = employees.get(i).getId();
				}
				tablePane = new JLayeredPane();
				frame.getContentPane().add(tablePane, BorderLayout.CENTER);
				tablePane.setLayout(new BorderLayout(0, 0));
				tablePane.setVisible(true);
	
				JPanel tablePanel = new JPanel();
				tablePanel.setBackground(Color.LIGHT_GRAY);
				tablePane.add(tablePanel, BorderLayout.CENTER);
				tablePanel.setLayout(new BorderLayout(0, 0));
	
				final JTable jt = new JTable(data, columns);
				jt.setBackground(SystemColor.control);
				jt.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
				jt.setColumnSelectionAllowed(false);
				jt.setRowSelectionAllowed(true);
				jt.setModel(new DefaultTableModel(data, columns) {
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
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tablePane.setVisible(false);
						row = jt.getSelectedRow();
						if (EvaluationEmployee.check(data[row][1], dep[0])) {
							  int choice = JOptionPane.showOptionDialog(null, 
								      "You have already evaluated this employee!! Do you want to change your rating?", 
								      "Change evaluation", 
								      JOptionPane.YES_NO_OPTION, 
								      JOptionPane.QUESTION_MESSAGE, 
								      null, null, null);
							  if (choice == JOptionPane.YES_OPTION) {
									questions(EvaluationEmployee.questions);	
							  } else {
									endMessage("End of Evaluation", "DirectorMenu", name, frame, employee);
							  }
						} else {
							questions(EvaluationEmployee.questions);
						}
					}
				});
	
				Component horizontalStrut = Box.createHorizontalStrut(164);
				buttonPanel.add(horizontalStrut, BorderLayout.WEST);

				Component verticalStrut = Box.createVerticalStrut(17);
				buttonPanel.add(verticalStrut, BorderLayout.SOUTH);

				Component horizontalStrut_1 = Box.createHorizontalStrut(175);
				buttonPanel.add(horizontalStrut_1, BorderLayout.EAST);

				Component verticalStrut_1 = Box.createVerticalStrut(11);
				buttonPanel.add(verticalStrut_1, BorderLayout.NORTH);
	
				JPanel headlinePanel = new JPanel();
				tablePane.add(headlinePanel, BorderLayout.NORTH);
				headlinePanel.setLayout(new BorderLayout(0, 0));
	
				JLabel headlineLabel = new JLabel("Please select an employee:");
				headlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
				headlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
				headlinePanel.add(headlineLabel, BorderLayout.CENTER);
	
				JPanel topPanel = new JPanel();
				headlinePanel.add(topPanel, BorderLayout.WEST);
				topPanel.setLayout(new BorderLayout(0, 0));
				
				Component horizontalStrut_2 = Box.createHorizontalStrut(92);
				headlinePanel.add(horizontalStrut_2, BorderLayout.EAST);
	
				JButton backButton = setBackButton(topPanel);
				backButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tablePane.setVisible(false);
						new DirectorMenu(name, frame, employee);
					}
				});
				
			} catch (Exception e) {
				endMessage("An error has occured.", "DirectorMenu", name, frame, employee);
			}
		} else {
			try {
				answers = new int[Evaluationforgui.questions.length];
				questions(Evaluationforgui.questions);
			} catch (Exception e) {
				e.printStackTrace();
				endMessage("An error has occured.", "EmployeeMenu", name, frame, employee);
			}
		}
	}
	private void questions(String[] questions) {
		count++;
		if (count == 1) {
			total_questions = questions.length;
		}
		final int new_length = questions.length - 1;
		final String[] new_questions = new String[new_length];
		for (int i = 1; i < questions.length; i++) {
			new_questions[i - 1] = questions[i];
		}
		
		final JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		layeredPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel(questions[0]);
		lblNewLabel.setPreferredSize(new Dimension(353, 35));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel, BorderLayout.CENTER);

		Component horizontalStrut = Box.createHorizontalStrut(10);
		panel.add(horizontalStrut, BorderLayout.WEST);

		Component verticalStrut_1 = Box.createVerticalStrut(0);
		panel.add(verticalStrut_1, BorderLayout.SOUTH);

		Box horizontalBox = Box.createHorizontalBox();
		panel.add(horizontalBox, BorderLayout.EAST);
		
		JPanel topPanel = new JPanel();
		panel.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel topLabel = new JLabel("Question " + count + " of " + total_questions);
		topLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		topPanel.add(topLabel, BorderLayout.CENTER);
		
		JButton backButton = setBackButton(topPanel);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(false);
				if (dep[1].equals("Employee")) {
					new EmployeeMenu(name, frame, employee);
				} else {
					tablePane.setVisible(true);
				}
			}
		});
		
		Component verticalStrut = Box.createVerticalStrut(28);
		topPanel.add(verticalStrut, BorderLayout.SOUTH);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(95);
		topPanel.add(horizontalStrut_11, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtnNewRadioButton = new JRadioButton("1 (Absolutely Disagree)");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setPreferredSize(new Dimension(100, 25));
		panel_2.add(rdbtnNewRadioButton, BorderLayout.CENTER);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(false);
				if (dep[1].equals("Employee")) {
					answers[count - 1] = 1;
					if (new_length == 0) {
						try {
							Evaluationforgui.saveAnswers(answers, employee.getDirectorId());
							endMessage("End of Evaluation", "EmployeeMenu", name, frame, employee);
						} catch (Exception e1) {
							endMessage("An error has occured.", "EmployeeMenu", name, frame, employee);
						}
					} else {
						questions(new_questions);
					}
				} else {
					sum++;
					if (new_length == 0) {
						EvaluationEmployee.saving(sum, employee.getId(), dep[0]);
						endMessage("End of Evaluation", "DirectorMenu", name, frame, employee);
					} else {
						questions(new_questions);
					}
				}
			}
		});

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_1, BorderLayout.WEST);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_2, BorderLayout.EAST);

		Component verticalStrut_2 = Box.createVerticalStrut(34);
		panel_2.add(verticalStrut_2, BorderLayout.NORTH);

		Component verticalStrut_3 = Box.createVerticalStrut(3);
		panel_2.add(verticalStrut_3, BorderLayout.SOUTH);

		JPanel panel_3 = new JPanel();
		panel_3.setMaximumSize(new Dimension(32756, 32761));
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_3, BorderLayout.WEST);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_4, BorderLayout.EAST);

		Component verticalStrut_4 = Box.createVerticalStrut(7);
		panel_3.add(verticalStrut_4, BorderLayout.NORTH);
		
				JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("5 (Absolutely Agree)");
				panel_3.add(rdbtnNewRadioButton_4, BorderLayout.CENTER);
				rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
				rdbtnNewRadioButton_4.setPreferredSize(new Dimension(100, 25));
				rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						layeredPane.setVisible(false);
						if (dep[1].equals("Employee")) {
							answers[count - 1] = 5;
							if (new_length == 0) {
								try {
									Evaluationforgui.saveAnswers(answers, employee.getDirectorId());
									endMessage("End of Evaluation", "EmployeeMenu", name, frame, employee);
								} catch (Exception e1) {
									endMessage("An error has occured.", "EmployeeMenu", name, frame, employee);
								}
							} else {
								questions(new_questions);
							}
						} else {
							sum += 5;
							if (new_length == 0) {
								EvaluationEmployee.saving(sum, employee.getId(), dep[0]);
								endMessage("End of Evaluation", "DirectorMenu", name, frame, employee);
							} else {
								questions(new_questions);
							}
						}
					}
				});

		Component verticalStrut_5 = Box.createVerticalStrut(90);
		panel_3.add(verticalStrut_5, BorderLayout.SOUTH);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setMaximumSize(new Dimension(32762, 32756));
		panel_4.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));

		Component verticalStrut_9 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_9, BorderLayout.EAST);

		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_8, BorderLayout.WEST);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_7, BorderLayout.SOUTH);

		Component verticalStrut_8 = Box.createVerticalStrut(1);
		panel_5.add(verticalStrut_8, BorderLayout.NORTH);
		
				JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4 (Agree)");
				panel_5.add(rdbtnNewRadioButton_3, BorderLayout.CENTER);
				rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
				rdbtnNewRadioButton_3.setPreferredSize(new Dimension(100, 25));
				rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						layeredPane.setVisible(false);
						if (dep[1].equals("Employee")) {
							answers[count - 1] = 4;
							if (new_length == 0) {
								try {
									Evaluationforgui.saveAnswers(answers, employee.getDirectorId());
									endMessage("End of Evaluation", "EmployeeMenu", name, frame, employee);
								} catch (Exception e1) {
									endMessage("An error has occured.", "EmployeeMenu", name, frame, employee);
								}
							} else {
								questions(new_questions);
							}
						} else {
							sum += 4;
							if (new_length == 0) {
								EvaluationEmployee.saving(sum, employee.getId(), dep[0]);
								endMessage("End of Evaluation", "DirectorMenu", name, frame, employee);
							} else {
								questions(new_questions);
							}
						}
					}
				});

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BorderLayout(0, 0));

		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panel_6.add(horizontalStrut_9, BorderLayout.WEST);

		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		panel_6.add(horizontalStrut_10, BorderLayout.EAST);
						
								JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2 (Disagree)");
								panel_6.add(rdbtnNewRadioButton_1, BorderLayout.CENTER);
								rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
								rdbtnNewRadioButton_1.setPreferredSize(new Dimension(100, 28));
								rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										layeredPane.setVisible(false);
										if (dep[1].equals("Employee")) {
											answers[count - 1] = 2;
											if (new_length == 0) {
												try {
													Evaluationforgui.saveAnswers(answers, employee.getDirectorId());
													endMessage("End of Evaluation", "EmployeeMenu", name, frame, employee);
												} catch (Exception e1) {
													endMessage("An error has occured.", "EmployeeMenu", name, frame, employee);
												}
											} else {
												questions(new_questions);
											}
										} else {
											sum += 2;
											if (new_length == 0) {
												EvaluationEmployee.saving(sum, employee.getId(), dep[0]);
												endMessage("End of Evaluation", "DirectorMenu", name, frame, employee);
											} else {
												questions(new_questions);
											}
										}
									}
								});

		JPanel panel_7 = new JPanel();
		panel_7.setMaximumSize(new Dimension(32740, 32731));
		panel_4.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_7.add(horizontalStrut_5, BorderLayout.WEST);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_7.add(horizontalStrut_6, BorderLayout.EAST);

		Component verticalStrut_6 = Box.createVerticalStrut(-22);
		panel_7.add(verticalStrut_6, BorderLayout.NORTH);

		Component verticalStrut_7 = Box.createVerticalStrut(-20);
		panel_7.add(verticalStrut_7, BorderLayout.SOUTH);
		
				JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3 (Neither Disagree Nor Agree)");
				panel_7.add(rdbtnNewRadioButton_2, BorderLayout.CENTER);
				rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				rdbtnNewRadioButton_2.setPreferredSize(new Dimension(100, 25));
				rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						layeredPane.setVisible(false);
						if (dep[1].equals("Employee")) {
							answers[count - 1] = 3;
							if (new_length == 0) {
								try {
									Evaluationforgui.saveAnswers(answers, employee.getDirectorId());
									endMessage("End of Evaluation", "EmployeeMenu", name, frame, employee);
								} catch (Exception e1) {
									endMessage("An error has occured.", "EmployeeMenu", name, frame, employee);
								}
							} else {
								questions(new_questions);
							}
						} else {
							sum += 3;
							if (new_length == 0) {
								EvaluationEmployee.saving(sum, employee.getId(), dep[0]);
								endMessage("End of Evaluation", "DirectorMenu", name, frame, employee);
							} else {
								questions(new_questions);
							}
						}
					}
				});
	}
}
