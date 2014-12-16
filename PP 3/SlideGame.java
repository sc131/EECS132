/**Stephanie Collins
  * This allows the game board to be created and the game to be played*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SlideGame extends JFrame implements ActionListener{
  /**This board holds buttons of the game*/
  private JPanel board;
  /**This array holds the buttons to be placed on the board*/
  private JButton[][] buttons;
  /**This holds integer values passed to the buttons and slide methods*/
  private int[][] values;
  
  /**Main method of the game*/
  public static void main(String[] args){
    int row = Integer.parseInt(args[0]);
    int col = Integer.parseInt(args[1]);
    SlideGame s = new SlideGame(row, col);
    s.countBlanks();
  }
  
  /**Constructor for the game board, intializes all base elements*/
  public SlideGame(int rows, int columns){
    //sets board up
    board = new JPanel(new GridLayout(rows, columns));
    //initializes array of buttons
    buttons = new JButton[rows][columns];
    //initializes array of ints
    values = new int[rows][columns];
    //constructs JFrame for the board
    JFrame j = new JFrame();
    j.setSize(500,500);
    j.getContentPane().add(board, "Center");
    //adds buttons to the buttons array and sets an actionListener for each one
    for(int i=0;i<buttons.length;i++){
      for(int k=0;k<buttons[i].length;k++){
        buttons[i][k] = new JButton();
        board.add(buttons[i][k]);
        buttons[i][k].addActionListener(this);
      }
    }
    //places a random 1 on the board to start the game
    this.countBlanks();
    j.setVisible(true);
  }
  
  /**Sets the value of the button shown on the board as the pieces shift*/
  public void setButtonLabel(){
    //runs through each value of each button and if the value is not zero it sets the button label to show the value
    for(int i = 0; i < values.length; i++){
      for(int j = 0; j < values[i].length; j++){
        if(values[i][j] != 0)
          buttons[i][j].setLabel("" + values[i][j]);
        else
          buttons[i][j].setLabel(null);
        
      }
    }
  }
  
  /**This method acts on the button pressed*/
  public void actionPerformed(ActionEvent e) {
    JButton b = (JButton) e.getSource(); 
    int i = 0;
    int j = 0;
    boolean buttonPressed = false;
    //Finds the button that was pressed
    while( i < buttons.length && !buttonPressed){
      j = 0;
      while( j < buttons[i].length && !buttonPressed){
        //when found buttonPressed = true and it breaks out of the loop
        if(buttons[i][j].equals(b)){
          buttonPressed = true;
        }
        j++;
      }
      i++;
    }
    //because i and j increment one last time before breaking out of the loop they must be decremented to have the correct value
    i = i-1;
    j = j-1;
    //if the button is in the top row slideLeft is called for each row
    if(i == 0 && j!= 0){
      boolean slide = false;
      for(int k = 0; k < values.length; k++){
        if(Project3.slideLeft(values, k) == true){
          slide = true;
        }
      }
      //if elements slide update button labels and add new random 1 to the board
      if(slide == true){
        setButtonLabel();
        countBlanks();
      }
    }
    //if the button is in the last row then slideRight is called
    else if( i == buttons.length-1 && j!= buttons[i].length-1){
      boolean slide = false;
      for(int k = 0; k < values.length; k++){
        if(Project3.slideRight(values, k) == true){
          slide = true;
        }
      }
      //if elements slide update button labels and add new random 1 to the board
      if(slide == true){
        setButtonLabel();
        countBlanks();
       }
     }
    //if the button is in the first column slideUp is called
    else if(i!= 0 && j == 0){
      boolean slide = false;
      for(int k = 0; k < values[i].length; k++){
        if(Project3.slideUp(values, k) == true){
           slide = true;
        }
      }
      //if elements slide update button labels and add new random 1 to the board
      if(slide == true){
        setButtonLabel();
        countBlanks();
      }
    }
    //if the button is in the last column slideDown is called
    else if(i< buttons.length-1 && j == buttons[i].length-1){
      boolean slide = false;
      for(int k = 0; k < values[i].length; k++){
        if(Project3.slideDown(values, k) == true){
          slide = true;
        }
      }
      //if elements slide update button labels and add new random 1 to the board
      if(slide == true){
          setButtonLabel();
          countBlanks();
        }
    }
        else;
          //ran out of time to finish diagonal shifts
  }

  /**Finds the number of blank spaces on the board and randomly inserts a 1 into one of the blank spaces*/
  public void countBlanks(){
    int count = 0;
    //finds the number of blank values
     for(int i = 0; i < values.length; i++){
      for(int j = 0; j < values[i].length; j++){
        if(values[i][j] == 0)
          count++;
      }
     }
     //creats an array holding the addresses of blank spaces
     int[][] zeros = new int[count][2];
     int k = 0;
     int q = 0;
     for(int i = 0; i < values.length; i++){
      for(int j = 0; j < values[i].length; j++){
        if(values[i][j] == 0){
          zeros[k][0] = i;
          zeros[k][1] = j;
          k++;
        }
       }
     }
     int temp = (int)(Math.random()*zeros.length);
     //sets the randomly chosen button label to 1 and updates the int value for that button
     values[zeros[temp][0]][zeros[temp][1]] = 1;
     buttons[zeros[temp][0]][zeros[temp][1]].setLabel("1");
  }
}
