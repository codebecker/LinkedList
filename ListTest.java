package linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

import jdk.nashorn.internal.runtime.Context.ThrowErrorManager;

/**
 * JUnit test setup for the List class.
 * @author Chris
 *
 */
public class ListTest {
	//global list declaration for testing
	List<String> list;
	
	/**
	 * Declares the global list new for each test so it is empty.
	 */
	@Before
	public void setUp(){
		list = new List<String>();
	}
	
	/**
	 * Test if a entry can be added at the beginning of an empty List.
	 */
	@Test
	public void testAddFirstEmptyList() {
		list.addFirst("teststring");
		assertEquals("teststring", list.getListelementContent(0));
	}
	
	/**
	 * Test if an entry can be added at the end of an empty List.
	 */
	@Test
	public void testAddLastEmptyList() {
		list.addLast("teststring");
		assertEquals("teststring", list.getListelementContent(0));
	}
	
	/**
	 * Test if multiple entry's can be added at the beginning of an empty.
	 */
	@Test
	public void testAddFirstMultipleElements() {
		String teststring;
		// fills the list with test entry's containing strings
		for (int i = 0; i < 10; i++) {
			teststring = "test" + i;
			list.addFirst(teststring);
		}
		//checks entry's content and throws an assert if necessary
		for (int i = 0; i < 10; i++) {
			teststring = "test" + (9 - i);
			assertEquals(teststring, list.getListelementContent(i));
		}
	}
	

	/**
	 * Test all the Methods which add entry's on a list in one sequence.
	 */
	@Test
	public void testaddNewListelement() {
		String teststring = "testdefaulttext";
		
		// fills the list with test entry's containing strings
		for (int i = 0; i < 10; i++) {
			list.addNewElement(i, teststring);
		}
		//checks entry's content and throws an assert if necessary
		for (int i = 0; i < 10; i++) {
			assertEquals(teststring, list.getListelementContent(i));
		}
		// add entry's at the middle of the list and check if them
		for (int i = 3; i < 6; i++) {
			list.addNewElement(i, "teststring" + i);
			assertEquals("teststring" + i, list.getListelementContent(i));
		}

		// add entry at the beginning and check
		list.addNewElement(0, "testtextatbeginning");
		assertEquals("testtextatbeginning", list.getListelementContent(0));

		// add entry at the seccond index and check
		list.addNewElement(1, "testtextatbeginning1");
		assertEquals("testtextatbeginning1", list.getListelementContent(1));

		// add an entry at the end with addNewElement Method and check
		list.addNewElement(list.getSize(), "testextatend");
		assertEquals("testextatend", list.getListelementContent(list.getSize() - 1));

		// add an entry at the seccond last index with addNewElement Method and check
		list.addNewElement(list.getSize() - 1, "testextatend1");
		assertEquals("testextatend1", list.getListelementContent(list.getSize() - 2));

		//check if the number of entry's is correct
		assertEquals(17, list.getSize());
	}

	/**
	 * Checks if entry's at the beginning could be removed.
	 */
	@Test
	public void testRemoveFirst() {
		String teststring = "testdefaulttext";

		// fülle die liste mit testelementen
		for (int i = 0; i < 10; i++) {
			list.addNewElement(i, teststring + i);
		}
		// remove first element from list
		list.removeFirst();
		assertEquals("testdefaulttext1", list.getListelementContent(0));
	}
	/**
	 * Checks if entry's at the end could be removed.
	 */
	@Test
	public void testRemoveLast() {
		String teststring = "testdefaulttext";

		// remove last element from empty list
		// list.removeLast();

		// fülle die liste mit testelementen
		for (int i = 0; i < 10; i++) {
			list.addNewElement(i, teststring + i);
		}
		// remove last element from list
		list.removeLast();
		assertEquals("testdefaulttext8", list.getListelementContent(list.getSize() - 1));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Test if removing entry's from a empty list throws an assert.
	 */
	@Test (expected = AssertionError.class)
	public void testRemoveLastonEmptyList() {
		
		list.removeLast();
		
	}

}
