package ch.six;
/* Item 32
 * Use EnumSet instead of Bit Fields
 */
import java.util.EnumSet;
import java.util.Set;

/*
 * Item 32
 */
public class EnumSetOverBitFields {
	public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }
	
	public static void applyStyles(Set<Style> styles) {/* do something */ }
	
	static public void main(String[] args) {
		applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
	}
}
