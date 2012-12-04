package se.forkjoin;

import java.util.concurrent.ThreadLocalRandom;

public class Problem {
	
	  private final int[] list = new int[2000000];

	  public Problem() {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
	    for (int i = 0; i < list.length; i++) {
	      list[i] = tlr.nextInt(500000,500000000);
	    }
	  }

	  public int[] getList() {
	    return list;
	  }

}
