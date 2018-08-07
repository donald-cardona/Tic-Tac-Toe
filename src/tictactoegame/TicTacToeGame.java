/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This program is designed to allow two users to play Tic-Tac-Toe
 * @author Donald Cardona
 */
public class TicTacToeGame extends Application {
    private char turn = 'x';
    
    @Override
    public void start(Stage primaryStage) {
        
        //Creating grid of tic tac toe rectangles 
        GridPane grid = new GridPane();
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                TicTacToePane tic = new TicTacToePane();
                
                tic.setOnMouseMoved(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        if(turn == 'x')
                            tic.setColor(Color.RED);
                        else if(turn == 'o')
                            tic.setColor(Color.BLUE);
                    }
                });
                
                tic.setOnMouseExited(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        tic.setColor(Color.WHITE);
                    }
                });
                
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
        
        StackPane root = new StackPane();
        root.getChildren().add(grid);
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
