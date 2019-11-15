import java.util.ArrayList;
import java.util.Scanner;

public class CommunicationOutput {

	public static ArrayList<Integer> senter = new ArrayList<Integer>();
	public static ArrayList<Integer> receiver = new ArrayList<Integer>();
	public static ArrayList<String> message = new ArrayList<String>();
	
	public void sentMessages(int id) {
		for(int i = 0; i < senter.size(); i++) {
			int no = 0;
			if(senter.get(i).equals(id)) {
				no++;
				System.out.println("Message no: " + no);
				System.out.println("Receiver's id: " + receiver.get(i));
				System.out.println("Message:\n" +message.get(i) + "\n\n");
			}
			if(no == 0) {
				System.out.println("There are no sent messages");
			}
		}
	}

	
	public void receivedMessages(int id) {
		int no = 0;
		for(int i = 0; i < receiver.size(); i++){
			if (receiver.get(i).equals(id)) {
				no++;
				System.out.println("Message no: " + no);
				System.out.println("Senter's id: " + senter.get(i));
				System.out.print("Message:\n" +message.get(i) + "\n\n");
			}
			if(no == 0) {
				System.out.println("There are no received messages");
			}
		}
	}
	
	public void newMessage(int id) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please, write your message.");
		String txt = in.next();
		int answer;
		do {
		System.out.println("Please write the id of the employee you send the message to.");
		int rid = in.nextInt();
		senter.add(id);
		message.add(txt);
		receiver.add(rid);
		System.out.println("Would you like to send the message to any other employees?(Y=1/N=2)");
		answer = in.nextInt();
		}while(answer == 1);
		System.out.print("Your message has been sent succesfully.\n\n");
	}
}
	
	
	
