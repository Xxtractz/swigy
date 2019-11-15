package swingy.model;

import org.jetbrains.annotations.Contract;

public class Map {
    int size;
    String [][] board;

    @Contract(pure = true)
    public Map(int boardSize){
        board = new String[boardSize][boardSize];
        for(int row = 0;row  < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                board[row][column] = null;
            }
        }
    }

    public void printBoard(int boardSize){
                for(int row = 0;row  < boardSize; row++){
            int column;
            for (column = 0; column < boardSize ; column++) {
                if (board[row][column] == null)
                {
                    System.out.print("| . ");
                }
                else {
                    System.out.print("| "+ board[row][column]  + " ");
                }
            }
            if (column == boardSize) {
                System.out.print("|");
            }
            System.out.print("\n");
        }
    }
}
