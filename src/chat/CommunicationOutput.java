package chat;

import java.util.ArrayList;
import java.util.Scanner;

public class CommunicationOutput {

	/* Creation of lists, in order to save ids and messages */
	protected static ArrayList<String> chatid = new ArrayList<String>();
	protected static ArrayList<String> members = new ArrayList<String>();
	protected static ArrayList<String> message = new ArrayList<String>();

	private static ArrayList<String> chatmembers = new ArrayList<String>();
	private static ArrayList<Integer> membernumber = new ArrayList<Integer>();

	protected static int cid = 0;

	/* This method returns the messages sent by the user */
	protected void sentMessages(String id) {
		if (message.size() == 0) {
			System.out.println("There are no sent messages\n");
		}
		for (int i = 0; i < message.size(); i++) {
			int csent = 0;
			if (members.get(i).contains(id)) {
				if (message.get(i).contains(id)) {
					csent++;
					System.out.print("You have sent a message in chat " + chatid.get(i));
					System.out.println(" Members of the chat: " + members.get(i));
					System.out.println("Message:\n" + message.get(i) + "\n");
				}
			}
			if (csent == 0) {
				System.out.println("There are no sent messages\n");
			}
		}
	}

	/* This method returns the messages that the user received */
	protected void receivedMessages(String id) {
		int creceived = 0;
		if (message.size() == 0) {
			System.out.println("There are no received messages\n");
		} else {
			for (int i = 0; i < message.size(); i++) {
				if (message.get(i).equals(id)) {
					if (!message.get(i).contains(id)) {
						creceived++;
						System.out.print("You have received a message in chat " + chatid.get(i));
						System.out.println(" Members of chat: " + members.get(i));
						System.out.println("Message:\n" + message.get(i) + "\n");
					}
				}
				if (creceived == 0) {
					System.out.println("There are no received messages\n");
				}
			}
		}
	}

	/* This method creates and sends a new message */
	protected void newMessage(String id) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please write your message");
		String mes = id + ": " + in.next();
		if (chatid.size() != 0) {
			chatMembers(id);
			if (existingChats(id) == true) {
				int chid = findChatId();
				chatid.add(chatid.get(chid));
				members.add(members.get(chid));
			} else {
				newChat(id);
			}
		} else {
			chatMembers(id);
			newChat(id);
		}
		message.add(mes);
	}

	// This method creates a new Chat
	protected void newChat(String id) {
		Scanner in = new Scanner(System.in);
		int c = 0;
		chatid.add(Integer.toString(cid));
		cid++;
		c++;
		membernumber.add(c);
		String sure = "N";
		String allids = "";
		for (int i = 0; i < chatmembers.size(); i++) {
			allids = allids + chatmembers.get(i) + " ";
			c++;
		}
		do {
			System.out.println("These are the ids of the employees submitted in the chat: \n" + allids);
			System.out.println("Do you wish to continue? (Y or N)");
			sure = in.nextLine();
			do {
				// if (sure.length() != 1) {
				if ((!sure.contentEquals("Y")) && (!sure.contentEquals("N"))) {
					System.out.println("Please insert only Y or N.");
					sure = in.nextLine();
					// }
				}
			} while (/* (sure.length() != 1) && */ (!sure.contentEquals("Y")) && (!sure.contentEquals("N")));
			if (sure.equals("N")) {
				chatmembers.clear();
				chatMembers(id);
				c = 1;
				allids = "";
				for (int i = 0; i < chatmembers.size(); i++) {
					allids = allids + chatmembers.get(i) + " ";
					c++;
				}
			} else {
				members.add(allids);
				membernumber.add(c);
			}

		} while (!sure.equals("Y"));

	}

	// This method checks for existing chats
	protected boolean existingChats(String id) {
		String tst;
		int countID = 0;
		boolean a = false;
		for (int c = 0; c < members.size(); c++) {
			countID = members.get(c).length() / 9;
			if (countID == chatmembers.size()) {
				for (int i = 0; i < chatmembers.size(); i++) {
					tst = chatmembers.get(c);
					if (members.get(c).contains(chatmembers.get(i))) {
						a = true;
					} else {
						a = false;
						break;
					}
				}
				if (a == false) {
					break;
				}
			}

		}
		if (a == true) {
			System.out.println("This chat already exists.");
		}
		return a;
	}

	// This method prints the chat in which the user participates
	protected void allChats(String id) {
		Scanner in = new Scanner(System.in);
		String testid = "";
		boolean k = false;
		if (chatid.size() == 0) {
			System.out.println("There are no chats in which you participate.\n");
		} else {
			for (int i = 0; i < chatid.size(); i++) {
				if (members.get(i).contains(id) && !testid.contains(chatid.get(i))) {
					System.out
							.println("You participate in chat: " + chatid.get(i) + " with members: " + members.get(i));
					testid = testid + chatid.get(i) + " ";
					k = true;
				}
			}
			String answer = "";
			System.out.println("Insert the id of the chat you would like to see or press N to exit.");
			int an = 0;

			do {
				try {
					answer = in.next();
					if (!answer.equals("N")) {
						an = Integer.parseInt(answer);
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Please insert an integer chat id, or press N to exit.");
				}
			} while (true);
			if (!answer.equals("N")) {
				do {
					for (int i = 0; i < chatid.size(); i++) {
						if (chatid.get(i).equals(answer)) {
							if (members.get(i).contains(id)) {
								System.out.println(message.get(i));
							} else {
								System.out.println("You do not participate in this chat.");
							}
						} else if (an > cid || an < 0) {
							System.out.println("This chat does not exist");
						}
					}
					System.out.println("Insert the id of the chat you would like to see or press N to exit.");
					answer = in.next();
				} while (!answer.equals("N"));
			}
			if (k = false) {
				System.out.println("There are no chats in which you participate. I'm sorry...\n");
			}
		}
	}

	// This method inserts the ids of the users who participate in a chat
	protected void chatMembers(String id) {
		Scanner in = new Scanner(System.in);
		int c = 0;
		if (c == 0 && chatmembers.isEmpty()) {
			chatmembers.add(id);
		} else {
			chatmembers.clear();
			chatmembers.add(id);
		}
		String rid = "";
		int intrid = 0;
		System.out.println("Please write the ids of the employees you would like to select.");
		System.out.println("To stop press 0");
		do {
			do {
				do {
					try {
						rid = in.next();
						intrid = Integer.parseInt(rid);
						break;
					} catch (NumberFormatException e) {
						System.out.println("ids are numbers with 8 digits.");
					}
				} while (true);
				if (rid.equals("0") && c != 0) {
					break;
				} else if (rid.equals("0") && c == 0) {
					System.out.println("You have to select at least one person. Please try again");
				} else if (rid.length() != 8) {
					System.out.println("ids have exactly 8 digits. Please try again");
				}
			} while (rid.length() != 8 || rid.equals("0"));
			if (!rid.equals("0")) {
				if (!rid.equals(id) && !chatmembers.contains(rid)) {
					chatmembers.add(rid);
				} else {
					System.out.println("This id is already in the chat");
				}
			}
			c++;
		} while (!rid.equals("0"));
	}

	// This method finds the id of the needed chat
	private int findChatId() {
		String tst;
		boolean b = false;
		int i = 0;
		while (i < members.size()) {
			for (int c = 0; c < chatmembers.size(); c++) {
				tst = chatmembers.get(c);
				if (members.get(i).contains(chatmembers.get(c))) {
					b = true;
				} else {
					b = false;
					break;
				}
			}
			if (b == false) {
				break;
			} else {
				return i;
			}

		}

		return cid;
	}

}