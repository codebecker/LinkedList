package linkedList;

import java.util.NoSuchElementException;

/**
 * Implementation of double Linked list.
 * 
 * @param T
 *            Object which will be saved in list
 * @author Chris
 */
public class List<T> {
	private ListElement<T> firstElement, lastElement;
	
	private int size = 0;

	/**
	 * Add entry at the beginning.
	 * 
	 * @param content
	 *            content of the entry.
	 */
	public void addFirst(T content) {
		ListElement<T> newElement = new ListElement<T>(content);
		if (firstElement == null) {
			firstElement = newElement;
			lastElement = newElement;
		} else {
			newElement.setNextElement(firstElement);
			firstElement.setPreviousElement(newElement);
			firstElement = newElement;
		}
		size ++;
	}

	/**
	 * Adds an entry at the end.
	 * 
	 * @param content
	 *            content of the entry.
	 */
	public void addLast(T content) {

		ListElement<T> newElement = new ListElement<T>(content);

		if (firstElement == null) {
			firstElement = newElement;
			lastElement = newElement;
		} else {
			newElement.setPreviousElement(lastElement);
			lastElement.setNextElement(newElement);
			lastElement = newElement;
		}
		size ++;

	}

	/**
	 * Adds an entry at the specified Index.
	 * 
	 * @param index
	 *            Index at which the entry should be added.
	 * @param object
	 *            object which should be saved.
	 */
	public void add(int index, T object) {

		if (index < 0 || index > this.getSize()) {
			throw new IndexOutOfBoundsException("Length of List: " + this.getSize() + " Index: " + index);
		}

		ListElement<T> indexElement = firstElement;
		ListElement<T> newElement = new ListElement<T>(object);

		if (firstElement == null) {
			firstElement = newElement;
			lastElement = newElement;
		} else if (index == 0) {
			this.addFirst(object);
		} else if (index == this.getSize()) {
			this.addLast(object);
		} else {
			for (int i = 0; i < index; i++) {
				indexElement = indexElement.getNextElement();
			}

			// add the element at the position
			newElement.setPreviousElement(indexElement.getPreviousElement());
			indexElement.setPreviousElement(newElement);
			newElement.setNextElement(indexElement);
			newElement.getPreviousElement().setNextElement(newElement);

		}
		size ++;
	}

	/**
	 * @param index
	 *            index of the entry.
	 * @return Value of the entry.
	 */
	public T get(int index) {
		// check if index is out of bounds
		if (index < 0 || index >= this.getSize()) {
			throw new IndexOutOfBoundsException("Length of List: " + this.getSize() + " Index: " + index);
		}
		ListElement<T> indexElement = firstElement;

		for (int i = 0; i < index; i++) {
			indexElement = indexElement.getNextElement();
		}
		T content = indexElement.getContent();
		return content;
	}

	/**
	 * Removes first entry
	 * 
	 * @return Value of the removed entry.
	 */
	public T removeFirst() {

		if (firstElement == null) {
			throw new NoSuchElementException("Can't remove from an empty list");
		}

		T removedContent = firstElement.getContent();

		firstElement.getNextElement().setPreviousElement(null);
		firstElement = firstElement.getNextElement();
		size --;
		return removedContent;
	}

	/**
	 * Removes the last entry.
	 * 
	 * @return Value of the removed entry.
	 */
	public T removeLast() {
		if (firstElement == null) {
			throw new NoSuchElementException("Can't remove from an empty list");
		}

		T removedContent = lastElement.getContent();
		lastElement.getPreviousElement().setNextElement(null);
		lastElement = lastElement.getPreviousElement();
		size --;
		return removedContent;
	}

	/**
	 * Get amount of entries.
	 * 
	 * @return amount of entries as Integer.
	 */
	public int getSize() {
		return size;
	}

}
