    package org.example.tictactoe;

    public class Board {

        public final int GRID_SIZE;
        private final int[][] board;

        public Board() {
            GRID_SIZE = 3;
            board = new int[GRID_SIZE][GRID_SIZE];
            initialize();
        }

        private void initialize() {
            for(int i=0;i<GRID_SIZE;i++) {
                for(int j=0;j<GRID_SIZE;j++) {
                    board[i][j] = -1;
                }
            }
        }

        public boolean placeMark(int row, int col, int player) {
            if(board[row][col] != -1) return false;
            board[row][col] = player;
            return true;
        }

        public boolean isWinning(int[] arr, int player) {
            for (int cell : arr) {
                if (cell != player) return false;
            }
            return true;
        }

        public int checkWinner() {
            for(int player = 1;player>=0;player--) {
                for(int[] row : board) {
                    if(isWinning(row, player)) return player;
                }

                for(int col = 0; col<GRID_SIZE; col++) {
                    int[] column = new int[GRID_SIZE];
                    for(int row=0;row<GRID_SIZE;row++) {
                        column[row] = board[row][col];
                    }
                    if(isWinning(column, player)) return player;
                }

                int[] d1 = new int[GRID_SIZE];
                int[] d2 = new int[GRID_SIZE];
                for(int i=0;i<GRID_SIZE;i++) {
                    d1[i] = board[i][i];
                    d2[i] = board[i][GRID_SIZE-1-i];
                }
                if (isWinning(d1, player) || isWinning(d2, player)) return player;
            }
            return -1;
        }
    }
