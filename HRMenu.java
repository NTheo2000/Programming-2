import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Insets;

public class HRMenu extends LoginMenu{

	private JFrame frame = new JFrame();
	private String firstname = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRMenu window = new HRMenu();
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
	public HRMenu() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}
	public HRMenu(String name) {
		this.firstname = name;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public JLayeredPane initialize() {
		JLayeredPane panel = new JLayeredPane();
		panel.setBounds(10, 5, 382, 25);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel headlinePanel = new JPanel();
		panel.add(headlinePanel, BorderLayout.NORTH);
		headlinePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel welcomeLabel = new JLabel("Welcome, " + firstname);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		headlinePanel.add(welcomeLabel, BorderLayout.CENTER);
		
		JButton SettingsButton = new JButton("Settings");
		SettingsButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		headlinePanel.add(SettingsButton, BorderLayout.EAST);
		
		JPanel menuPanel = new JPanel();
		panel.add(menuPanel, BorderLayout.CENTER);
		menuPanel.setLayout(new BorderLayout(0, 0));
		
		JButton ev_candButton = new JButton("Evaluate Candidates");
		ev_candButton.setMargin(new Insets(0, 0, 0, 0));
		ev_candButton.setMinimumSize(new Dimension(150, 23));
		ev_candButton.setMaximumSize(new Dimension(150, 23));
		ev_candButton.setPreferredSize(new Dimension(150, 12));
		menuPanel.add(ev_candButton, BorderLayout.WEST);
		ev_candButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton ev_empButton = new JButton("Evaluate Employees");
		ev_empButton.setMargin(new Insets(0, 0, 0, 0));
		ev_empButton.setPreferredSize(new Dimension(130, 19));
		menuPanel.add(ev_empButton, BorderLayout.CENTER);
		ev_empButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton chatButton = new JButton("Chat");
		chatButton.setMargin(new Insets(0, 0, 0, 0));
		chatButton.setMinimumSize(new Dimension(130, 23));
		chatButton.setMaximumSize(new Dimension(130, 23));
		chatButton.setPreferredSize(new Dimension(130, 23));
		menuPanel.add(chatButton, BorderLayout.EAST);
		chatButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel menuLabel = new JLabel("Please select one of the following actions");
		menuLabel.setPreferredSize(new Dimension(197, 30));
		menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuPanel.add(menuLabel, BorderLayout.NORTH);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBackground(Color.ORANGE);
		verticalStrut.setForeground(Color.WHITE);
		headlinePanel.add(verticalStrut, BorderLayout.SOUTH);
		
		return panel;
	}
}
