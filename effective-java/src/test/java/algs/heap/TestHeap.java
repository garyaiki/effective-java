package algs.heap;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import static algs.utils.ScanRemoteFiles.readStringsInTextFile;


public class TestHeap {
  private static String wordsURL = "http://algs4.cs.princeton.edu/24pq/words3.txt"; 
  private static String[] inputs;
  @BeforeClass
  public static void loadTestFiles() throws IOException {
    List<String> readInputList = readStringsInTextFile(wordsURL);
    inputs = readInputList.toArray(new String[0]);
  }
  
  @Test
  public void sortHeap() {
    for(String s: inputs) {
      System.out.print(s + ", ");
    }
    System.out.format("%nNow sorted%n ");

    Heap.sort(inputs);
    for(String s: inputs) {
      System.out.format(s + ", ");
    }
  }

}
