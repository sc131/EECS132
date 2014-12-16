/**Stephanie Collins
 * this class represents a comparison between to int expressions*/
public class Comparison extends BooleanExpressions{
  /** creates a value to store the left operand expression*/
  private IntExpression leftOpEx;
  /** creates a value to store the right operand expression*/
  private IntExpression rightOpEx;
  /** creates a value to store the type of comparison operator*/
  private Operator op;
  /** creates a set number of enum comparisons*/
  public enum Operator{LT, LTE, GT, GTE, EQ, NEQ;}
  /**creates a Comparison type*/
  public Comparison(Operator op, IntExpression leftOpEx, IntExpression rightOpEx){
    //intializes the comparison operator
    this.op = op;
    //initializes the left operand expression
    this.leftOpEx = leftOpEx;
    //initializes the right operand expression
    this.rightOpEx = rightOpEx;
  }
  
  /**returns the boolean value that is the result of applying the operator to the operand expressions*/
  public boolean value(State state){
    boolean val = false;
    //checks each case of the operator
    switch (op){
      //if operator is LT then statement is true
      case LT: 
        if(leftOpEx.value(state) < rightOpEx.value(state))
          val = true;
        break;
      //if operator is LTE then statement is true  
      case LTE:
        if(leftOpEx.value(state) <= rightOpEx.value(state))
          val = true;
        break;
      //if operator is GT then statement is true  
      case GT:
        if(leftOpEx.value(state) > rightOpEx.value(state))
          val = true;
        break;
      //if operator is GTE then statement is true  
      case GTE:
        if(leftOpEx.value(state) >= rightOpEx.value(state))
          val = true;
        break;
      //if operator is EQ then statement is true  
      case EQ:
        if(leftOpEx.value(state) == rightOpEx.value(state))
          val = true;
        break;
      //if operator is NEQ then statement is true  
      case NEQ:
        if(leftOpEx.value(state) != rightOpEx.value(state))
          val = true;
        break;
    }
    return val;
  }
  
  /** returns a string containing the string value of the operands and operator*/
  public String toString(){
    StringBuilder b = new StringBuilder();
    b.append(leftOpEx.toString());
    //inserts proper string character of the operator
    switch(op){
      //if op is LT < is added
      case LT:
        b.append(" < ");
        break;
      //if op is LTE <= is added  
      case LTE:
        b.append(" <= ");
        break;
      //if op is GT > is added  
      case GT: 
        b.append(" > ");
        break;
      //if op is GTE >= is added  
      case GTE:
        b.append(" >= ");
        break;
      //if op is EQ == is added  
      case EQ:
        b.append(" == ");
        break;
      //if op is NEQ != is added  
      case NEQ:
        b.append(" != ");
        break;
    }
    //adds the right operand
    b.append(rightOpEx.toString());
    return b.toString();
  }
  
  
}