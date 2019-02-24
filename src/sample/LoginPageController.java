package sample;

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
  public void onLoginButtonPressed(javafx.event.ActionEvent event) {
    try {

      String userlogin = usernameField.getText();
      String passlogin = passwordField.getText();

      General.currentUser = new User(userlogin, passlogin);
      General.screenChange("sample/HertzappMainPage.fxml", root);
    }catch(Exception e){
    e.printStackTrace();
      System.out.println(e.getCause());}
    }




}
