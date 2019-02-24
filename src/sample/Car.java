package sample;

public class Car {

  private String make;
  private String model;
  private int year;
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

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Car(String make, String model, int year, String image) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.image = image;
  }

  public Car(String make, String model, int year) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.image=null;
  }
}
