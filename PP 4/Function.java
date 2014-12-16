/**Stephanie Collins
  * This class represents a function*/
public class Function{
 
 /**creates a field for an array of variables*/
 private Variable[] v;
 /**creates a field for the String name*/
 private String name;
 /**creates a field for the String name*/
 private Statements s;
 
 /**Creates a Function object and initializes the array, name and statement*/
 public Function(String name, Statements s, Variable... v){
   this.v = new Variable[v.length];
   this.name = name;
   this.s = s;
   //runs through the array to set the length of the field array
    for(int i = 0; i < v.length; i++){
      this.v[i] = v[i];
    }
  }
 
 /**Returns a string representation of the function with the action being used in the function and the variables the function is used on*/
 public String toString(){
   StringBuilder b = new StringBuilder();
   b.append("function " + getName() + "(");
   //lists all the elements of the variables array
   for(int i = 0; i < v.length; i++){
     if(i < v.length-1)
       b.append(v[i].toString() + ", ");
     else
       b.append(v[i].toString());
   }
   b.append(")\n" + s.toStringTabbed(1));
   return b.toString();
 }
 public String getVariableName(int i){
   return v[i].toString();
 }
 /**returns the name of the variables*/
 public String getName(){
   return name;
 }
 /**returns the statements of the function*/
 public Statements getBody(){
   return s;
 }
}