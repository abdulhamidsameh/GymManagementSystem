package adminScenes;

import healthclub.Admin;
import healthclub.Coach;
import healthclub.Member;
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


        public class AdminManageCoachDelete {
        
            
                public static GridPane adminManageCoachDelete(Stage souece) {
                
                    
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
                        final Text actiontarget=new Text();
                        PasswordField password = new PasswordField();
                        fname.setEditable(false);
                        mname.setEditable(false);
                        lname.setEditable(false);
                        age.setEditable(false);
                        sal.setEditable(false);
                        username.setEditable(false);
                        password.setEditable(false);
                        Button btn = new Button("Delete");
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
                        grid.add(btn,13,28);
                        Button btn1=new Button("Search");
                        grid.add(btn1,8,2);
                        grid.add(actiontarget, 14, 25);
                        btn.setOnAction((ActionEvent event) -> {
                        Coach m=new Coach();
                        if(id.getText().equals(""))
                        {
                        actiontarget.setFill(Color.BLUE);
                        actiontarget.setText("Please Enter The ID");  
                        }
                        else
                        {
                        if(m.checkCoach(Integer.valueOf(id.getText())))
                        {
                        Admin adm=new Admin();
                        adm.deletecoach(Integer.valueOf(id.getText()));
                        souece.close();
                        mainStage.AdminStage.adminStage();
                        }
                        else
                        {
                        actiontarget.setFill(Color.BLUE);
                        actiontarget.setText("Please Enter The Correctly ID");
                        }
                        }
                        });
                        btn1.setOnAction((event)->{     
                        Coach m=new Coach();
                        if(id.getText().equals(""))
                        {
                            actiontarget.setFill(Color.BLUE);
                                actiontarget.setText("Please Enter The ID");  
                        }
                        else
                        {
                        if(m.checkCoach(Integer.valueOf(id.getText())))
                        {
                        Coach q=new Coach();
                        m=q.searchCoachById(Integer.valueOf(id.getText()));
                        fname.setText(m.getFname());
                        mname.setText(m.getMname());
                        lname.setText(m.getLname());
                        age.setText(String.valueOf(m.getAge()));
                        sal.setText(String.valueOf(m.getsalary()));
                        username.setText(m.getUsername());
                        password.setText(m.getPass());
                        }
                        else
                        {
                        actiontarget.setFill(Color.BLUE);
                        actiontarget.setText("Please Enter The Correctly ID");                        
                        }   
                        }   
                        });
                        souece.setTitle("Admin-DeleteCoach");
                        return grid;    
        }
        }