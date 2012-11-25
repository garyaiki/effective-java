package ch.eight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

/* Item 48
 * Float and Double are meant for scientific Not monetary calculations
 * Use BigDecimal, int or long for $
 * When BigDecimal is too slow use long and calculate in cents
 */
public class AvoidFloatAndDoubleForExactAnswers {

	private BigDecimal modelVal = new BigDecimal("24.455"); // for calculating
	private BigDecimal displayVal = modelVal.setScale(2, RoundingMode.HALF_EVEN); // for formatted display
	
	public void display() {
		NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
		usdCostFormat.setMinimumFractionDigits( 1 );
		usdCostFormat.setMaximumFractionDigits( 2 );
		System.out.println( usdCostFormat.format(displayVal.doubleValue()) );
	}
}
