/**
 * Stephanie Collins
 * The state type represents variables and their contents*/

import java.util.*;
public class State{
  
 /** creates a hashtable to store variable names and values*/
 private Hashtable<String, Integer> table = new Hashtable<String, Integer>();
 
 /**updates values in the hashtable with the variable name and value*/
 public void update(String vName, Integer vValue){
   table.put(vName, vValue);                                      //inserts the variable with the corresponding value
 }
 
 /**returns the value of variable vName in the hashtable, and returns 0 if it doesn't exist*/
 public int lookup(String vName){
   if(table.containsKey(vName))
     return table.get(vName);
   else
     return 0;
 }
}