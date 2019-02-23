package sample;

public class Car {
  private String Model;
  //need to store picture
  private String pictureUrl;
  private String features;
  private String size;
  private String tier;

  public String getModel() {
    return Model;
  }

  public void setModel(String model) {
    Model = model;
  }

  public String getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }

  public String getFeatures() {
    return features;
  }

  public void setFeatures(String features) {
    this.features = features;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getTier() {
    return tier;
  }

  public void setTier(String tier) {
    this.tier = tier;
  }

  public Car(String model, String pictureUrl, String features, String size, String tier) {
    Model = model;
    this.pictureUrl = pictureUrl;
    this.features = features;
    this.size = size;
    this.tier = tier;
  }
}
