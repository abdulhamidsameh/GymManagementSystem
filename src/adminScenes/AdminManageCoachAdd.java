package adminScenes;

import healthclub.Admin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


        public class AdminManageCoachAdd {
 
            
                public static GridPane adminManageCoachAdd(Stage souece) {
                
                    
                        Label label1 = new Label("ID");
                        Label label2 = new Label("First Name");
                        Label label3 = new Label("Last Name");
                        Label label4 = new Label("Middle Name");
                        Label label5 = new Label("Age");
                        Label label6 = new Label("Sallary");
                        Label label7 = new Label("User Name");
                        Label label8 = new Label("PassWord");
                        TextField id =new TextField();
                        TextField fname =new TextField();
                        TextField mname =new TextField();
                        TextField lname =new TextField();
                        TextField age =new TextField();
                        TextField sal =new TextField();
                        TextField username =new TextField();
                        PasswordField password = new PasswordField();
                        final Text actiontarget=new Text();
                        Button btn = new Button("Add");
                        btn.setOnAction((ActionEvent event) -> {
                        if(id.getText().equals("")||fname.getText().equals("")||mname.getText().equals("")||lname.getText().equals("")||username.getText().equals("")||password.getText().equals("")||sal.getText().equals("")||age.getText().equals(""))
                        {
                        actiontarget.setFill(Color.BLUE);
                        actiontarget.setText("Please Fill All New Coach Information");        
                        }else
                        {
                        Admin adm=new Admin();
                        if(adm.CheckIdFound(Integer.valueOf(id.getText())))
                        {
                        actiontarget.setFill(Color.BLUE);
                        actiontarget.setText("This personal ID is already used");     
                        }
                        else
                        {
                        Admin admin1=new Admin();
                        admin1.addCoach(fname.getText(), mname.getText(), lname.getText(), username.getText(), password.getText(), Float.valueOf(sal.getText()), Integer.valueOf(age.getText()), Integer.valueOf(id.getText()));
                        souece.close();
                        mainStage.AdminStage.adminStage();
                        }
                        }
                        });        
                        GridPane grid = new GridPane();
                        grid.setHgap(5);
                        grid.setVgap(5);
                        grid.add(label1,3,2);
                        grid.add(label2,3,4);
                        grid.add(label3,3,8);
                        grid.add(label4,3,6);
                        grid.add(label5,3,10);
                        grid.add(label6,3,12);
                        grid.add(label7,3,14);
                        grid.add(label8,3,16);
                        grid.add(id,6,2);
                        grid.add(fname,6,4);
                        grid.add(mname,6,6);
                        grid.add(lname,6,8);
                        grid.add(age,6,10);
                        grid.add(sal,6,12);
                        grid.add(username,6,14);
                        grid.add(password,6,16);
                        grid.add(btn,40,50);
                        grid.add(actiontarget, 10, 45);
                        souece.setTitle("Admin-AddCoach");
                        return grid;
        }
        }