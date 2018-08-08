/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Donald Cardona
 */
public class TicTacToeBoard extends VBox {
    private Line line1;                 //Line objects will be used to set up the tic tac toe board
    private Line line2;                 
    private Line line3;
    private Line line4;
    private HBox hbox;                  //Hbox used to set a horizontal layout of the two buttons
    private BorderPane border;          //BorderPane used to organize tic tac toe board
    private char turn;                  //Turn is used to determine whose turn it is to draw on the board
    private TicTacToePane tic;          //Tic is a Tic Tac Toe square that will be used to set up a 3x3 GridPane
    private GridPane grid;              //Grid is used to hold TicTacToePanes
    private char [][] marks;            //Separate grid that hold which spots hold X's and O's
    private int count;                  //Used to declare draw when all spots are filled with no winner
    private Label winner;               //Label to declare winner or draw when result is determined
    private Button exit;                //Button to leave game
    private Button newGame;             //Buton to start new Tic Tac Toe game
    
    /**
     * Constructor designed to instantiate and initialize variables and panes
     * in class. It will also set MouseEvents and ActionEvents to
     * TicTacToePane, the exit button, and the new game button.
     */
    public TicTacToeBoard() {
        line1 = new Line(0, 50, 150, 50);
        line2 = new Line(0, 100, 150, 100);
        line3 = new Line(50, 0, 50, 150);
        line4 = new Line(100, 0, 100, 150);
        hbox = new HBox();
        border = new BorderPane();
        turn = 'x';
        grid = new GridPane();
        marks = new char[][] {
            {'b', 'b', 'b'},
            {'b', 'b', 'b'},
            {'b', 'b', 'b'}
        };
        count = 0;
        winner = new Label("");
        
        //Action Event to exit the game
        exit = new Button("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.exit(-1);
            }
            
        });
        
        //Action Event to restart the game with a blank tic tac toe board
        //using a new tictactoeboard, a new scene, and a new stage.
        newGame = new Button("New Game");
        newGame.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                TicTacToeBoard board = new TicTacToeBoard();
                Scene scene = new Scene(board, 300, 300);
                Stage primaryStage = new Stage();
                
                primaryStage.setTitle("Tic Tac Toe");
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        
        });
        
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
                            marks[(int)grid.getRowIndex(tic)][(int)grid.getColumnIndex(tic)] = 'x';
                            checkXWin();
                            turn = 'o';
                            count++;
                        }
                        else if(turn == 'o') {
                            tic.drawO();
                            marks[(int)grid.getRowIndex(tic)][(int)grid.getColumnIndex(tic)] = 'o';
                            checkOWin();
                            turn = 'x';
                            count++;
                        }
                        tic.setDisable(true);
                        
                    }
                });
                grid.add(tic, j, i);
            }
        }
        //Gathering all nodes and panes
        border.setPrefSize(150, 150);
        border.getChildren().addAll(grid, line1, line2, line3, line4, hbox);
        
        hbox.getChildren().addAll(newGame, exit);
        
        this.getChildren().addAll(border, winner, hbox);
    }
    
    /**
     * This method is designed to determine if X has achieved a win either by 
     * 3 in a row, 3 in a column, or 3 in a diagonal. This method will also
     * determine if the game has reached a draw.
     */
    public void checkXWin() {
        for(int i = 0; i < 3; i++) {
            if(marks[i][0] == marks[i][1] && marks[i][1] == marks[i][2] && marks[i][1] == 'x') {
                winner.setText("X wins");
                border.setDisable(true);
            }
        }
        
        for(int j = 0; j < 3; j++) {
            if(marks[0][j] == marks[1][j] && marks[1][j] == marks[2][j] && marks[1][j] == 'x') {
                winner.setText("X wins");
                border.setDisable(true);
            }
        }
        
        if(marks[0][0] == marks[1][1] && marks[1][1] == marks[2][2] && marks[1][1] == 'x' ) {
            winner.setText("X wins");
            border.setDisable(true);
        }
        
        else if(marks[2][0] == marks[1][1] && marks[1][1] == marks[0][2] && marks[1][1] == 'x') {
            winner.setText("X wins");
            border.setDisable(true);
        }
        else if(count == 8)
            winner.setText("It's a Draw");
    }
    
    /**
     * This method is designed to determine if O has achieved a win either by 
     * 3 in a row, 3 in a column, or 3 in a diagonal.
     */
    public void checkOWin() {
        for(int i = 0; i < 3; i++) {
            if(marks[i][0] == marks[i][1] && marks[i][1] == marks[i][2] && marks[i][1] == 'o') {
                winner.setText("O wins");
                border.setDisable(true);
            }
        }
        
        for(int j = 0; j < 3; j++) {
            if(marks[0][j] == marks[1][j] && marks[1][j] == marks[2][j] && marks[1][j] == 'o') {
                winner.setText("O wins");
                border.setDisable(true);
            }
        }
        
        if(marks[0][0] == marks[1][1] && marks[1][1] == marks[2][2] && marks[1][1] == 'o') {
            winner.setText("O wins");
            border.setDisable(true);
        }
        
        else if(marks[2][0] == marks[1][1] && marks[1][1] == marks[0][2] && marks[1][1] == 'o' ) {
            winner.setText("O wins");
            border.setDisable(true);
        }
    }
}
