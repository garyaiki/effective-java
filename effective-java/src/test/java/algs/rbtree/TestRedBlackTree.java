package algs.rbtree;

import static algs.utils.ScanRemoteFiles.readStringsInTextFile;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestRedBlackTree {
  private static String tinySTURL = "http://algs4.cs.princeton.edu/33balanced/tinyST.txt";
  private static String[] inputs;
  
  @BeforeClass
  public static void loadTestFiles() throws IOException {
    List<String> readInputList = readStringsInTextFile(tinySTURL);
    inputs = readInputList.toArray(new String[0]);
  }
  
  @Test
  public void buildRBTree() {
    System.out.format("%nRaw input%n ");    
    for(String s: inputs) {
      System.out.format("%s ", s);
    }
    System.out.format("%nBuild RedBlackTree%n ");   
    RedBlackTree<Integer> rbTree = new RedBlackTree<Integer>();
    int value = 0;
    for(String key: inputs) {
      rbTree.put(key, value++);
    }
    for(int i = 0; i < rbTree.treeSize(); i++) {
      String key = rbTree.select(i);
      System.out.format("Key %s Value %d, ", key, rbTree.get(key));
    }
  }
}
