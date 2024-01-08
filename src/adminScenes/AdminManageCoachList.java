package adminScenes;

import com.sun.org.apache.xpath.internal.operations.String;
import healthclub.Coach;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import mainStage.AdminStage;


                public class AdminManageCoachList {
                    
                    
                        public static BorderPane adminManageCoachList(Stage sosouce) {
                            
                            
                                BorderPane border = new BorderPane();
                                javafx.scene.control.TableView table= new javafx.scene.control.TableView();
                                border.setCenter(table);
                                Button btn=new Button("Finish");
                                btn.setOnAction((event)->{
                                sosouce.close();
                                AdminStage.adminStage();
                                });
                                HBox hbox=new HBox();
                                hbox.getChildren().add(btn);
                                hbox.setAlignment(Pos.BOTTOM_RIGHT);
                                border.setBottom(hbox);
                                Coach c=new Coach();
                                ArrayList<Coach>t=new ArrayList<Coach>();
                                t=c.listOfAllCoaches();
                                ObservableList<Coach> data=FXCollections.observableArrayList(t);
                                table.setItems(data);
                                TableColumn<Coach, String> firstName = new TableColumn<>("First Name");
                                firstName.setCellValueFactory( new PropertyValueFactory<>("fname") );
                                TableColumn<Coach, String> MiddelName = new TableColumn<>("Middel Name");
                                MiddelName.setCellValueFactory( new PropertyValueFactory<>("mname") );
                                TableColumn<Coach, String>LastName = new TableColumn<>("Last Name");
                                LastName.setCellValueFactory( new PropertyValueFactory<>("lname") );
                                TableColumn<Coach, String>UserName = new TableColumn<>("UserName");
                                UserName.setCellValueFactory( new PropertyValueFactory<>("username") );  
                                TableColumn<Coach, String>Password = new TableColumn<>("Password");
                                Password.setCellValueFactory( new PropertyValueFactory<>("pass") );
                                TableColumn<Coach, String>Age = new TableColumn<>("Age");
                                Age.setCellValueFactory( new PropertyValueFactory<>("age") );
                                TableColumn<Coach, String>ID = new TableColumn<>("ID");
                                ID.setCellValueFactory( new PropertyValueFactory<>("id") );
                                table.getColumns().addAll(firstName,MiddelName,LastName,UserName,Password,Age,ID);
                                sosouce.setTitle("Admin-ListCoach");
                return border;
        }
        }