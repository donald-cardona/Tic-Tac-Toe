/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * This class is designed to create a TicTacToe board using a grid pane
 * @author Donald Cardona
 */
public class TicTacToePane extends StackPane {
    private Rectangle rect;
    private char mark;
    
    public TicTacToePane() {
        rect = new Rectangle(50, 50, Color.WHITE);
        mark = 'b';
        this.getChildren().add(rect);
    }
    
    public void setColor(Color color) {
        this.rect.setFill(color);
    }
    
    public Paint getColor() {
        return this.rect.getFill();
    }
    
    public void drawX() {
        Line line = new Line(5,5,45,45);
        Line line2 = new Line(5,45,45,5);
        this.getChildren().addAll(line, line2);
    }
    
    public void drawO() {
        Circle c = new Circle(20);
        c.setFill(Color.WHITE);
        c.setStroke(Color.BLACK);
        this.getChildren().addAll(c);
    }

    /**
     * @return the turn
     */
    public char getMark() {
        return mark;
    }

    /**
     * @param turn the turn to set
     */
    public void setMark(char turn) {
        this.mark = turn;
    }
    
    
}
