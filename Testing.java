
public class Testing {
	private int id;
	private String name;

	public Testing(String name) {
		super();
		this.name = name;
		id++;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Testing [name=" + name + "]";
	}

}
