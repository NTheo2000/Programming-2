public class Menu {
	
	public static void communicationMenu() {
		System.out.println("Communication Menu:");
		System.out.println("1. Sent messages");
		System.out.println("2. Received messages");
		System.out.println("3 New message");
	}

	public static void answer(int a, int id) {
		CommunicationOutput output = new CommunicationOutput();
		if (a == 1) {
			output.sentMessages(id);
			
		} else if (a == 2) {
			output.receivedMessages(id);
			
		} else if (a == 3) {
			output.newMessage(id);
			
		}

	}

}
