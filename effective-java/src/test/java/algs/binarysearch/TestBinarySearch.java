package algs.binarysearch;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.primitives.Ints;

public class TestBinarySearch {

  private static String tinyWURL = "http://algs4.cs.princeton.edu/11model/tinyW.txt"; 
  private static String tinyTURL = "http://algs4.cs.princeton.edu/11model/tinyT.txt";
  private static int[] whitelist;
  private static int[] inputs;

  private static List<Integer> readIntegersFromRemoteTextFile(String urlString) throws IOException {
    URL url = new URL(urlString);
    try(Scanner scanner = new Scanner(url.openStream());) {
      List<Integer> integers = new ArrayList<Integer>();
      while(scanner.hasNextInt()) {
        integers.add(scanner.nextInt());
      }
      return integers;
    } // close scanner
  }

  @BeforeClass 
  public static void loadTestFiles() throws IOException {
    List<Integer> readWhitelist = readIntegersFromRemoteTextFile(tinyWURL);
    whitelist = Ints.toArray(readWhitelist);
    Arrays.sort(whitelist);
    List<Integer> readInputlist = readIntegersFromRemoteTextFile(tinyTURL);
    inputs = Ints.toArray(readInputlist);
  }

  @Test
  public void searchTiny() {
    for(int i: inputs) {
      int key = i;
      if(BinarySearch.rank(key, whitelist) == -1) {
        System.out.println(key);
      }
    }

  }

}
