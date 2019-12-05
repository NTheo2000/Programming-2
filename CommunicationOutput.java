import java.util.ArrayList;
import java.util.Scanner;

public class CommunicationOutput {

	/* Creation of lists, in order to save ids and messages */
	public static ArrayList<Integer> senter = new ArrayList<Integer>();
	public static ArrayList<Integer> receiver = new ArrayList<Integer>();
	public static ArrayList<String> message = new ArrayList<String>();

	/* This method returns the messages sent by the user */
	public void sentMessages(int id) {
		if (senter.size() == 0) {
			System.out.println("There are no sent messages\n");
		}
		for (int i = 0; i < senter.size(); i++) {
			int csent = 0;
			if (senter.get(i).equals(id)) {
				csent++;
				System.out.println("Message no: " + csent);
				System.out.println("Receiver's id: " + receiver.get(i));
				System.out.println("Message:\n" + message.get(i) + "\n\n");
			}
			if (csent == 0) {
				System.out.println("There are no sent messages\n");
			}
		}
	}

	/* This method returns the messages that the user received */
	public void receivedMessages(int id) {
		int creceived = 0;
		if (receiver.size() == 0) {
			System.out.println("There are no receiver messages\n");
		}
		for (int i = 0; i < receiver.size(); i++) {
			if (receiver.get(i).equals(id)) {
				creceived++;
				System.out.println("Message no: " + creceived);
				System.out.println("Senter's id: " + senter.get(i));
				System.out.print("Message:\n" + message.get(i) + "\n\n");
			}
			if (creceived == 0) {
				System.out.println("There are no received messages\n");
			}
		}
	}

	/* This method creates and sends a new message */
	public void newMessage(int id) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please, write your message.");
		String txt = in.next();
		int rid;
		int c = 0;
		System.out.println("Please write the ids of the employees you send the message to.");
		System.out.println("To stop press 0");
		do {
			do {
			rid = in.nextInt();
			if(rid == 0 && c != 0) {
				break;
			}
			else if(rid == 0 && c == 0) {
				System.out.println("You have to send the message to at least ne person. Please try again");
			}
			else if (Integer.toString(rid).length() != 8) {
				System.out.println("ids have exactly 8 digits. Please try again");
			}
			}while(Integer.toString(rid).length() != 8 || rid == 0);
			senter.add(id);
			message.add(txt);
			receiver.add(rid);
			c++;
		} while (rid != 0);
		System.out.print("Your message has been sent succesfully.\n\n");
	}
}
