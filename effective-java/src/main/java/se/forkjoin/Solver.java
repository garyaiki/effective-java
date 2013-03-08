package se.forkjoin;
/*
 * Create a pool of threads, each thread has a deque (LIFO and FIFO)
 * ForkJoinTasks recursive divide themselves into subtasks which are pushed and popped to the LIFO
 * When a threads deque is empty it pops from another thread's FIFO (work stealing)
 * Stealing from the other end of the deque reduces contention
 * Also, divide and conquer produces large tasks early so their at the front.
 * FJTasks are given a threshold below which it is more efficient to process without forking
 * FJTasks are Runnable and implement Future 
 * RecursiveTask extends FJTask with compute() and returns a result
 * RecursiveAction extends FJTask with compute() and does not return a result
 * Small task granularities (100..10000) tend to run faster 
 */
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author garystruthers
 * Scala parallel collections wrap fork/join, good for things where processing order doesn't matter, like map,filter,flatMap,forAll
 */
public class Solver extends RecursiveAction {
	private int[] list;
	public long result;

	public Solver(int[] array) {
		this.list = array;
	}
	@Override
	protected void compute() {
		if (list.length == 1) {
			result = list[0];
		} else {
			int midpoint = list.length / 2;
			int[] l1 = Arrays.copyOfRange(list, 0, midpoint);
			int[] l2 = Arrays.copyOfRange(list, midpoint, list.length);
			Solver s1 = new Solver(l1);
			Solver s2 = new Solver(l2);
			invokeAll(s1, s2);
			result = s1.result + s2.result;
		}
	}

	/**
	 * @param args
	 */
	 public static void main(String[] args) {
		    Problem test = new Problem();
		    // Check the number of available processors
		    int nThreads = Runtime.getRuntime().availableProcessors();
		    System.out.println(nThreads);
		    Solver mfj = new Solver(test.getList());
		    ForkJoinPool pool = new ForkJoinPool(nThreads);
		    pool.invoke(mfj);
		    long stealCount = pool.getStealCount();
		    long result = mfj.result;
		    System.out.format("Done. Result:  %d%n", result);
		    System.out.format("Steal count: %d%n", stealCount);
		    long sum = 0;
		    // Check if the result was ok
		    for (int i = 0; i < test.getList().length; i++) {
		      sum += test.getList()[i];
		    }
		    System.out.println("Done. Result: " + sum);
	 }

}
