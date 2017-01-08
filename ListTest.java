package linkedList;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * JUnit test for the List class.
 * 
 * @author Chris
 *
 */
public class ListTest {
	List<String> list;

	/**
	 * initialize the list so it's empty for every test.
	 */
	@Before
	public void setUp() {
		list = new List<String>();
	}

	/**
	 * fill test list with test elements in descending order.
	 * 
	 * @param amount
	 *            amount of elements
	 * @param testString
	 *            content of elements
	 */
	public void fillListWithElements(int amount, String testString) {
		for (int i = 0; i < amount; i++) {
			list.addFirst(testString + i);
		}
	}

	/**
	 * Test if an entry can be added at the beginning of an empty List.
	 */
	@Test
	public void testAddFirstEmptyList() {
		list.addFirst("teststring");
		assertEquals("teststring", list.get(0));
	}

	/**
	 * Test if an entry can be added at the end of an empty List.
	 */
	@Test
	public void testAddLastEmptyList() {
		list.addLast("teststring");
		assertEquals("teststring", list.get(0));
	}

	/**
	 * Test if multiple entries can be added at the beginning of an empty list.
	 */
	@Test
	public void testAddTenFirstElements() {
		int amountOfTestElements = 10;
		String testString = "test";
		fillListWithElements(amountOfTestElements, testString);

		for (int i = 0; i < amountOfTestElements; i++) {
			String teststring = testString + (amountOfTestElements - 1 - i);
			assertEquals(teststring, list.get(i));
		}
	}

	/**
	 * Test all the Methods which add entries on a list in one.
	 */
	@Test
	public void testaddNewListelement() {

		int amountOfTestElements = 10;
		String testString = "test";
		fillListWithElements(amountOfTestElements, testString);

		// add entries at the middle of the list and check if them
		for (int i = 3; i < 6; i++) {
			list.add(i, testString + i);
			assertEquals(testString + i, list.get(i));
		}
	}

	@Test
	public void testListSizeWithTenElements() {
		int amountOfTestElements = 10;
		String testString = "test";
		fillListWithElements(amountOfTestElements, testString);
		assertEquals(10, list.getSize());
	}

	/**
	 * Checks if entries at the beginning could be removed.
	 */
	@Test
	public void testRemoveFirst() {
		String teststring = "TestDefaultText";

		int amountOfTestElements = 8;
		fillListWithElements(amountOfTestElements, teststring);

		// remove first element from list
		assertEquals("TestDefaultText" + (amountOfTestElements - 1), list.removeFirst());
		assertEquals("TestDefaultText" + (amountOfTestElements - 2), list.get(0));
	}

	/**
	 * Checks if entries at the end are removed as expected.
	 */
	@Test
	public void testRemoveLast() {
		String teststring = "TestDefaultText";

		int amountOfTestElements = 8;
		fillListWithElements(amountOfTestElements, teststring);

		// remove last element from list
		assertEquals(teststring + 0, list.removeLast());
		assertEquals(teststring + 1, list.get(list.getSize() - 1));
	}

	/**
	 * Test if removing last entry from an empty list throws an exception.
	 */
	@Test(expected = NoSuchElementException.class)
	public void testRemoveLastOnEmptyList() {

		list.removeLast();

	}

	/**
	 * Test if removing first entry from an empty list throws an exception.
	 */
	@Test(expected = NoSuchElementException.class)
	public void testRemoveFirstOnEmptyList() {

		list.removeFirst();

	}

}
