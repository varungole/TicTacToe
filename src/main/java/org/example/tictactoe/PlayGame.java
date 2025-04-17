package org.example.tictactoe;

import javafx.scene.layout.GridPane;

public class PlayGame {

    private final int gridSize;
    private final GameController gameController;

    public PlayGame(int gridSize, GameController gameController) {
        this.gridSize = gridSize;
        this.gameController = gameController;
    }

    public void playGame(GridPane gridPane) {
        for(int row=0;row<gridSize;row++) {
            for(int col=0;col<gridSize;col++) {
                Tile currTile = createTile(gridPane, row, col);
                attachTileEvent(currTile);
            }
        }
    }

    private Tile createTile(GridPane gridPane, int row, int col) {
        Tile tile = new Tile(row, col);
        gridPane.add(tile,row,col);
        return tile;
    }

    private void attachTileEvent(Tile tile) {
        tile.setOnMouseClicked(mouseEvent -> {
            int row = tile.getRow();
            int col = tile.getCol();
            gameController.handleMove(row,col,tile);
        });
    }
}
