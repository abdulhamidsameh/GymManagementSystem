package adminScenes;
import healthclub.Admin;
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
import mainStage.*;
public class AdminManageMemberUpdate {
public static GridPane adminManageMemberUpdate(Stage souce) {
Label label1 = new Label("ID");
Label label2 = new Label("First Name");
Label label3 = new Label("Last Name");
Label label4 = new Label("Middle Name");
Label label5 = new Label("Age");
Label label6 = new Label("Billing");
Label label7 = new Label("User Name");
Label label8 = new Label("PassWord");
Label label9 = new Label("Coach Name");
Label label10 = new Label("Start Day");
TextField id =new TextField();
TextField fname =new TextField();
TextField mname =new TextField();
TextField lname =new TextField();
TextField age =new TextField();
TextField billing =new TextField();
TextField username =new TextField();
PasswordField password = new PasswordField();
TextField Cname =new TextField();
TextField sday =new TextField();
Button btn = new Button("Update");
Button btn1 = new Button("Search");
GridPane grid = new GridPane();
grid.setHgap(5);
grid.setVgap(5);
grid.add(btn1,15,8);
grid.add(label1,3,8);
grid.add(label2,3,10);
grid.add(label3,3,14);
grid.add(label4,3,12);
grid.add(label5,3,16);
grid.add(label6,3,18);
grid.add(label7,3,20);
grid.add(label8,3,22);
grid.add(label9,3,24);
grid.add(label10, 3, 26);
grid.add(id,6,8);
grid.add(fname,6,10);
grid.add(mname,6,12);
grid.add(lname,6,14);
grid.add(age,6,16);
grid.add(billing,6,18);
grid.add(username,6,20);
grid.add(password,6,22);
grid.add(Cname, 6, 24);
grid.add(sday,6,26);
grid.add(btn,20,35);
final Text actiontarget=new Text();
grid.add(actiontarget, 10, 30);
btn1.setOnAction((ActionEvent event) -> {
Member m=new Member();
if(id.getText().equals(""))
{
actiontarget.setFill(Color.BLUE);
actiontarget.setText("Please Enter The Personal ID");
}else
{
if(m.checkMember(Integer.valueOf(id.getText())))
{
Member q=new Member();
m=q.searchMemberById(Integer.valueOf(id.getText()));
fname.setText(m.getFname());
mname.setText(m.getMname());
lname.setText(m.getLname());
age.setText(String.valueOf(m.getAge()));
billing.setText(String.valueOf(m.getBilling()));
username.setText(m.getUsername());
password.setText(m.getPass());
Cname.setText(m.getnamecoach());
sday.setText(String.valueOf(m.getStartedday()));
}
else
{
actiontarget.setFill(Color.BLUE);
actiontarget.setText("Please Enter The Correct ID");            }}
});
btn.setOnAction((ActionEvent event) -> {
Member m=new Member();
if((id.getText().equals("")||fname.getText().equals("")||mname.getText().equals("")||lname.getText().equals("")||username.getText().equals("")||password.getText().equals("")||Cname.getText().equals("")||sday.getText().equals("")||billing.getText().equals("")||age.getText().equals("")&&!m.checkMember(Integer.valueOf(id.getText()))))
{
actiontarget.setFill(Color.BLUE);
actiontarget.setText("Please Enter Your Member Information");  
}
else
{
if((m.checkMember(Integer.valueOf(id.getText()))))
{
Member info=new Member();
info.setId(Integer.valueOf(id.getText()));
info.setFname(fname.getText());
info.setMname(mname.getText());
info.setLname(lname.getText());
info.setAge(Integer.valueOf(age.getText()));
info.setBilling(Float.valueOf(billing.getText()));
info.setUsername(username.getText());
info.setPass(password.getText());
info.setNamecoach(Cname.getText());
info.setStartedday(Integer.valueOf(sday.getText()));
System.err.println("1");  
Admin adm=new Admin();
adm.updatemember(Integer.valueOf(id.getText()),info);
System.err.println("2");
souce.close();
AdminStage.adminStage();
}
else
{
actiontarget.setFill(Color.BLUE);
actiontarget.setText("Please Enter The Correct ID");            }}
});   
souce.setTitle("Admin-Update_Member");
return grid;
}}