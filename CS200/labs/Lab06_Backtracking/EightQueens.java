/*
 * File Queens.java
 */

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Program to find a solution to the 8 queens problem
 * and display the result graphically.
 * 
 * @author Jim Schnepf, modified by J. Andrew Holey
 * @version October, 2012
 */
public class EightQueens extends JFrame {
  
  private static final Color QUEENSPOT      = Color.RED;
  private static final Color OPEN           = Color.BLACK;
  
  // delay between redraws of chessboard
  private static int SLEEP_TIME = 200;
  
  //squares per row or column
  private static int BOARD_SIZE = 8;
  
  // used to indicate an empty square
  private static final int EMPTY = 0;
  
  //used to indicate a square containing a queen
  private static int QUEEN = 1;
  
  private int board[][]; // chess board
  private TwoDimGrid GUIBoard;
  
  /**
   * Constructor creates an empty square board
   */
  public EightQueens() {
    board = new int[BOARD_SIZE][BOARD_SIZE];
    GUIBoard = new TwoDimGrid(BOARD_SIZE, BOARD_SIZE);
    getContentPane().add(GUIBoard, BorderLayout.CENTER);
    pack();
    setVisible(true);
    displayBoard();
  }
  
  /**
   * Clears the board
   * post: Sets all of the squares to EMPTY
   */
  public void clearBoard() {
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j <  BOARD_SIZE; j++) {
        board[i][j] = EMPTY;
      }
    }
  }
  
  /**
   * Displays the board
   * post: board is displayed using grid
   */
  void displayBoard() {
    
    GUIBoard.recolor(board, QUEENSPOT, OPEN);
    try {
      Thread.sleep(SLEEP_TIME);
    }
    catch(InterruptedException ie) {
      ie.printStackTrace();
      System.exit(1);
    }      
  }
  
  /**
   * Places queens in the colums beginning at the 
   * column specified
   * Precondition: Queens are already placed in all columns preceding currentColumn
   * Post: If a solution is found, each column
   * of the board contains one queen and method returns true;
   * otherwise, returns false (no solution exists for a queen anywhere 
   * in column specified
   */
  public boolean placeQueens(int currentColumn) {
    /*** Write your code here ************************************************************/
  }
  
  /**
   * Set a queen on a row indicated by row and column
   * post: Sets the square on the board in a
   * given row and column to QUEEN.
   * 
   */
  private void setQueen(int column, int row) {
    board[column][row] = QUEEN;
    displayBoard();
  }
  
  /** Remove a queen at square indicated by row and column
    *  post: Sets the square on a board in a given row and column 
    * to EMPTY  
    */
  
  private void removeQueen(int column, int row) {
    board[column][row] = EMPTY;
    displayBoard();
  }
  
  /**
   * Determines whether the square on the board at a given 
   * row and column is under attack by any queens in the columns 1 
   * through "column  - 1"
   * @param column the y-coordinate for the square on the board
   * @param row the x-coordinate for the square on the board
   * @return true if placing the queen at square (column, row) is allowed or 
   *         false otherwise
   */
  private boolean isUnderAttack(int column, int row){
    boolean attacked = false;
    /*** Write your code here ************************************************************/
    return attacked;
  }
  
  /**
   * Start the Queens search 
   */
  public static void main(String [] args) {
    EightQueens q = new EightQueens();
    q.placeQueens(0);
  }
}     




