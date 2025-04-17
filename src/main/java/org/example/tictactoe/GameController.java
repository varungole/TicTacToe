package org.example.tictactoe;

import javafx.scene.control.Alert;

public class GameController {

    private final Board board;
    private boolean currentPlayer = true;

    public GameController(Board board) {
        this.board = board;
    }

    private void showWinnerPopup(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setWidth(5);
        alert.showAndWait();
    }
    private void printResult(int answer) {
        if(answer == 1) showWinnerPopup("Player 1 has won the game");
        else if(answer == 0)  showWinnerPopup("Player 2 has won the game");
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
