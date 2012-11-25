package ch.createanddestroy;
/*
 * Call as BuilderPattern bp = new BuilderPattern.Builder(240, 8).calories(100).build();
 * 
 * 1.6 common interface for all builders
 * public interface Builder<T> {
 *   public T build();
 * }
 */
public class BuilderPattern {
	private final int servingSize;
	private final int servings;	
	private final int calories;	
	
	public static class Builder {
		private final int servingSize;
		private final int servings;
		
		private int calories = 0;
		
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val) {
			this.calories = val;
			return this;
		}
		
		public BuilderPattern build() {
			return new BuilderPattern(this);
		}
	}
	
	private BuilderPattern(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
	}

}
