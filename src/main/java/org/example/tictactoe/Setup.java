package org.example.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class Setup {

    public static void setupGrid(GridPane gridPane) {
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
    }

}
