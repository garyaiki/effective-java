package algs.heap;

/**
 * @author garystruthers
 * Array is any type that implements Comparable
 * @see http://stackoverflow.com/questions/1770972/java-generics-compareto-and-capture1-of
 */
public class Heap {
  
  public static <U extends Comparable<? super U>> void sort(U[] pQueue) {
    int qSize = pQueue.length;
    for(int half = qSize/2; half >= 1; half--) {
      sink(pQueue, half, qSize);
    }
    while (qSize > 1) {
      exch(pQueue, 1, qSize--);
      sink(pQueue, 1, qSize);
    }
  }

  private static <U extends Comparable<? super U>> void sink(U[] pQueue, int half, int qSize) {
    while(half * 2 <= qSize) {
      int full = half * 2;
      if(full < qSize && less(pQueue, full, full + 1)) {
        full++;
      }
      if(!less(pQueue, half, full)) {
        break;
      }
      exch(pQueue, half, full);
      half = full;
    }

  }
  
  private static <U extends Comparable<? super U>> boolean less(U[] pQueue, int lo, int hi) {
    return pQueue[lo - 1].compareTo(pQueue[hi - 1]) < 0;
  }
  
  private static <U extends Comparable<? super U>> void exch(U[] pQueue, int lo, int hi) {
    U tmp = pQueue[lo - 1];
    pQueue[lo - 1] = pQueue[hi - 1];
    pQueue[hi - 1] = tmp;
  }
}
