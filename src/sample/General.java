package sample;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class General {
  public static void screenChange(String newScreen, Node oldScreenroot) throws IOException {
    Stage stage = new Stage();
    Parent root = FXMLLoader.load(General.class.getClassLoader().getResource(newScreen));
    Scene scene = new Scene(root);
    stage.setTitle("RecommendationApp");
    stage.setScene(scene);
    stage.show();
    stage.setMinWidth(scene.getWidth());
    stage.setMinHeight(scene.getHeight());
    stage = (Stage) oldScreenroot.getScene().getWindow();

    stage.close();
  }
  public static User currentUser;
}
