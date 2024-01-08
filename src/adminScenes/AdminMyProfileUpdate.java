package adminScenes;
import healthclub.*;
import javafx.event.ActionEvent;
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
import mainStage.AdminStage;
public class AdminMyProfileUpdate {
public static GridPane adminMyProfileUpdate(Stage souce) {
Label label1 = new Label("First Name");
Label label2 = new Label("Last Name");
Label label3 = new Label("Middle Name");
Label label4 = new Label("Age");
Label label5 = new Label("User Name");
Label label7 = new Label("PassWord");
TextField fname =new TextField();
TextField mname =new TextField();
TextField lname =new TextField();
TextField age =new TextField();
TextField username =new TextField();
PasswordField nPassword = new PasswordField();
Button btn = new Button("Update");
GridPane grid = new GridPane();
grid.setHgap(5);
grid.setVgap(5);
grid.add(label1,3,2);
grid.add(label2,3,6);
grid.add(label3,3,4);
grid.add(label4,3,8);
grid.add(label5,3,10);
grid.add(label7,3,12);
grid.add(fname,6,2);
grid.add(mname,6,4);
grid.add(lname,6,6);
grid.add(age,6,8);
grid.add(username,6,10);
grid.add(nPassword,6,12);
grid.add(btn,30,58);
Admin admin1=new Admin();
final Text actiontarget=new Text();
grid.add(actiontarget, 16, 53);  
btn.setOnAction((ActionEvent event) -> {
if(fname.getText().equals("")||mname.getText().equals("")||lname.getText().equals("")||age.getText().equals("")||username.getText().equals("")||nPassword.getText().equals(""))
{
actiontarget.setText("Please Enter All Information");
actiontarget.setFill(Color.BLUE);
}
else{
{
admin1.setId(1);
admin1.setFname(fname.getText());
admin1.setMname(mname.getText());
admin1.setLname(lname.getText());
admin1.setAge(Integer.valueOf(age.getText()));
admin1.setUsername(username.getText());
admin1.setPass(nPassword.getText());
admin1.updateAdmin(admin1);
System.out.println(admin1.getPass()); 
System.out.println(nPassword.getText());
souce.close();
AdminStage.adminStage();
}
} });
souce.setTitle("Admin-UpdateProfile");
return grid;
}
}