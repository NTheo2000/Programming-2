import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GUIMENU extends LoginMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMENU window = new GUIMENU();
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
	public GUIMENU() {
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
		layeredPane.setLayout(new BorderLayout(0,0));
		
		JPanel panel = new JPanel();
		panel.getComponents();
		panel.add(layeredPane);
		panel.setLayout(new BorderLayout(0,0));
		
		
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
		lblChatMenu.setBounds(151, 16, 125, 20);
		layeredPane.add(lblChatMenu);
		
		//JPanel topPanel = new JPanel();
		//lblChatMenu.add(topPanel, BorderLayout.WEST);
		//topPanel.setLayout(new BorderLayout(0, 0));

		JButton backButton = setBackButton(panel);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.handleFiles();
			}
		});
	}

}
