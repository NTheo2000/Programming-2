import java.util.Scanner;
public class HandleExceptions {
	public static void handleEmailNotSentException(String address, String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you Like to retry sending the email?");
		String ans = sc.nextLine();
		if (ans.toLowerCase().startsWith("y")) {
			try {
				MakeCandidateEmployee.sendEmail(address, message);
			} catch (EmailNotSentException e) {
				System.out.println("Still failed to send the email.");
				handleEmailNotSentException(address, message);
			}
		}
		sc.close();
	}
}
