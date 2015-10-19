package edu.bupt.zyq.list;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

 Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 Write a function to compute the next state (after one update) of the board given its current state.
 * Created by root on 15-10-5.
 */
public class GameofLife {

    public void gameOfLife(int[][] board) {
        if(board == null || board.length < 1) return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int lives = isAlive(board, i, j - 1) + isAlive(board, i - 1, j - 1)
                        +isAlive(board, i + 1, j - 1) + isAlive(board, i + 1, j)
                        +isAlive(board, i + 1, j + 1) + isAlive(board, i, j + 1)
                        +isAlive(board, i - 1, j + 1) + isAlive(board, i - 1, j);
                if(lives == 3 || lives + board[i][j] == 3) board[i][j] |= 2;//only 2 situation will be 1 next generation
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] >>= 1;
            }
        }
    }

    public int isAlive(int[][] board, int i, int j){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length)return board[i][j] & 1;//some pre cell have been edit by |2,
        //only the last bit is origin cell
        return 0;
    }

    public int excute(int[][] board, int i, int j, int lives){
        if(board[i][j] == 1 && (lives < 2 || lives >3)) return 0;
        if(board[i][j] == 0 && lives == 3) return 1;
        return board[i][j];
    }

    public static void main(String[] args){
//        int[][] board = {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};
        int[][] board = {{1, 1}, {1, 0}};
        new GameofLife().gameOfLife(board);
    }

}
