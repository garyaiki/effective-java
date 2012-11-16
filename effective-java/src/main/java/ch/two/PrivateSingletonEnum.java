package ch.two;

public class PrivateSingletonEnum {
	
	public enum Elvis {
		INSTANCE;
		
		private int age;
		
		public int getAge() {
			return age;
		}
		
		public static void main() {
			Elvis elvis = Elvis.INSTANCE;
			int hisAge = elvis.getAge();
		}
	}

}
