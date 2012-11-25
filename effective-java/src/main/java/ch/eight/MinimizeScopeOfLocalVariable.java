package ch.eight;
/* Item 45
 * In C variables were declared at the top of a method. Java programmers should break this habit.
 * DECLARE LOCAL VARIABLES WHERE THEY are FIRST USED
 * Scope of locals is from where they are declared to the end of the enclosing block
 * NEARLY EVERY LOCAL SHOULD have an INITIALIZER, try-catch is may force declaring before initialization
 * when it is used outside the try block
 *  
 */
public class MinimizeScopeOfLocalVariable {

// use this form for iterating over collections, variable declared in loop less error prone 
// {@code	for(Element e : c) { doSomething(); } }
	
	// make methods smaller so variable scopes don't overlap
}
