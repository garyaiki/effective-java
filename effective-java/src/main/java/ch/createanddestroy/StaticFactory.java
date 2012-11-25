package ch.createanddestroy;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service.State;

public class StaticFactory {
	/* Item 1 static factory methods +have names +not required to make everytime invoked
	 * +can return subtype +less verbose with parameterized types */
	public static Boolean makeBoolean(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}
	//less verbose than creation with parameterized types
	Map<String, List<String>> map = Maps.newHashMap();
	
	void testGuavaService() throws InterruptedException, ExecutionException, TimeoutException {
		Service service = new ExecutionThreadService();


		State state = service.startAndWait();
		if(state == Service.State.RUNNING) {
			// http://code.google.com/p/guava-libraries/wiki/ListenableFutureExplained
				state = service.stop().get(1, TimeUnit.SECONDS);

			if(state == Service.State.TERMINATED) {
				// Stopped OK
			}
		}
	}
	/* http://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
	 * static nested classes don't have access to enclosing class. Non-static classes do.
	 * example at https://gist.github.com/3354249
	 */
	static class ExecutionThreadService extends AbstractExecutionThreadService {

		@Override
		protected void run() throws Exception {
			while(isRunning() && !Thread.currentThread().isInterrupted()) {
				//ok
			}
			
		}
		
	}
}
