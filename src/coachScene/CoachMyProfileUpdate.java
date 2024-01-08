package coachScene;
import healthclub.Admin;
import healthclub.Coach;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainStage.*;
public class CoachMyProfileUpdate {
public static GridPane coachMyProfileUpdate(Stage source,int id) {
Label label1 = new Label("First Name");
Label label2 = new Label("Last Name");
Label label3 = new Label("Middle Name");
Label label4 = new Label("Age");
Label label5 = new Label("User Name");
Label label6 = new Label("PassWord");
TextField fname =new TextField();
TextField mname =new TextField();
TextField lname =new TextField();
TextField age =new TextField();
TextField username =new TextField();
PasswordField password = new PasswordField();
Button btn = new Button("Update");
final Text actiontarget=new Text();
actiontarget.setFill(Color.BLUE);
Coach m=new Coach();
Coach q=new Coach();
m=q.searchCoachById(id);
fname.setText(m.getFname());
mname.setText(m.getMname());
lname.setText(m.getLname());
age.setText(String.valueOf(m.getAge()));
username.setText(m.getUsername());
password.setText(m.getPass());
final float s=m.getsalary();
final String oldpass=m.getPass();
btn.setOnAction((event) -> {
if( fname.getText().equals("")||mname.getText().equals("")||lname.getText().equals("")||username.getText().equals("")||password.getText().equals("")||age.getText().equals("") )
{
actiontarget.setText("Please enter all Information"); 
}else
{
Admin adm=new Admin();
q.setFname(fname.getText());
q.setMname(mname.getText());
q.setLname(lname.getText());
q.setAge( Integer.valueOf(age.getText()));
q.setPass(password.getText());
q.setUsername(username.getText());
q.setsalary(s);
q.setId(id);
adm.updateCoach(q);
source.close();
mainStage.CoachStage.coachStage(id);                  
}
});
GridPane grid = new GridPane();
grid.setHgap(5);
grid.setVgap(5);
grid.add(label1,3,2);
grid.add(label2,3,6);
grid.add(label3,3,4);
grid.add(label4,3,8);
grid.add(label5,3,10);
grid.add(label6,3,12);
grid.add(fname,6,2);
grid.add(mname,6,4);
grid.add(lname,6,6);
grid.add(age,6,8);
grid.add(username,6,10);
grid.add(password,6,12);
grid.add(btn,18,35);
grid.add(actiontarget,15,30);
source.setTitle("Coach-UpdateProfile");
return grid;
}
}