package healthclub;
import com.sun.javafx.scene.control.skin.CustomColorDialog;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import mainStage.*;
public class Healthclub extends Application{
@Override
public void start(Stage primaryStage) {
ProgressBar progress = new ProgressBar();
progress.setMinWidth(200);
progress.setMaxWidth(Double.MAX_VALUE);
IntegerProperty seconds = new SimpleIntegerProperty();
progress.progressProperty().bind(seconds.divide(60.0)); 
Timeline timeline = new Timeline(
new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),           
new KeyFrame(Duration.minutes(0.2), e-> {                    
primaryStage.close();
Login.login();
 System.out.println("Minute over");
}, new KeyValue(seconds, 60))   
);
timeline.setCycleCount(1);
timeline.play();;
HBox hbox1=new HBox();
hbox1.getChildren().add(progress);
hbox1.setAlignment(Pos.CENTER);
BorderPane gride=new BorderPane();
gride.setCenter(hbox1);
Scene scene =new Scene(gride,750,500);
scene.getStylesheets().add(Healthclub.class.getResource("mystylee.css").toExternalForm());
primaryStage.setScene(scene);
primaryStage.setTitle("welcome");
primaryStage.setResizable(false);
primaryStage.show();
Hyperlink link = new Hyperlink("Food systems");
link.setOnAction((event)->{
getHostServices().showDocument("https://www.dailymedicalinfo.com/view-article/%D9%86%D8%B8%D8%A7%D9%85-%D8%BA%D8%B0%D8%A7%D8%A6%D9%8A-%D9%84%D9%83%D9%85%D8%A7%D9%84-%D8%A7%D9%84%D8%A7%D8%AC%D8%B3%D8%A7%D9%85/");
});
gride.setBottom(link);
}
public static void main(String[] args){
String projectPath = System.getProperty("user.dir");
File currentDir = new File(projectPath); 
checkDirectoryContents(currentDir);

launch(args);
}
public static void checkDirectoryContents(File dir){
File[] files = dir.listFiles();
boolean memberFile = true;
boolean coachFile = true;
boolean adminFile =true;
for (File file : files) {
if (file.getName().contains("member.bin")) {
memberFile = false;
}
if (file.getName().contains("coach.bin")) {
coachFile = false;
}
if(file.getName().contains("admin.bin"))
{
adminFile = false;
}
}
if (memberFile) {
Member x = new Member();
x.commitToFile();
} 
if (coachFile) {
Coach x = new Coach();
x.commitToFile();
}
if (adminFile) {
Admin x = new Admin();
x.firstCommitToFile();
} 
}
}