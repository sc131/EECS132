/**Stephanie
 * This class represents a boolean operation between boolean expressions*/
public class BooleanOperation extends BooleanExpressions{
  /**creates a field to hold the operator value*/
  private Operator op;
  /**creates a field to hold the boolean left operand*/
  private BooleanExpressions leftOpEx;
  /**creates a field to hold the boolean right operand*/
  private BooleanExpressions rightOpEx;
  /**creates the operator values*/
  public enum Operator{ And, Or;}
  /**creates a BooleanOperation*/
  public BooleanOperation(Operator op, BooleanExpressions leftOpEx, BooleanExpressions rightOpEx){
    //initializes the operator
    this.op = op;
    //initializes the left operand
    this.leftOpEx = leftOpEx;
    //initializes the right operand
    this.rightOpEx = rightOpEx;
  }
  /**returns the boolean value after applying the operator to the left and right operands*/
  public boolean value(State s){
    boolean val = false;
    //checks for the value of op and sets val to true when it matches the case
    switch(op){
      case And:
       if(leftOpEx.value(s) && rightOpEx.value(s))
         val = true;
       break;
      case Or:
        if(leftOpEx.value(s) || rightOpEx.value(s))
          val = true;
        break;
    }
    return val;
  }
  
  /** returns a string of the operands and boolean operator*/
  public String toString(){
    StringBuilder b = new StringBuilder();
    //adds the left operand to the start of the stringBuilder
    b.append(leftOpEx.toString());
    //checks the case of the operator and adds the appropriate symbol to the stringBuilder*/
    switch(op){
      case And: 
        b.append(" && ");
        break;
      case Or:
        b.append(" || ");
        break;
    }
    //adds the right operand to end of the stringBuilder
    b.append(rightOpEx.toString());
    return b.toString();
  }
}