import java.io.*;
import java.util.ArrayList;

public class Menu {

	/* This method prints the communication menu */
	public static void communicationMenu() {
		System.out.println("Communication Menu:");
		System.out.println("1. New message");
		System.out.println("2. Participating chats");
		System.out.println("3. Sent messages");
		System.out.println("4. Received messages");
		System.out.println("Press 0 to go back to the main menu.");
	}

	/*Files*/
	protected static void handleFiles() {
		File f1 = new File("chatidf.txt");
		File f2 = new File("messagef.txt");
		File f3 = new File("membersf.txt");
		File f4 = new File("cidf.txt");
		CommunicationOutput output = new CommunicationOutput();
		try {
			FileOutputStream fo1 = new FileOutputStream(f1);
			FileOutputStream fo2 = new FileOutputStream(f2);
			FileOutputStream fo3 = new FileOutputStream(f3);
			FileOutputStream fo4 = new FileOutputStream(f4);
			ObjectOutputStream d1 = new ObjectOutputStream(fo1);
			ObjectOutputStream d2 = new ObjectOutputStream(fo2);
			ObjectOutputStream d3 = new ObjectOutputStream(fo3);
			ObjectOutputStream d4 = new ObjectOutputStream(fo4);
			if (f1.length() != 0) {
				d1.flush();
			}
			if (f2.length() != 0) {
				d2.flush();
			}
			if (f3.length() != 0) {
				d3.flush();
			}
			if (f4.length() != 0) {
				d4.flush();
			}
			d1.writeObject(output.chatid);
			d2.writeObject(output.message);
			d3.writeObject(output.members);
			d4.writeObject(output.cid);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected void readFiles () throws ClassNotFoundException {
		File f1 = new File("chatidf.txt");
		File f2 = new File("messagef.txt");
		File f3 = new File("membersf.txt");
		File f4 = new File("cidf.txt");
		CommunicationOutput output = new CommunicationOutput();
		try {
			FileInputStream fo1 = new FileInputStream(f1);
			FileInputStream fo2 = new FileInputStream(f2);
			FileInputStream fo3 = new FileInputStream(f3);
			FileInputStream fo4 = new FileInputStream(f4);
			ObjectInputStream d1 = new ObjectInputStream(fo1);
			ObjectInputStream d2 = new ObjectInputStream(fo2);
			ObjectInputStream d3 = new ObjectInputStream(fo3);
			ObjectInputStream d4 = new ObjectInputStream(fo4);
			output.chatid = (ArrayList<String>) d1.readObject();
			output.message = (ArrayList<String>) d2.readObject();
			output.members = (ArrayList<String>) d3.readObject();
			output.cid = d4.read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* This method gets the user's answer and calls the wanted method */
	public static void answer(double a, String id) {
		CommunicationOutput output = new CommunicationOutput();
		if (a == 1) {
			output.newMessage(id);
		} else if (a == 2) {
			output.allChats(id);
		} else if (a == 3) {
			output.sentMessages(id);
		} else if (a == 4) {
			output.receivedMessages(id);
		} else if (a == 0) {
			handleFiles();
		}
	}

}