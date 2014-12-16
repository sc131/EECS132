/**Stephanie Collins
  * This class represents a loop statement*/
public class Loop extends Statements{
  
  /**creates a field for the booleanExpression*/
  private BooleanExpressions bExpression;
  /**creates a field for the input statement*/
  private Statements s1;
  
  /**Creates a Loop object with a booleanExpression object and a statement*/
  public Loop(BooleanExpressions bExpression, Statements s1){
    //initializes booleanExpression
    this.bExpression = bExpression;
    //initializes statement
    this.s1 = s1;
  }
  
  /**While the condition's value is true the input state is used to execute the statment*/
  public void execute(State s){
    while(bExpression.value(s))
      s1.execute(s);
  }
  
  /**Returns a string representation of the loop statement with the condition and statement*/
  public String toString(){
    return "while (" + bExpression.toString() + ")\n" + s1.toStringTabbed(1);
  }
  
  /**Returns the same as toString but everything is by the number of tabs in the parameter*/
  public String toStringTabbed(int tabs){
    StringBuilder b = new StringBuilder();
    for(int i = 0; i < tabs; i++){
      b.append("\t");
    }
    b.append("while (" + bExpression.toString() + ")\n" + s1.toStringTabbed(tabs+1));
    return b.toString();
    
  }
}