package org.example.tictactoe;

public class GameController {

    private final Board board;
    private boolean currentPlayer = true;

    public GameController(Board board) {
        this.board = board;
    }

    private void printResult(int answer) {
        if(answer == 1) System.out.println("X has won");
        else if(answer == 0) System.out.println("Y has won");
    }

    public void handleMove(int row, int col, Tile tile) {
        int player = currentPlayer ? 1 : 0;
        if (!board.placeMark(col, row, player)) return;
        if (currentPlayer) {
            tile.drawX();
        } else {
            tile.drawO();
        }
        int answer =board.checkWinner();
        printResult(answer);
        currentPlayer = !currentPlayer;
    }
}
