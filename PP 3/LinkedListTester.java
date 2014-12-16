import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test classes LinkedList and LLNode
 */
public class LinkedListTester {
  
  /**
   * Test the insertAfter method
   */
  @Test
  public void testInsertAfter() {
    LLNode<Integer> listNode = new LLNode<Integer>(1, null);
    listNode.insertAfter(3);
    assertEquals("Inserting on end of list. Checking new next node", new Integer(3), listNode.getNext().getElement());
    assertEquals("Checking next's next", null, listNode.getNext().getNext());
    listNode.insertAfter(2);
    assertEquals("Inserting in middle of list. Checking new next node", new Integer(2), listNode.getNext().getElement());
    assertEquals("Checking next's next", new Integer(3), listNode.getNext().getNext().getElement());
  }
  
  /**
   * Test the deleteNext method
   */
  @Test
  public void testDeleteNext() {
    LLNode<Integer> listNode = new LLNode<Integer>(1, new LLNode<Integer>(2, new LLNode<Integer>(3, null)));
    listNode.deleteNext();
    assertEquals("deleting from middle of list", new Integer(3), listNode.getNext().getElement());
    listNode.deleteNext();
    assertEquals("deleting last node of list", null, listNode.getNext());
    listNode.deleteNext();
    assertEquals("deleting when next is null", null, listNode.getNext());
  }
  
  /**
   * Test the toString method
   */
  @Test
  public void testToString() {
    LinkedList<Integer> list = new LinkedList<Integer>();
    assertEquals("Testing empty list", "list:", list.toString());
    list.addToFront(3);
    assertEquals("Testing list of one node", "list: 3", list.toString());
    list.addToFront(2);
    assertEquals("Testing list of two nodes", "list: 2 3", list.toString());
    list.addToFront(1);
    assertEquals("Testing list of three nodes", "list: 1 2 3", list.toString());
  }
  
  /**
   * Test the contains method
   */
  @Test
  public void testContains() {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.addToFront(3);
    list.addToFront(2);
    list.addToFront(1);
    list.addToFront(0);
    assertTrue("This Dun Goofed", list.contains(0));
    assertTrue("This Dun Goofed", list.contains(1));
    assertTrue("This Dun Goofed", list.contains(2));
    assertTrue("This Dun Goofed", list.contains(3));
    assertFalse("This Dun Goofed, the other way", list.contains(4));
  }
  
  /**
   * Test the remove method
   */
  @Test
  public void testRemove() {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.addToFront(4);
    list.addToFront(3);
    list.addToFront(2);
    list.addToFront(1);
    list.remove(5);
    assertEquals("Removing element not in list", "list: 1 2 3 4", list.toString());
    list.remove(3);
    assertEquals("Removing middle element", "list: 1 2 4", list.toString());
    list.remove(1);
    assertEquals("Removing first element", "list: 2 4", list.toString());
    list.remove(4);
    assertEquals("Removing last element", "list: 2", list.toString());
    list.remove(2);
    assertEquals("Removing only element", "list:", list.toString());
    list.remove(0);
    assertEquals("Removing from empty list", "list:", list.toString());
  }
  
}