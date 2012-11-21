package ch.six;
/* Item 34
 * A rare justification of extending enums is for opcodes
 */

public class ExtensibleEnumsWithInterfaces {
	
	public interface Operation {
		double apply(double x, double y);
	}

	public enum BasicOperation implements Operation {
		
		PLUS("+") {
			public double apply(double x, double y) { return x + y;}
		},
		MINUS("-") {
			public double apply(double x, double y) { return x - y;}
		},
		TIMES("*") {
			public double apply(double x, double y) { return x * y;}
		},
		DIVIDE("/") {
			public double apply(double x, double y) { return x / y;}
		};
		
		private final String symbol;
		
		BasicOperation(String symbol) {
			this.symbol = symbol;
		}
		
		@Override
		public String toString() {
			return symbol;
		}
	}
	
	public enum ExtendedOperation implements Operation {
		
		EXP("^") {
			public double apply(double x, double y) { return Math.pow(x, y);}
		},
		REMAINDER("%") {
			public double apply(double x, double y) { return x % y;}
		};
		
		private final String symbol;
		
		ExtendedOperation(String symbol) {
			this.symbol = symbol;
		}
		
		@Override
		public String toString() {
			return symbol;
		}
	}
}
