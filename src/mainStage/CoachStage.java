/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//import CoachStages.*;
import coachScene.*;
import javafx.scene.layout.BorderPane;
/**
 *
 * @author c.city
 */
public class CoachStage {
    
    
   
    public static void coachStage(int id) {
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
        
        //Menu manage = new Menu("Plane");
        //Menu member = new Menu("Member");
        //member.getItems().addAll(new MenuItem("Add"),new MenuItem("Delete"),new MenuItem("Update"),new MenuItem("Search"),new MenuItem("List"),new MenuItem("Report"));
        
        // Menu coach = new Menu("Coach");
         //coach.getItems().addAll(new MenuItem("Add"),new MenuItem("Delete"),new MenuItem("Update"),new MenuItem("Search"),new MenuItem("List"));
          //manage.getItems().addAll(member,new SeparatorMenuItem(),coach);
          //Menu id = new Menu("ID");
          //Menu user = new Menu("CurrentUser");
        
          Menu activities =new Menu("activities");
          MenuItem message = new MenuItem("Message");
          MenuItem plane = new MenuItem("Plane");
          MenuItem member=new MenuItem("Member");
          activities.getItems().addAll(message,new SeparatorMenuItem(),plane,new SeparatorMenuItem(),member);
          menubar.getMenus().addAll(profile,activities);
       
       //Label label3 = new Label("Balance :");
       // TextField textfield = new TextField();
       message.setOnAction((event)->{
           
       border.setCenter(CoachActivitiesMessage.CoachActivitiesMessage(newstage,id));
       } );
       
       
       plane.setOnAction((event)->{
         //  CoachActivitesPlane.
        border.setCenter(CoachActivitesPlane.CoachActivitesPlane(newstage,id));
         
       });
      
       //grid.add(label3, 50, 80);
       //grid.add(textfield, 65, 90);
    //   Button btn = new Button();
                   border.setCenter(CoachHome.coachHome(newstage,id));
                                     
    home.setOnAction((ActionEvent event) -> {
                                 border.setCenter(CoachHome.coachHome(newstage,id));
       });
     member.setOnAction((ActionEvent event) -> {
                                 border.setCenter(CoachActivitesMembers.coachActivitesMembers(newstage,id));
       });
    
    
    logout.setOnAction((event)->{
        newstage.close();
    Login.login();
    });
    
        update.setOnAction((handel)->{
          border.setCenter(CoachMyProfileUpdate.coachMyProfileUpdate(newstage,id));
            
        });
         border.setTop(menubar);
       Scene scene = new Scene (border,755,500);
         scene.getStylesheets().add(CoachStage.class.getResource("ffff.css").toExternalForm());
       // scene.getStylesheets().add(admin.class.getResource("styyle.css").toExternalForm());
        newstage.setTitle("Coache");
        newstage.setScene(scene);
        newstage.setResizable(false);
        newstage.show();
    
    }
    
}
