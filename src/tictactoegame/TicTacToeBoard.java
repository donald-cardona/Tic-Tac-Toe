/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 *
 * @author Donald Cardona
 */
public class TicTacToeBoard extends BorderPane {
    private Line line1;                 //Line objects will be used to set up the tic tac toe board
    private Line line2;                 
    private Line line3;
    private Line line4;
    private char turn;                  //Turn is used to determine whose turn it is to draw on the board
    private TicTacToePane tic;          //Tic is a Tic Tac Toe square that will be used to set up a 3x3 GridPane
    private GridPane grid;              //Grid is used to hold TicTacToePanes
    
    
    public TicTacToeBoard() {
        line1 = new Line(0, 50, 150, 50);
        line2 = new Line(0, 100, 150, 100);
        line3 = new Line(50, 0, 50, 150);
        line4 = new Line(100, 0, 100, 150);
        turn = 'x';
        grid = new GridPane();
        
        // Nested for loop used to create tic tac toe panes as well as set 
        // mouse events for when they are clicked on to draw X's and O's
        // and organizing the panes into a 3x3 grid
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                TicTacToePane tic = new TicTacToePane();
                
                // Mouse Event used to allow the mouse to hover over available
                // spots to place X's and O's
                tic.setOnMouseMoved(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        if(turn == 'x')
                            tic.setColor(Color.RED);
                        else if(turn == 'o')
                            tic.setColor(Color.BLUE);
                    }
                });
                
                // Mouse Event allows previous squares that cursor hovers over
                // to return to original state prior to the cursor hover
                tic.setOnMouseExited(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        tic.setColor(Color.WHITE);
                    }
                });
                
                // Mouse Event used to draw X's and O's when clicking an 
                // available TicTacToePane
                tic.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if(turn == 'x') {
                            tic.drawX();
                            tic.setMark(turn);
                            turn = 'o';
                        }
                        else if(turn == 'o') {
                            tic.drawO();
                            tic.setMark(turn);
                            turn = 'x';
                        }
                        tic.setDisable(true);
                        
                    }
                });
                grid.add(tic, j, i);
            }
        }
        
        this.getChildren().addAll(grid, line1, line2, line3, line4);
    }
}
