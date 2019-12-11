import java.util.*;
public class idMaker {
	static int m1=0;
	static int m2=0;
	private ArrayList<Integer> id_employers =  new ArrayList<Integer>();
	private ArrayList<Integer> id_employees =  new ArrayList<Integer>();
//**********************************//
	public void makeIdEmlpoyee (){
		for( int i=0;i<6;i++){
			id_employees.add(8180059+i);

		}
	}
	public ArrayList<Integer> getIdEmployee() {
		if(m1==0){
			makeIdEmlpoyee ();
			m1=1;
		}
		return id_employees ;
	}
	//****************************//
	public void makeIdEmlpoyers (){
		for( int i=0;i<2;i++){
			id_employees.add(7180059+i);

		}
	}
	public ArrayList<Integer> getIdEmloyer() {
			if(m2==0){
				makeIdEmlpoyers ();
				m2=1;
			}
			return id_employers ;
	}
}



















