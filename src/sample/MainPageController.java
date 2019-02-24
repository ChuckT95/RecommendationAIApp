package sample;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainPageController {

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
  void OnPrevButtonPressed(ActionEvent event) {


  }

  @FXML
  void onViewCarButtonPressed(ActionEvent event) {


  }

  @FXML
  void onViewNextButtonPressed(ActionEvent event) {


  }

  @FXML
  void initialize(){
    ArrayList<Car> carOptions;


    manualComboBox.setItems(FXCollections.observableArrayList());
  }

}
