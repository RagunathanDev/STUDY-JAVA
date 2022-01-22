package classes.NestedAndInner;

//static nested class(Nested class)
public class NestedClass {

	// For accessing the nested class
	// Not necessary to create outer class obj.
	// Directly access the innerclass,Like

	public static void main(String[] args) {

		EmployeeNested.Salary salary = new EmployeeNested.Salary();
		System.out.println(salary.getInfo());

		// Get another class
		EmployeeNested empNested = new EmployeeNested();
		EmployeeNested.HRConnect hrConnect = empNested.new HRConnect();
		System.out.println(hrConnect.getInfo());
	}

}

class EmployeeNested {

	private String name;

	public final static int salaryAmount = 5000000;

	private final static int variationAmount = 200000;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	protected static class Salary {

		public String getInfo() {
			return "" + salaryAmount;
		}
	}

	public class HRConnect extends Salary {

		public String getInfo() {
			return "" + (salaryAmount + variationAmount);
		}
	}

}