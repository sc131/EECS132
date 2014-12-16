public class Customer{
  private String lastName = null;
  private String firstName = null;
  private String address = null;
  private Date date = null;
  private Account electricAccount = null;
  private Account gasAccount = null;
  private Account waterAccount = null;
  //creates a customer object with just a last name and address
  public Customer(String lastName, String address){
    this.lastName = lastName;
    this.address = address;
  }
  
  //creates customer object with a first name and last name, address, and date
  public Customer(String firstName, String lastName, String address, Date date){
    this(lastName,address);
    this.firstName = firstName;
    this.date = date;
  } 
  
  //sets the first name of the customer
  public void setFirstName(String firstName){
    this.firstName = firstName;
  }
  
  //gets the first name of the customer
  public String getFirstName(){
    return this.firstName;
  }
  
  //sets last name of the customer
  public void setLastName(String lastName){
    this.lastName = lastName;
  }
  
  //gets the last name of the customer
  public String getLastName(){
    return this.lastName;
  }
  
  //sets the address of the customer
  public void setAddress(String address){
    this.address = address;
  }
  
  //gets the address of the customer
  public String getAddress(){
    return this.address;
  }
  
  //creates a bank account for electricity
  public void setElectricAccount(Account electricAccount){
    this.electricAccount = electricAccount;
  }
  
  //gets the electric account of the customer
  public Account getElectricAccount(){
    return this.electricAccount;
  }
  
  //creates a bank account for gas
  public void setGasAccount(Account gasAccount){
    this.gasAccount = gasAccount;
  }
  
  //gets the gas account of the customer
  public Account getGasAccount(){
    return this.gasAccount;
  }
  
  //creates a bank account for water
  public void setWaterAccount(Account waterAccount){
    this.waterAccount = waterAccount;
  }
  
  //gets the bank account for the customer
  public Account getWaterAccount(){
    return this.waterAccount;
  }
  
  public void setDate(Date date){
    this.date = date;
  }
  
  public Date getDate(){
    return this.date;
  }
  
  //increments the date and calls the processDate method from the Account class for each of the accounts 
  public void incrementDate(){
    date.incrementDay();
    electricAccount.processDate(date);
    gasAccount.processDate(date);
    waterAccount.processDate(date);
  }
}