package adminScenes;
import healthclub.Member;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.text.TableView;
import mainStage.*;
public class AdminManageMemberReport {
public static BorderPane adminManageMemberReport(Stage souce) {
BorderPane border=new BorderPane();
Label label = new Label("ID");
TextField id = new TextField();
Label label2 = new Label("Report");
TextArea myreport = new TextArea();
Button btn2=new Button();
btn2.setText("Report");
HBox hbox =new HBox();
final Text actiontarget=new Text();
hbox.getChildren().add(label);
hbox.getChildren().add(id);
border.setTop(hbox);
VBox vbox = new VBox();
actiontarget.setFill(Color.BLUE);
btn2.setOnAction((event) -> {
if(myreport.getText().equals("")||id.getText().equals(""))
{
actiontarget.setText("Please Fill Information");
}else
{
Member m=new Member();
if(m.checkMember(Integer.valueOf(id.getText())))
{
m.addReport(Integer.valueOf(id.getText()), myreport.getText());
souce.close();
AdminStage.adminStage();
}else
{
actiontarget.setText("Please Enter The Correct ID");
}
} });
vbox.getChildren().add(label2);
vbox.getChildren().add(myreport);
border.setCenter(vbox);
HBox hbox1=new HBox();
hbox1.getChildren().add(btn2);
vbox.getChildren().add(hbox1);
HBox hbox2=new HBox();
hbox2.setAlignment(Pos.BOTTOM_CENTER);
border.setBottom(hbox2);
hbox2.getChildren().add(actiontarget);
hbox1.setAlignment(Pos.BOTTOM_RIGHT);
souce.setTitle("Admin-Report_Member");
return border;
}
}