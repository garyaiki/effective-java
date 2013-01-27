package algs.pq;

import static algs.utils.ScanRemoteFiles.readStringsInTextFile;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestMaxPriorityQueue {
  private static String tinyPQURL = "http://algs4.cs.princeton.edu/24pq/tinyPQ.txt";
  private static String[] inputs;
  
  @BeforeClass
  public static void loadTestFiles() throws IOException {
    List<String> readInputList = readStringsInTextFile(tinyPQURL);
    inputs = readInputList.toArray(new String[0]);
  }
  
  @Test
  public void buildQ() {
    System.out.format("%nRaw input%n ");    
    for(String s: inputs) {
      System.out.format("%s ", s);
    }
    System.out.format("%nBuild Max String Priority Queue%n ");   
    MaxStringPQ maxPQ = new MaxStringPQ(inputs.length);
    for(String item: inputs) {
      if(!item.equals("-")) {
        maxPQ.insert(item);
      } else if (!maxPQ.isEmpty()) {
        System.out.format(" delete \"%s\" ", maxPQ.deleteMax());   
      }
      System.out.format("PQ size %d, ", maxPQ.size());   

    }

  }
}
