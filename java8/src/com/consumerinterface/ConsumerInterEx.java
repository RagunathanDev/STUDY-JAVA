package com.consumerinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterEx {

	public static void main(String[] args) {

		// Consumer FunctionalInterface -> can accept an argument but won't return
		// anything.
		// class based
		// consumerImp con = new consumerImp();

		// Lambda function
		Consumer<Integer> con = (t) -> System.out.println("Print : " + t);

		// call the accept method
		con.accept(5);

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//		list.forEach(con);

		list.forEach(t -> System.out.println(t));

	}
}

class consumerImp implements Consumer<Integer> {
	@Override
	public void accept(Integer t) {
		System.out.print(t);
	}

}