public class Date{
  private int date = 0;
  private int month = 0;
  private int year = 0;
  
  //constructs a date object with a day and month
  public Date(int day, int month){
    this.date = day;
    this.month = month;
  }
  
  //gets the day of the date object
  public int getDay(){
    return this.date;
  }
  
  //gets the month of the date object
  public int getMonth(){
    return this.month;
  }
  
  //increments the day of the date object, increasing the month when necessary, based on the standard calander 
  public void incrementDay(){
    //increments the day for months with 30 days
    if(((month < 8) && (month % 2 == 0)) && (month != 2) || ((month > 8) && (month % 2 != 0))){
      if(date < 30)
        date++;
      else{
        date = 1;
        month++;
      }
    }
    //increments the day for months with 31 days
    else if((month >= 8) && (month % 2 == 0) || (month < 8) && (month % 2 != 0)){
      if(date < 31)
        date++;
      else if (month != 12){
        date = 1;
        month++;
      }
      else{
        date = 1;
        month = 1;
        year++;
      }
    }
    //increments the day for february
    else{ 
      if(date <= 27)
        date++;
      else{
        date = 1;
        month++;
      }
    }
  }
  public int monthsUntil(Date date){
    int monthsUntil = 0;
    if(this.getDay() < date.getDay())
      monthsUntil = date.getMonth() - this.getMonth() - 1;
    else
      monthsUntil = date.getMonth() - this.getMonth();
    return monthsUntil;
  }
}