package evaluationCandidate;

import java.util.ArrayList;
import java.util.Comparator;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Ranks the candidates based on the points they have gathered from the
 * evaluation system. Reads form the JSON file the points for each candidate and
 * ranks the based on the points they have. It separates each candidate from the
 * file and it sorts from the one one with the least points to the one with the
 * most points.
 * 
 * @author Michalis Dontas
 * @version 3.1 14 Jan 2020
 */
public class Rankings {
	/**
	 * Sorts the candidates based on their points.
	 * 
	 * @param <Dep>
	 * @param candidates
	 * @param position
	 * @return the sorted list of the candidates
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@SuppressWarnings("unchecked")
	public static <Dep> ArrayList<Dep> sortByDepartment(JSONArray candidates, String position)
			throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<? extends Candidate> Dep = (Class<? extends Candidate>) Class.forName("evaluateCandidates." + position);
		ArrayList<Dep> list = createListFromFile(candidates, Dep);
		Constructor<? extends Candidate> con = Dep.getConstructor();
		list.sort((Comparator<? super Dep>) con.newInstance());
		while (list.size() > 10) {
			list.remove(10);
		}
		return list;
	}

	/**
	 * Separates each candidate from the JSON file
	 * 
	 * @param <Dep>
	 * @param candidates
	 * @param Dep
	 * @return list with candidates
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@SuppressWarnings("unchecked")
	public static <Dep> ArrayList<Dep> createListFromFile(JSONArray candidates, Class<? extends Candidate> Dep)
			throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		ArrayList<Dep> list = new ArrayList<Dep>();
		Constructor<? extends Candidate> con = Dep.getConstructor(JSONObject.class);
		for (Object candidate : candidates) {
			list.add((Dep) con.newInstance((JSONObject) candidate));
		}
		// separate each candidate from the file and store him to an ArrayList.

		return list;
	}
}