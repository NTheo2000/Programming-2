package evaluateCandidates;


import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Employee {
	
	private String full_name;
	private long age;
	private String nationality;
	private String city_of_residence;
	private String ssn;
	private double salary;
	private String id;
	private String department;
	
	public Employee() {

	}
	
	public Employee(JSONObject employee) {
		this.full_name = (String) searchPersonalDataInFile(employee, "full_name");
		this.age = (Long) searchPersonalDataInFile(employee, "age");
		this.nationality = (String) searchPersonalDataInFile(employee, "nationality");
		this.city_of_residence = (String) searchPersonalDataInFile(employee, "city_of_residence");
		this.ssn = (String) searchPersonalDataInFile(employee, "ssn");
		this.salary = (Double) searchPersonalDataInFile(employee, "salary");
		this.id = (String) searchPersonalDataInFile(employee, "id");
		this.department = findDepartment(id);
	}

	protected Object searchPersonalDataInFile(JSONObject employee, String keywords)  {
		return employee.get(keywords);
	}

	public String getFull_name() {
		return full_name;
	}
	public double getSalary() {
		return salary;
	}
	public long getAge() {
		return age;
	}
	public String getCity_of_residence() {
		return city_of_residence;
	}
	public String getNationality() {
		return nationality;
	}
	public String getDepartment() {
		return department;
	}
	public String getId() {
		return id;
	}
	public int getDepartmentId() {
		return Integer.parseInt((String.valueOf(id)).substring(0, 1));
	}
	public static String findDepartment(String id) {
		String dep = "";
		int dep_number = Integer.parseInt((String.valueOf(id)).substring(0, 1));
		switch(dep_number) {
		case 0 :
			dep = "HR Manager";
			break;
		case 1 : 
			dep = "Marketing Employee";
			break;
		case 2 :
			dep = "Accounting Employee";
			break;
		case 3 :
			dep = "IT Employee";
			break;
		case 4 : 
			dep = "HR Employee";
			break;
		case 5 :
			dep = "Marketing Director";
			break;
		case 6 :
			dep = "Accounting Director";
			break;
		case 7 :
			dep = "IT Director";
			break;
		case 8:
			dep = "HR Director";
			break;
		default:
			dep = "Unidentified departmnet";
			break;
		}
		return dep;
	}
	public String getDirectorId() throws Exception {
		int dep_number = Integer.parseInt((String.valueOf(this.id)).substring(0, 1));
		String director_id = null;
		JSONParser parser = new JSONParser();
		JSONArray employees = (JSONArray) parser.parse(new FileReader("WorkersDatabase.json"));
		switch(dep_number) {
		case 1 :
		case 2 :
		case 3 :
		case 4 :
			for (Object obj : employees) {
				String potential_id = (String) ((JSONObject) obj).get("id");
				int first_number = Integer.parseInt((String.valueOf(potential_id)).substring(0, 1));
				if (first_number == dep_number + 4) {
					director_id = potential_id;
					break;
				}
			}
			break;
		default:
			break;
		}
		return director_id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", full_name=" + full_name + ", age=" + age + ", nationality=" + nationality
				+ ", city_of_residence=" + city_of_residence + ", ssn=" + ssn + ", salary=" + salary + "] "
						+ "works as " + department;
	}
}
