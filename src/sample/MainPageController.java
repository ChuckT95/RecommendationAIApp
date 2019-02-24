package sample;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.AddDetailView;
import com.recombee.api_client.api_requests.RecommendItemsToUser;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.bindings.RecommendationResponse;
import com.recombee.api_client.exceptions.ApiException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    carDesc.setText(recommended[i].getMakeModelYear());
    General.displayedCar = recommended[i];
  }

  @FXML
  public void onViewCarButtonPressed(javafx.event.ActionEvent event) {

    //todo possible AR functionality
    //todo possible simple display instead of AR
  }

  @FXML
  void onManualChoicePressed(){
    for(Car choice : General.list){
      if(manualComboBox.getValue().equals(choice.getMakeModelYear())){
        carImage.setImage(new Image(choice.getImage()));
        carDesc.setText(choice.getMakeModelYear());
        General.displayedCar = choice;
      }
    }

  }

  @FXML
  public void onViewNextButtonPressed(javafx.event.ActionEvent event) {
  if(i==4){i=0;}else{i++;}
    carImage.setImage(new Image(recommended[i].getImage()));
    carDesc.setText(recommended[i].getMakeModelYear());
    General.displayedCar = recommended[i];
  }

  @FXML
  void initialize() throws SQLException, ApiException, ParseException, IOException {

    RecombeeClient client = new RecombeeClient("hertz", "OJcnyDcMwAP3iIhhrLST9pa31QFFfqXuzWV0m8T9VVpK6ZTcoOmju0ep7zwsPIMe");
    RecommendationResponse recommendationResponse = client.send(new RecommendItemsToUser("25", 5));
       client.send(new AddDetailView("2c169e575644d840838e", "xyz")

            .setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-12-09 13:05:06") )


            .setCascadeCreate(true));
    System.out.println("\nRecommended items:");

    for(Recommendation rec: recommendationResponse) System.out.println(rec.getId());
    System.out.println("\nRecommended items:");
    int j =0;
    for(Recommendation rec: recommendationResponse){
      Car car = new Car(rec.getId());
      recommended[j++]=car;

    }
//    br.close();
    General.displayedCar = recommended[0];

    General.fillCarList();
    for(Car now : General.list){
      list2.add(now.getMakeModelYear());
    }
    manualComboBox.setItems(FXCollections.observableArrayList(list2));
    carImage.setImage(new Image(/*recommended[i].getImage())*/"https://dubsism.files.wordpress.com/2017/12/image-not-found.png?w=547"));
    carDesc.setText(/*recommended[i].getMakeModelYear*/"null");
    General.list.get(0).setImage("https://cdn.bringatrailer.com/wp-content/uploads/2016/08/m3-bat-3-940x593.jpg");
    General.list.get(1).setImage("https://static.cargurus.com/images/site/2009/11/15/21/45/1999_chrysler_300m_4_dr_std_sedan-pic-4715104499934606259-1600x1200.jpeg");
    General.list.get(2).setImage("https://cdn04.carsforsale.com/3/263387/23381145/thumb/1129185428.jpg");
    General.list.get(3).setImage("https://i.kinja-img.com/gawker-media/image/upload/s--yAPKfqds--/c_fill,f_auto,fl_progressive,g_center,h_675,q_80,w_1200/dbi2fte0e27yl0yobe2q.jpg");
    General.list.get(4).setImage("https://www.google.com/search?q=isuzu+amigo+1994&client=firefox-b-1-d&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjHucmZydTgAhULm1kKHU0zBxQQ_AUIDigB&biw=1536&bih=790#imgrc=6GhKJbAyq6e42M:");
  }





}
