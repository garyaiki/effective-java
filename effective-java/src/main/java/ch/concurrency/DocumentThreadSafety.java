package ch.concurrency;
/* Item 70
 * synchronized modifier does not mean threadsafe
 * @Immutable classes are threadsafe
 * @Threadsafe unconditionally: Mutable classes with sufficient internal synchronization such as ConncurrentHashMap
 * @Threadsafe conditionally : Mutable classes that require external synchronization of a small number of methods
 * @NotThreadSafe: classes must be have each method surrounded by synchronization
 * Thread hostile: not safe even if all methods surrounded by synchronization
 */
public class DocumentThreadSafety {
	/* Concurrent utils annotations document threadsafety
	 * @Immutable classes are threadsafe
	 * @Threadsafe unconditionally: Mutable classes with sufficient internal synchronization such as ConncurrentHashMap
	 * @Threadsafe conditionally : Mutable classes that require external synchronization of a small number of methods
	 * @NotThreadSafe: classes must be have each method surrounded by synchronization
	 * @NotThreadSafe Thread hostile: not safe even if all methods surrounded by synchronization
	 */
	
	// Private lock for unconditionally threadsafe classes
	private final Object lock = new Object();
	/**
	 * @Threadsafe this method is internally synchronized
	 */
	public void foo() {
		synchronized(lock) { // client has no access to lock, prevents them from holding it too long
			// 
		}

	}

}
