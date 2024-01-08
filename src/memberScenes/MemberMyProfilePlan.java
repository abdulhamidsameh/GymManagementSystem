/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberScenes;

import healthclub.Coach;
import healthclub.Member;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainStage.CoachStage;
import mainStage.MemberStage;

/**
 *
 * @author c.city
 */
public class MemberMyProfilePlan {
    
    
  public static GridPane memberMyProfilePlan(Stage souse,int iD)
  {
    Label Sunday = new Label("Sunday");
         Label Monday = new Label("Monday");
          Label Tuesday = new Label("Tuesday");
           Label Wednesday = new Label("Wednesday");
            Label Thursday = new Label("Thursday");
             Label Friday = new Label("Friday");
              Label Saturday  = new Label("Saturday ");
             
      TextField sunday =new TextField();
       TextField monday =new TextField();
        TextField tuesday =new TextField();
         TextField wednesday =new TextField();
          TextField thursday =new TextField();
           TextField friday =new TextField();
            TextField saturday  =new TextField();
            final Text actiontarget=new Text();
 
            sunday.setEditable(false);
                        monday.setEditable(false);
            tuesday.setEditable(false);
            wednesday.setEditable(false);
            thursday.setEditable(false);
            friday.setEditable(false);
    saturday.setEditable(false);
 
    //final Text actiontarget=new Text();
    
            //////////////////////////////////////////////////
                         ArrayList<String>timeplan1=new ArrayList<String>();

                Coach cc=new Coach();
//      
//            
//           timeplan1=cc.getplanbyId(iD);
Member m=new Member();
Member mm=new Member();
mm=m.searchMemberById(iD);

Coach c=new Coach();
 if(c.hasCoachName(mm.getnamecoach()))
 {
    timeplan1=m.getplanForMember(iD);        
            sunday.setText(timeplan1.get(0));
            monday.setText(timeplan1.get(1));
            tuesday.setText(timeplan1.get(2));
            wednesday.setText(timeplan1.get(3));
            thursday.setText(timeplan1.get(4));
            friday.setText(timeplan1.get(5));
            saturday.setText(timeplan1.get(6));

 }   
    else
 {
     actiontarget.setText("Your Coach Is Not Found");
 }
            
            
            
            
            
            
        Button btn = new Button("Finish");

        btn.setOnAction((ActionEvent event) -> {
                                  
            
            MemberStage.memberstage(iD);
            
                 souse.close();
          
       });
        
        GridPane grid = new GridPane();
         grid.setHgap(5);
         grid.setVgap(5);
        grid.add(Sunday,3,2);
        grid.add(Monday,3,4);
        grid.add(Tuesday,3,8);
        grid.add(Wednesday,3,6);
        grid.add(Thursday,3,10);
        grid.add(Friday,3,12);
        grid.add(Saturday ,3,14);
         grid.add(sunday,6,2);
          grid.add(monday,6,4);
           grid.add(tuesday,6,6);
            grid.add(wednesday,6,8);
             grid.add(thursday,6,10);
              grid.add(friday,6,12);
               grid.add(saturday ,6,14);
                grid.add(btn,12,18);
              //  Button btn1=new Button("add plan");
                //grid.add(btn1,8 , 2);
                grid.add(actiontarget,10,35);
                actiontarget.setFill(Color.BLUE);
               souse.setTitle("Memder-Plan");

       return grid;
  }
}
