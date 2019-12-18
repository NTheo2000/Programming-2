package ExerciseProgram2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Random;

public class CreateCandidate {
	protected static String[] full_name = new String[100];
	protected static long[] age = new long[30];
	protected static String[] nationality = new String[10];
	protected static String[] city_of_residence = new String[10];
	protected static String[] ssn = new String[100];
	protected static String[] field = new String[4];
	protected static String[] email = new String[100];

	protected static int[] level_of_languages = new int[5];
	protected static int[] number_of_languages = new int[5];
	protected static int[] level_of_computer_handling = new int[5];
	protected static int[] former_experience = new int[30];
	protected static boolean[] recommendation_letter = new boolean[2];
	protected static int[] number_of_programming_languages = new int[5];

	protected static double[] master_in_main_field = new double[51];
	protected static double[] master_in_other_field = new double[51];
	protected static double[] phd_in_main_field = new double[51];
	protected static double[] phd_in_other_field = new double[51];

	public CreateCandidate() {

	}

	public String getRandom(String[] x) {
		int rand = new Random().nextInt(x.length);
		return x[rand];
	}

	public int getRandom(int[] x) {
		int rand = new Random().nextInt(x.length);
		return x[rand];
	}

	public boolean getRandom(boolean[] x) {
		int rand = new Random().nextInt(x.length);
		return x[rand];
	}

	public double getRandom(double[] x) {
		int rand = new Random().nextInt(x.length);
		return x[rand];
	}

	public String getFull_name(int i) {
		return full_name[i];
	}

	public void setFull_name(String full_name, int i) {
		CreateCandidate.full_name[i] = full_name;
	}

	public long getAge(int i) {
		return age[i];
	}

	public void setAge(int age, int i) {
		CreateCandidate.age[i] = age;
	}

	public String getNationality(int i) {
		return nationality[i];
	}

	public void setNationality(String nationality, int i) {
		CreateCandidate.nationality[i] = nationality;
	}

	public String getCity_of_residence(int i) {
		return city_of_residence[i];
	}

	public void setCity_of_residence(String city_of_residence, int i) {
		CreateCandidate.city_of_residence[i] = city_of_residence;
	}

	public String getSsn(int i) {
		return ssn[i];
	}

	public void setSsn(String ssn, int i) {
		CreateCandidate.ssn[i] = ssn;
	}

	public String getField(int i) {
		return field[i];
	}

	public void setField(String field, int i) {
		CreateCandidate.field[i] = field;
	}

	public String getEmail(int i) {
		return email[i];
	}

	public void setEmail(String email, int i) {
		CreateCandidate.email[i] = email;
	}

	public int getLevel_of_languages(int i) {
		return level_of_languages[i];
	}

	public void setLevel_of_languages(int level_of_languages, int i) {
		CreateCandidate.level_of_languages[i] = level_of_languages;
	}

	public int getNumber_of_languages(int i) {
		return number_of_languages[i];
	}

	public void setNumber_of_languages(int number_of_languages, int i) {
		CreateCandidate.number_of_languages[i] = number_of_languages;
	}

	public int getLevel_of_computer_handling(int i) {
		return level_of_computer_handling[i];
	}

	public void setLevel_of_computer_handling(int level_of_computer_handling, int i) {
		CreateCandidate.level_of_computer_handling[i] = level_of_computer_handling;
	}

	public int getFormer_experience(int i) {
		return former_experience[i];
	}

	public void setFormer_experience(int former_experience, int i) {
		CreateCandidate.former_experience[i] = former_experience;
	}

	public boolean getRecommendation_letter(int i) {
		return recommendation_letter[i];
	}

	public void setRecommendation_letter(boolean recommendation_letter, int i) {
		CreateCandidate.recommendation_letter[i] = recommendation_letter;
	}

	public int getNumber_of_programming_languages(int i) {
		return number_of_programming_languages[i];
	}

	public void setNumber_of_programming_languages(int number_of_programming_languages, int i) {
		CreateCandidate.number_of_programming_languages[i] = number_of_programming_languages;
	}

	public double getMaster_in_main_field(int i) {
		return master_in_main_field[i];
	}

	public void setMaster_in_main_field(double master_in_main_field, int i) {
		CreateCandidate.master_in_main_field[i] = master_in_main_field;
	}

	public double getMaster_in_other_field(int i) {
		return master_in_other_field[i];
	}

	public void setMaster_in_other_field(double master_in_other_field, int i) {
		CreateCandidate.master_in_other_field[i] = master_in_other_field;
	}

	public double getPhd_in_main_field(int i) {
		return phd_in_main_field[i];
	}

	public void setPhd_in_main_field(double phd_in_main_field, int i) {
		CreateCandidate.phd_in_main_field[i] = phd_in_main_field;
	}

	public double getPhd_in_other_field(int i) {
		return phd_in_other_field[i];
	}

	public void setPhd_in_other_field(double phd_in_other_field, int i) {
		CreateCandidate.phd_in_other_field[i] = phd_in_other_field;
	}

	protected static JSONArray candidateList = new JSONArray();

	@SuppressWarnings("unchecked")
	public static void createDatabase(String name) {
		int i = 0;
		full_name[i++] = "Catrice Heiman";
		full_name[i++] = "Kermit Durrell";
		full_name[i++] = "Fredia Smalle";
		full_name[i++] = "Henriette Buresh";
		full_name[i++] = "Georgine Hinrichs";
		full_name[i++] = "Darrell Lanz";
		full_name[i++] = "Tenisha Wurster";
		full_name[i++] = "Mai Yohe";
		full_name[i++] = "Eugenia Lee";
		full_name[i++] = "Jacqueline Socha";
		full_name[i++] = "Sheila Ortega";
		full_name[i++] = "Wyatt Mazzone";
		full_name[i++] = "Linnea Siguenza";
		full_name[i++] = "Louise Felker";
		full_name[i++] = "Kimberley Clink";
		full_name[i++] = "Ria Nakasone";
		full_name[i++] = "Rosalie Mansur";
		full_name[i++] = "Jerrell Deland";
		full_name[i++] = "Dannielle Edling";
		full_name[i++] = "Bradly Mudge";
		full_name[i++] = "Jennette Kitchen";
		full_name[i++] = "Sharmaine Preas";
		full_name[i++] = "Maud Ruffo";
		full_name[i++] = "Jordan Mello";
		full_name[i++] = "Melynda Saver";
		full_name[i++] = "Mireille Siers";
		full_name[i++] = "Bryanna Wicklund";
		full_name[i++] = "Tanya Mccartney";
		full_name[i++] = "Adeline Cuthbert";
		full_name[i++] = "Denver Muller";
		full_name[i++] = "Gordon Walters";
		full_name[i++] = "Salvatore Tancredi";
		full_name[i++] = "Duncan Odriscoll";
		full_name[i++] = "Wilbert Talbott";
		full_name[i++] = "Allan Joye";
		full_name[i++] = "Darwin Zabel";
		full_name[i++] = "Eduardo Blose";
		full_name[i++] = "Ben Redford";
		full_name[i++] = "Derick Whetstone";
		full_name[i++] = "Damian Gans";
		full_name[i++] = "Chester Vandermolen";
		full_name[i++] = "Reid Allison";
		full_name[i++] = "Jonathan Damore";
		full_name[i++] = "Marlin Gasper";
		full_name[i++] = "Booker Cromartie";
		full_name[i++] = "Art Kogut";
		full_name[i++] = "Hyman Bunyard";
		full_name[i++] = "Ahmed Alsup";
		full_name[i++] = "Margarito Bainbridge";
		full_name[i++] = "Ivory Fenstermacher";
		full_name[i++] = "Arlie Davin";
		full_name[i++] = "Greg Spitz";
		full_name[i++] = "Moses Smallwood";
		full_name[i++] = "Tommy Midgette";
		full_name[i++] = "Sylvester Stmarie";
		full_name[i++] = "Alvaro Askew";
		full_name[i++] = "Brady Jellison";
		full_name[i++] = "Kendall Bowling";
		full_name[i++] = "Irwin Errico";
		full_name[i++] = "Fabian Barhorst";
		full_name[i++] = "Luciano Kardos";
		full_name[i++] = "Lionel Majors";
		full_name[i++] = "Scotty Nair";
		full_name[i++] = "Daron Buse";
		full_name[i++] = "Damian Jacquemin";
		full_name[i++] = "Jeramy Littlefield";
		full_name[i++] = "Michael Florian";
		full_name[i++] = "Cornelius Kaster";
		full_name[i++] = "Emmanuel Millner";
		full_name[i++] = "Robt Arzate";
		full_name[i++] = "Vance Rickey";
		full_name[i++] = "Delmer Duffy";
		full_name[i++] = "Brice Kivett";
		full_name[i++] = "Carl Etherton";
		full_name[i++] = "Dirk Maio";
		full_name[i++] = "Daren Stolz";
		full_name[i++] = "Adrian Castello";
		full_name[i++] = "Frederick Wyatt";
		full_name[i++] = "Billy Withrow";
		full_name[i++] = "Lazaro Wommack";
		full_name[i++] = "Steven Abram";
		full_name[i++] = "Dusty Wydra";
		full_name[i++] = "Orval Choe";
		full_name[i++] = "Everett Maddalena";
		full_name[i++] = "Henry Speir";
		full_name[i++] = "Hassan Setzer";
		full_name[i++] = "Barton Saez";
		full_name[i++] = "Jackie Pinkett";
		full_name[i++] = "Thomas Aliff";
		full_name[i++] = "Humberto Burda";
		full_name[i++] = "Alan Morman";
		full_name[i++] = "Emerson Harvin";
		full_name[i++] = "Dennis Gamez";
		full_name[i++] = "Cedric Gobble";
		full_name[i++] = "Jan Oriol";
		full_name[i++] = "Chet Rutledge";
		full_name[i++] = "Panos logothetis";
		full_name[i++] = "Manos Roussos";
		full_name[i++] = "Michael Dontas";
		full_name[i++] = "Thomas Larwse";
		i = 0;
		nationality[i++] = "Greek";
		nationality[i++] = "American";
		nationality[i++] = "Brazilian";
		nationality[i++] = "French";
		nationality[i++] = "Spanish";
		nationality[i++] = "German";
		nationality[i++] = "Italian";
		nationality[i++] = "Indian";
		nationality[i++] = "Mexican";
		i = 0;
		city_of_residence[i++] = "Athens";
		city_of_residence[i++] = "New York";
		city_of_residence[i++] = "Zurich";
		city_of_residence[i++] = "Boston";
		city_of_residence[i++] = "Madrid";
		city_of_residence[i++] = "Paris";
		city_of_residence[i++] = "Monaco";
		city_of_residence[i++] = "Trikala";
		city_of_residence[i++] = "Rome";
		city_of_residence[i++] = "Venice";
		i = 0;
		field[i++] = "Marketing";
		field[i++] = "Accounting";
		field[i++] = "HR";
		field[i++] = "IT";
		for (i = 0; i < 30; i++) {
			age[i] = i + 20;
			former_experience[i] = i;
		}
		Random rand = new Random();
		for (i = 0; i < 100; i++) {
			String num = "";
			for (int j = 0; j < 9; j++) {
				num = String.valueOf(rand.nextInt(10)) + num;
			}
			ssn[i] = num;
			email[i] = "c" + ssn[i] + "@gmail.com";
		}
		for (i = 0; i < 5; i++) {
			level_of_languages[i] = i;
			number_of_languages[i] = i;
			level_of_computer_handling[i] = i;
			number_of_programming_languages[i] = i;
		}
		recommendation_letter[0] = false;
		recommendation_letter[1] = true;
		for (i = 0; i < 51; i++) {
			master_in_main_field[i] = 5 + i / 10;
			master_in_other_field[i] = 5 + i / 10;
			phd_in_main_field[i] = 5 + i / 10;
			phd_in_other_field[i] = 5 + i / 10;
		}
		int rand51, rand30, rand10, rand5, rand4, rand2;
		try {
			for (i = 0; i < 100; i++) {
				rand51 = new Random().nextInt(phd_in_other_field.length);
				rand30 = new Random().nextInt(age.length);
				rand10 = new Random().nextInt(nationality.length);
				rand5 = new Random().nextInt(level_of_languages.length);
				rand4 = new Random().nextInt(field.length);
				rand2 = new Random().nextInt(recommendation_letter.length);
				candidateList.add(createCandidate(full_name[i], ssn[i], email[i], master_in_main_field[rand51],
						master_in_other_field[rand51], phd_in_main_field[rand51], phd_in_other_field[rand51],
						age[rand30], former_experience[rand30], nationality[rand10], city_of_residence[rand10],
						level_of_languages[rand5], number_of_languages[rand5], level_of_computer_handling[rand5],
						number_of_programming_languages[rand5], field[rand4], recommendation_letter[rand2]));
			}

			File file = new File(name);
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(candidateList.toJSONString());
			fileWriter.flush();
			fileWriter.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static JSONObject createCandidate(String full_name, String ssn, String email, double master_in_main_field,
			double master_in_other_field, double phd_in_main_field, double phd_in_other_field, long age,
			int former_experience, String nationality, String city_of_residence, int level_of_languages,
			int number_of_languages, int level_of_computer_handling, int number_of_programming_languages, String field,
			boolean recommendation_letter) {
		JSONObject candidate = new JSONObject();

		candidate.put("full_name", full_name);
		candidate.put("email", email);
		candidate.put("ssn", ssn);
		candidate.put("master_in_main_field", master_in_main_field);
		candidate.put("master_in_other_field", master_in_other_field);
		candidate.put("phd_in_main_field", phd_in_main_field);
		candidate.put("phd_in_other_field", phd_in_other_field);
		candidate.put("age", age);
		candidate.put("former_experience", former_experience);
		candidate.put("nationality", nationality);
		candidate.put("city_of_residence", city_of_residence);
		candidate.put("level_of_languages", level_of_languages);
		candidate.put("number_of_languages", number_of_languages);
		candidate.put("level_of_computer_handling", level_of_computer_handling);
		candidate.put("number_of_programming_languages", number_of_programming_languages);
		candidate.put("field", field);
		candidate.put("recommendation_letter", recommendation_letter);

		return candidate;
	}

}