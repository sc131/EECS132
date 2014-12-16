/**@Author Stephanie Collins
  * This class creates a Database of Contacts*/
import java.util.*;

import java.util.LinkedList;

public class ContactDatabase<T> extends Database{
  
  /**@param Iterable object to print out
    * This prints out a list of objects base on the input list
    * @return String of list printed*/
  public String printList(Iterable iter){
    //creates a StringBuilder to hold the elements of the list
    StringBuilder b = new StringBuilder();
    //the number to print out number the elements of the list
    int i = 1;
    //prints out the objects of the list and adds each one to the StringBuilder
    for(Object it: iter){
      System.out.println(i + "." + " " + it);
      b.append(i + "." + " " + it + "\n");
      i++;
    }
    return b.toString();
  }
  
  /**Main method to run the program*/
  public static <T> void main(String[] args){
    //Creates a new ContactDatabase of Contacts
    ContactDatabase<Contact<Object>> c = new ContactDatabase<Contact<Object>>();
    //Scanner to take in user input
    Scanner scan = new Scanner(System.in);
    //String to hold first(keyword) input signature
    String input = "";
    //ArrayList to hold values returned by "listby" and "find" in order to use "delete"
    ArrayList<Contact<Object>> hold = new ArrayList<Contact<Object>>();
    //holds elements returned by "find" before transferring them to ArrayList hold
    LinkedList<Contact<Object>> temp1 = new LinkedList<Contact<Object>>();
    //keeps taking input and running the program until "quit" is entered
    while(!input.equals("quit")){
      //takes all input in one line of and splits it into usable pieces via an array
      String[] inputVals = scan.nextLine().split(" " );
      //sets input to equal the keyword
      input = inputVals[0];
      //if keyword is "add" then it creates a new contact and adds it to the database
      if(input.equals("add")){
        String name = inputVals[1];
        String number = inputVals[2];
        String email = inputVals[3];
        c.add(new Contact<Object>(name, number, email));
      }
      //prints an ordered list of contacts based on the trait the user types in
      if(input.equals("listby")){
        //hold keeps track of the returned ArrayList
        hold = c.getList(inputVals[1]);
        c.printList(hold);
      }
      //finds a contact based on the trait and value a user puts in
      if(input.equals("find"))
      {
        //Stores the given trait String in trait
        String trait = inputVals[1]; 
        //Stores the given value String in value
        String value = inputVals[2]; 
        //finds contact based on name
        if(trait.equals("name"))
        {
          //clears the linked list in order to hold a new one
          temp1.clear();
          //clears the arraylist to hold a new one
          hold.clear();
          //Stores a Contact to be looked up in the list
          Contact con = new Contact(value, null, null);
          //holds linkedlist returned by lookup method
          temp1 = c.lookup(trait, con);
          //copies everything from linkedlist to arraylist
          for(Contact it: temp1)
            hold.add(it);
          //prints list
          c.printList(hold);
          
        }
        //finds contact based on number
        else if(trait.equals("number"))
        {
          //clears previous entries of linkedlist
          temp1.clear();
          //clears previous entries of arraylist
          hold.clear();
          //Stores a Contact to be looked up in the list
          Contact con = new Contact(null, value, null);
          //holds linkedlist returned by lookup method
          temp1 = c.lookup(trait, con);
          //copies objects from linkedlist to arraylist
          for(Contact it: temp1)
            hold.add(it);
          c.printList(hold);
        }
        //finds contact based on email
        else
        {
         //clears previous entries of linkedlist
         temp1.clear();
         //clears preivous entries of arraylist
         hold.clear();
         //Stores a Contact to be looked up in the list
         Contact con = new Contact(null, null, value); 
         //holds linkedlist returned by lookup method
         temp1 = c.lookup(trait, con);
         //copies objects from linkedlist to arraylist
         for(Contact<Object> it: temp1)
           hold.add(it);
         c.printList(hold);
       }
      }
      //deletes element at the given point in the from the index
      if(inputVals[0].equals("delete"))
      {
        //Stores the String of the number of the Contact to be removed
        String removed = inputVals[1]; 
        //deletes the element at given input value in the database
        c.delete(hold.remove(Integer.parseInt(removed)));
      }
      //calls makeIndex method with the trait entered by the user
      if(input.equals("makeindex")){
        c.makeIndex(inputVals[1]);
      }
     }

    } 
}