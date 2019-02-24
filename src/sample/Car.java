package sample;

public class Car {

  private String car_make;
  private String car_model;
  private int car_year;
  private String image;
  private String makeModelYear;

  public String getMakeModelYear() {
    return makeModelYear;
  }

  public void setMakeModelYear(String makeModelYear) {
    this.makeModelYear = makeModelYear;
  }

  public String getCar_make() {
    return car_make;
  }

  public void setCar_make(String car_make) {
    this.car_make = car_make;
  }

  public String getCar_model() {
    return car_model;
  }

  public void setCar_model(String car_model) {
    this.car_model = car_model;
  }

  public int getCar_year() {
    return car_year;
  }

  public void setCar_year(int car_year) {
    this.car_year = car_year;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Car(String car_make, String car_model, int car_year, String image) {
    this.car_make = car_make;
    this.car_model = car_model;
    this.car_year = car_year;
    this.image = image;
  }

  public Car(String makeModelYear) {
    this.makeModelYear = makeModelYear;
    this.image = "https://dubsism.files.wordpress.com/2017/12/image-not-found.png?w=547";
  }

  public Car(String car_make, String car_model, int car_year) {
    this.car_make = car_make;
    this.car_model = car_model;
    this.car_year = car_year;
    this.makeModelYear = this.car_make + " " + this.car_model + " " + this.car_year;
    this.image = "https://dubsism.files.wordpress.com/2017/12/image-not-found.png?w=547";
  }
}
