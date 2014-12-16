/**Stephanie Collins
  * This class consists of methods shifting elements on the game goard */
public class Project3{
  
  /**Slides the elements of row in array left, combining equal elements next to each other
    * @param array from SlideGame and row of shifting elements
    */
   public static boolean slideLeft(int[][] array, int row){
    boolean didSlideL = false;                                 //return value
    int k = 0;                                                 //array element
    int i = 0;                                                 //array element
   
    //counts the number of zeros elements of the array before the first non-zero element
    while(k< array[row].length && array[row][k] == 0){
      k++;
    }
    //if k equals the row length then the row is all zeros and the method returns false
    if(k == array[row].length)
      return didSlideL;
    
    //if there is no zero at the start of the row then the loop finds the first zero element
    if(k == 0){
      while(k < array[row].length && array[row][k] != 0)
        k++;
      i = k;
    }
    //if there is a zero element in the row
    if(k != 0){
      //from the first zero element through the end of the row shift all the zero elements to the end
      while(k < array[row].length){
        //sets the zero element at i to the non-zero element at k
        if(array[row][k] != 0){
          array[row][i] = array[row][k];
          array[row][k] = 0;
          i++;
        }
        k++;
      }
    }
    k = 0;                                                     //resets k
    //runs through row from start to end shifting elements
    while(k < array[row].length-1){
      //if current array element equals zero and the previous one doesn't, move the next array element to the current position
      if(array[row][k] == 0 && array[row][k-1] != 0){
        array[row][k] = array[row][k+1];
        array[row][k+1] = 0;
        didSlideL= true;
      } 
      //else if the current and previous array elements equal zero, set the previous array element equal to the next array element
      else if(k != 0 && array[row][k] == 0 && array[row][k-1] == 0){
        array[row][k-1] = array[row][k+1];
        array[row][k+1] = 0;
      }
      //if the current array element equals the previous array element, set the previous element to 2* itself
      if(k != 0 && array[row][k] == array[row][k-1]){
        array[row][k-1] *= 2;
        array[row][k] = 0;
        didSlideL = true;

      } 
      //else if the current array element equals the next array element, set the current one equal to 2* itself
      else if(array[row][k] == array[row][k+1]){
        array[row][k] *= 2;
        array[row][k+1] = 0;
        didSlideL = true;
      }
      k++;
    }
    return didSlideL;
  }
  
  /**This method shifts all non-zero numbers to the right and combines equal values
    * @param array from SlideGame and row of shifting elements
    */
  public static boolean slideRight(int[][] array, int row){
    boolean didSlideR = false;                                 //return value
    int k = array[row].length-1;                               //array accessor              
    int i = array[row].length-1;                               //array accessor
    
    //counts the number of zeros elements of the array before the first non-zero element
    while(k> 0 && array[row][k] == 0){
      k--;
    }
    //if k equals zero then the row is all zeros and the method returns false
    if(k == 0)
      return didSlideR;
     //if there is no zero at the start of the row then the loop finds the first zero
    if(k == array[row].length-1){
      while(k >= 0 && array[row][k] != 0)
        k--;
      i = k;
    }
    //if there is a zero element in the row
    if(k != array[row].length-1){
      //from the first zero element through the start of the row shift all the zeros to the start
      while(k >= 0){
        //sets the zero element at i to the non-zero element at k and sets k element to zero
        if(array[row][k] != 0){
          array[row][i] = array[row][k];
          array[row][k] = 0;
          i--;
        }
        k--;
      }
    }
    k = array[row].length-1;
    while(k > 0){
      //if the current array element equals zero and the next one doesn't, the current element equals the previous one and the zero shifts left
      if(array[row][k] == 0 && array[row][k+1] != 0){
        array[row][k] = array[row][k-1];
        array[row][k-1] = 0;
        didSlideR= true;
      } 
      //else if both the current and next array elements equal zero, the next element equals the previous element and the zero shifts left
      else if(k != array[row].length-1 && array[row][k] == 0 && array[row][k+1] == 0){
        array[row][k+1] = array[row][k-1];
        array[row][k-1] = 0;
      }
      //if the current and previous array elements are equal then the current element equals 2* itself and the previous is set to zero
      if(array[row][k] == array[row][k-1]){
        array[row][k] *= 2;
        array[row][k-1] = 0;
        didSlideR = true;

      } 
      //else if the current and next elements are equal then the next element equals 2* itself and the current one is set to zero
      else if(k != array[row].length-1 && array[row][k] == array[row][k+1]){
        array[row][k+1] = array[row][k] + array[row][k+1];
        array[row][k] = 0;
        didSlideR = true;
      }
      k--;
    }
    return didSlideR;
 }
  
  /**slides the elements of col to the top and combines equal elements
    * @param array from SlideGame and column of shifting elements
    */
  public static boolean slideUp(int[][] array, int col){
    boolean didSlideUp = false;
    int k = 0;
    int i = 0;
    //counts the number of zeros elements of the array before the first non-zero element
    while(k< array.length && array[k][col] == 0){
      k++;
    }
    //if k equals the length of the array then the column is all zeros and it returns false
    if(k == array.length)
      return didSlideUp;
    //if there is no zero at the start of the column then the loop finds the first zero element
    if(k == 0){
      while(k < array.length && array[k][col] != 0)
        k++;
      i = k;
    }
    //shifts all the zeros to the bottom
    if(k != 0){
      while(k < array.length){
        if(array[k][col] != 0){
          array[i][col] = array[k][col];
          array[k][col] = 0;
          i++;
        }
        k++;
      }
    }
    k = 0;
    while(k < array.length-1){
      //if current array element equals zero and the previous one doesn't then the current element is set to the next element
      if(k != 0 && array[k][col] == 0 && array[k-1][col] != 0){
        array[k][col] = array[k+1][col];
        array[k+1][col] = 0;
        didSlideUp= true;
      } 
      //if both the current and previous elements are zero then the previous one is set to the next element
      else if(k != 0 && array[k][col] == 0 && array[k-1][col] == 0){
        array[k-1][col] = array[k+1][col];
        array[k+1][col] = 0;
      }
      //if the current and previous elements are equal then the previous element is equal to 2* itself and the current element equals zero
      if(k != 0 && array[k][col] == array[k-1][col]){
        array[k-1][col] = array[k][col] + array[k-1][col];
        array[k][col] = 0;
        didSlideUp = true;

      } 
      //if the current and next elements are equal then the current element is set to 2* itself and the next element equals zero
      else if(array[k][col] == array[k+1][col]){
        array[k][col] = array[k][col] + array[k+1][col];
        array[k+1][col] = 0;
        didSlideUp = true;
      }
      k++;
    }
    return didSlideUp;
  }
  /**slides the non-zero elements of col down to the bottom and combines equal elements*/
  public static boolean slideDown(int[][] array, int col){
     boolean didSlideD = false;
    int k = array.length-1;
    int i = array.length-1;
    //counts the number of zeros elements of the array before the first non-zero element
    while(k > 0 && array[k][col] == 0){
      k--;
    }
    //if k equals zero then the entire column is made of zeros and the method returns false
    if(k == 0)
      return didSlideD;
    //if there is no zero element at the bottom of the column the loop finds the first zero element within the column
    if(k == array.length-1){
      while(k >= 0 && array[k][col] != 0)
        k--;
      i = k;
    }
    //shifts all the zeros to the top of the column
    if(k != array.length-1){
      while(k >= 0){
        if(array[k][col] != 0){
          array[i][col] = array[k][col];
          array[k][col] = 0;
          i--;
        }
        k--;
      }
    }
    k = array.length-1;
    while(k > 0){
      //if current array element equals zero and the next one doesn't then the current element is set to the previous one and the previous one is set to zero
      if(array[k][col] == 0 && array[k+1][col] != 0){
        array[k][col] = array[k-1][col];
        array[k-1][col] = 0;
        didSlideD= true;
      } 
      //if both the current and next elements equal zero then the next element is set to the previous one and the previous one is set to zero
      else if(k != array.length-1 && array[k][col] == 0 && array[k+1][col] == 0){
        array[k+1][col] = array[k-1][col];
        array[k-1][col] = 0;
      }
      //if the current and previous elements are equal then the current one equals 2* itself and the previous one is set to zero
      if(array[k][col] == array[k-1][col]){
        array[k][col] = array[k][col] + array[k-1][col];
        array[k-1][col] = 0;
        didSlideD = true;
      } 
      //if the current and next elements are equal then the next one equals 2* itself and the current one is set to zero
      else if(k != array.length-1 && array[k][col] == array[k+1][col]){
        array[k+1][col] = array[k][col] + array[k+1][col];
        array[k][col] = 0;
        didSlideD = true;
      }
      k--;
    }
    return didSlideD;
  }
  
  /**Shifts elements of corresponding diagonal up and left in the same diagonal
    * @param array from SlideGame, row and col of diagonal
    */ 
  public static boolean slideUpLeft(int[][] array, int row, int col){
    boolean didSlideUL = false;
    //if row is greater than col then run through the length of row which is shorter
    if(row >= col){
      int offset = row - col; //sets the offset between row and col in order to stay in the proper diagonal
      int i = offset;
      int k = 0;
      int temp1 = offset;          //place markers
      int temp2 = 0;          //place markers
      //counts the number of zeros before the first non-zero element
      while(i < array[row].length && array[i][k] == 0){
        i++;
        k++;
      }
      //if i equals the length of the row then the diagonal is all zeros and the method returns false
      if(i == array[row].length)
        return didSlideUL;
      //if there is no initial zero then the loop finds the first zero element within the array
      if(i == offset){
      while(i < array[row].length && array[i][k] != 0){
        i++;
        k++;
      }
      temp1 = i;
      temp2 = k;
      }

      //shifts all the zeros to the bottom right of the diagonal
      if(i != offset){
        while(i < array[row].length){
          if(array[i][k] != 0){
            array[temp1][temp2] = array[i][k];
            array[i][k] = 0;
            temp1++;
            temp2++;
          }
          i++;
          k++;
        }
      }
      i = offset;
      k = 0;
      while(i < array[row].length-1){
        //if current array element equals zero and hte previous one doesn't then the current element is set to the next element
        if(i != offset && array[i][k] == 0 && array[i-1][k-1] != 0){
          array[i][k] = array[i+1][k+1];
          array[i+1][k+1] = 0;
          didSlideUL = true;
        }
        //if both the current and previous elements are zero then the previous one is set to the next element
        else if(i!= offset && array[i][k] == 0 && array[i-1][k-1] == 0){
          array[i-1][k-1] = array[i+1][k+1];
          array[i+1][k+1] = 0;
        }
        //if the current and previous elements are equal then the previous element is equal to 2* itself and the current element equals zero
        if(i != offset && array[i][k] == array[i-1][k-1]){
          array[i-1][k-1]*= 2;
          array[i][k] = 0;
          didSlideUL = true;
        }
        //if the current and next elements are equal then the current element is set to 2* itself and the next element equals zero
        else if(array[i][k] == array[i+1][k+1]){
          array[i][k] *= 2;
          array[i+1][k+1] = 0;
          didSlideUL = true;
        }
        i++;
        k++;
      }
    }
    else{
      //sets the offset between row and col in order to stay in the proper diagonal
      int offset = col - row; 
      int i = offset;
      int k = 0;
      int temp1 = offset;                                             //place markers
      int temp2 = 0;                                                  //place markers
      //counts the number of zeros before the first non-zero element
      while(i < array.length && array[k][i] == 0){
        i++;
        k++;
      }
      //if i equals the length of the row then the diagonal is all zeros and the method returns false
      if(i == array.length)
        return didSlideUL;
      //if there is no initial zero then the loop finds the first zero element within the array
      if(i == offset){
      while(i < array.length && array[k][i] != 0){
        i++;
        k++;
      }
      temp1 = i;
      temp2 = k;
      }

      //shifts all the zeros to the bottom right of the diagonal
      if(i != offset){
        while(i < array.length){
          if(array[i][k] != 0){
            array[temp2][temp1] = array[k][i];
            array[k][i] = 0;
            temp1++;
            temp2++;
          }
          i++;
          k++;
        }
      }
      i = offset;
      k = 0;
      while(i < array.length-1){
        //if current array element equals zero and hte previous one doesn't then the current element is set to the next element
        if(i != offset && array[k][i] == 0 && array[k-1][i-1] != 0){
          array[k][i] = array[k+1][i+1];
          array[k+1][i+1] = 0;
          didSlideUL = true;
        }
        //if both the current and previous elements are zero then the previous one is set to the next element
        else if(i!= offset && array[k][i] == 0 && array[k-1][i-1] == 0){
          array[k-1][i-1] = array[k+1][i+1];
          array[k+1][i+1] = 0;
        }
        //if the current and previous elements are equal then the previous element is equal to 2* itself and the current element equals zero
        if(i != offset && array[k][i] == array[k-1][i-1]){
          array[k-1][i-1]*= 2;
          array[k][i] = 0;
          didSlideUL = true;
        }
        //if the current and next elements are equal then the current element is set to 2* itself and the next element equals zero
        else if(array[k][i] == array[k+1][i+1]){
          array[k][i] *= 2;
          array[k+1][i+1] = 0;
          didSlideUL = true;
        }
        i++;
        k++;
      }
    }
    return didSlideUL;
  }
  
  /**Shifts non-zero elements of array in the corresponding diagonal up right
    * @param array from SlideGame, row and col of diagonal
    */
  public static boolean slideUpRight(int[][] array, int row, int col){
   boolean didSlideUR = false;
      //sets the offset between row and col in order to stay in the proper diagonal
      int offset = (int) Math.abs(row - col); 
      int i = offset;
      int k = array[row].length-1;
      int temp1 = offset;                                             //place markers
      int temp2 = array[row].length-1;                                //place markers
      //counts the number of zeros before the first non-zero element  
      while(i < array[row].length && array[i][k] == 0){
        i++;
        k--;
      }
      //if i equals the length of the row then the diagonal is all zeros and the method returns false
      if(i == array[row].length)
        return didSlideUR;
      //if there is no initial zero then the loop finds the first zero element within the array
      if(i == offset){
      while(i < array[row].length && array[i][k] != 0){
        i++;
        k--;
      }
      temp1 = i;
      temp2 = k;
      }

      //shifts all the zeros to the bottom right of the diagonal
      if(i != offset){
        while(i < array[row].length){
          if(array[i][k] != 0){
            array[temp1][temp2] = array[i][k];
            array[i][k] = 0;
            temp1++;
            temp2--;
          }
          i++;
          k--;
        }
      }
      i = offset;
      k = array[row].length-1;
      while(i < array[row].length-1){
        //if current array element equals zero and hte previous one doesn't then the current element is set to the next element
        if(i != offset && array[i][k] == 0 && array[i-1][k+1] != 0){
          array[i][k] = array[i+1][k-1];
          array[i+1][k-1] = 0;
          didSlideUR = true;
        }
        //if both the current and previous elements are zero then the previous one is set to the next element
        else if(i!= offset && array[i][k] == 0 && array[i-1][k+1] == 0){
          array[i-1][k-1] = array[i+1][k-1];
          array[i+1][k-1] = 0;
        }
        //if the current and previous elements are equal then the previous element is equal to 2* itself and the current element equals zero
        if(i != offset && array[i][k] == array[i-1][k+1]){
          array[i-1][k+1]*= 2;
          array[i][k] = 0;
          didSlideUR = true;
        }
        //if the current and next elements are equal then the current element is set to 2* itself and the next element equals zero
        else if(array[i][k] == array[i+1][k-1]){
          array[i][k] *= 2;
          array[i+1][k-1] = 0;
          didSlideUR = true;
        }
        i++;
        k--;
      }
    return didSlideUR;
  }
  
  /**Slides non-zero elements on diagonal from top left to bottom right and combines equal values
    * @param array from SlideGame and row and column of diagonal*/
  public static boolean slideDownRight(int[][] array, int row, int col){
    boolean didSlideUL = false;
    //if row is greater than col then run through the length of row which is shorter
    if(row >= col){
      int offset = row - col; //sets the offset between row and col in order to stay in the proper diagonal
      int i = array[row].length-1;
      int k = array.length-1-offset;
      int temp1 = i;          //place markers
      int temp2 = k;          //place markers
      //counts the number of zeros before the first non-zero element
      while(i >= 0 && array[i][k] == 0){
        i--;
        k--;
      }
      //if i is past the length of the row then the diagonal is all zeros and the method returns false
      if(i == -1)
        return didSlideUL;
      //if there is no initial zero then the loop finds the first zero element within the array
      if(i == array[row].length-1){
      while(k > 0 && array[i][k] != 0){
        i--;
        k--;
      }
      temp1 = i;
      temp2 = k;
      }

      //shifts all the zeros to the top left of the diagonal
      if(i != array[row].length-1){
        while(k > 0){
          if(array[i][k] != 0){
            array[temp1][temp2] = array[i][k];
            array[i][k] = 0;
            temp1--;
            temp2--;
          }
          i--;
          k--;
        }
      }
      i = array[row].length-1;
      k = array.length-1-offset;
      while(k > 0){
        //if current array element equals zero and the next one doesn't then the current element is set to the previous element
        if(i != array[row].length-1 && k > 0 && array[i][k] == 0 && array[i+1][k+1] != 0){
          array[i][k] = array[i-1][k-1];
          array[i-1][k-1] = 0;
          didSlideUL = true;
        }
        //if both the current and next elements are zero then the next one is set to the previous element
        else if(i!= array[row].length-1 && k > 0 && array[i][k] == 0 && array[i+1][k+1] == 0){
          array[i+1][k+1] = array[i-1][k-1];
          array[i-1][k-1] = 0;
        }
        //if the current and next elements are equal then the next element is equal to 2* itself and the current element equals zero
        if(i != array[row].length-1 && array[i][k] == array[i+1][k+1]){
          array[i+1][k+1]*= 2;
          array[i][k] = 0;
          didSlideUL = true;
        }
        //if the current and previous elements are equal then the current element is set to 2* itself and the previous element equals zero
        else if(k!= 0 && array[i][k] == array[i-1][k-1]){
          array[i][k] *= 2;
          array[i-1][k-1] = 0;
          didSlideUL = true;
        }
        i--;
        k--;
      }
    }
    //if col is greater than the row
    else{
      int offset = col - row;                                  //sets the offset between row and col in order to stay in the proper diagonal
      int i = array.length-1;                                  //array accessor value
      int k = array[row].length-1-offset;
      int temp1 = i;                                           //place markers
      int temp2 = k;                                           //place markers
      //counts the number of zeros before the first non-zero element
      while(i >= 0 && array[k][i] == 0){
        i--;
        k--;
      }
      //if i equals -1 then the diagonal is all zeros and the method returns false
      if(i == -1)
        return didSlideUL;
      //if there is no initial zero then the loop finds the first zero element within the array
      if(i == array.length-1){
      while( k> 0 && array[k][i] != 0){
        i--;
        k--;
      }
      temp1 = i;
      temp2 = k;
      }
      System.out.println("i= " + i + "k= " +k);
      //shifts all the zeros to the top left of the diagonal
      if(i != array.length-1){
        while(k > 0){
          System.out.println(array[k][i]);
          if(array[k][i] != 0){
            array[temp2][temp1] = array[k][i];
            System.out.println(array[temp2][temp1]);
            array[k][i] = 0;
            temp1--;
            temp2--;
          }
          i--;
          k--;
        }
      }
      i = array.length-1;
      k = array[row].length-1-offset;
      while(k > 0){
        //if current array element equals zero and the next one doesn't then the current element is set to the next element
        if(i != array.length-1 && array[k][i] == 0 && array[k+1][i+1] != 0){
          array[k][i] = array[k-1][i-1];
          array[k-1][i-1] = 0;
          didSlideUL = true;
        }
        //if both the current and next elements are zero then the next one is set to the previous element
        else if(i!= array.length-1 && array[k][i] == 0 && array[k+1][i+1] == 0){
          array[k+1][i+1] = array[k-1][i-1];
          array[k-1][i-1] = 0;
        }
        //if the current and next elements are equal then the next element is equal to 2* itself and the current element equals zero
        if(i != array.length-1 && array[k][i] == array[k+1][i+1]){
          array[k+1][i+1]*= 2;
          array[k][i] = 0;
          didSlideUL = true;
        }
        //if the current and previous elements are equal then the current element is set to 2* itself and the previous element equals zero
        else if(array[k][i] == array[k-1][i-1]){
          array[k][i] *= 2;
          array[k-1][i-1] = 0;
          didSlideUL = true;
        }
        i--;
        k--;
      }
    }
    return didSlideUL;    
  }
}
  