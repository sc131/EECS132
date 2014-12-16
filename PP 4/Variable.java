/**Stephanie Collin
 * represents a variable type in the program*/
public class Variable extends IntExpression{
  
  /**stores the name of the variable*/
  private String name;
  
  /**creates a variable with string Name*/
  public Variable(String name){
    this.name = name;
  }
  
  /**returns the value of the variable asociated with state*/
  public int value(State state){
   int val = state.lookup(toString());                 //looks up the value of the variable in the state's hashtable; 
   return val;
  }
  
  /**Returns the name of the variable*/
  public String toString(){
    return this.name;
  }
}