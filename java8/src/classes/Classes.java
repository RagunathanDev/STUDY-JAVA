package classes;

public class Classes {

	Classes() {
		System.out.println("Constructor");
	}

	public static class NestedClass {

		NestedClass() {
			System.out.println("Nested class..");
		}

		public class InnerNestedClass {

			InnerNestedClass() {
				System.out.println("Inner Nested class");
			}
		}
	}

	public static void main(String[] args) {
		Classes cls = new Classes();
	}
}

class OuterClass {

	OuterClass() {
		System.out.println("Outer Class");
	}

	public class OuterInnerClass {

		OuterInnerClass() {
			System.out.println("Outer Inner class...");
		}
	}

}
