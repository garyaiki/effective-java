package ch.concurrency;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import com.google.common.collect.ForwardingSet;

public class ObservableSet<E> extends ForwardingSet<E> {
	
	final Set<E> delegate; // backing set
	public ObservableSet(Set<E> delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	protected Set<E> delegate() {
		return delegate;
	}

	// CopyOnWrite makes a copy of the array for all write operations
	private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<SetObserver<E>>();
	
	public void addObserver(SetObserver<E> observer) {
		observers.add(observer); // this would have to be in a synchronized block without CopyOnWriteArrayList
	}
	
	public void removeObserver(SetObserver<E> observer) {
		observers.remove(observer); // this would have to be in a synchronized block without CopyOnWriteArrayList
	}
	// snapshot can be safely traversed within a lock
	private void notifyElementAdded(E element) {
/*		List<SetObserver<E>> snapshot = null; Unnecessary because of CopyOnWriteArrayList
		synchronized(observers) {
			snapshot = new ArrayList<SetObserver<E>>(observers);
		}
*/
		for (SetObserver<E> observer : observers) {
			observer.added(this, element);
		}
	}
	
	@Override
	public boolean add(E element) {
		boolean added = super.add(element);
		if(added) {
			notifyElementAdded(element);
		}
		return added;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;
		for ( E element : c) {
			result |= add(element); // note |= is equivalent to result = add(element) | result
		}
		return result;
	}
}
