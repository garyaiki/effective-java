package ch.six;

import com.google.common.base.Enums;
import com.google.common.base.Optional;

/*
 * Item 30
 * +typesafe
 * +immutable
 * +a gereralization of singleton
 * +printable toString()
 * +may add methods and fields and implement interfaces
 * +implement all Object methods and Comparable, Serializable interfaces
 */
public class EnumsOverIntConstants {

	public enum Apple { FUJI, PIPPIN, GRANNY_SMITH }
	// Enums should usually be top level classes
	public enum Planet {
		MERCURY(3.3023+23, 2.439e6),
		VENUS(4.869e+24, 6.052e6);
		
		private final double mass;
		private final double radius;
		private final double surfaceGravity;
		private static final double G = 6.67300E-11;
		
		Planet(double mass, double radius) {
			this.mass = mass;
			this.radius = radius;
			surfaceGravity = G * mass / (radius * radius);
		}

		public double getMass() {
			return mass;
		}

		public double getRadius() {
			return radius;
		}

		public double getSurfaceGravity() {
			return surfaceGravity;
		}
		
		public double surfaceWeight(double mass) {
			return mass * surfaceGravity;
		}
	}
	
	// Guava Enums utility methods
	public static void main(String[] args) {
		Optional<Planet> op = Enums.getIfPresent(Planet.class, "surfaceGravity");
		Optional<Planet> op2 = Enums.getIfPresent(Planet.class, "MERCURY");
		System.out.println(Enums.getField(Planet.MERCURY) + " " + op + " " + op2);
		System.out.println(Operation.PLUS.apply(10.0, 5.5));

	}
	
	//Constant specific method implementations
	public enum Operation {
		PLUS {double apply(double x, double y) {return x + y;} },
		MINUS {double apply(double x, double y) {return x - y;} };
		abstract double apply(double x, double y);
	}
	
}
