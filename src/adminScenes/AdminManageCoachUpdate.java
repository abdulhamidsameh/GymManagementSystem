package adminScenes;

import healthclub.Admin;
import healthclub.Coach;
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


public class AdminManageCoachUpdate {

    
        public static GridPane adminManageCoachUpdate (Stage souece)


                {
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
                TextField salary =new TextField();
                TextField username =new TextField();
                PasswordField password = new PasswordField();
                final Text actiontarget=new Text();
                Button btn = new Button("Update");
                btn.setOnAction((ActionEvent event) -> {
                Coach m=new Coach();
                if( id.getText().equals("")||fname.getText().equals("")||mname.getText().equals("")||lname.getText().equals("")||username.getText().equals("")||password.getText().equals("")||salary.getText().equals("")||age.getText().equals("") &&(!m.checkCoach(Integer.valueOf(id.getText()))))
                {
                actiontarget.setFill(Color.BLUE);
                actiontarget.setText("Please Enter Your Coach Information");   
                }
                else
                {
                if((m.checkCoach(Integer.valueOf(id.getText()))))
                {
                Admin adm=new Admin();
                m.setFname(fname.getText());
                m.setMname(mname.getText());
                m.setLname(lname.getText());
                m.setUsername(username.getText());
                m.setPass(password.getText());
                m.setAge(Integer.valueOf(age.getText()));
                m.setsalary(Float.valueOf(salary.getText()));
                m.setId(Integer.valueOf(id.getText()));
                adm.updateCoach(m);
                souece.close();
                mainStage.AdminStage.adminStage();
                }else
                {
                actiontarget.setFill(Color.BLUE);
                actiontarget.setText("Please Enter The Correct ID");
                }}
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
                grid.add(salary,6,12);
                grid.add(username,6,14);
                grid.add(password,6,16);
                grid.add(btn,14,35);
                Button btn1=new Button("Search");
                grid.add(btn1,8 , 2);
                grid.add(actiontarget,10,30);
                btn1.setOnAction((event)->{     
                Coach m=new Coach();
                if(id.getText().equals(""))
                {
                actiontarget.setFill(Color.BLUE);
                actiontarget.setText("Please Enter The Personal ID");
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
                salary.setText(String.valueOf(m.getsalary()));
                username.setText(m.getUsername());
                password.setText(m.getPass());
                }
                else
                {
                actiontarget.setFill(Color.BLUE);
                actiontarget.setText("Please Enter The Correct ID");
                } }
                });
                souece.setTitle("Admin-UpdateCoach");
                return grid;      
}
}