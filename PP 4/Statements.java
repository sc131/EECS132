/**Stephanie Collins
  * This class allows any class acting as a statement to override the required methods*/
public abstract class Statements{
 
  /**This is a method stub that executes the statement of the extending class*/
  public abstract void execute(State s);
  
  /**This is a method stub that returns the string representation of the extending class*/
  public abstract String toString();
  
  /**This is a method stub that returns the same value as the toString method but with an indentation of the given number of tabs*/
  public abstract String toStringTabbed(int tabs);
  
}