    package org.example.tictactoe;

    import javafx.application.Application;
    import javafx.geometry.Pos;
    import javafx.scene.Node;
    import javafx.scene.Scene;
    import javafx.scene.control.Label;
    import javafx.scene.layout.GridPane;
    import javafx.stage.Popup;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.util.concurrent.atomic.AtomicInteger;

    public class HelloApplication extends Application {

        public final int GRID_SIZE = 3;
        public int[][] board = new int[GRID_SIZE][GRID_SIZE];
        private boolean changeTurn = false;

        public void createMatrix(GridPane gridPane) {
            for(int row=0;row<GRID_SIZE;row++) {
                for(int col=0;col<GRID_SIZE;col++) {
                    Tile tile = new Tile(row, col);
                    gridPane.setVgap(10);
                    gridPane.setHgap(10);
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.add(tile,row,col);
                }
            }
        }

        private boolean checkRow(int[] row) {
            if (row[0] == 0) return false; // empty row
            for (int i = 1; i < GRID_SIZE; i++) {
                if (row[i] != row[0]) return false;
            }
            return true;
        }


        private boolean checkIfWinner(int[][] board, int currSign) {
            int count = 0;
            //check each row
            for(int[] row : board) {
                if(checkRow(row)) {
                    return true;
                }
            }
            return false;
        }

        private void showPopup(String message, Stage stage) {
            Popup popup = new Popup();
            Label label = new Label(message);
            label.setStyle("-fx-font-size: 16px; -fx-background-color: lightblue; -fx-padding: 10px;");
            popup.getContent().add(label);
            popup.setAutoHide(true);
            popup.show(stage);
        }

        public void startGame(GridPane gridPane, Stage mainStage) {
            for(Node node : gridPane.getChildren()) {
                Tile currTile = (Tile) node;
                AtomicInteger currSign = new AtomicInteger(-1);
                currTile.setOnMouseClicked(mouseEvent -> {
                    int currRow = currTile.getRow();
                    int currCol = currTile.getCol();
                    if (board[currRow][currCol] != 0) {
                        return;
                    }
                   if(!changeTurn) {
                       currTile.drawX();
                       changeTurn = true;
                       board[currRow][currCol] = 1;
                       currSign.set(1);
                   } else {
                       currTile.drawO();
                       changeTurn = false;
                       board[currRow][currCol] = 2;
                       currSign.set(2);
                   }
                    if(checkIfWinner(board, currSign.get())) {
                        showPopup("Player " + currSign.get() + " just won!", mainStage);
                    }
                });
            }
        }

        @Override
        public void start(Stage mainStage) throws IOException {
            GridPane gridPane = new GridPane();
            createMatrix(gridPane);
            startGame(gridPane, mainStage);
            Scene scene = new Scene(gridPane, 400 , 400);
            mainStage.setScene(scene);
            mainStage.setTitle("TicTacToe");
            mainStage.show();
        }

        public static void main(String[] args) {
            launch();
        }
    }