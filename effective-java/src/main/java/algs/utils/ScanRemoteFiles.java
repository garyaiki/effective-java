package algs.utils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanRemoteFiles {
  
  public static List<Integer> readIntegersInTextFile(String urlString) throws IOException {
    URL url = new URL(urlString);
    try(Scanner scanner = new Scanner(url.openStream());) {
      List<Integer> integers = new ArrayList<Integer>();
      while(scanner.hasNextInt()) {
        integers.add(scanner.nextInt());
      }
      return integers;
    } // close scanner
  }
  
  public static List<String> readStringsInTextFile(String urlString) throws IOException {
    URL url = new URL(urlString);
    try(Scanner scanner = new Scanner(url.openStream());) {
      List<String> strings = new ArrayList<String>();
      while(scanner.hasNext()) {
        strings.add(scanner.next());
      }
      return strings;
    } // close scanner
  }

}
