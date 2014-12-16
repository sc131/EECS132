public class Account{
  private double lineFee = 0;
  private double rate = 0;
  private double taxRate = 0;
  private double interestRate = 0;
  private int monthlyUsage = 0;
  private int expectedMonthlyUsage = 0;
  private double accountBalance = 100;
  private double currentMonthBill = 0;
  private double previousMonthBill = 0;
  private double amountPaid = 0;
  private int pastYearUsage = 0;
  private int currentYearUsage = 0;
  private Customer customer = null;
  private Date anniversaryDate = null;
  private boolean isOpen = false;
  
  public Account(double lineFee, double rate, double taxRate, double interestRate, int expectedMonthlyUsage){
    this.lineFee = lineFee;
    this.rate = rate;
    this.taxRate = taxRate;
    this.interestRate = interestRate;
    this.expectedMonthlyUsage = expectedMonthlyUsage;
    pastYearUsage = 12*expectedMonthlyUsage;
  }
  public Account(double lineFee, double rate, double taxRate, double interestRate, int expectedMonthlyUsage, Customer customer, Date date){
    this(lineFee, rate, taxRate, interestRate, expectedMonthlyUsage);
    this.customer = customer;
    anniversaryDate = date;
    this.isOpen = true;
  }
  //sets monthly fee for having an account
  public void setLineFee(double lineFee){
    this.lineFee = lineFee;
  }
  //gets monthly fee for having an account
  public double getLineFee(){
    return this.lineFee;
  }
  //sets rate for the account
  public void setRate(double rate){
    this.rate = rate;
  }
  //gets rate for the account
  public double getRate(){
    return this.rate;
  }
  //sets the sales tax percentage
  public void setSalesTaxRate(double taxRate){
    this.taxRate = taxRate;
  }
  //gets the sales tax percentage
  public double getSalesTaxRate(){
    return this.taxRate;
  }
  //sets the interest tax percentage 
  public void setInterestRate(double interestRate){  
    this.interestRate = interestRate;
  }
  //gets the interest tax percentage on over-due amounts
  public double getInterestRate(){
    return this.interestRate;
  }
  //sets the amount of service used by the account this month
  public void setMonthUsage(int monthlyUsage){
    this.monthlyUsage = monthlyUsage;
  }
  //gets the amount of service used by the account this month
  public int getMonthUsage(){
    return this.monthlyUsage;
  }
  //gets the amount of service used by the account in the past year
  public int getPastYearUsage(){
    return this.pastYearUsage;
  }
  //gets the accountBalance currently in the account
  public double getBalance(){
    return this.accountBalance; 
  }
  //gets the amount billed to the customer for this month
  public double getMonthBill(){
    return this.currentMonthBill;
  }
  //gets amount already paid by the customer so far this month
  public double getAmountPaidThisMonth(){
    return this.amountPaid; 
  }
  //removes "amount" from current accountBalance and increases amountPaid by "amount"
  public void receivePayment(double amount){
    accountBalance -= amount;
    amountPaid += amount;
  }
  public void openAccount(Date date, Customer customer){
    anniversaryDate = date;
    this.customer = customer;
  }
  //returns true if account is open, false if not
  public boolean isOpen(){
    if(anniversaryDate ==  null && customer == null)
      this.isOpen = false;
    else 
      this.isOpen = true;
    return this.isOpen;
  }
  //returns anniversary (opening date) date for the account
  public Date getAnniversaryDate(){
    return this.anniversaryDate;
  }
  //returns customer of the account
  public Customer getCustomer(){
    return this.customer;
  }
  //checks to see if the account is set up with a monthly plan
  public boolean isOnMonthlyPlan(){
    if(expectedMonthlyUsage == pastYearUsage/12)
      return false;
    else
      return true;
  }
  //turns off monthly plan, setting the expected monthly usage equal to a standard rate year round
  public void turnOffMonthlyPlan(){
    if(isOpen == true)
      expectedMonthlyUsage = pastYearUsage/12;
  }
  
  //turns on the monthly plan, setting expected monthly usage to a different rate each month
  public void turnOnMonthlyPlan(){
    if(isOpen == true){
      if((pastYearUsage - currentYearUsage) >= 0)
        expectedMonthlyUsage = (pastYearUsage - currentYearUsage)/(customer.getDate().monthsUntil(anniversaryDate));
    }
  }
  
  //calculates expectedMonthlyUsage, and sets pastYearUsage equal to currentYearUsage, resets currentYearUsage
  public void endOfYearProcessing(){
    if(isOpen == true){
      if(isOnMonthlyPlan() == false)
        expectedMonthlyUsage = currentYearUsage/12;
      else
        expectedMonthlyUsage = (currentYearUsage + (Math.abs(currentYearUsage - pastYearUsage)))/12;
    }
      pastYearUsage = currentYearUsage;
      currentYearUsage = 0;
  }                      
  //resets monthly values such as amountPaid, and calculates the current balance and current bill
  public void endOfMonthProcessing(){
    if(isOpen == true){
      currentYearUsage += monthlyUsage;
      accountBalance = (accountBalance + lineFee) + monthlyUsage*rate + taxRate*(accountBalance + lineFee) + taxRate*(monthlyUsage*rate);
      if(amountPaid < currentMonthBill){
        accountBalance += interestRate*(currentMonthBill - amountPaid);
      }
      if(isOnMonthlyPlan() == false){
        if(accountBalance >= 0)
          currentMonthBill = accountBalance;
        else
          currentMonthBill = 0;
      }
      else{
        if((previousMonthBill - amountPaid) > 0)
        currentMonthBill = (previousMonthBill - amountPaid) + interestRate*(previousMonthBill - amountPaid) + lineFee + rate*expectedMonthlyUsage + taxRate*(lineFee + rate*expectedMonthlyUsage);
        else
          currentMonthBill = (previousMonthBill - amountPaid) + lineFee + rate*expectedMonthlyUsage + taxRate*(lineFee + rate*expectedMonthlyUsage);
      }
    }
    amountPaid = 0;
    previousMonthBill = currentMonthBill;
  }
  //checks the date input to see if endOfYearProcessing or endOfMonthProcessing needs to be called
  public void processDate(Date date){
    if(isOpen == true){
      if((date.getDay() == anniversaryDate.getDay()) && (date.getMonth() == anniversaryDate.getMonth()))
        endOfYearProcessing();
      else if(date.getDay() == anniversaryDate.getDay())
        endOfMonthProcessing();
    }
  }
}