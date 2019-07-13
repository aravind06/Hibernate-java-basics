package java_8_stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {

	public static void main(String[] args) throws IOException {
		
		//reading Input file from resource folder
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		FileReader reader = new FileReader(new File(classloader.getResource("test.txt").getFile()));
		BufferedReader buffer = new BufferedReader(reader);
		
		//converting the read file to a list<String> -> each line as string
		String s;
		List<String> input = new ArrayList<String>();
		while ((s = buffer.readLine()) != null) {
			input.add(s);
		}
		
		//splitting the above list to get a list of words
		List<String> words = input.stream().flatMap(line -> Arrays.stream(line.split(" ")))
				.collect(Collectors.toList());
		
		//mapping the list of words with words as keys and they occurance as value
		Map<String, Integer> studentsMap = words.stream()
				.collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
		
		//printing the same
		studentsMap.forEach((k, v) -> System.out.println(k + "==>" + v));
		buffer.close();
	}

}
