/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainStage;

//import MemberStages.MemperMyProfileUpdate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import memberScenes.*;
//import MemberStages.*;
/**
 *
 * @author c.city
 */
public class MemberStage {
    
    public static void memberstage(int iD) {
               Stage newstage =new Stage();
BorderPane border=new BorderPane();
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
       
        MenuBar menubar = new MenuBar();
        menubar.prefHeightProperty().bind(newstage.widthProperty());
        grid.add(menubar, 0, 0);
        menubar.setMaxSize(750, 20);
        
        Menu profile = new Menu("My Profile");
                MenuItem home = new MenuItem("home");
        MenuItem update = new MenuItem("Update");
        
         MenuItem logout = new MenuItem("LogOut");
        profile.getItems().addAll(home,new SeparatorMenuItem(),update,new SeparatorMenuItem(),logout);
        Menu activities=new Menu("activities");
        MenuItem plan = new MenuItem("Plane");
        MenuItem message=new MenuItem("message");
        MenuItem report=new MenuItem("report");
        activities.getItems().addAll(plan,new SeparatorMenuItem(),message,new SeparatorMenuItem(),report);
        
        
        //Menu Coahe = new Menu("Coahe");
        //Menu member = new Menu("Member");
        //member.getItems().addAll(new MenuItem("Add"),new MenuItem("Delete"),new MenuItem("Update"),new MenuItem("Search"),new MenuItem("List"),new MenuItem("Report"));
        
         //Menu coach = new Menu("Coach");
         //coach.getItems().addAll(new MenuItem("Add"),new MenuItem("Delete"),new MenuItem("Update"),new MenuItem("Search"),new MenuItem("List"));
          //manage.getItems().addAll(member,new SeparatorMenuItem(),coach);
          //Menu id = new Menu("ID");
          //Menu user = new Menu("CurrentUser");
          //Menu End_Date = new Menu("End_Date");
          
        menubar.getMenus().addAll(profile,activities);
       
       //Label label3 = new Label("Balance :");
        //TextField textfield = new TextField();
       
       
                                       border.setCenter(MemberHome.memberHome(newstage,iD));

       //grid.add(label3, 50, 80);
       //grid.add(textfield, 65, 90);
     //  Button btn = new Button();
        home.setOnAction((ActionEvent event) -> {
                                 border.setCenter(MemberHome.memberHome(newstage,iD));
       });
        
         report.setOnAction((ActionEvent event) -> {
                                 border.setCenter(MemberActivitesReport.memberActivitesRepor(newstage,iD));
       });
        
        plan.setOnAction((ActionEvent event) -> {
                                 border.setCenter(MemberMyProfilePlan.memberMyProfilePlan(newstage, iD));
       });
       
               logout.setOnAction((handel)-> {
                   newstage.close();
                   Login.login();
        });
     message.setOnAction((handel)-> {
                   border.setCenter(MemberActivitiesMessage.memberActivitiesMessage(newstage, iD));
        });

       
        update.setOnAction((handel)-> {
                       
         // MemperMyProfileUpdate.memperMyProfileUpdate();
            border.setCenter(MemberMyProfileUpdate.memberMyProfileUpdate(newstage,iD));
            
        });
        
        border.setTop(menubar);
        
       Scene scene = new Scene (border,750,500);
         scene.getStylesheets().add(MemberStage.class.getResource("styllle.css").toExternalForm());
       // scene.getStylesheets().add(admin.class.getResource("styyle.css").toExternalForm());
        newstage.setTitle("Member");
        newstage.setScene(scene);
        newstage.setResizable(false);
        newstage.show();
}
}