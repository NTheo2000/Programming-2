import java.util.Scanner;
public class test {
	public static void main (String [] args ){
		Employee sc = new Employee ();//*//
		Evaluation ev = new Evaluation(sc.getId());
		Scanner input = new Scanner(System.in);
		int a=52;
		do{
			System.out.println("Καλώς ήλθες στην εφαρμογή για την αξιολόγηση του Manager σου! \n Για να συνεχίσεις πατα 1!");
			int an=input.nextInt();
			if(an!=1){
				break;
			}else {

				System.out.println("Δώσε το id: ");
					int id=input.nextInt();
				while(!ev.yparxid(id)){
					System.out.println("Δεν υπάρχει το id. Αν θες να ξαναπροσπαθήσεις δώσε το id \n αλλιώς δώσε τιμή 0");
					id=input.nextInt();
					if(id==0){
						break;
					}
				}
				if(id==0){
					break;
				}
				if(ev.idExist(id)){
					System.out.println("Συγγνώμη έχει ήδη υποβάλει αξιολόγηση!" +"\n Θες να ακυρώσεις και να ξανα υποβάλεις (1/2) ; ");
					a=input.nextInt();
				}
				if ( a==1 || (ev.idExist(id )==false)){
					ev.questions(id);
				}
			}

		}while(true); //η επανάληψη υπάρχει για το αρχικό μενού. Θ αβροθμε μια συνθηκή όλοι μαζι ή θα σβήσοθμε τη επνάληψη//
	}
}






