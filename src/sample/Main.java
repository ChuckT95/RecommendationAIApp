package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage)  {
    try {
      Stage stage = new Stage();

      Parent root = FXMLLoader.load(Main.class.getClassLoader().getResource("sample/LoginPage2.fxml"));

      Scene scene = new Scene(root);

      stage.setTitle("RecommendationApp");

      stage.initModality(Modality.APPLICATION_MODAL);

      stage.setScene(scene);

      stage.show();

      //Set minimum size of window
      stage.setMinWidth(scene.getWidth());
      stage.setMinHeight(scene.getHeight());
    } catch(Exception e){
    e.printStackTrace();
    System.out.println(e.getCause());
    }
  }
}
