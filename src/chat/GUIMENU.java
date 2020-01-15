import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import GUI_Classes.DirectorMenu;
import GUI_Classes.EmployeeMenu;
import GUI_Classes.HRMenu;
import GUI_Classes.LoginMenu;
import GUI_Classes.Settings;
import evaluateCandidates.Employee;

public class GUIMENU extends LoginMenu {

	private JFrame frame;
	private String firstname;
	private Employee employee;
	/**
	 * Create the application.
	 */
	public GUIMENU(String firstname, JFrame frame, Employee employee) {
		this.firstname = firstname;
		this.frame = frame;
		this.employee = employee;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			
			Menu.readFiles();
			JLayeredPane layeredPane = new JLayeredPane();
			frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
			layeredPane.setLayout(null);
			
			JButton btnNewMessage = new JButton("New Message");
			btnNewMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewMessage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					JLayeredPane panel = new JLayeredPane();
					panel.setBounds(10, 5, 382, 25);
					frame.getContentPane().add(panel, BorderLayout.CENTER);
					panel.setLayout(new BorderLayout(0, 0));
					panel.setVisible(true);
					CommunicationOutput output = new CommunicationOutput();
					output.newMessage(MainClass.holdid);
				}
			});
			btnNewMessage.setBounds(30, 90, 155, 49);
			layeredPane.add(btnNewMessage);
			
			JButton btnParticipatingChats = new JButton("Participating Chats");
			btnParticipatingChats.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnParticipatingChats.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					JLayeredPane panel = new JLayeredPane();
					panel.setBounds(10, 5, 382, 25);
					frame.getContentPane().add(panel, BorderLayout.CENTER);
					panel.setLayout(new BorderLayout(0, 0));
					panel.setVisible(true);
					CommunicationOutput output = new CommunicationOutput();
					output.allChats(MainClass.holdid);
				}
			});
			btnParticipatingChats.setBounds(210, 90, 189, 49);
			layeredPane.add(btnParticipatingChats);
			
			JButton btnSentMessages = new JButton("Sent Messages");
			btnSentMessages.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnSentMessages.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					JLayeredPane panel = new JLayeredPane();
					panel.setBounds(10, 5, 382, 25);
					frame.getContentPane().add(panel, BorderLayout.CENTER);
					panel.setLayout(new BorderLayout(0, 0));
					panel.setVisible(true);
					CommunicationOutput output = new CommunicationOutput();
					output.sentMessages(MainClass.holdid);
				}
			});
			btnSentMessages.setBounds(30, 155, 155, 49);
			layeredPane.add(btnSentMessages);
			
			JButton btnReceivedMessages = new JButton("Received Messages");
			btnReceivedMessages.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnReceivedMessages.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					JLayeredPane panel = new JLayeredPane();
					panel.setBounds(10, 5, 382, 25);
					frame.getContentPane().add(panel, BorderLayout.CENTER);
					panel.setLayout(new BorderLayout(0, 0));
					panel.setVisible(true);
					CommunicationOutput output = new CommunicationOutput();
					output.receivedMessages(MainClass.holdid);
				}
			});
			btnReceivedMessages.setBounds(210, 155, 189, 49);
			layeredPane.add(btnReceivedMessages);
			
			JLabel lblChatMenu = new JLabel("Chat Menu");
			lblChatMenu.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblChatMenu.setBounds(15, 16, 125, 20);
			layeredPane.add(lblChatMenu);
			
			JButton backButton = new JButton("Back");
			backButton.setIconTextGap(6);
			backButton.setHorizontalAlignment(SwingConstants.LEFT);
			backButton.setIcon(new ImageIcon(Settings.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/backspace-icon.png")));
			backButton.setBounds(0, 0, 100, 23);
			layeredPane.add(backButton);
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					layeredPane.setVisible(false);
					Menu.handleFiles();
					String[] dep = employee.getDepartment().split("\\s");
					if (dep[1].equals("Manager")) {
						new HRMenu(firstname, frame, employee);
					} else if (dep[1].equals("Director")) {
						new DirectorMenu(firstname, frame, employee);
					} else {
						new EmployeeMenu(firstname, frame, employee);
					}
				}
			});
		} catch (Exception e) {
			String[] dep = employee.getDepartment().split("\\s");
			if (dep[1].equals("Manager")) {
				endMessage("Error has occured.", "HRMenu", firstname, frame, employee);
			} else if (dep[1].equals("Director")) {
				endMessage("Error has occured.", "DirectorMenu", firstname, frame, employee);
			} else {
				endMessage("Error has occured.", "EmployeeMenu", firstname, frame, employee);
			}
		}
	}
}