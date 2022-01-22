package com.streamApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) throws IOException {

		// 1.Integer Stream
		System.out.println("------------1------------");
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println();

		// 2.Integer Stream with skip
		System.out.println("------------2------------");
		IntStream.range(1, 15).skip(5).forEach(x -> System.out.println(x));
		System.out.println();

		// 3.Integer Stream with sum
		System.out.println("------------3------------");
		System.out.println(IntStream.range(1, 15).sum());
		System.out.println();

		// 4.Stream.of, sorted and findFirst
		System.out.println("------------4------------");
		Stream.of("kannan", "ragu", "sangili").sorted().findAny().ifPresent(System.out::println);
		System.out.println();

		// 5.Stream from Array, sort, filter and print
		System.out.println("------------5------------");
		String name[] = { "sarika", "amanda", "kannan", "ragu", "sangili" };
		Arrays.stream(name).filter(x -> x.startsWith("s")).sorted().forEach(System.out::println);

		// 6.Stream from Array, sort, filter and print
		System.out.println("------------6------------");
		Arrays.stream(new int[] { 1, 2, 3 }).map(x -> x * x).average().ifPresent(System.out::println);

		// 7.Stream from List, sort, filter and print
		System.out.println("------------7------------");
		List<String> people = Arrays.asList("sarika", "amanda", "kannan", "ragu", "sangili");
		people.stream().map(String::toLowerCase).filter(x -> x.startsWith("s")).forEach(System.out::println);

		// 8.Stream rows from text file, sort, filter and print
		System.out.println("------------8------------");
		Stream<String> bands = Files.lines(Paths.get("D:\\Read.txt"));
		bands.sorted().filter(x -> x.startsWith("s")).forEach(System.out::println);
		bands.close();

		// 9.Stream rows from text file and save to List
		System.out.println("------------9------------");
		List<String> bands2 = Files.lines(Paths.get("D:\\Read.txt")).filter(x -> x.contains("ili"))
				.collect(Collectors.toList());
		bands2.forEach(x -> System.out.println(x));

		// 10.Stream rows from csv file and count
		System.out.println("------------10------------");
		Stream<String> rows = Files.lines(Paths.get("D:\\Data.txt"));
		int rowCount = (int) rows.map(x -> x.split(",")).filter(x -> x.length == 3).count();
		System.out.println(rowCount + "rows.");
		rows.close();

		// 11.Stream rows from csv file, parse data from rows
		System.out.println("------------11------------");
		Stream<String> rows1 = Files.lines(Paths.get("D:\\Data.txt"));
		rows1.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) > 15)
				.forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
		rows1.close();

		// 12.Stream rows from csv file, parse data from rows
		System.out.println("------------12------------");
		Stream<String> rows2 = Files.lines(Paths.get("D:\\Data.txt"));
		Map<String, Integer> mapOne = new HashMap<>();
		mapOne = rows2.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
		rows2.close();

		for (String key : mapOne.keySet()) {
			System.out.println(key + " " + mapOne.get(key));
		}
		System.out.println();

		// 13.Reduction Sum
		System.out.println("------------13------------");
		int totalInt = Stream.of(2, 3, 5, 6, 7, 7).reduce(0, (a, b) -> a + b);

		System.out.println("Total of Integer " + totalInt);

		double totalDouble = Stream.of(2.1, 3.5, 4.4).reduce(0.0, (Double c, Double d) -> c + d);

		System.out.println("Total of Integer " + totalDouble);

		// 14.Reduction Summary statistics
		System.out.println("------------14------------");

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		IntSummaryStatistics summary = IntStream.of(a).summaryStatistics();
		System.out.println(summary.getCount());

	}
}