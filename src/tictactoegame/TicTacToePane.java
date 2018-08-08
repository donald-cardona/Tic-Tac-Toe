/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * This class is designed to create a TicTacToe square that will later be 
 * organized into a 3x3 GridPane. This class will also have methods to display
 * X's and O's on top of the TicTacToe square using a StackPane.
 * @author Donald Cardona
 */
public class TicTacToePane extends StackPane {
    private Rectangle rect;         //Shape used to create TicTacToe square
    
    /**
     * Constructor used to instantiate rectangle and add it to the StackPane
     */
    public TicTacToePane() {
        rect = new Rectangle(50, 50, Color.WHITE);
        this.getChildren().add(rect);
    }
    
    /**
     * Method designed to set color of TicTacToe square when mouse hovers over
     * square and also when mouse does not hover over square.
     * @param color variable used to set TicTacToe Square color
     */
    public void setColor(Color color) {
        this.rect.setFill(color);
    }
    
    /**
     * Method is designed to draw an X over the TicTacToe square using two line
     * objects and adding it to the StackPane.
     */
    public void drawX() {
        Line line = new Line(5,5,45,45);
        Line line2 = new Line(5,45,45,5);
        this.getChildren().addAll(line, line2);
    }
    
    /**
     * Method is designed to draw an O over the TicTacToe square using a circle
     * object and adding it to the StackPane.
     */
    public void drawO() {
        Circle c = new Circle(20);
        c.setFill(Color.WHITE);
        c.setStroke(Color.BLACK);
        this.getChildren().addAll(c);
    }
}
