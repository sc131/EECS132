/**Stephanie Collins
  * This class represents a Function call*/
public class FunctionCall extends IntExpression{
  /**creates a field for the function*/
  private Function f;
  
  /**creates a field for the array of IntExpressions*/
  private IntExpression[] i1;
  
  /**creates a FunctionCall object and initializes the function and IntExpression array fields*/
  public FunctionCall(Function f, IntExpression... i1){
    this.i1 = new IntExpression[i1.length];
    this.f = f;
    //sets the length of the array
    for(int i = 0; i < i1.length; i++){
      this.i1[i] = i1[i];
    }
  }
  
  /**updates a new state with the value of the variable from the input state
    * returns the value of keyword return from the new state*/
  public int value(State s){
    State s1 = new State();
    //sets the new state with the values of the input state
    for(int i = 0; i < i1.length; i++){
      s1.update(f.getVariableName(i), i1[i].value(s));
    }
    f.getBody().execute(s1);
    return  s1.lookup("return");
  }
  
  /**returns a string with the functions name, and string representation of the arugments*/
  public String toString(){
    StringBuilder b = new StringBuilder();
    b.append(f.getName() + "(");
    //adds the intExpressions to the stringBuilder
    for(int i = 0; i < i1.length; i++){
      if(i < i1.length-1)
        b.append(i1[i] + ", ");
      else 
        b.append(i1[i]);
    }
    b.append(")");
    return b.toString();
  }
  
}