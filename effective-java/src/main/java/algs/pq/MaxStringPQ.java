package algs.pq;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

public class MaxStringPQ {
  private String[] pQueue;
  int qSize = 0;

  /**
   * @param capacity
   * @param type
   * Can't create generic array
   * @see http://www.informatics.susx.ac.uk/courses/dats/notes/html/node181.html
   */
  public MaxStringPQ(int capacity) {
    pQueue = new String[capacity + 1];
  }

  public MaxStringPQ(String[] keys) {
    this(keys.length);
    qSize = keys.length;
    for(int i = 0; i < qSize; i++) {
      pQueue[i + 1] = keys[i]; // pQueue 1 based, keys zero based
    }
    for(int half = qSize/2; half >= 1; half--) {
      sink(half);
    }
    checkState(isMaxHeap() == true, "Subtree of pQueue rooted is not a max heap");
  }
  
  public boolean isEmpty() {
    return qSize == 0;
  }
  
  public int size() {
    return qSize;
  }
  
  public void insert (String key) {
    if (qSize >= pQueue.length - 1) {
      resize(pQueue.length * 2);
    }
    pQueue[++qSize] = key;
    swim(qSize);
    checkState(isMaxHeap() == true, "Subtree of pQueue rooted is not a max heap");
  }
  
  public String deleteMax() {
    checkState(!isEmpty(), "Can't delete, priority queue is empty" );
    String max = pQueue[1];
    exch(1, qSize--);
    sink(1);
    pQueue[qSize + 1] = null;
    if((qSize > 0) && (qSize == (pQueue.length - 1) / 4)) {
      resize(pQueue.length / 2);
    }
    checkState(isMaxHeap() == true, "Subtree of pQueue rooted is not a max heap");
    return max;
  }
  private void swim(int half) {
    while(half > 1 && less(half/2, half)) {
      exch(half, half/2);
      half = half/2;
    }
  }
  
  private void sink(int half) {
    while (half * 2 <= qSize) {
      int full = half * 2;
      if(full < qSize && less(full, full + 1)) {
        full++;
      }
      if(!less(half, full)) {
        break;
      }
      exch(half, full);
      half = full;
    }
  }
  private void resize(int capacity) {
    checkArgument(capacity > qSize, "New capacity argument is not greater than current Q size.");
    String[] temp = new String[capacity];
    for(int i = 1; i <= qSize; i++) {
      temp[i] = pQueue[i];
    }
    pQueue = temp;
  }
  
  private boolean isMaxHeap() {
    return isMaxHeap(1);
  }
  
  private boolean isMaxHeap(int half) {
    if(half > qSize) {
      return true;
    }
    int left = half * 2;
    int right = half * 2 + 1;
    if(left <= qSize && less(half, left)) {
      return false;
    }
    if(right <= qSize && less(half, right)) {
      return false;
    }
    return isMaxHeap(left) && isMaxHeap(right);
  }
  
  private boolean less( int lo, int hi) {
    return pQueue[lo].compareTo(pQueue[hi]) < 0;
  }
  
  private void exch(int i, int j) {
    String temp = pQueue[i];
    pQueue[i] = pQueue[j];
    pQueue[j] = temp;
  }
}
