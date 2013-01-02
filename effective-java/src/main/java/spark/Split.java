package spark;

import scala.actors.threadpool.Arrays;
import spark.api.java.function.FlatMapFunction;

public class Split extends FlatMapFunction<String, String> {
	public Iterable<String> call(String s) {
		return Arrays.asList(s.split(" "));
	}

}
