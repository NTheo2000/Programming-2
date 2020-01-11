package GuiClasses;

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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import evaluationEmployees.EvaluationEmployee;
import jobHirring.Employee;
import jobHirring.WorkersDatabase;

public class EvaluationEmployeeMenu extends LoginMenu {

	private JFrame frame;
	private Employee employee;
	private String name;
	private String[] words;
	static int sum;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public EvaluationEmployeeMenu(String name, JFrame frame, Employee employee) {
		this.name = name;
		this.frame = frame;
		this.employee = employee;
		words = this.employee.getDepartment().split(" ");
		sum = 0;
		initialize();
	}

	public EvaluationEmployeeMenu() {

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setVisible(true);

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		try {

			ArrayList<Employee> employees = WorkersDatabase.getEmployeesbyDirectorsDepartment(employee.getId());
			String[] columns = { "name", "id" };
			String[][] settings = new String[employees.size()][2];
			for (int i = 0; i < employees.size(); i++) {
				settings[i][0] = employees.get(i).getFull_name();
				settings[i][1] = employees.get(i).getId();
			}
			JLayeredPane tablePane = new JLayeredPane();
			frame.getContentPane().add(tablePane, BorderLayout.CENTER);
			tablePane.setLayout(new BorderLayout(0, 0));
			tablePane.setVisible(true);

			JPanel tablePanel = new JPanel();
			tablePanel.setBackground(Color.LIGHT_GRAY);
			tablePane.add(tablePanel, BorderLayout.CENTER);
			tablePanel.setLayout(new BorderLayout(0, 0));

			JTable jt = new JTable(settings, columns);
			jt.setBackground(SystemColor.control);
			jt.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
			jt.setColumnSelectionAllowed(false);
			jt.setRowSelectionAllowed(true);
			jt.setModel(new DefaultTableModel(settings, columns) {
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
					int row = jt.getSelectedRow();
					if (EvaluationEmployee.check(settings[row][1], words[0])) {
						checkPanel(settings[row][1]);
					}

					for (int i = 0; i < 10; i++) {
						questions(EvaluationEmployee.questions[i]);
					}
					end(settings[row][1]);
				}
			});

			Component horizontalStrut = Box.createHorizontalStrut(151);
			buttonPanel.add(horizontalStrut, BorderLayout.WEST);

			Component verticalStrut = Box.createVerticalStrut(17);
			buttonPanel.add(verticalStrut, BorderLayout.SOUTH);

			Component horizontalStrut_1 = Box.createHorizontalStrut(152);
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

			JButton backButton = setBackButton(topPanel);
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tablePane.setVisible(false);
					frame.validate();
				}
			});

			Component verticalStrut_2 = Box.createVerticalStrut(11);

		} catch (Exception e) {
			e.printStackTrace();
			endMessage("An error has occured.", "DirectorMenu", frame);
		}
	}

	public void checkPanel(String id) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		layeredPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("                        You have already evaluated this employee!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("                         Do you want to change your ratining?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		layeredPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new BorderLayout(0, 0));

		JButton btnNewButton = new JButton("YES");
		btnNewButton.setPreferredSize(new Dimension(80, 40));
		panel_3.add(btnNewButton, BorderLayout.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EvaluationEmployee.delete(id, words[0]);
				return;
			}
		});

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut, BorderLayout.WEST);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_1, BorderLayout.EAST);

		Component verticalStrut = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut, BorderLayout.NORTH);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_1, BorderLayout.SOUTH);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new BorderLayout(0, 0));

		JButton btnNewButton_1 = new JButton("NO");
		btnNewButton_1.setPreferredSize(new Dimension(80, 40));
		panel_4.add(btnNewButton_1, BorderLayout.CENTER);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endMessage("End of Evaluation.", "DirectorMenu", frame);
			}
		});

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_2, BorderLayout.WEST);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_3, BorderLayout.EAST);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_2, BorderLayout.SOUTH);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_3, BorderLayout.NORTH);
	}

	public void questions(String label) {
		frame = new JFrame();
		frame.setBounds(100, 100, 614, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		layeredPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel(label);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut, BorderLayout.WEST);

		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut, BorderLayout.NORTH);

		Component verticalStrut_1 = Box.createVerticalStrut(0);
		panel.add(verticalStrut_1, BorderLayout.SOUTH);

		Box horizontalBox = Box.createHorizontalBox();
		panel.add(horizontalBox, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtnNewRadioButton = new JRadioButton("1 (Absolutely Disagree)");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setPreferredSize(new Dimension(100, 25));
		panel_2.add(rdbtnNewRadioButton, BorderLayout.CENTER);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum++;

			}
		});

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_1, BorderLayout.WEST);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_2, BorderLayout.EAST);

		Component verticalStrut_2 = Box.createVerticalStrut(64);
		panel_2.add(verticalStrut_2, BorderLayout.NORTH);

		Component verticalStrut_3 = Box.createVerticalStrut(1);
		panel_2.add(verticalStrut_3, BorderLayout.SOUTH);

		JPanel panel_3 = new JPanel();
		panel_3.setMaximumSize(new Dimension(32756, 32761));
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2 (Disagree)");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setPreferredSize(new Dimension(100, 25));
		panel_3.add(rdbtnNewRadioButton_1, BorderLayout.CENTER);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = sum + 2;

			}
		});

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_3, BorderLayout.WEST);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_4, BorderLayout.EAST);

		Component verticalStrut_4 = Box.createVerticalStrut(0);
		panel_3.add(verticalStrut_4, BorderLayout.NORTH);

		Component verticalStrut_5 = Box.createVerticalStrut(60);
		panel_3.add(verticalStrut_5, BorderLayout.SOUTH);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setMaximumSize(new Dimension(32762, 32756));
		panel_4.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3 (Neither Disagree Nor Agree)");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_2.setPreferredSize(new Dimension(100, 25));
		panel_5.add(rdbtnNewRadioButton_2, BorderLayout.CENTER);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = sum + 3;

			}
		});

		Component verticalStrut_9 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_9, BorderLayout.EAST);

		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_8, BorderLayout.WEST);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_7, BorderLayout.SOUTH);

		Component verticalStrut_8 = Box.createVerticalStrut(1);
		panel_5.add(verticalStrut_8, BorderLayout.NORTH);

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4 (Agree)");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_3.setPreferredSize(new Dimension(100, 25));
		panel_6.add(rdbtnNewRadioButton_3, BorderLayout.CENTER);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = sum + 4;

			}
		});

		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panel_6.add(horizontalStrut_9, BorderLayout.WEST);

		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		panel_6.add(horizontalStrut_10, BorderLayout.EAST);

		JPanel panel_7 = new JPanel();
		panel_7.setMaximumSize(new Dimension(32740, 32731));
		panel_4.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("5 (Absolutely Agree)");
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_4.setPreferredSize(new Dimension(100, 25));
		panel_7.add(rdbtnNewRadioButton_4, BorderLayout.CENTER);
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum = sum + 5;

			}
		});

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_7.add(horizontalStrut_5, BorderLayout.WEST);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_7.add(horizontalStrut_6, BorderLayout.EAST);

		Component verticalStrut_6 = Box.createVerticalStrut(-32);
		panel_7.add(verticalStrut_6, BorderLayout.NORTH);

		Component verticalStrut_7 = Box.createVerticalStrut(-30);
		panel_7.add(verticalStrut_7, BorderLayout.SOUTH);

	}

	public void end(String id) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel label = new JLabel("End of Evaluation");
		panel.add(label);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(0, 0));

		Component horizontalStrut = Box.createHorizontalStrut(36);
		panel_2.add(horizontalStrut, BorderLayout.WEST);

		Component horizontalStrut_1 = Box.createHorizontalStrut(47);
		panel_2.add(horizontalStrut_1, BorderLayout.EAST);

		Component verticalStrut = Box.createVerticalStrut(97);
		panel_2.add(verticalStrut, BorderLayout.NORTH);

		Component verticalStrut_1 = Box.createVerticalStrut(67);
		panel_2.add(verticalStrut_1, BorderLayout.SOUTH);

		JButton btnSubmission = new JButton("Submission");
		panel_2.add(btnSubmission, BorderLayout.CENTER);
		btnSubmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EvaluationEmployee.saving(sum, id, words[0]);
				endMessage("Successful Submision.", "DirectorMenu", frame);
			}
		});

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));

		Component horizontalStrut_2 = Box.createHorizontalStrut(39);
		panel_3.add(horizontalStrut_2, BorderLayout.WEST);

		Component horizontalStrut_3 = Box.createHorizontalStrut(36);
		panel_3.add(horizontalStrut_3, BorderLayout.EAST);

		Component verticalStrut_2 = Box.createVerticalStrut(65);
		panel_3.add(verticalStrut_2, BorderLayout.SOUTH);

		Component verticalStrut_3 = Box.createVerticalStrut(98);
		panel_3.add(verticalStrut_3, BorderLayout.NORTH);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(97, 25));
		panel_3.add(btnCancel, BorderLayout.CENTER);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endMessage("Unsuccessful Submision.", "DirectorMenu", frame);
			}
		});

	}

}
