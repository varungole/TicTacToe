    package org.example.tictactoe;

    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.layout.GridPane;
    import javafx.stage.Stage;

    import java.io.IOException;

    public class HelloApplication extends Application {

        private final Board board = new Board();
        private final GameController gameController = new GameController(board);
        private final PlayGame playGame = new PlayGame(board.GRID_SIZE, gameController);

        private void setupScene(Stage mainStage, GridPane gridPane) {
            Scene scene = new Scene(gridPane, 400 , 400);
            mainStage.setScene(scene);
            mainStage.setTitle("TicTacToe");
            mainStage.show();
        }

        @Override
        public void start(Stage mainStage) throws IOException {
            GridPane gridPane = new GridPane();
            Setup.setupGrid(gridPane);
            playGame.playGame(gridPane);
            setupScene(mainStage, gridPane);
        }

        public static void main(String[] args) {
            launch();
        }
    }