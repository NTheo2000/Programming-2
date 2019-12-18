package ExerciseProgram2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize(); 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnMarketingEmployee = new JButton("Marketing Employee");
		btnMarketingEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMarketingEmployee.setBounds(43, 13, 160, 25);
		frame.getContentPane().add(btnMarketingEmployee);
		
		JButton btnItEmployee = new JButton("IT Employee");
		btnItEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnItEmployee.setBounds(43, 51, 160, 25);
		frame.getContentPane().add(btnItEmployee);
		
		JButton btnAccountingEmployee = new JButton("Accounting Employee");
		btnAccountingEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAccountingEmployee.setBounds(43, 89, 160, 25);
		frame.getContentPane().add(btnAccountingEmployee);
		
		JButton btnHrEmployee = new JButton("H-R Employee");
		btnHrEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHrEmployee.setBounds(43, 127, 160, 25);
		frame.getContentPane().add(btnHrEmployee);
		
		JButton btnMarketingDirector = new JButton("Marketing Director");
		btnMarketingDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMarketingDirector.setBounds(260, 13, 160, 25);
		frame.getContentPane().add(btnMarketingDirector);
		
		JButton btnItDirector = new JButton("IT Director");
		btnItDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnItDirector.setBounds(260, 51, 160, 25);
		frame.getContentPane().add(btnItDirector);
		
		JButton btnAccountingDirector = new JButton("Accounting Director");
		btnAccountingDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAccountingDirector.setBounds(260, 89, 160, 25);
		frame.getContentPane().add(btnAccountingDirector);
		
		JButton btnHrDirector = new JButton("H-R Director");
		btnHrDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHrDirector.setBounds(260, 127, 160, 25);
		frame.getContentPane().add(btnHrDirector);
	}
}
