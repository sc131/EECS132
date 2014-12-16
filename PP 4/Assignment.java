/**Stephanie Collins
 * This class represents an assignment statement*/
public class Assignment extends Statements{
  /**creates a field for the Variable value*/
  private Variable variable;
  /**creates a field for the IntExpression*/
  private IntExpression intEx;
  /**creates an Assignment object with a variable and IntExpression*/
  public Assignment(Variable variable, IntExpression intEx){
    //initializes variable
    this.variable = variable;
    //initializes intEx
    this.intEx = intEx;
  }
  
  /**updates the state to set the variable value to the value of the expression*/
  public void execute(State state){
    state.update(variable.toString(), intEx.value(state));
  }
    
  /**returns a string with the variable name showing it assigned to the value of intEx*/
  public String toString(){
    return "" + variable.toString() + " := " + intEx.toString() + ";\n";
  }
  
  /**returns the same value as toString() but with the int parameter num of tabs*/
  public String toStringTabbed(int tabs){
    StringBuilder b = new StringBuilder();
    //inserts the parameter number of tabs before the adding the toString statement*/
    for(int i = 0; i < tabs; i++)
      b.append("\t");
    //adds the string from the toString method
    b.append(this.toString());
    return b.toString();
  }

}