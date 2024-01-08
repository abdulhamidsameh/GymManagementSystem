/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainStage;

import healthclub.Admin;
import healthclub.Coach;
import healthclub.Member;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author c.city
 */
public  class Login {
      
    
    public static void login() {
        Stage newstage=new Stage(); 
        GridPane grid=new GridPane();
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        
        grid.setPadding(new Insets(20,20,20,20));
        Scene scene =new Scene(grid,750,500);
           scene.getStylesheets().add(Login.class.getResource("ceses.css").toExternalForm());
        Text text=new Text("Login");
        Label username=new Label("User Name : ");
        TextField textfield=new TextField();
        Label passowrd=new Label("Password : ");
        PasswordField passwordfield=new PasswordField();
        grid.add(text,0,0,2,1);
        grid.add(username,0,1);
        grid.add(textfield,1,1);
        grid.add(passowrd,0,2);
        grid.add(passwordfield,1,2);
        
        grid.setGridLinesVisible(false);
        Button btn =new Button("Submit");
        HBox hbtn=new HBox(20);
        hbtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbtn.getChildren().add(btn);
        grid.add(hbtn, 1, 3);
        System.out.println("0");
        final Text actiontarget=new Text();
        grid.add(actiontarget, 1, 6);
        btn.setOnAction((ActionEvent event) -> {
          //login                                                   //login
            Admin x=new Admin();
            Coach z=new Coach();
            Member y=new Member();
            if(x.login(textfield.getText(), passwordfield.getText()))
            {
                System.err.println("login true");
            newstage.close();
                      

                AdminStage.adminStage();
            
            }
            
            if(y.login(textfield.getText(), passwordfield.getText()))
            {
                       
           
            newstage.close();
                    Member c=new Member();
                   int id=c.getIdbyUsernmam(textfield.getText(), passwordfield.getText());       

                MemberStage.memberstage(id);
            }
            
            if(z.login(textfield.getText(), passwordfield.getText()))
            {
               
            newstage.close();
                      Coach c=new Coach();
                   int id=c.getIdbyUsernmam(textfield.getText(), passwordfield.getText());

                CoachStage.coachStage(id);
            }
            {
                 actiontarget.setFill(Color.BLUE);
            actiontarget.setText("the username or password is wrong"); 
            }
          
        });
                newstage.setResizable(false);
        newstage.setTitle("Login Page");
        newstage.setScene(scene);
        newstage.show();
        
    }
}
