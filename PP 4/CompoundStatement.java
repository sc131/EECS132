/**Stephanie Collins
  * This class represents a compound statement*/
public class CompoundStatement extends Statements{
  /**creates a field for a Statement*/
  private Statements[] statement;
  /**creates a CompoundStatement object*/
  public CompoundStatement(Statements... statement){
    //initializes the array
    this.statement = new Statements[statement.length];
    //uses the loop to set the length of the field array
    for(int i = 0; i <statement .length; i++){
      this.statement[i] = statement[i];
    }
  }
  
  /**At each point of the loop, the statement at the given point is executed using the state parameter*/
  public void execute(State state){
    for(int i = 0; i < statement.length; i++){
      statement[i].execute(state); 
    }
  }
  /**returns a string within brackets of each statement indented,in the statement array*/
  public String toString(){
    StringBuilder b = new StringBuilder();
    b.append("{\n");
    //adds the statement at the given point in the loop, at an indentation of 1
    for(int i = 0; i< statement.length; i++){
      b.append(statement[i].toStringTabbed(1));
    }
    b.append("}\n");
    return b.toString();
  }
  
  /**returns a String that is the same as toString() but indented the input number of times*/
  public String toStringTabbed(int tab){
    StringBuilder b = new StringBuilder();
    //indents the loop by tab number of spaces
    for(int i = 0; i < tab-1; i++){
      b.append("\t");
    }
    b.append("{\n");
    //adds the statements in the array appropriately indented*/
    for(int i = 0; i < statement.length; i++){
      b.append(statement[i].toStringTabbed(tab));
    }
    //indents the line again
    for(int i = 0; i < tab-1; i++){
      b.append("\t");
    }
    //then closes the bracket
    b.append("}\n");
    return b.toString();
  }
  
}