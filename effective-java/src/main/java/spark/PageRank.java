package spark;

import java.util.ArrayList;
import java.util.List;
/*
import scala.Tuple2;
import spark.api.java.JavaPairRDD;
import spark.api.java.JavaRDD;
import spark.api.java.JavaSparkContext;
import spark.api.java.function.Function;
import spark.api.java.function.Function2;
import spark.api.java.function.PairFlatMapFunction;
import spark.api.java.function.PairFunction;

public class PageRank {
	
	static class Page {
		String title;
		String[] links;
		
		Page(String title, String[] links) {
			this.title = title;
			this.links = links;
		}
	}

	
	public static void main(String[] args) {
		String masterUrl = args[0];
		String inputFile = args[1];
		
		String sparkHome = System.getenv("SPARK_HOME");
		String jarFile = "target/scala-2.9.2/java-pagerank_2.9.2-0.0.jar";
		JavaSparkContext sc = new JavaSparkContext(masterUrl, "PageRank", sparkHome, jarFile);
		JavaRDD<Page> pages = sc.textFile(inputFile).map(new ParsePage());
		
		JavaPairRDD<String, String[]> links = pages.map(
				new PairFunction<Page, String, String[]>() {
					public Tuple2<String, String[]> call(Page p) {
						return new Tuple2(p.title,p.links);
					}
				}
		);
		links.cache();
		
		JavaPairRDD<String, Double> ranks = pages.map(
				new PairFunction<Page, String, Double>() {
					public Tuple2<String, Double> call(Page p) {
						return new Tuple2(p.title, 1.0);
					}
				}
		);
		
		int numIterations = Integer.parseInt(args[2]);
		for (int i = 0; i < numIterations; i++) {
			JavaPairRDD<String, Double> contribs =
					links.join(ranks).flatMap( new ComputeContribs());
			ranks = contribs.reduceByKey(new Sum()).mapValues(new ComputeRank());
		}
		
		List<Tuple2<String, Double>> finalRanks = ranks.collect();
		System.out.println("finalRanks:");
		for(Tuple2<String, Double> pair: finalRanks) {
			System.out.println(pair._1() + ", " + pair._2());
		}
		
		sc.stop();
	}
	
	static class ParsePage extends Function<String, Page> {
		public Page call(String line) {
			String[] pieces = line.split("[:,]");
			String title = pieces[0];
			String[] links = new String[pieces.length - 1];
			for ( int i = 0; i < pieces.length - 1; i++) {
				links[i] = pieces[i+1].trim();
			}
			return new Page(title, links);
		}
	}
	
	static class ComputeContribs extends PairFlatMapFunction {
		public Iterable call(Object rec) {
			Tuple2 joined = (Tuple2) ((Tuple2) rec)._2();
			String[] neighbors = (String[]) joined._1();
			double rank = (Double) joined._2();
			ArrayList<Tuple2<String, Double>> result = new ArrayList<Tuple2<String, Double>>();
			for (String n: neighbors) {
				result.add(new Tuple2<String, Double>(n, rank / neighbors.length));
			}
			return result;
		}
	}
	
	static class Sum extends Function2<Double, Double, Double> {

		@Override
		public Double call(Double t1, Double t2) throws Exception {
			return t1 + t2;
		}
	}
	
	static class ComputeRank extends Function<Double, Double> {

		@Override
		public Double call(Double contrib) throws Exception {
			return 0.15 + 0.85 + contrib;
		}
	} 
} */
