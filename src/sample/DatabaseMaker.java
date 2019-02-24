package sample;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMaker {

  public static void main(String[] args) throws FileNotFoundException {
    Gson gson = new Gson();
    JsonReader jread = new JsonReader(new FileReader("libs/Database/userdata.json"));
    User[] temp = gson.fromJson(jread, User[].class);
    String url = "jdbc:sqlite:libs/Database/HackathonDB.db";

    try {
      Connection conn = DriverManager.getConnection(url);
      String query1 = "CREATE TABLE IF NOT EXISTS USER ( username VARCHAR (20), password VARCHAR (20), UserID INT PRIMARY KEY, Gender VARCHAR (10), state VARCHAR (20), car_make VARCHAR (20) REFERENCES Car (make), car_model VARCHAR (20) REFERENCES Car (model), car_year INT REFERENCES Car (year), previous_rent_times INT);";
      String query2 = "CREATE TABLE  IF NOT EXISTS Car (\n"
          + "    make  VARCHAR (20),\n"
          + "    model VARCHAR (20),\n"
          + "    year_made  INT\n"
          + ");";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query1);
      stmt.executeUpdate(query2);
      for(User current: temp){
        PreparedStatement pstmt = conn.prepareStatement("INSERT into USER (username, password, UserID, Gender, state, car_make, car_model, car_year, previous_rent_times) VALUES (?,?,?,?,?,?,?,?,?);");
        pstmt.setString(1, current.getUsername());
        pstmt.setString(2, current.getPassword());
        pstmt.setInt(3, current.getId());
        pstmt.setString(4, current.getGender());
        pstmt.setString(5, current.getState());
        pstmt.setString(6, current.getCar_make());
        pstmt.setString(7, current.getCar_model());
        pstmt.setInt(8, current.getCar_year());
        pstmt.setInt(9, current.getPrevious_rent_times());



          pstmt.executeUpdate();
        }


    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e);
    }
  }
}
