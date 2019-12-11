import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReadingAndWritingInFile {
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
			System.out.print(e);
		}
	}

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
			System.out.print(e);
			return null;
		}
	}
}
