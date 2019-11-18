
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Rankings {
	
	@SuppressWarnings("unchecked")
	public static <Dep> ArrayList<Dep> sortByDepartment(JSONArray employees, 
			String position) throws IOException, InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, ClassNotFoundException,
	NoSuchMethodException, SecurityException {
		Class<? extends Candidate> Dep = (Class<? extends Candidate>) Class.forName(position);
		ArrayList<Dep> list = createListFromFile(employees, Dep);
		
		Collections.sort(list, new Comparator<Dep>() {
		    public int compare(Dep o1, Dep o2) {
		       return (int) (((Candidate) o2).getTotal_points() - ((Candidate) o1).getTotal_points());
		    }
		 });
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static <Dep> ArrayList<Dep> createListFromFile(JSONArray employees, 
			Class<? extends Candidate> Dep) 
					throws IOException, InstantiationException, IllegalAccessException, 
					IllegalArgumentException, InvocationTargetException, ClassNotFoundException,
					NoSuchMethodException, SecurityException {
		ArrayList<Dep> list = new ArrayList<Dep>();
		Constructor<? extends Candidate> con = Dep.getConstructor(JSONObject.class, String.class);
		for(Object employee : employees) {
			list.add((Dep) con.newInstance((JSONObject) employee, "employee"));
		}
		//separate each candidate from the file and store him to an ArrayList.
		
		return list;
	}
}