package adminScenes;
import healthclub.Coach;
import healthclub.Member;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mainStage.AdminStage;
public class AdminMangeMemberList {
public static BorderPane  adminMangeMemberList(Stage souce) {
BorderPane border = new BorderPane();
javafx.scene.control.TableView table= new javafx.scene.control.TableView();
Member c=new Member();
ArrayList<Member>t=new ArrayList<Member>();
t=c.listOfAllMembers();
ObservableList<Member> data=FXCollections.observableArrayList(t);
table.setItems(data);
TableColumn<Member, String> firstName = new TableColumn<>("First Name");
firstName.setCellValueFactory( new PropertyValueFactory<>("fname") );
TableColumn<Member,String> MiddelName = new TableColumn<>("Middel Name");
MiddelName.setCellValueFactory( new PropertyValueFactory<>("mname") );
TableColumn<Member,String>LastName = new TableColumn<>("Last Name");
LastName.setCellValueFactory( new PropertyValueFactory<>("lname") );
TableColumn<Member,String>UserName = new TableColumn<>("UserName");
UserName.setCellValueFactory( new PropertyValueFactory<>("username") );  
TableColumn<Member,String>Password = new TableColumn<>("Password");
Password.setCellValueFactory( new PropertyValueFactory<>("pass") );
TableColumn<Member,String>Age = new TableColumn<>("Age");
Age.setCellValueFactory( new PropertyValueFactory<>("age") );
TableColumn<Member,String>ID = new TableColumn<>("ID");
ID.setCellValueFactory( new PropertyValueFactory<>("id") );
table.getColumns().addAll(firstName,MiddelName,LastName,UserName,Password,Age,ID);
Button btn=new Button("Finish");
btn.setOnAction((event)->{
    souce.close();
AdminStage.adminStage();
});
HBox hbox=new HBox();
hbox.getChildren().add(btn);
hbox.setAlignment(Pos.BOTTOM_RIGHT);
border.setCenter(hbox);
border.setTop(table);
souce.setTitle("Admin-List_Member");
return border;
}
}