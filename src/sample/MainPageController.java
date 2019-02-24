package sample;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainPageController {
  static int i = 0;
  private ObservableList<String> list2 = FXCollections.observableArrayList();
  static Car[] recommended = new Car[5];

  @FXML
  private ComboBox<String> manualComboBox;

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
  public void OnPrevButtonPressed(javafx.event.ActionEvent event) {
    if(i==0){i=4;}else{i--;}
    carImage.setImage(new Image(recommended[i].getImage()));
    carDesc.setText(recommended[i].getCar_make() + " : " + recommended[i].getCar_model() + " : " + recommended[i].getCar_year());
    General.displayedCar = recommended[i];
  }

  @FXML
  public void onViewCarButtonPressed(javafx.event.ActionEvent event) {

    //todo possible AR functionality
    //todo possible simple display instead of AR
  }

  @FXML
  void onManualChoicePressed(){
    String[] split = manualComboBox.getValue().split("\\s+");
    Car choice = new Car(split[0], split[1], Integer.parseInt(split[2]));
    carImage.setImage(new Image(choice.getImage()));
    carDesc.setText(choice.getCar_make() + " " + choice.getCar_model() + " " + choice.getCar_year());
    General.displayedCar = choice;
  }

  @FXML
  public void onViewNextButtonPressed(javafx.event.ActionEvent event) {
  if(i==4){i=0;}else{i++;}
    carImage.setImage(new Image(recommended[i].getImage()));
    carDesc.setText(recommended[i].getCar_make() + " " + recommended[i].getCar_model() + " " + recommended[i].getCar_year());
    General.displayedCar = recommended[i];
  }

  @FXML
  void initialize() throws SQLException {

    //todo initialize recommended with AI

    //General.displayedCar = recommended[i];

    General.fillCarList();
    for(Car now : General.list){
      list2.add(now.getCar_make() + " " + now.getCar_model() + " " + now.getCar_year());
    }
    manualComboBox.setItems(FXCollections.observableArrayList(list2));
    carImage.setImage(new Image(/*recommended[i].getImage())*/"https://dubsism.files.wordpress.com/2017/12/image-not-found.png?w=547"));
    carDesc.setText(/*recommended[i].getCar_make() + " : " + recommended[i].getCar_model() + " : " + recommended[i].getCar_year()*/"null");

  }




}
