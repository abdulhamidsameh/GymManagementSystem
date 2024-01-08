/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainStage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//for grid
//import AdminStages.*;
//for logout
import adminScenes.*;
import healthclub.*;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author c.city
 */
public class AdminStage {
    
    
    public static void adminStage() {
        Stage newstage =new Stage();
                BorderPane border=new BorderPane();
               // Admin admin=new Admin();

           //     admin1=admin.getAdmin();
//          Label current_user=new Label("User");
//          Label id =new Label("ID");
//          TextField current_filed=new TextField("euueueueu");
//          TextField id_filed=new TextField("snndnnd");
         // border.setCenterShape(false);
          
          
         // border.positionInArea(id, 20, 0, 20, 10, 10, Insets.EMPTY, HPos.valueOf(), VPos.BASELINE, true);
          

//GridPane grid = new GridPane();
//        grid.setHgap(5);
//        grid.setVgap(5);
        
        MenuBar menubar = new MenuBar();
      //  menubar.prefHeightProperty().bind(newstage.widthProperty());
      //  grid.add(menubar, 0, 0);
        menubar.setMaxSize(750, 20);
        
        Menu profile = new Menu("My Profile");
        MenuItem update = new MenuItem("Update");
        //MenuItem Current_balance = new MenuItem("Current Balance");
         MenuItem logout = new MenuItem("LogOut");
         MenuItem home = new MenuItem("home");
        profile.getItems().addAll(home,new SeparatorMenuItem(),update,new SeparatorMenuItem(),logout);
                
        Menu manage = new Menu("Manage");
        Menu member = new Menu("Member");
        MenuItem addmember =new MenuItem("Add");
        MenuItem deletemember =new MenuItem("Delete");
        MenuItem updatemember =new MenuItem("Update");
        MenuItem searchmember =new MenuItem("Search");
        MenuItem listmember =new MenuItem("List");
        MenuItem reportmember =new MenuItem("Report");
        addmember.setOnAction((event) -> {
            border.setCenter(AdminManageMemberAdd.adminManageMemberAdd(newstage));
            
        });
        deletemember.setOnAction((event) ->{
        border.setCenter(AdminManageMemberDelete.adminManageMemberDelete(newstage));
        });
        
        updatemember.setOnAction((event)->{
            border.setCenter(AdminManageMemberUpdate.adminManageMemberUpdate(newstage));
        });
        //
        searchmember.setOnAction((event)->{
        border.setCenter(AdminManageMemberSearch.adminManageMemberSearch(newstage));
        });
        
        //
                listmember.setOnAction((event)->{
                    border.setCenter(AdminMangeMemberList.adminMangeMemberList(newstage));
        });
                
                reportmember.setOnAction((event)->{
        border.setCenter(AdminManageMemberReport.adminManageMemberReport(newstage));
        });
        
        
        
        
        
        
        
        
        member.getItems().addAll(addmember,deletemember,updatemember,searchmember,listmember,reportmember);
        
         Menu coach = new Menu("Coach");
         MenuItem addcoach = new MenuItem("Add");
         MenuItem deletecoach = new MenuItem("Delete");
         MenuItem updatecoach = new MenuItem("Update");
         MenuItem searchcoach = new MenuItem("Search");
         MenuItem listcoach = new MenuItem("List");
        coach.getItems().addAll(addcoach,deletecoach,updatecoach,searchcoach,listcoach);
          manage.getItems().addAll(member,new SeparatorMenuItem(),coach);
        //  Menu Current_balance = new Menu("Current_Balance");
          //Menu id = new Menu("ID");
          //Menu user = new Menu("CurrentUser");
//        Menu detials = new Menu("My Profile");
//        MenuItem update = new MenuItem("Update");
//        //MenuItem Current_balance = new MenuItem("Current Balance");
//         MenuItem logout = new MenuItem("LogOut");
//         MenuItem home = new MenuItem("home");
//            
        menubar.getMenus().addAll(profile,manage);
       update.setOnAction((ActionEvent event) -> {
         
              border.setCenter(AdminMyProfileUpdate.adminMyProfileUpdate(newstage));
       });
      
          border.setCenter(AdminHome.adminHome(newstage));
       
       
       
       /////////////////////////////  home
       
       
        home.setOnAction((ActionEvent event) -> {
                                 border.setCenter(AdminHome.adminHome(newstage));
       });
       
       
       
       
       
         deletecoach.setOnAction((event)->{
                   
          border.setCenter(AdminManageCoachDelete.adminManageCoachDelete(newstage));
      });
      
       
       
       logout.setOnAction((ActionEvent event) -> {
           newstage.close();
       Login.login();
       });
       
      addcoach.setOnAction((event)->{
                   
          border.setCenter(AdminManageCoachAdd.adminManageCoachAdd(newstage));
      });
      
         updatecoach.setOnAction((event)->{
                   
              
          border.setCenter(AdminManageCoachUpdate.adminManageCoachUpdate(newstage));
      });
      
        
         
         
          searchcoach.setOnAction((event)->{
                   
          border.setCenter(AdminManageCoachSearch.adminManageCoachSearch(newstage));
      });
      
           listcoach.setOnAction((event)->{
                   
              
                 border.setCenter(AdminManageCoachList.adminManageCoachList(newstage));
      //    AdminManageCoachList.adminManageCoachList();
      });
      
         
         
         
         
         
         
         
                                                           //border  
         
        //   border.setCenter(grid);
                       border.setTop(menubar);
//         
//         border.setRight(id);
//         border.setRight(id_filed);
//         border.setRight(current_user);
//         border.setRight(current_filed);
       Scene scene = new Scene (border,850,520);
        scene.getStylesheets().add(AdminStage.class.getResource("myne.css").toExternalForm());
        newstage.setTitle("Admin");
        newstage.setScene(scene);
        newstage.setResizable(false);
        newstage.show(); 
        
    }
    
    
    
}
