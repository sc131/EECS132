/**Stephanie Collins
  * This class represents the return statement*/
public class Return extends Statements{
  /**creates a field for the IntExpression*/
  private IntExpression intEx;
  /**creates a Return object with the intEx field initialized to the parameter intEx*/
  public Return(IntExpression intEx){
    this.intEx = intEx;
  }
  
  /**updates the state to set a new variable named return to the intEx value*/
  public void execute(State s){
    s.update((new Variable("return")).toString(), intEx.value(s));
  }
  
  /**returns a string with the variable name "return" and its intEx value*/
  public String toString(){
    return "return " + intEx + ";\n";
  }
  
  /**reutrns the same as toString but with an input parameter number of tabs before the toString() value*/
  public String toStringTabbed(int tab){
    StringBuilder b = new StringBuilder();
    //adds the appropriate number of tab characters
    for(int i = 0; i < tab; i++)
      b.append("\t");
    //adds the toString() value
    b.append(this.toString());
    return b.toString();
  }
}