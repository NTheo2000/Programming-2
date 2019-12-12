import java.util.ArrayList;
import java.util.Scanner;

public class CommunicationOutput {

	/* Creation of lists, in order to save ids and messages */
	public static ArrayList<String> senter = new ArrayList<String>();
	public static ArrayList<String> receiver = new ArrayList<String>();
	public static ArrayList<String> message = new ArrayList<String>();

	/* This method returns the messages sent by the user */
	public void sentMessages(String id) {
		if (senter.size() == 0) {
			System.out.println("There are no sent messages\n");
		}
		for (int i = 0; i < senter.size(); i++) {
			int csent = 0;
			if (senter.get(i).equals(id)) {
				csent++;
				System.out.println(csent + ":");
				System.out.println("Receiver's id: " + receiver.get(i));
				System.out.println("Message:\n" + message.get(i) + "\n\n");
			}
			if (csent == 0) {
				System.out.println("There are no sent messages\n");
			}
		}
	}

	/* This method returns the messages that the user received */
	public void receivedMessages(String id) {
		int creceived = 0;
		if (receiver.size() == 0) {
			System.out.println("There are no received messages\n");
		}
		for (int i = 0; i < receiver.size(); i++) {
			if (receiver.get(i).equals(id)) {
				creceived++;
				System.out.println(creceived + ":");
				System.out.println("Senter's id: " + senter.get(i));
				System.out.print("Message:\n" + message.get(i) + "\n\n");
			}
			if (creceived == 0) {
				System.out.println("There are no received messages\n");
			}
		}
	}

	/* This method creates and sends a new message */
	public void newMessage(String id) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please, write your message.");
		String txt = in.next();
		String rid;
		int c = 0;
		System.out.println("Please write the ids of the employees you send the message to.");
		System.out.println("To stop press 0");
		do {
			do {
			rid = in.next();
			if(rid.equals("0") && c != 0) {
				break;
			}
			else if(rid.equals("0") && c == 0) {
				System.out.println("You have to send the message to at least ne person. Please try again");
			}
			else if (rid.length() != 8) {
				System.out.println("ids have exactly 8 digits. Please try again");
			}
			}while(rid.length() != 8 || rid.equals("0"));
			if (!rid.contentEquals("0")) {
			senter.add(id);
			message.add(txt);
			receiver.add(rid);
			}
			c++;
		} while (!rid.equals("0"));
		System.out.print("Your message has been sent succesfully.\n\n");
	}
}
