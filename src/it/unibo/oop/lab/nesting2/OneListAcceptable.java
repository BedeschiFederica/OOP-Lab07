package it.unibo.oop.lab.nesting2;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>
 * 		the type of the list
 */
public class OneListAcceptable<T> implements Acceptable<T> {
	private final List<T> list;
	
	/**
	 * Builds a new {@link OneListAcceptable}.
     * 
     * @param list 
     *      the list to accept
	 */
	public OneListAcceptable(List<T> list) {
		this.list = new ArrayList<T>(list);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Acceptor<T> acceptor() {
		return new Acceptor<T>() {
			
			/**
			 * {@inheritDoc}
			 */
			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				if (!OneListAcceptable.this.list.isEmpty() 
						&& OneListAcceptable.this.list.get(0).equals(newElement)) {
					OneListAcceptable.this.list.remove(0);
				}
				else {
					throw new ElementNotAcceptedException(newElement);
				}
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void end() throws EndNotAcceptedException {
				if (!OneListAcceptable.this.list.isEmpty()) {
					throw new EndNotAcceptedException();
				}
			}
			
		};
	}
}
