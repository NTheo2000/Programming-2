
public class Menu {
	
	/*This method prints the communication menu*/
	public static void communicationMenu() {
		System.out.println("Communication Menu:");
		System.out.println("1. Sent messages");
		System.out.println("2. Received messages");
		System.out.println("3 New message");
	}

	/*This method gets the user's answer and calls the wanted method*/
	public static void answer(double a, int id) {
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
