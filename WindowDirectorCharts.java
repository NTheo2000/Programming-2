import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Dimension;

public class WindowDirectorCharts {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowDirectorCharts window = new WindowDirectorCharts();
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
	public WindowDirectorCharts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
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
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnBarChart = new JButton("Score per question (Bar Chart)");
		btnBarChart.setPreferredSize(new Dimension(150, 23));
		panel_1.add(btnBarChart, BorderLayout.CENTER);
		
		Component verticalStrut_2 = Box.createVerticalStrut(55);
		panel_1.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component verticalStrut_3 = Box.createVerticalStrut(92);
		panel_1.add(verticalStrut_3, BorderLayout.SOUTH);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(8);
		panel_1.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(0);
		panel_1.add(horizontalStrut_3, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		layeredPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnPieChart = new JButton("Employee satisfaction level (Pie Chart)");
		btnPieChart.setPreferredSize(new Dimension(150, 23));
		panel_2.add(btnPieChart, BorderLayout.CENTER);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_4, BorderLayout.WEST);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(6);
		panel_2.add(horizontalStrut_5, BorderLayout.EAST);
		
		Component verticalStrut_4 = Box.createVerticalStrut(55);
		panel_2.add(verticalStrut_4, BorderLayout.NORTH);
		
		Component verticalStrut_5 = Box.createVerticalStrut(92);
		panel_2.add(verticalStrut_5, BorderLayout.SOUTH);
	}
}
