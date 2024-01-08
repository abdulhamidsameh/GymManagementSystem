/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberScenes;
import healthclub.Member;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author c.city
 */
public class MemberHome {
     public static GridPane memberHome(Stage souece,int iD) {
            GridPane grid=new GridPane();
            
            
            
            
            
            Member m=new Member();
            Member mm=new Member();  
            m=mm.searchMemberById(iD);
                grid.setHgap(5);
                grid.setVgap(5);
        Label label1 = new Label("Current User");
        grid.add(label1, 2, 3);
        TextField currentuser = new TextField();
        currentuser.setText("d");
        currentuser.setEditable(false);
        grid.add(currentuser,3 , 3);
        currentuser.setText(m.getFname()+" "+m.getMname()+" "+m.getLname());
        Label label2 = new Label("ID");
        grid.add(label2, 12, 3);
        TextField id = new TextField();
        id.setText(String.valueOf(iD));
        id.setEditable(false);
        grid.add(id, 13, 3);
        Label label3 = new Label("Date Of subscription");
        grid.add(label3, 2, 80);
        TextField members = new TextField();
      //  members.setText(String.valueOf(mm.numberofmembersofonecoach(m.getnamecoach())));
        members.setText(String.valueOf(mm.getStarteddaybyId(iD)));
      members.setEditable(false);
        grid.add(members, 3, 80);
//        Hyperlink link = new Hyperlink("Food systems");
//         grid.add(link, 38, 88);
//       //scene.getStylesheets().add(memberhome.class.getResource("styles.css").toExternalForm());
//        link.setOnAction((event)->{
//       getHostServices().showDocument("https://www.dailymedicalinfo.com/view-article/%D9%86%D8%B8%D8%A7%D9%85-%D8%BA%D8%B0%D8%A7%D8%A6%D9%8A-%D9%84%D9%83%D9%85%D8%A7%D9%84-%D8%A7%D9%84%D8%A7%D8%AC%D8%B3%D8%A7%D9%85/");
//      
//        });
        
////        stage13.setTitle("Member-HomePage");
////        stage13.setScene(scene);
////        stage13.show();
            
            
            
            
            
            
            
            
            
            
            
            return grid;
        }
}
