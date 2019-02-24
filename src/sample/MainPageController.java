package sample;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainPageController {
  static int i = 0;
  static Car[] recommended = new Car[5];

  @FXML
  private ComboBox<Car> manualComboBox;

  @FXML
  private AnchorPane root;

  @FXML
  private Button viewCarButton;

  @FXML
  private Button onManualChoicePressed;

  @FXML
  private Button nextButton;

  @FXML
  private Button prevButton;

  @FXML
  private ImageView carImage;

  @FXML
  private Label carDesc;

  @FXML
  void OnPrevButtonPressed(ActionEvent event) {
    if(i==0){i=4;}else{i--;}
    carImage.setImage(new Image(recommended[i].getImage()));
    carDesc.setText(recommended[i].getCar_make() + " : " + recommended[i].getCar_model() + " : " + recommended[i].getCar_year());
    General.displayedCar = recommended[i];
  }

  @FXML
  void onViewCarButtonPressed(ActionEvent event) {

    //todo possible AR functionality
    //todo possible simple display instead of AR
  }

  @FXML
  void onManualChoicePressed(){

    Car choice = manualComboBox.getValue();
    carImage.setImage(new Image(choice.getImage()));
    carDesc.setText(choice.getCar_make() + " : " + choice.getCar_model() + " : " + choice.getCar_year());
    General.displayedCar = choice;
  }

  @FXML
  void onViewNextButtonPressed(ActionEvent event) {
  if(i==4){i=0;}else{i++;}
    carImage.setImage(new Image(recommended[i].getImage()));
    carDesc.setText(recommended[i].getCar_make() + " : " + recommended[i].getCar_model() + " : " + recommended[i].getCar_year());
    General.displayedCar = recommended[i];
  }

  @FXML
  void initialize() throws SQLException {

    //todo initialize recommended with AI
    General.displayedCar = recommended[i];

    General.fillCarList();
    manualComboBox.setItems(FXCollections.observableArrayList(General.list));
    carImage.setImage(new Image(recommended[i].getImage()));
    carDesc.setText(recommended[i].getCar_make() + " : " + recommended[i].getCar_model() + " : " + recommended[i].getCar_year());

  }

}
