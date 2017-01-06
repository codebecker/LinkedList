package linkedList;

/**
 * LinkedList implementation with double link.
 * 
 * @author Chris
 */
public class List<T> {
	// first an last element pointing at null by default
	private ListElement<T> firstElement = null;
	private ListElement<T> lastElement = null;

	/**
	 * Generates a new empty List
	 */
	public List() {
	}

	/**
	 * Add an entry at the beginning.
	 * 
	 * @param object
	 *            object witch should be saved.
	 */
	public void addFirst(T object) {
		ListElement<T> newElement = new ListElement<T>(object);
		if (firstElement == null) {
			firstElement = newElement;
			lastElement = newElement;
		} else {
			newElement.setNextElem(firstElement);
			firstElement.setPreviousElem(newElement);
			firstElement = newElement;
		}
	}

	/**
	 * Adds an entry at the end.
	 * 
	 * @param object
	 *            object witch should be saved.
	 */
	public void addLast(T object) {

		ListElement<T> newElement = new ListElement<T>(object);

		if (firstElement == null) {
			firstElement = newElement;
			lastElement = newElement;
		} else {
			newElement.setPreviousElem(lastElement);
			lastElement.setNextElem(newElement);
			lastElement = newElement;
		}

	}

	/**
	 * Adds an entry at the specified Index.
	 * 
	 * @param index
	 *            Index at which the entry should be added.
	 * @param object
	 *            object witch should be saved.
	 */
	public void addNewElement(int index, T object) {
		ListElement<T> pointerElem = firstElement;
		ListElement<T> newElement = new ListElement<T>(object);

		// check if index is out of bounce
		assert (index >= 0 & index <= this.getSize()) : "Can't add entry's outside a lists border";

		if (firstElement == null) {
			firstElement = newElement;
			lastElement = newElement;
		} else if (index == 0) {
			this.addFirst(object);
		} else if (index == this.getSize()) {
			this.addLast(object);
		} else {
			// searches for the element
			for (int i = 0; i < index; i++) {
				pointerElem = pointerElem.getNextElem();
			}

			// add the element at the position
			newElement.setPreviousElem(pointerElem.getPreviousElem());
			pointerElem.setPreviousElem(newElement);
			newElement.setNextElem(pointerElem);
			newElement.getPreviousElem().setNextElem(newElement);

		}
	}

	/**
	 * Search an entry at the specified index.
	 * 
	 * @param index
	 *            index ot the entry which should be.
	 * @return Value of the entry.
	 */
	public T getListelementContent(int index) {
		ListElement<T> pointerElem = firstElement;
		assert (firstElement != null) : "Can't get entry's from an empty list";

		// check if index is out of bounce
		assert (index >= 0 & index <= this.getSize()) : "Index is out of bounce";

		for (int i = 0; i < index; i++) {
			pointerElem = pointerElem.getNextElem();
		}
		T content = pointerElem.getContent();
		return content;
	}

	/**
	 * Delete the first entry.
	 * 
	 * @return Value of the deleted entry.
	 */
	public T removeFirst() {

		assert (firstElement != null) : "Can't delete from an empty list";

		T deletedContendBuffer = firstElement.getContent();

		firstElement.getNextElem().setPreviousElem(null);
		firstElement = firstElement.getNextElem();
		return deletedContendBuffer;
	}

	/**
	 * Delete the last entry.
	 * 
	 * @return Value of the deleted entry.
	 */
	public T removeLast() {
		// check if list is empty
		assert (firstElement != null) : "Can't delete from an empty list";

		T deletedContendBuffer = lastElement.getContent();
		lastElement.getPreviousElem().setNextElem(null);
		lastElement = lastElement.getPreviousElem();
		return deletedContendBuffer;
	}

	/**
	 * Get number of entry's.
	 * 
	 * @return number of entry's as Integer.
	 */
	public int getSize() {
		int counter = 0;
		ListElement<T> pointerElement = firstElement;
		// iterate through the list and count number of entry's
		while (pointerElement != null) {
			counter++;
			pointerElement = pointerElement.getNextElem();
		}
		return counter;
	}

}
