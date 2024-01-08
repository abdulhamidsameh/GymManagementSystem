package coachScene;
import healthclub.Coach;
import healthclub.Member;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainStage.CoachStage;
public class CoachActivitiesMessage {
public static BorderPane CoachActivitiesMessage(Stage souse,int iD)
{
BorderPane border=new BorderPane();
Label label = new Label("ID");
final Text actiontarget=new Text();
actiontarget.setFill(Color.BLUE);
TextField id = new TextField();
Label label2 = new Label("Message");
TextArea mymessage = new TextArea();
Button btn2=new Button();
btn2.setText("Send");
HBox hbox =new HBox();
hbox.getChildren().add(label);
hbox.getChildren().add(id);
border.setTop(hbox);
VBox vbox = new VBox();
Member x=new Member();
Coach cc=new Coach();
Coach ccc=new Coach();
ccc=cc.getCoachbyId(iD);
String s=ccc.getFname()+" "+ccc.getMname()+" "+ccc.getLname();
System.out.println(s);
btn2.setOnAction((event) -> {
if(mymessage.getText().equals("")||id.getText().equals(""))
{
System.out.println("1");
actiontarget.setText("Enter Your All Data");
}
else{
System.out.println("2");
Coach y=new Coach();
y=cc.getCoachbyId(iD);
if(x.checkMemberForCoach(Integer.valueOf(id.getText()),y.getFname()+" "+y.getMname()+" "+y.getLname()))
{System.out.println("3");
Member n=new Member();
n.setMessagesbyId(mymessage.getText(),Integer.valueOf(id.getText()));
  souse.close();
  CoachStage.coachStage(iD);
}  else
{System.out.println("4");
    actiontarget.setText("You Don't Have This Member");
}
}});
vbox.getChildren().add(label2);
vbox.getChildren().add(mymessage);
border.setCenter(vbox);
HBox hbox1=new HBox();
hbox1.getChildren().add(btn2);
vbox.getChildren().add(hbox1);
hbox1.setAlignment(Pos.BOTTOM_RIGHT);
souse.setTitle("Coach-Send_Message");
HBox hbox3=new HBox();
hbox3.setAlignment(Pos.CENTER);
hbox3.getChildren().add(actiontarget);
border.setBottom(hbox3);
return border;
}
}