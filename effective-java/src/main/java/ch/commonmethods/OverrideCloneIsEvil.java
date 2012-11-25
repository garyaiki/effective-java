package ch.commonmethods;

public class OverrideCloneIsEvil {
	/* Item 11 Clonable is a mixin interface marking a class as permitting cloning
	 * unfortunately it lacks a clone method and the Object class clone method is protected
	 * 
	 * If a class implements Clonable, clone() returns a field by field copy of the object BAD STYLE
	 * All superclasses must also have a "properley functioning" clone()
	 * In effect clone() is a problemetic constructor
	 * Prefer a copy constructor or a static factory
	 */
	private String x;
	private String y;
	private String z;
	
	//Copy Constructor Google does this, they don't clone()
	public OverrideCloneIsEvil(OverrideCloneIsEvil overrideCloneIsEvil) {
		this.x = overrideCloneIsEvil.x;
		this.y = overrideCloneIsEvil.y;
		this.z = overrideCloneIsEvil.z;
	}
	
	public OverrideCloneIsEvil() {
		// TODO Auto-generated constructor stub
	}

	// static factory is ok too
	public static OverrideCloneIsEvil newInstance(OverrideCloneIsEvil overrideCloneIsEvil) {
		OverrideCloneIsEvil copy = new OverrideCloneIsEvil();
		copy.x = overrideCloneIsEvil.x;
		copy.y = overrideCloneIsEvil.y;
		copy.z = overrideCloneIsEvil.z;
		return copy;
	}
}
