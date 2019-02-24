package sample;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginPageController {

  @FXML
  private Button loginButton;

  @FXML
  private TextField passwordField;

  @FXML
  private TextField usernameField;

  @FXML
  private AnchorPane root;

  @FXML
  void onLoginButtonPressed(ActionEvent event) throws IOException {
    String userlogin = usernameField.getText();
    String passlogin = passwordField.getText();

    //General.currentUser =  new User(userlogin, passlogin);
    General.screenChange("HertzappMainPage.fxml", root);
  }

}
