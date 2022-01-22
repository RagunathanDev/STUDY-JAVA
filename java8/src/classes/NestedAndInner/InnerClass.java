package classes.NestedAndInner;

//Non-Static nested class (Inner class)
public class InnerClass {

	public static void main(String[] args) {

		// If you want to access the inner class(Non-Static nested class)
		// First you need to create an obj for outter class, then you can create obj for
		// inner class.

		Employee employee = new Employee();
		employee.setName("Ragu");
		Employee.Salary salary = employee.new Salary();
		System.out.println(salary.getInfo());
		System.out.println(salary.getName());
	}

}

class Employee {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	protected class Salary {

		// Private member variable can also access.

		private final static int amount = 20000;

		public String getInfo() {
			return "Name:" + Employee.this.name + ", Salary Amount:" + amount;
		}

		public String getName() {
			return Employee.this.getName();
		}

	}

}
