package generics;

// @ T -> Type special to use the common methods.
public class AddNumber {

	AddNumber() {
	}

	public <T extends Number, S extends Number> void add(T a, S s) {
		System.out.println(a.intValue() + s.intValue());
	}
}
