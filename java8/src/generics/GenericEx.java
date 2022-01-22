package generics;

public class GenericEx {

	public static void main(String[] args) {
		// Mention the Type in Generic class. not in primitive type
		AddNumber numberI = new AddNumber();

		numberI.<Double, Double>add(2D, 2D);

		// AddNumber<Double> numberD = new AddNumber<>();
		// numberD.add(22.05);

		// AddNumber<String> string = new AddNumber<>();
		// string.add("ragu");

	}
}
