package org.example.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Tile extends StackPane {

    private final Text text = new Text();
    private final int ROW;
    private final int COL;

    public Tile(int ROW, int COL) {
        Rectangle border = new Rectangle(100, 100);
        border.setFill(Color.WHITE);
        border.setStroke(Color.BLACK);

        text.setStyle("-fx-font-size: 36px;");

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);
        this.ROW = ROW;
        this.COL = COL;
    }

    public boolean isEmpty() {
        return text.getText().isEmpty();
    }

    public void drawX() {
        text.setText("X");
    }

    public void drawO() {
        text.setText("O");
    }

    public String getValue() {
        return text.getText();
    }

    public int getRow() {
        return this.ROW;
    }

    public int getCol() {
        return this.COL;
    }
}
