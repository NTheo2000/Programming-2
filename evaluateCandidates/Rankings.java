package evaluateCandidates;


import java.util.ArrayList;
import java.util.Comparator;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Rankings {
    @SuppressWarnings("unchecked")
	public static <Dep> ArrayList<Dep> sortByDepartment(JSONArray candidates, 
			String position) throws IOException, InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, ClassNotFoundException,
	NoSuchMethodException, SecurityException {
		Class<? extends Candidate> Dep = (Class<? extends Candidate>) Class.forName("EvaluateCandidates." + position);
		ArrayList<Dep> list = createListFromFile(candidates, Dep);
		Constructor<? extends Candidate> con = Dep.getConstructor();
		list.sort((Comparator<? super Dep>) con.newInstance());
		while (list.size() > 10) {
			list.remove(10);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static <Dep> ArrayList<Dep> createListFromFile(JSONArray candidates, 
			Class<? extends Candidate> Dep) 
					throws IOException, InstantiationException, IllegalAccessException, 
					IllegalArgumentException, InvocationTargetException, ClassNotFoundException,
					NoSuchMethodException, SecurityException {
		ArrayList<Dep> list = new ArrayList<Dep>();
		Constructor<? extends Candidate> con = Dep.getConstructor(JSONObject.class);
		for (Object candidate : candidates) {
			list.add((Dep) con.newInstance((JSONObject) candidate));
		}
		//separate each candidate from the file and store him to an ArrayList.
		
		return list;
	}
}