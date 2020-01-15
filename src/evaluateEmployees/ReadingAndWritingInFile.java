package evaluateEmployees;
/*
 * ReadingAndWritingInFile
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class records and retrieves data to / from a specific folder through its
 * methods writeObject, readObject, readNumber, write and read.
 * 
 * @author Dimitris Vougioukos
 *
 */
public class ReadingAndWritingInFile {
	/**
	 * Records data to a specific folder.
	 * 
	 * @param path   Contains the path of the folder in which we enter data.
	 * @param array1 Contains the ratings and IDs of employees of a department for
	 *               the current semester.
	 * @param array2 Contains the scores of employees of a department for all their
	 *               semesters.
	 * @param array3 Contains the ID of the employees of a department and is
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves data from a specific folder.
	 * 
	 * @param path Contains the path of the folder from which we retrieve data.
	 * @return the data of the folder through a array.
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retrieves data from a specific folder.
	 * 
	 * @param path Contains the path of the folder from which we retrieve data.
	 * @return the data of the folder.
	 */

	public static int readNumber(String path) {
		try {
			FileInputStream rd = new FileInputStream(path);
			int times = rd.read();
			rd.close();
			return times;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Records data to a specific folder.
	 * 
	 * @param path Contains the path of the folder from which we retrieve data.
	 * @param days Days of current semester.
	 * @param date Date of last connection to program.
	 */
	public static void write(String path, Long days, LocalDate date) {
		try {
			new FileWriter(path).close();
			FileOutputStream wr = new FileOutputStream(path);
			ObjectOutputStream write = new ObjectOutputStream(wr);
			write.writeObject(days);
			write.writeObject(date);
			write.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves data from a specific folder.
	 * 
	 * @param path Contains the path of the folder from which we retrieve data.
	 * @return the data of the folder through a array.
	 */

	public static Object[] read(String path) {
		try {
			Object[] retur = new Object[2];
			FileInputStream rd = new FileInputStream(path);
			ObjectInputStream read = new ObjectInputStream(rd);
			retur[0] = read.readObject();
			retur[1] = read.readObject();
			read.close();
			return retur;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
