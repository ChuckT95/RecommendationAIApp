package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {

  private String username;
  private String password;
  private int id;
  private String state;
  private String gender;
  private String car_make;
  private String car_model;
  private int car_year;
  private int previous_rent_times;

  public User(String username, String password, int id, String state, String gender,
      String car_make, String car_model, int car_year, int previous_rent_times) {
    this.username = username;
    password = password;
    this.id = id;
    this.state = state;
    this.gender = gender;
    this.car_make = car_make;
    this.car_model = car_model;
    this.car_year = car_year;
    this.previous_rent_times = previous_rent_times;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
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

  public int getPrevious_rent_times() {
    return previous_rent_times;
  }

  public void setPrevious_rent_times(int previous_rent_times) {
    this.previous_rent_times = previous_rent_times;
  }
  public User(String username, String password) throws SQLException {
    String url = "jdbc:sqlite:libs/Database/HackathonDB.db";
    Connection conn = DriverManager.getConnection(url);
    Statement stmt = conn.createStatement();
    ResultSet rs1 = stmt.executeQuery(String.format("select * from USER where username= %s and password = %s", username, password));
    rs1.next();
    this.username=rs1.getString(1);
    this.password=rs1.getString(2);
    this.id=rs1.getInt(3);
    this.gender=rs1.getString(4);
    this.state=rs1.getString(5);
    this.car_make=rs1.getString(6);
    this.car_model=rs1.getString(7);
    this.car_year=rs1.getInt(8);
    this.previous_rent_times=rs1.getInt(9);
    rs1.close();
    stmt.close();
    conn.close();
  }
}