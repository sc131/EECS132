/**@Author Stephanie Collins
  * This class represents a phone or email contact
  */
import java.util.*;
public class Contact<T> implements DatabaseType<T>{// , Comparator<T>{
  /**hold the name of the contact*/
  private String name;
  /**holds the phone number of the contact*/
  private String number;
  /**holds the email of the contact*/
  private String email;
  
  /**Creates a new contact 
    * @param initializes the fields*/
  public Contact(String name, String number, String email){
    this.name = name;
    this.number = number;
    this.email = email;
  }
  
  /**Sets contact name
    * @param name to set field*/
  public void setName(String name){
    this.name = name;
  }
  
  /**@return the name of the contact*/
  public String getName(){
    return this.name;
  }
  
  /**Sets the phone number for the contact
    * @param phone number to set field*/
  public void setNumber(String number){
    this.number = number;
  }
  
  /** @returns the phone number of the contact*/
  public String getNumber(){
    return this.number;
  }
  
  /**Sets the email of the contact
    * @param email to set field*/
  public void setEmail(String email){
    this.email = email;
  }
  
  /** @return the email of the contact*/
  public String getEmail(){
    return this.email;
  }
  
  /** @return a string with the name, number, and email of the contact*/
  public String toString(){
    return "Name: " + getName() + ", Number: " + getNumber() + ", Email: " + getEmail();
  }
  
  /**Checks if two contacts are equal
    * @param the contact to compare with*/
  public boolean equals(Contact<T> con){
     return (getName().equals(con.getName()) && getNumber().equals(con.getNumber()) && getEmail().equals(con.getEmail()));
  }
  
  public int compare(T e1, T e2){
    if(e1.equals(e2))
      return 0;
    else if(e1.toString().compareTo(e2.toString()) == -1)
      return -1;
    else
      return 1;
  }
  
  /** @param the trait to compare objects by 
   * @returns a Comparator comparing 2 objects by trait*/
 public Comparator<T> getComparatorByTrait(String trait) {
   if(trait.equals("name")){
     return new Comparator<T>() {
       public int compare(T c1, T c2){
         return ((Contact)c1).getName().compareTo(((Contact)c2).getName());
       }};
   }
   else if(trait.equals("number")){
     return new Comparator<T>(){
       public int compare(T c1, T c2){
         return ((Contact)c1).getNumber().compareTo(((Contact)c2).getNumber());
       }};
   }
   else{
     return new Comparator<T>(){
       public int compare(T c1, T c2){
         return ((Contact)c1).getEmail().compareTo(((Contact)c2).getEmail());
       }};
   }
 }
}