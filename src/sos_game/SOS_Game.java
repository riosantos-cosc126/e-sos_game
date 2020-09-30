
package sos_game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class SOS_Game extends Application {
    
        Label lblHead = new Label();
        Button t1 = new Button();
        Button t2 = new Button();
        Button t3 = new Button();
        Button t4 = new Button();
        Button t5 = new Button();
        Button t6 = new Button();
        Button t7 = new Button();
        Button t8 = new Button();
        Button t9 = new Button();
        Button btnReset = new Button("RESET");
        Button btnExit = new Button("EXIT");
        Label p1 = new Label("Player 1: ");
        Label p2 = new Label("Player 2: ");
        Label p1s = new Label("0");
        Label p2s = new Label("0");
        
        private String startGame = "S";
        private int sCount = 0;
        private final int oCount = 0;
    
    Stage pStart = new Stage();
    
    @Override
    public void start(Stage primaryStage) {
       Button btnStart = new Button("Start");
       Button btnMechanics = new Button("Mechanics");
       Button btnExit = new Button("Exit");
       Image img = new Image(getClass().getResource("Images/start.gif").toString());
       ImageView imgv = new ImageView(img);
       
       btnStart.setMaxSize(100, 100);
       btnMechanics.setMaxSize(100, 100);
       btnExit.setMaxSize(100, 100); 
       VBox root = new VBox();
       imgv.setFitWidth(300);
       imgv.setFitHeight(450);
       root.getChildren().addAll(btnStart, btnMechanics, btnExit);
       GridPane gp = new GridPane();
       gp.setMaxSize(300, 450);
       gp.setAlignment(Pos.CENTER);
       gp.getChildren().addAll(imgv,root);
       root.setAlignment(Pos.CENTER);
       root.setSpacing(20);
       
     
       btnExit.setOnAction ((ActionEvent event ) -> {
          int c = JOptionPane.showConfirmDialog(null, "Exit the Game? ","Exit?",JOptionPane.YES_NO_OPTION,
                  JOptionPane.INFORMATION_MESSAGE);
          
          if (c == JOptionPane.OK_OPTION){
              System.exit(0);
          }
          
          else{
              primaryStage.show();
          }

       });
       
       btnMechanics.setOnAction((ActionEvent event) -> {
          primaryStage.hide();
          SOS_Game.this.mec(pStart);
       });
       
       btnStart.setOnAction((ActionEvent event) -> {
          primaryStage.hide();
          SOS_Game.this.game(pStart);
       });
        
        Scene scene = new Scene(gp, 300, 450);
        
        primaryStage.setTitle("SOS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
  
    
    public void mec (Stage mechanics){
        
        Label lbl = new Label();
        Label lblTitle = new Label();
        lblTitle.setText("General Mechanics");
        lblTitle.setFont(Font.font("Gill Sans",FontWeight.BOLD,20));
        lblTitle.setTextFill(Color.RED);
        lbl.setText("1. A player needs to input S or O. \n\n2. A player needs to build SOS to win around.");
        lbl.setTextFill(Color.BLUE);
        Button btnBack = new Button("Back");
        lbl.setFont(Font.font("Gill Sans",FontWeight.MEDIUM,14));
        
        btnBack.setMaxSize(100, 100);
        
        VBox root = new VBox();
        root.getChildren().addAll(lblTitle,lbl,btnBack);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        
        btnBack.setOnAction((ActionEvent event) ->{
            mechanics.hide();
            SOS_Game.this.start(pStart);
        });
        
        Scene scene = new Scene (root, 350,450);
        mechanics.setTitle("Mechanics");
        mechanics.setScene(scene);
        mechanics.show();
    }
    
      
    public void game (Stage game){
        
        //Size of Player Labels for Score
        p1.setPrefSize(200, 100);
        p1.setAlignment(Pos.BASELINE_CENTER);
        p1.setFont(Font.font("Tahoma",FontWeight.BOLD,42));
        p2.setPrefSize(200, 100);
        p2.setAlignment(Pos.BASELINE_CENTER);
        p2.setFont(Font.font("Tahoma",FontWeight.BOLD,42));
        
        //Size of Scoreboard
        p1s.setPrefSize(200, 100);
        p1s.setAlignment(Pos.BASELINE_CENTER);
        p1s.setFont(Font.font("Tahoma",FontWeight.BOLD,42));
        p2s.setPrefSize(200, 100);
        p2s.setAlignment(Pos.BASELINE_CENTER);
        p2s.setFont(Font.font("Tahoma",FontWeight.BOLD,42));
        
        //Sizes of Buttons
        t1.setPrefSize(200, 100);
        t2.setPrefSize(200, 100);
        t3.setPrefSize(200, 100);
        t4.setPrefSize(200, 100);
        t5.setPrefSize(200, 100);
        t6.setPrefSize(200, 100);
        t7.setPrefSize(200, 100);
        t8.setPrefSize(200, 100);
        t9.setPrefSize(200, 100);
        btnReset.setPrefSize(200, 100);
        btnReset.setFont(Font.font("Tahoma",FontWeight.BOLD,31));
        btnExit.setPrefSize(200, 100);  
        btnExit.setFont(Font.font("Tahoma",FontWeight.BOLD,31));
        
        //Scenes
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        HBox row3 = new HBox();
        VBox mainly = new VBox();
        
        row1.getChildren().addAll(t1,t2,t3,p1,p1s);
        row2.getChildren().addAll(t4,t5,t6,p2,p2s);
        row3.getChildren().addAll(t7,t8,t9,btnReset,btnExit);
        
        row1.setSpacing(1);
        row2.setSpacing(1);
        row3.setSpacing(1);
        
        mainly.getChildren().addAll(row1,row2,row3);
        mainly.setSpacing(3);
        mainly.setAlignment(Pos.CENTER);
        mainly.setStyle("-fx-padding: 5;" + "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 3;" +
                      "-fx-border-insets: 5;" + 
                      "-fx-border-radius: 5;" + 
                      "-fx-border-color: red;");
        
        
        t1.setOnAction((ActionEvent event) -> {
           
            t1.setText(startGame);
    
        if(startGame.equalsIgnoreCase("S"))
        {   
            t1.setStyle("-fx-background-color: #00FF00 ");
        }
        else
        {   
            t1.setStyle("-fx-background-color: #0000FF ");
        }
         choose_a_player();
         winningGame();
        });
        
        
        t2.setOnAction((ActionEvent event) -> {
           
            t2.setText(startGame);
    
        if(startGame.equalsIgnoreCase("S"))
        {   
            t2.setStyle("-fx-background-color: #00FF00 ");
        }
        else
        {   
            t2.setStyle("-fx-background-color: #0000FF ");
        }
         choose_a_player();
         winningGame();
        });
        
        
        t3.setOnAction((ActionEvent event) -> {
           
            t3.setText(startGame);
    
        if(startGame.equalsIgnoreCase("S"))
        {   
            t3.setStyle("-fx-background-color: #00FF00 ");
        }
        else
        {   
            t3.setStyle("-fx-background-color: #0000FF ");
        }
         choose_a_player();
         winningGame();
        });
        
        t4.setOnAction((ActionEvent event) -> {
           
            t4.setText(startGame);
    
        if(startGame.equalsIgnoreCase("S"))
        {   
            t4.setStyle("-fx-background-color: #00FF00 ");
        }
        else
        {   
            t4.setStyle("-fx-background-color: #0000FF ");
        }
         choose_a_player();
         winningGame();
        });
        
        t5.setOnAction((ActionEvent event) -> {
           
            t5.setText(startGame);
    
        if(startGame.equalsIgnoreCase("S"))
        {   
            t5.setStyle("-fx-background-color: #00FF00 ");
        }
        else
        {   
            t5.setStyle("-fx-background-color: #0000FF ");
        }
         choose_a_player();
         winningGame();
        });
        
        
        t6.setOnAction((ActionEvent event) -> {
           
            t6.setText(startGame);
    
        if(startGame.equalsIgnoreCase("S"))
        {   
            t6.setStyle("-fx-background-color: #00FF00 ");
        }
        else
        {   
            t6.setStyle("-fx-background-color: #0000FF ");
        }
         choose_a_player();
         winningGame();
        });
        
        
        t7.setOnAction((ActionEvent event) -> {
           
            t7.setText(startGame);
    
        if(startGame.equalsIgnoreCase("S"))
        {   
            t7.setStyle("-fx-background-color: #00FF00 ");
        }
        else
        {   
            t7.setStyle("-fx-background-color: #0000FF ");
        }
         choose_a_player();
         winningGame();
        });
        
        
        t8.setOnAction((ActionEvent event) -> {
           
            t8.setText(startGame);
    
        if(startGame.equalsIgnoreCase("S"))
        {   
            t8.setStyle("-fx-background-color: #00FF00 ");
        }
        else
        {   
            t8.setStyle("-fx-background-color: #0000FF ");
        }
         choose_a_player();
         winningGame();
        });
        
        
        t9.setOnAction((ActionEvent event) -> {
           
            t9.setText(startGame);
    
        if(startGame.equalsIgnoreCase("S"))
        {   
            t9.setStyle("-fx-background-color: #00FF00 ");
        }
        else
        {   
            t9.setStyle("-fx-background-color: #0000FF ");
        }
         choose_a_player();
         winningGame();
        });
        
        btnReset.setOnAction((ActionEvent event) -> {
            t1.setText(null); t2.setText(null); t3.setText(null); t4.setText(null);
            t5.setText(null); t6.setText(null); t7.setText(null); t8.setText(null);
            t9.setText(null); p1s.setText(null); p2s.setText(null); t1.setStyle(null);
            t2.setStyle(null); t3.setStyle(null); t4.setStyle(null); t5.setStyle(null);
            t6.setStyle(null); t7.setStyle(null); t8.setStyle(null); t9.setStyle(null);
        });
        
        btnExit.setOnAction((ActionEvent event) -> {
           if(JOptionPane.showConfirmDialog(null, "Confirm if you want to exit", "S O S",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
        {
            SOS_Game.this.start(pStart);
        }
        else {
                game.show();
                }
        
        });
        
        Scene scene = new Scene (mainly , 1200 , 350);
        game.setTitle("SOS Game");
        game.setScene(scene);
        game.show();
    }
    
    public void choose_a_player()
    {
        if(startGame.equalsIgnoreCase("S"))
        {
            startGame = "O";
        }
        else
        {
            startGame = "S";
        }
    }
    
    public void gameScore()
    {
        p1s.setText(String.valueOf(sCount));
        p2s.setText(String.valueOf(oCount));
    }
    
    public void winningGame() {
            
        String b1 = t1.getText();
        String b2 = t2.getText();
        String b3 = t3.getText();
        String b4 = t4.getText();
        String b5 = t5.getText();
        String b6 = t6.getText();
        String b7 = t7.getText();
        String b8 = t8.getText();
        String b9 = t9.getText();   
        
        if(b1 == ("S") && b2 == ("O") && b3 == ("S"))
        {
            JOptionPane.showMessageDialog(null, "Player 1 wins!", "S O S", JOptionPane.INFORMATION_MESSAGE);
            sCount++;
            gameScore();
            t1.setStyle("-fx-background-color : #FF00FF");
            t2.setStyle("-fx-background-color : #FF00FF");
            t3.setStyle("-fx-background-color : #FF00FF");
        }
        
        else if(b4 == ("S") && b5 == ("O") && b6 == ("S"))
        {
            JOptionPane.showMessageDialog(null, "Player 1 wins!", "S O S", JOptionPane.INFORMATION_MESSAGE);
            sCount++;
            gameScore();
            t4.setStyle("-fx-background-color : #FF00FF");
            t5.setStyle("-fx-background-color : #FF00FF");
            t6.setStyle("-fx-background-color : #FF00FF");
        }
        
        else if(b7 == ("S") && b8 == ("O") && b9 == ("S"))
        {
            JOptionPane.showMessageDialog(null, "Player 1 wins!", "S O S", JOptionPane.INFORMATION_MESSAGE);
            sCount++;
            gameScore();
            t7.setStyle("-fx-background-color : #FF00FF");
            t8.setStyle("-fx-background-color : #FF00FF");
            t9.setStyle("-fx-background-color : #FF00FF");
        }
        
        else if(b1 == ("S") && b5 == ("O") && b9 == ("S"))
        {
            JOptionPane.showMessageDialog(null, "Player 1 wins!", "S O S", JOptionPane.INFORMATION_MESSAGE);
            sCount++;
            gameScore();
            t1.setStyle("-fx-background-color : #FF00FF");
            t5.setStyle("-fx-background-color : #FF00FF");
            t9.setStyle("-fx-background-color : #FF00FF");
        }
        
        else if(b2 == ("S") && b5 == ("O") && b8 == ("S"))
        {
            JOptionPane.showMessageDialog(null, "Player 1 wins!", "S O S", JOptionPane.INFORMATION_MESSAGE);
            sCount++;
            gameScore();
            t2.setStyle("-fx-background-color : #FF00FF");
            t5.setStyle("-fx-background-color : #FF00FF");
            t8.setStyle("-fx-background-color : #FF00FF");
        }
        
        else if(b3 == ("S") && b6 == ("O") && b9 == ("S"))
        {
            JOptionPane.showMessageDialog(null, "Player 1 wins!", "S O S", JOptionPane.INFORMATION_MESSAGE);
            sCount++;
            gameScore();
            t3.setStyle("-fx-background-color : #FF00FF");
            t6.setStyle("-fx-background-color : #FF00FF");
            t9.setStyle("-fx-background-color : #FF00FF");
        }
        
        else if(b1 == ("S") && b4 == ("O") && b7 == ("S"))
        {
            JOptionPane.showMessageDialog(null, "Player 1 wins!", "S O S", JOptionPane.INFORMATION_MESSAGE);
            sCount++;
            gameScore();
            t1.setStyle("-fx-background-color : #FF00FF");
            t4.setStyle("-fx-background-color : #FF00FF");
            t7.setStyle("-fx-background-color : #FF00FF");
        }
        
        else if(b3 == ("S") && b5 == ("O") && b7 == ("S"))
        {
            JOptionPane.showMessageDialog(null, "Player 1 wins!", "S O S", JOptionPane.INFORMATION_MESSAGE);
            sCount++;
            gameScore();
            t3.setStyle("-fx-background-color : #FF00FF");
            t5.setStyle("-fx-background-color : #FF00FF");
            t7.setStyle("-fx-background-color : #FF00FF");
        }
}
}
