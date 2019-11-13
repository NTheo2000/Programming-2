import java.util.ArrayList;
public class Employee {
	private  ArrayList<Integer> id = new ArrayList<Integer>();
	public void  makeId (){
		for ( int i=0;i<5;i++){
			id.add(8180059+i);
		}
	}
	public ArrayList<Integer> getId (){
		makeId();
		return (id);
	}
}

