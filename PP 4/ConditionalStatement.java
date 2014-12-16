/**Stephanie Collins
  * This class represents a conditional statement*/
public class ConditionalStatement extends Statements{
  /**creates a field for the boolean expression*/
  private BooleanExpressions bExpression;
  /**creates a field for left operand*/
  private Statements leftOpEx;
  /**creates a field for right operand*/
  private Statements rightOpEx;
  /**Creates a ConditionalStatement object initializing boolean expression and 2 statements*/
  public ConditionalStatement(BooleanExpressions bExpression, Statements leftOpEx, Statements rightOpEx){
    this.bExpression = bExpression;
    this.leftOpEx = leftOpEx;
    this.rightOpEx = rightOpEx;
  }
  
  /**uses the state to get the value of the condition, which is used to execute on the statements*/
  public void execute(State s){
    //if the condition is true then the left operand is executed
    if(bExpression.value(s))
      leftOpEx.execute(s);
    //if it's false then the right operand is executed
    else
      rightOpEx.execute(s);
    }
  /**returns a string in the form of a conditional statement with the conditional test 
    * and the left operand within the if and the right operand within the else statements*/
  public String toString(){
    return "if (" + bExpression.toString() + ")\n" + leftOpEx.toStringTabbed(1) + "else\n" + rightOpEx.toStringTabbed(1);
  }
  
  /**same as toString() but indented*/
  public String toStringTabbed(int tabs){
    StringBuilder b = new StringBuilder();
    //adds the parameter number of tabs to the front of the string
    for(int i = 0; i < tabs; i++){
      b.append("\t");
    }
    //inserts the if statement
    b.append("if (" + bExpression.toString() + ")\n" + leftOpEx.toStringTabbed(tabs+1));
    //adds the parameter number of tabs before the else statement
    for(int i = 0; i < tabs; i++){
      b.append("\t");
    }
    //adds the rest of the else statement
    b.append("else\n" + rightOpEx.toStringTabbed(tabs+1));
    return b.toString();
  }
}