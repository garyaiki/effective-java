package ch.concurrency;
// callback interface
public interface SetObserver<E> {
	// invoked when an element is added to the observable set
	void added(ObservableSet<E>set, E element);

}
