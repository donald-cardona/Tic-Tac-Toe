/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This program is designed to set up and allow two users to play Tic-Tac-Toe.
 * @author Donald Cardona
 */
public class TicTacToeGame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TicTacToeBoard board = new TicTacToeBoard();
        Scene scene = new Scene(board, 300, 300);
        
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
