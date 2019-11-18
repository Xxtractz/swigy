package swingy.model;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Map {
    private int size;
    private String [][] board;

    @Contract(pure = true)
    public Map(){
    }

    public void printBoard(){
        for(int row = 0;row  < size; row++){
            int column;
            for (column = 0; column < size ; column++) {
                if (board[row][column] == null) {
                    System.out.print("| . ");
                }
                else {
                    System.out.print("| "+ board[row][column]  + " ");
                }
            }
            if (column == size) {
                System.out.print("|");
            }
            System.out.print("\n");
        }
    }

    public void setSize(int level) {
        this.size = (int) ((level -1) * 5 + 10 - (level*0.02));
    }

    public int getSize() {
        return size;
    }

    public void updatePosition(int x, int y, String c){
        this.board[x][y] = c;
    }

    public void VillianPosition(@NotNull int[] x, @NotNull int[] y, String[] c){
        for (int i = 0; i < x.length ; i++) {
            this.board[x[i]][y[i]] = c[i];
        }
    }

    public void setBoard() {
        this.board = new String[size][size];
        for(int row = 0;row  < size; row++) {
            for (int column = 0; column < size; column++) {
                board[row][column] = null;
            }
        }
    }
}
