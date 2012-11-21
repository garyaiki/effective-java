package ch.seven;

import static com.google.common.base.Preconditions.checkArgument;

import java.sql.Date;

/* Item 39
 * Make a defensible copy of each mutable parameter to the constructor
 * Simply passing a reference in the constructor allows client to modify caller
 */
public class MakeDefensiveCopies {

	private final Date start;
	private final Date end;

	public MakeDefensiveCopies(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		
		// make copies BEFORE checking preconditions
		checkArgument(this.start.compareTo(this.end) < 0, "start must be before end");
	}
	// Defensive accessor; even though fields are final their contained fields are still mutable
	public Date getStart() {
		return new Date(start.getTime());
	}

	public Date getEnd() {
		return new Date(end.getTime());
	}


	
	
}
