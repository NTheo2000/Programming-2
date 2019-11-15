public class Menu {
	// With this method we print our messages menu.
	public static void communicationMenu() {
		System.out.println("MENU: \n 1.Messages sent \n 2.Messages received \n 3.New message");
		System.out.print("Insert answer: ");

	}

	// The following method checks the response given from the user and each answer
	// is resulted to an outcome.
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
