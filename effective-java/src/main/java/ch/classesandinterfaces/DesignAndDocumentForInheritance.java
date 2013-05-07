package ch.classesandinterfaces;

/* Item 17
 * Overridden public, package-private methods and constructors must describe
 * what it overrides and if they're called before or after
 * By convention the comment ends with "This implementation" precisely describing the override
 * This convention problematically exposes implementation details
 * Test classes intended for subclasses by writing subclasses
 * 
 * Constructors MUST NOT call overridable methods; overriding method called before subclass constructed
 * This restriction also applies to Clonable and Serializable; neither clone() or readObject()
 * may invoke an overridable method.
 * Serializable readResolve() and writeReplace() must be protected Not private so subclass calls them 
 * 
 * Scala adds "sealed" modifier which allows overriding but only in the same source file. This allows only you to define
 * sub-classes
 */
public class DesignAndDocumentForInheritance {

}
