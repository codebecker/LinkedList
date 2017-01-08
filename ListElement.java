package linkedList;

/**
 * ListElement represent entries in LinkedLists.
 * 
 * @author Chris
 */

public class ListElement<T> {

	/**
	 * If there is no previous or next element it is pointing at null.
	 */
	private ListElement<T> previousElement, nextElement;
	private T content;

	/**
	 * Generate an element with content.
	 * 
	 * @param newContent
	 *            content to be saved in the Element.
	 */
	public ListElement(T newContent) {
		this.content = newContent;
	}
	
	public ListElement<T> getPreviousElement() {
		return this.previousElement;
	}

	public void setPreviousElement(ListElement<T> previousElem) {
		this.previousElement = previousElem;
	}

	public ListElement<T> getNextElement() {
		return nextElement;
	}

	public void setNextElement(ListElement<T> nextElement) {
		this.nextElement = nextElement;
	}

	public T getContent() {
		return content;
	}
}
