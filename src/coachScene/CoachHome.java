package coachScene;
import healthclub.Coach;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class CoachHome {
public static GridPane coachHome(Stage souece,int iD) {
GridPane grid=new GridPane();
grid.setHgap(5);
grid.setVgap(5);
Coach c=new Coach();
Coach q=new Coach();
c=q.searchCoachById(iD);
Label label1 = new Label("Current User");
grid.add(label1, 2, 3);
TextField currentuser = new TextField();
currentuser.setText(c.getFname()+" "+c.getMname()+" "+c.getLname());
currentuser.setEditable(false);
grid.add(currentuser,3 , 3);
Label label2 = new Label("ID");
grid.add(label2, 13, 3);
TextField id = new TextField();
id.setText(String.valueOf(id));
id.setText(String.valueOf(c.getId()));
id.setEditable(false);
grid.add(id, 14, 3);
Label label3 = new Label("Number Of Members");
grid.add(label3, 14, 80);
TextField members = new TextField();
members.setText(String.valueOf(c.numberofmembersofonecoach(iD)));
members.setEditable(false);
grid.add(members, 15, 80);
return grid;
}
}