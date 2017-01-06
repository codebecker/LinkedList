package linkedList;

/**
 * ListElement represent entry's in LinkedLists. Each ListElement knows his
 * previous and next neighbor by default pointing at null.
 * 
 * @author Chris
 */

public class ListElement<T> {

	// each ListElement knows his previous and next neighbor by default pointing
	// at null.
	// content type is dynamically allocated..
	private ListElement<T> previousElem, nextElem;
	private T content;

	/**
	 * Generate an empty ListElement.
	 */
	public ListElement() {
	}

	/**
	 * Generate a element with content
	 * 
	 * @param newContent
	 *            content to be saved in the element.
	 */
	public ListElement(T newContent) {
		this.content = newContent;
	}

	/**
	 * Get the previous ListElement. If it is null there is no previous
	 * ListElement.
	 * 
	 * @return reference to the previous ListElement.
	 */
	public ListElement<T> getPreviousElem() {
		return previousElem;
	}

	/**
	 * Set the previous listElement
	 * 
	 * @param previousElem
	 *            listElement which should be next Element.
	 * 
	 */
	public void setPreviousElem(ListElement<T> previousElem) {
		this.previousElem = previousElem;
	}

	/**
	 * Get the next listElement. If it is null there is no previous ListElement.
	 * 
	 * @return reference to the next listElement.
	 */
	public ListElement<T> getNextElem() {
		return nextElem;
	}

	/**
	 * Set next ListElement.
	 * 
	 * @param nextElem
	 *            reference to the next Element.
	 */
	public void setNextElem(ListElement<T> nextElem) {
		this.nextElem = nextElem;
	}

	/**
	 * Get content of ListElement.
	 * 
	 * @return content with previously allocated type.
	 */
	public T getContent() {
		return content;
	}
}
