
package adminScenes;

import healthclub.Admin;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class AdminHome {

    
        public static GridPane adminHome(Stage souece) {
        
                GridPane grid=new GridPane();
                Admin adm=new Admin();
                Admin adm1=new Admin();
                adm1=adm.getAdmin();
                grid.setHgap(5);
                grid.setVgap(5);
                Label label1 = new Label("Current User");
                grid.add(label1, 2, 3);
                TextField currentuser = new TextField();
                currentuser.setText(adm1.getFname()+" "+adm1.getMname()+" "+adm1.getLname());
                currentuser.setEditable(false);
                grid.add(currentuser,3 , 3);
                Label label2 = new Label("ID");
                grid.add(label2, 10, 3);
                TextField id = new TextField();
                id.setText(String.valueOf(adm1.getId()));
                id.setEditable(false);
                grid.add(id, 11, 3);
                Label label3 = new Label("Num Of Members");
                grid.add(label3, 12, 80);
                TextField members = new TextField();
                members.setEditable(false);
                members.setText(String.valueOf(adm1.numberOfAllMember()));
                grid.add(members, 14, 80);
                Label label4 = new Label("Num Of Coaches");
                grid.add(label4, 12, 78);
                TextField coaches = new TextField();
                coaches.setText(String.valueOf(adm1.numberOfAllCoaches()));
                coaches.setEditable(false);
                grid.add(coaches, 14, 78);
                Label label5 = new Label("Balance");
                grid.add(label5, 2, 80);
                TextField balance = new TextField();
                balance.setEditable(false);
                balance.setText(String.valueOf(adm1.getTheSumOfAllbilling()));
                grid.add(balance, 3, 80);
                
                return grid;
}
}