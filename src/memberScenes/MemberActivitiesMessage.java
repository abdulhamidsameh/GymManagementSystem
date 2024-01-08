package memberScenes;
import healthclub.Coach;
import healthclub.Member;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mainStage.CoachStage;
import mainStage.MemberStage;
public class MemberActivitiesMessage {
public static BorderPane memberActivitiesMessage(Stage souce,int iD)
{
BorderPane border=new BorderPane();
TextArea mymessage = new TextArea();
Button btn2=new Button();
btn2.setText("Finish");
HBox hbox =new HBox();
VBox vbox = new VBox();
Member x=new Member();
mymessage.setText(x.getMessagesbuId(iD));
mymessage.setEditable(false);
btn2.setOnAction((event) -> {
souce.close();
MemberStage.memberstage(iD);
});
vbox.getChildren().add(mymessage);
border.setTop(vbox);
HBox hbox1=new HBox();
hbox1.getChildren().add(btn2);
hbox1.setAlignment(Pos.BOTTOM_RIGHT);
souce.setTitle("Memder-message");
border.setCenter(hbox1);
return border;
}
}