package arraylist;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ArrayListEx {

	public static void main(String[] args) {

		ArrayList<String> nameList = new ArrayList<>();
		nameList.add("one");
		nameList.add("two");
		nameList.add("Three");
		nameList.add("Four");
		nameList.add("Five");

		nameList.stream().forEach(item -> {
			System.out.println(item);
		});

		nameList.stream().sorted().filter(item -> item.endsWith("r")).collect(Collectors.toList())
				.forEach(item -> System.out.println(item));
		;

		ArrayList<Integer> numberList = new ArrayList<>();

		numberList.add(11);
		numberList.add(30);
		numberList.add(35);
		numberList.add(40);
		numberList.add(34);
		numberList.add(null);
		numberList.add(21);
		numberList.add(null);
		numberList.add(null);
		numberList.add(null);
		numberList.add(null);
		numberList.add(null);
		numberList.add(null);
		numberList.add(null);
		numberList.add(89);
		numberList.add(76);
		numberList.add(89);
		numberList.add(76);
		numberList.add(60);

		numberList.stream().sorted().forEach(System.out::println);
		;
		System.out.println(numberList);

	}
}
