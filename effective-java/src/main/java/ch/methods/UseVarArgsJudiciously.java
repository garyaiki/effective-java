package ch.methods;

import java.util.Arrays;

/* Item 42
 * Only use varargs when there is a variable list of arguments
 * varargs expensivly create an array better to specify each arg, with 4 or more varargs might be ok 
 */
public class UseVarArgsJudiciously {
	// for zero or more arguments
	static int sum(int...args) {
		int sum = 0;
		for (int arg : args) {
			sum += arg;
		}
		return sum;
	}

	// for one or more arguments
	static int min(int firstArg, int...remainingArgs) {
		int min = firstArg;
		for (int arg : remainingArgs) {
			min += arg;
		}
		return min;
	}
	
	// right way to print an array
	static void printArray(int...args) {
		System.out.println(Arrays.toString(args));
	}
}
