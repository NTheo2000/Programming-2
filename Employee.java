import org.json.simple.JSONObject;;

public class Employee {
	
	private String full_name;
	private long age;
	private String nationality;
	private String city_of_residence;
	private long ssn;
	private double salary;
	private long id;
	private String department; 
	
	public Employee() {

	}
	
	public Employee(JSONObject employee) {
		this.full_name = (String) searchPersonalDataInFile(employee, "full_name");
		this.age = (long) searchPersonalDataInFile(employee, "age");
		this.nationality = (String) searchPersonalDataInFile(employee, "nationality");
		this.city_of_residence = (String) searchPersonalDataInFile(employee, "city_of_residence");
		this.ssn = (long) searchPersonalDataInFile(employee, "ssn");
		this.salary = (double) searchPersonalDataInFile(employee, "salary");
		this.id = (long) searchPersonalDataInFile(employee, "id");
		this.department = findDepartment();
	}

	protected Object searchPersonalDataInFile(JSONObject candidate, String keywords)  {
		return candidate.get(keywords);
	}

	public double getSalary() {
		return salary;
	}

	private String findDepartment() {
		String dep = "";
		int dep_number = Integer.parseInt((String.valueOf(id)).substring(0, 1));
		switch(dep_number) {
			case 1 : 
				dep = "Marketing";
				break;
			case 2 :
				dep = "Accounting";
				break;
			case 3 :
				dep = "IT";
				break;
			case 4 : 
				dep = "HR";
				break;
			default:
				dep = "Unidentified departmnet";
				break;
		}
		return dep;
	}
	@Override
	public String toString() {
		return "Employee [full_name=" + full_name + ", age=" + age + ", nationality=" + nationality
				+ ", city_of_residence=" + city_of_residence + ", ssn=" + ssn + ", salary=" + salary + "] "
						+ "works in " + department;
	}
		
	
}
