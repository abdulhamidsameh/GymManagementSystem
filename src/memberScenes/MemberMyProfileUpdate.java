/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberScenes;

import healthclub.Admin;
import healthclub.Member;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainStage.MemberStage;

/**
 *
 * @author c.city
 */
public class MemberMyProfileUpdate {
    
  public static GridPane memberMyProfileUpdate(Stage sourse,int iD)
  { 
      
   Label label1 = new Label("First Name");
          Label label2 = new Label("Last Name");
           Label label3 = new Label("Middle Name");
            Label label4 = new Label("Age");
           
             
               Label label6 = new Label("User Name");
       Label label7 = new Label("PassWord");
       TextField fname =new TextField();
        TextField mname =new TextField();
         TextField lname =new TextField();
          TextField age =new TextField();
           
            TextField username =new TextField();
           
          PasswordField password = new PasswordField();
        Button btn = new Button("Update");
/////////////////////////////////////////////////////////////////////////////////////////////////


 // Admin adm=new Admin();
              Member q=new Member();
                            Member m=new Member();
           m=q.searchMemberById(Integer.valueOf(iD));
            fname.setText(m.getFname());
              mname.setText(m.getMname());
              lname.setText(m.getLname());
              age.setText(String.valueOf(m.getAge()));
            //  billing.setText(String.valueOf(m.getBilling()));
              username.setText(m.getUsername());
              password.setText(m.getPass());
            //  Cname.setText(m.getnamecoach());
            //  sday.setText(String.valueOf(m.getStartedday()));


  final Text actiontarget=new Text();
       // grid.add(actiontarget, 15, 15);


       //  Member q=new Member();
////////////////////////////////////////////////////////////////////////////
        btn.setOnAction((event) -> {
            
        
             if( fname.getText().equals("")||mname.getText().equals("")||lname.getText().equals("")||username.getText().equals("")||password.getText().equals("")||age.getText().equals("") )
            {
                
                  actiontarget.setFill(Color.BLUE);
                  actiontarget.setText("Please Enter All Informition");
            }else
            {
                  // if(Opassword.getText().equals(oldpass))
                   
                Member info=new Member();
                info.updatememberbyIdfromMember(iD, fname.getText(), mname.getText(), lname.getText(), username.getText(), password.getText(), Integer.valueOf(age.getText()));
//                          info.setId(Integer.valueOf(iD));
//                          info.setFname(fname.getText());
//                          info.setMname(mname.getText());
//                         info.setLname(lname.getText());
//                          info.setAge(Integer.valueOf(age.getText()));
//                           info.setBilling(Float.valueOf(billing.getText()));
//                            info.setUsername(username.getText());
//                             info.setPass(password.getText());
//                              info.setNamecoach(Cname.getText());
//                               info.setStartedday(Integer.valueOf(sday.getText()));
//                           System.err.println("1");  
//                           Admin adm=new Admin();
//                           adm.updatemember(Integer.valueOf(id.getText()),info);
            MemberStage.memberstage(iD);
            sourse.close();
            } });
        
        GridPane grid = new GridPane();
         grid.setHgap(5);
         grid.setVgap(5);
        
        grid.add(label1,3,2);
        grid.add(label2,3,6);
        grid.add(label3,3,4);
        grid.add(label4,3,8);
       
        grid.add(label6,3,10);
        grid.add(label7,3,12);
        
         
          grid.add(fname,6,2);
           grid.add(mname,6,4);
            grid.add(lname,6,6);
             grid.add(age,6,8);
             
               grid.add(username,6,10);
                
                grid.add(password,6,12);
                grid.add(btn,3,35);
                grid.add(actiontarget,15,35);
     //   Scene scene = new Scene(grid, 750, 500);      
           sourse.setTitle("Memder-Profile_Update");

      return grid;
  }
    
    
}
