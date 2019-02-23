package sample;

public class Car {

  private String make;
  private String model;
  private String year;
  private String image;

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Car(String make, String model, String year, String image) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.image = image;
  }

}
