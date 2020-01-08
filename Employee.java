package EvaluateCandidates;

import org.json.simple.JSONObject;;

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
		this.age = (long) searchPersonalDataInFile(employee, "age");
		this.nationality = (String) searchPersonalDataInFile(employee, "nationality");
		this.city_of_residence = (String) searchPersonalDataInFile(employee, "city_of_residence");
		this.ssn = (String) searchPersonalDataInFile(employee, "ssn");
		this.salary = (double) searchPersonalDataInFile(employee, "salary");
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", full_name=" + full_name + ", age=" + age + ", nationality=" + nationality
				+ ", city_of_residence=" + city_of_residence + ", ssn=" + ssn + ", salary=" + salary + "] "
						+ "works as " + department;
	}
}
