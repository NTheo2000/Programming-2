package evaluateEmployees;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * This class records and retrieves data to / from a specific folder through its
 * methods writeObject and readObject.
 * 
 * @author Dimitris Vougioukos
 *
 */
public class ReadingAndWritingInFile {
	/**
	 * Records data to a specific folder.
	 * 
	 * @param path   contains the path of the folder in which we enter data.
	 * @param array1 contains the ratings and IDs of employees of a department for
	 *               the current semester.
	 * @param array2 contains the scores of employees of a department for all their
	 *               semesters.
	 * @param array3 contains the ID of the employees of a department and is
	 *               parallel to the array list array2.
	 */
	public static void writeObject(String path, ArrayList<ArrayList<Double>> array1,
			ArrayList<ArrayList<Double>> array2, ArrayList<Double> array3) {
		try {
			new FileWriter(path).close();
			FileOutputStream wr = new FileOutputStream(path);
			ObjectOutputStream write = new ObjectOutputStream(wr);
			write.writeObject(array1);
			write.writeObject(array2);
			write.writeObject(array3);
			write.close();
		} catch (Exception e) {
		}
	}

	/**
	 * Retrieves data from a specific folder.
	 * 
	 * @param path contains the path of the folder from which we retrieve data.
	 * @return returns the data of the folder through a array.
	 */
	public static Object[] readObject(String path) {
		try {
			FileInputStream rd = new FileInputStream(path);
			ObjectInputStream read = new ObjectInputStream(rd);
			Object[] arraylists = new Object[3];
			for (int i = 0; i < 3; i++) {
				arraylists[i] = read.readObject();
			}
			read.close();
			return arraylists;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Throwed exception");
			return null;
		}
	}
}
