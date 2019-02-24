package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class General {

  public static Car displayedCar;
  public static ArrayList<Car> list = new ArrayList();
  public static User currentUser;

  public General() throws SQLException {
  }

  public static void screenChange(String newScreen, Node oldScreenroot) throws IOException {
    try {
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
    } catch (Exception e1) {
      e1.getCause();
      e1.printStackTrace();
    }

  }

  public static void fillCarList() throws SQLException {
    String url = "jdbc:sqlite:libs/Database/HackathonDB.db";
    Connection con = DriverManager.getConnection(url);
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("select * from Car");

    while (rs.next()) {
      Car current = new Car(rs.getString(1), rs.getString(2), rs.getInt(3));
      list.add(current);
    }

  }
}
