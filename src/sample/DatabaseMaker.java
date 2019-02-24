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
    JsonReader jread = new JsonReader(new FileReader("libs/Database/data.csv"));
    User[] temp = gson.fromJson(jread, User[].class);
    String url = "jdbc:sqlite:libs/Database/HackathonDB.db";

    try {
      Connection conn = DriverManager.getConnection(url);
      String query1 = "CREATE TABLE IF NOT EXISTS USER ( username VARCHAR (20), password VARCHAR (20), UserID INT PRIMARY KEY, Gender VARCHAR (10), state VARCHAR (20), car_make VARCHAR (20) REFERENCES Car (make), car_model VARCHAR (20) REFERENCES Car (model), car_year INT REFERENCES Car (year), previous_rent_times INT);";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query1);
      for(User current: temp){
        PreparedStatement pstmt = conn.prepareStatement("INSERT into user () VALUES (?,?,?,?,?,?,?,?,?);");
        pstmt.setString(1, current.get_id());
        pstmt.setBoolean(2, current.isActive());
        pstmt.setInt(3, current.getAge());
        pstmt.setString(4, current.getF_name());
        pstmt.setString(5, current.getL_name());
        pstmt.setString(6, current.getGender());
        pstmt.setString(7, current.getCompany());
        pstmt.setString(8, current.getPhone());
        pstmt.setString(9, current.getAddress());
        pstmt.executeUpdate();


      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
