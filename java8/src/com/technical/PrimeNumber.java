package com.technical;

import java.math.BigInteger;
import java.util.stream.Stream;

public class PrimeNumber {
	public static void main(String[] args) {

		Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime).limit(10).forEach(System.out::println);

	}

}
