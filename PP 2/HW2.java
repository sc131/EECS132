/**Stephanie Collins
  * The purpose of this class is to practice writing loops
  */
public class HW2{
  
  /** This method checks to see if the input string is in alphabetical order*/
  public boolean isAlphabeticalOrder(String s){
    boolean alphaOrder = true;
    String sUP = s.toUpperCase();
    //The goal of the loop is to check if the string is in alphabetical order by comparing char values
    for(int i = 1; i < sUP.length(); i++){
      char c = sUP.charAt(i);
      if((c >= 'A') && (c <= 'Z')){
        if(c < sUP.charAt(i - 1))
          alphaOrder = false;
      }
    }
    return alphaOrder;
  }

  /** This method removes the first n occurences of the input char in the string*/
  public String removeNchars(String s, int n, char c){
    StringBuilder b = new StringBuilder();
    int countRemoved = 0;
    //add the char at i to string builder if it is not equal to c while i is less than n
    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) == c && countRemoved < n){
        b.append(s.charAt(i+1));
        countRemoved++;
        i++;
      }
      else{
        b.append(s.charAt(i));
      }
    }
    return b.toString();
  }
  
  /** Switches the first occurence of c with the char to the right of it, and then returns the same string with the switch*/
  public String moveXright(char c, String s){
    StringBuilder b = new StringBuilder();
    boolean swap = false;
    //Goal: Find where c is in s and switch it with the char after it
    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) != c || swap == true || i == s.length() - 1)   //If the char at i+1 doesn't equal c, or it's already been swapped,or it's the last val copy the char into StringBuilder
        b.append(s.charAt(i));
      else{
        b.append(s.charAt(i+1));
        b.append(s.charAt(i));
        swap = true;
        i++;
      }
    }
    return b.toString();
   }
  
  /** This method returns the first input string, but with brackets around all instances of the second string contained in the first one*/
  public String bracketString(String s1, String s2){
   StringBuilder b = new StringBuilder();
      //This loops runs through each character of the first string*/
      for(int i = 0; i < s1.length(); i++){
        if(s1.charAt(i) == s2.charAt(0)){                           //Checks to see if the char at i in the first string is the same as char at 0 in s2
          int p = 0;                                                //Increments to move through query while the second loop moves through phrase
          boolean isValid = true;                                   //Assumes the second string will be found in the first
          //Runs through the query compare the value of phrase at j to each char of query 
          for(int j = i; p < s2.length(); j++){
            if(s1.length() == j){                                   //This keeps j within the index of phrase and changes isValid to false 
                                                                    //since query won't be exist if condition is met
              j--;
              isValid = false;
            }
            if(s1.charAt(j) != s2.charAt(p)){                       //Changes isValid to false if at any point if char at j of phrase doesn't equal the corresponding char of query
              isValid = false;
            }
            p++;
          }
          if(isValid){                                              //If isValid is true after running through the second loop, it adds brackets around query
                                                                    //while adding it to the return value
            b.append("[" + s2 + "]");
            i += s2.length() - 1;                                   //Adjusts i to increment past the query, and -1 allows the loop to complete its 
                                                                    //increment without skipping a char
          } 
          else {                                                    //If at any point isValid is false char at i of phrase is added to output and the loop continues checking values
            b.append(s1.charAt(i));      
          }
        } 
        else {                                                      //If the second loop is not entered at all, char at i of phrase is added to output 
                                                                    //and the loop continues checking values
          b.append(s1.charAt(i));
        }
      
      }
    return b.toString();
  } 
    
    
  /**Moves all values of the input char in the input String to the right of the next non-c char*/
  public String moveAllXsRight(char c, String s){
    StringBuilder b = new StringBuilder();
    //Goes through the String checking for instances of c in order to move them to the right
    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) != c || i == s.length()-1){                     //If the value in s at i doesn't equal c, or i is the last char of s, then insert it into the StringBuilder
        b.append(s.charAt(i));
      }
      else if (i != s.length()-1){                                   //If the value at i is equal to c AND is not the last char, 
                                                                     //find out how many values of c are in a row and shift them to the right
        int k = 0;                                                   //k keeps track of the where i needs to jump to in order to continuing copying values into the StringBuilder
        int j = i;
        //This loops counts the number of times c comes up in a row in s in order to shift them all to the right of the next non-c char
        while(s.charAt(j) == c){
          j++;
        }
        b.append(s.charAt(j));
        k = j;
        //This loops places the values of c into the StringBuilder after the non-c value to the right of them has been placed
         while(j > i){
           j--;
           b.append(s.charAt(j));
         }
         i+= k-1;                                                    //Moves i to the correct place to continue looking through the string, -1 is necessary b/c the loop's increment 
                                                                     //will cause it to skip a value otherwise
      }
     }
    return b.toString();
   }
  
  /** Moves the value of c to the same position one line below, and takes the value at that position 
    * moving it into the original position of c*/
  public String moveXdown(char c, String s){
    StringBuilder b = new StringBuilder();
    int i = 0;
    int placeHold = 0;                                               //Keeps track of how far into a new line c is
    int numN = 0;                                                    //keeps track of what line c is on
    int placeC = 0;                                                  //Keeps track of what position c is in overall in s
    boolean found = false;
    //the purpose of this loop is to find where c is
    while(i < s.length() && !found){
      placeHold++;
      if(s.charAt(i) == '\n'){                                       //finds the line c is on
        numN++;
        placeHold = 0;
      }
      if(s.charAt(i) == c && !found && i != s.length() -1){          //finds the overall position of c in s and the number of characters into the new line c is
                                                                     //as long as it exists and is not the final char in the string, in which case there is nothing to swap with
       found = true;
       placeC = i;
      }
     i++;
    }
    int k = 0;
    int numN2 = 0;                                                   //keeps track of the line the value being swapped with c is on
    int placeHold2 = 0;                                              //keeps track of how far into a line the value swapped is
    int placeSwap = 0;                                               //keeps track of the overall position of the value being swapped
    boolean found2 = false;
    //the purpose of this loop is to find the value to be swapped with c
    while(k < s.length() && !found2){
      placeHold2++;
      if(s.charAt(k) == '\n'){                                       //finds the same new line as c
        numN2++;
        placeHold2 = 0;
      }
      if((placeHold2 == placeHold) && (numN2 == (numN + 1))){        //if the loop has reached the same point in line on the line below c, the values are held and the loop exits
          placeSwap = k;
          found2 = true;
      }
      k++;
    }
    //the purpose of this loop is to append all the chars of s into the StringBuilder in the correct order
    for(int j = 0; j < s.length(); j++){
      if(found && found2){                                             //only enters this if c exists in the loop and is not the last value
                                                                       //and has a corresponding value in the line below at the same position
        if(j == i-1){                                                  //appends the value to be swapped with c at the string position of c (where the loop exited after finding c)
          b.append(s.charAt(placeSwap));
        }
        else if(j == k-1){                                             //appends c at the position of the valued being swapped with c (where the loop exited after finding the value)
          b.append(s.charAt(placeC));
        }
        else{                                                          //appends everything else in order
          b.append(s.charAt(j));
        }
      }
      else                                                           //appends everything in order if c was not found in the string or if it was the last char
        b.append(s.charAt(j));
    }
    return b.toString();
  }
  
  //Swaps the input char and the char to the left of it
  public String moveXleft(char c, String s){
    StringBuilder b = new StringBuilder();
    boolean swap = false;                                            //Checks to see if the first instance of c has been swapped
    //Goal: Find where c is in s and switch it with the preceding char
    for(int i = 0; i < s.length()-1; i++){
      if(s.charAt(i+1) != c || swap == true)                         //If the char at i+1 doesn't equal c, or it's already been swapped, copy the char into StringBuilder
        b.append(s.charAt(i));
      else{                                                          //They do match and c hasn't been swapped yet so switch the order as they're copied into b
        b.append(s.charAt(i+1));
        b.append(s.charAt(i));
        swap = true;
        i++;
      }
      if(i == s.length()-2)                                          //If the end of the string is reached, regardless of the value of swap or char at i, copy as is
        b.append(s.charAt(i+1));  
    }
    return b.toString();
  }
}