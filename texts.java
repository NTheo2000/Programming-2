import java.util.*;
import java.io.*;
public class texts {
	 public static void main (String[] args){
		WorkersDatabase ids = new WorkersDatabase();
		ArrayList<Integer> id = new ArrayList<Integer>();
		id_employee=ids.getAllEmployeeObjects();
		mkTextEmployee(id);
	}
	public static ArrayList<Integer[]> id_scores = new ArrayList<Integer[]>();
	public static void mkTextEmployee ( ArrayList<Integer> id_employee ){
		for(int i=0 ; i<id_employee.size();i++){
			Integer[] a = new Integer[] {id_employee.get(i),0,0,0,0,0,0,0,0,0,0};
			id_scores.add(a);
		}
		File file = new File ("C:\\Users\\AGGELOS\\Desktop\\Εργασία προγραμματισμού ΙΙ\\id_scores.txt");
		try {
	  		  FileOutputStream EmployeesFile = new FileOutputStream(file);
		      ObjectOutputStream EmployeesStream = new ObjectOutputStream(EmployeesFile);
		      EmployeesStream.writeObject(id_scores);
		      EmployeesStream.close();
		  }catch(Exception e){
		  }
	  }
  }

