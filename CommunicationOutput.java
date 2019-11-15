import java.util.ArrayList;
import java.util.Scanner;

public class CommunicationOutput {
	public static ArrayList<Integer> senter = new ArrayList<Integer>();
	public static ArrayList<Integer> receiver = new ArrayList<Integer>();
	public static ArrayList<String> message = new ArrayList<String>();

	public void sentMessages(int id) {
		int csent=0;
		for (int i = 0; i < senter.size(); i++) {
			if (senter.get(i).equals(id)) {
				System.out.println("Message sent: " + message.get(i) + "\nMessage receiver was: " + receiver.get(i));
				csent++;
			} 
			if (csent==0) {
				System.out.println("User has never sent a message.");
			}

		}
	}

	public void receivedMessages(int id) {
		int creceived=0;
		for (int i = 0; i < receiver.size(); i++) {
			if (receiver.get(i).equals(id)) {
				System.out.println("Message sent: " + message.get(i) + "\n Message senter was: " + senter.get(i));
				creceived++;
			}
			if (creceived==0) {
				System.out.println("User has never receive a message.");
			}
		}
	}

	public void newMessage(int id) {
		Scanner in = new Scanner(System.in);
		senter.add(id);
		System.out.print("Type message: ");
		String txt = in.nextLine();
		message.add(txt);
		System.out.print("Enter receiver's id here: ");
		int idr = in.nextInt();
		receiver.add(idr);

	}
}
