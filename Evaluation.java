import java.util.Scanner;
import java.util.ArrayList;
public class Evaluation {
	private ArrayList<Integer> id_employee = new ArrayList<Integer>();
	public Evaluation ( ArrayList<Integer> id_employee ) {
		this.id_employee=id_employee;
	}
	public  boolean yparxid (int id){
		boolean a=false;
		for(int i=0;i<id_employee.size();i++){
			if (id_employee.get(i)==id){
				a=true;
			}
		}
		return a;
	}

	Scanner sc = new Scanner (System.in);
	private ArrayList<Integer> id = new ArrayList<Integer>();
	private ArrayList<Double> MO  = new ArrayList<Double>();
	private ArrayList<Double> Aver  = new ArrayList<Double>();
	public boolean idExist ( int ids ){ //μεδοοσ 1//
		if ( id.contains(ids)){
			return true;
		}else{
			return false ;
		}
	}
	public void questions ( int id){ //μεθοδος 2//
		int  a;
		int ids=id;
		int[] answers = new int[5];
		do{

			System.out.print("Ακολουθούν οι ερωτήσεις ( οι απαντήσεις βαθμολογούνται από 1-5): \n 1. q1 \n");
			answers[0]=sc.nextInt();
			System.out.print("q2\n");
			answers[1]=sc.nextInt();
			System.out.print("q3\n");
			answers[2]=sc.nextInt();
			System.out.print("q4\n");
			answers[3]=sc.nextInt();
			System.out.print("q5\n");
			answers[4]=sc.nextInt();
			System.out.print("Οι ερωτήσεις τελείωσαν. Είσαι σίγουρος για τισ απαντήσεις σου; \n Αν ναι απάντησε 1 \n Αν όχι απάντησε 2 \n Αν θες να ακυρώσεις εντελώς την διαδικασία απάντησε 3! :  ");
			a = sc.nextInt();
			if(a==1||a==3){
				break;
			}
		}while(true);
		if(a==1){
			inputEvaluation(answers,ids);
		}
	}
	public void inputEvaluation( int [] answers , int ids ){ //method 3 //
		int sum=0;
		for ( int i=0;i<5;i++){
			sum=sum+answers[i];
		}
		if (id.contains(ids)){
			int ind=id.indexOf(ids);
			id.remove(ind);
			MO.remove(ind);
		}
		id.add(ids);
		double mo=sum/5;
		MO.add(mo);
		double sum2=0;
		for( int i=0;i<MO.size();i++){
			sum2=sum2+MO.get(i);
		}
		//Aver.set(0,sum2/id.size());  prepei na vroume tous mines//
	}

}
































