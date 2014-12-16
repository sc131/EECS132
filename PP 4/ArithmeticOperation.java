/** Stephanie Collins
  * This class represents an arithmetic expression between two integer values*/
public class ArithmeticOperation extends IntExpression{
  /**creates a field to hold to type of arithmetic operation*/
  Operator op;
  /**creates a field to hold the the first integer expression*/
  IntExpression leftOpEx;
  /**creates a field to hold the second integer expression*/
  IntExpression rightOpEx;
  
  /**creates an enum value holding the arithmetic operator*/
  public enum Operator{ Add, Sub, Mult, Div, Rem;}
  
  /**Creates an arithmetic operator type with an operator, and 2 int expression parameters*/
  public ArithmeticOperation(Operator op, IntExpression leftOpEx, IntExpression rightOpEx){
     this.op = op;                                //initializes operator field
     this.leftOpEx = leftOpEx;                    //initializes 1st int expression
     this.rightOpEx = rightOpEx;                  //initializes 2nd int expression
  }
  
  /**returns the int value of the arithmetic operation used on the two int expressions*/
  public int value(State s){
    int val = 0;  
    //initializes the value to be returned by the method
    switch (op) {
      //checks if the operator is Add and does the corresponding operation
      case Add:                                   
        val =  leftOpEx.value(s) + rightOpEx.value(s);
        break;
      case Sub:                                   //checks if the operator is Sub and does the corresponding operation
        val = leftOpEx.value(s) - rightOpEx.value(s);
        break;
      //checks if the operator is Mult and does the corresponding operation
      case Mult:                                 
        val = leftOpEx.value(s)*rightOpEx.value(s);
        break;
      //checks if the operator is Div and does the corresponding operation
      case Div:                                   
        if(rightOpEx.value(s) != 0)
          val = leftOpEx.value(s)/rightOpEx.value(s);
        break;
      //checks if the operator is Rem and does the corresponding operation
      case Rem:                                  
        if(rightOpEx.value(s) != 0)
          val = leftOpEx.value(s)%rightOpEx.value(s);
        break;
    }
    return val;
  }
  
  /**returns a string value of the arithmetic expression*/
  public String toString(){
    StringBuilder b = new StringBuilder();
    //adds the left operand expression to the stringBuilder
    b.append(leftOpEx.toString());
    //checks to see which string version of op is needed for the string expression
    switch (op){
      //if it's Add then + is added
      case Add:
        b.append(" + ");
        break;
      //if it's Sub then - is added 
      case Sub:
        b.append(" - ");
        break;
      //if it's Mult then * is added  
      case Mult:
        b.append(" * ");
        break;
      //if it's Div then / is added  
      case Div:
        b.append(" / ");
        break;
      //if it's Rem then % is used  
      case Rem:
        b.append(" % ");
        break;
    }
    //adds the right operand expression to the stringBuilder
    b.append(rightOpEx.toString());
    return b.toString();
  }
  
}