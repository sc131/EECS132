/**@Author
  * Stephanie Collins
  * This class represents a Database, holding elements T and ordering them based on particular traits*/
import java.util.LinkedList;
import java.util.*;
public class Database<T extends DatabaseType<T>>{
 
  private LLNode<T> startList;
  private Hashtable<String, ArrayList<T>> dataIndexes = new Hashtable<String, ArrayList<T>>();
  
  /**@param an element of the database
    * This adds an element to the database
    * @return void*/
  public void add(T element){
    //checks if the intial LLNode is null
    if(startList == null){
      //initializes the first node to the input element
      startList = new LLNode<T>(element, null);
      //clears hashtable because all indexes are rendered irrelevant       
      dataIndexes.clear();
    }
    //if the node only contains one element, set the second element to input element
    else if(startList.getNext() == null){
      //sets next element to input element
      startList.setNext(new LLNode<T>(element, null));
      //clears hashtable because all indexes are rendered irrelevant 
      dataIndexes.clear();
    }
    //if there is more than one element in the node
    else{
      //holds second node
      LLNode<T> test = startList.getNext();
      //finds the last instantiated node
      while(test.getNext() != null){ 
        test = test.getNext();
      }
      //adds new node of (element) to the end of the node
      test.setNext(new LLNode<T>(element, null));
      //clears hashtable because all indexes are rendered irrelevant 
      dataIndexes.clear();
    }
   }
  
  /**@param an element to be deleted from the database
    * This removes an element from the database
    * @return void*/
  public void delete(T element){
    //creates an LLNode to hold the next value of the node
    LLNode<T> iter = startList;
    
    while(iter.getNext() != null){
      //holds the current value of the node
      LLNode<T> temp = iter;
      //holds the next value of the node
      iter = iter.getNext();
      //checks if the next node and the input element are the same in order to remove the given element
      if(temp.getNext().equals(element)){
        temp.setNext(iter);
        dataIndexes.clear();
      }
    }
  }
  
  /**@param a value to match in the database using the comparator
    * @return a LinkedList containing all elements in the database matching the input value*/
  public LinkedList<T> lookupInList(T element, Comparator<T> comp){
    //an LLNode to run through all nodes
    LLNode<T> iter = startList;
    //return value holding all values matching the input element
    LinkedList<T> compList = new LinkedList<T>();
    //runs through all nodes, comparing them with the input element
    while(iter != null){
      //uses the comparator to see if the input element and the element in iter are equal
      if(comp.compare(element, iter.getElement()) == 0){
        //adds element at iter to return 
        compList.add(iter.getElement());
      }
      iter = iter.getNext();
    }
    return compList;
  }
  
  /**@param element to lookup, arraylist to look for element in, comparator to compare elements
    * Looks for element in index using comp
    * @return linkedlist with all copies of element in index*/
  public LinkedList<T> lookupInIndex(T element, ArrayList<T> index, Comparator<T> comp){
    //searched is the index of the element in the ArrayList that is equal to the input element
    int searched = Collections.binarySearch(index, element, comp);
    //goes through list to find matching elements
    int i = searched;
    //linkedlist to return
    LinkedList<T> compList = new LinkedList<T>();
    //checks for elements equal to the input element below the index returned by the binary search 
    if(searched  >= 1 && comp.compare(index.get(searched),index.get(searched-1)) == 0){
      //finds the element with the lowest index matching the input element, starting at the value returned by the binary search 
      while(i > 0 && index.get(i-1).equals(index.get(searched))){
        i--;
      }
      //adds each element matching the input element from lowest index to the linkedlist
      while(i < index.size() && index.get(i).equals(index.get(searched))){
        compList.add(index.get(i));
        i++;
      }
    }
    //adds elements matching input element from searched (as the lowest index) until elements no longer are equal or end of list is reached
    else if(searched != index.size()-1 && comp.compare(index.get(searched), index.get(searched+1)) == 0){
      while(i < index.size() && index.get(i).equals(searched)){
        compList.add(index.get(i));
        i++;
      }
    }
    //adds single element at index searched
    else{
      System.out.println(searched);
      compList.add(index.get(searched));
    }
    return compList;
  }
  
  /**@param uses trait to make an arraylist organized by trait
    * Creates an arraylist of elements from the database, sorted by trait
    * @return void*/
  public void makeIndex(String trait){
    //if the database is not empty create an arraylist organized by trait
    if(startList.getElement() != null)
    {
      //creates a comparator to compare elements by trait
      Comparator<T> comp = startList.getElement().getComparatorByTrait(trait);
      //creates an arraylist to store elements
      ArrayList<T> indexes = new ArrayList<T>();
      //LLNode to run through elements of the database
      LLNode<T> temp = startList;
      while (temp != null)
      {
        //adds the element at temp to the arraylist
        indexes.add(temp.getElement());
        //gets the next node
        temp = temp.getNext();
      }
      //sorts the arraylist according the comparator's trait
      Collections.sort(indexes, comp);
      //adds the sorted arraylist to the hashtable 
      dataIndexes.put(trait, indexes);
    }
  }
  
  /**@param trait to use to find element
    * Find an element in the database using the trait and the corresponding value of the element
    * @return a linkedlist containing all values of element matching the input element*/
  public LinkedList<T> lookup(String trait, T element)
  {
    //returns an empty linkedlist if the database is empty
    if(startList.getElement() == null){
      return new LinkedList<T>();
    }
    //calls lookupindex to return a linked list for the specified trait and element if the hashtable has a key matching the trait
    else if(dataIndexes.containsKey(trait)){
      return lookupInIndex(element, dataIndexes.get(trait), element.getComparatorByTrait(trait));
    }
    //if an index doesn't exist in the hashtable for input trait, return the linkedlist from lookupinlist
    else{
      return lookupInList(element, element.getComparatorByTrait(trait));
    }  
  }
  
  /**@param trait to order list by
    * If an index for the input trait exists in the hashtable, return the corresponding arraylist
    * @return arraylist of trait from the hashtable or empty arraylist*/
  public ArrayList<T> getList(String trait){
    //if there is an arraylist for trait in the hashtable return it
    if(dataIndexes.get(trait) != null){
      return dataIndexes.get(trait);
    }
    //else if the database isn't empty call make index to create an arraylsit for type trait in the hashtable and return it
    else if(startList.getElement() != null){
      this.makeIndex(trait);
      return dataIndexes.get(trait);
    }
    //else return an ampty arraylist
    else{
       return new ArrayList<T>();
    }
  }
}