/**Stephanie Collins
  * Represents a whole number*/
 public class Number extends IntExpression{
  
  /**stores the value of the number*/ 
  private int num;
  
  /**creates a Number with value num*/
  public Number(int num){
    this.num = num;
  }
  
  /**returns the value of the Number*/
  public int value(State s){
    return num;
  }
  
  /**returns a String representation of Number*/
  public String toString(){
    return Integer.toString(num);
  }
  
}