package sample;

public class User {
private String username;
private String Password;
private String[] attributes;
private String accountID;

  public String getAccountID() {
    return accountID;
  }

  public void setAccountID(String accountID) {
    this.accountID = accountID;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return Password;
  }

  public void setPassword(String password) {
    Password = password;
  }

  public String[] getAttributes() {
    return attributes;
  }

  public void setAttributes(String[] attributes) {
    this.attributes = attributes;
  }

  public User(String username, String password, String[] attributes) {
    this.username = username;
    Password = password;
    this.attributes = attributes;
  }

  public User(String username, String password) {
    this.username = username;
    Password = password;
    attributes = null;
  }

  public User(String username, String password, String[] attributes, String accountID) {
    this.username = username;
    Password = password;
    this.attributes = attributes;
    this.accountID = accountID;
  }
}
