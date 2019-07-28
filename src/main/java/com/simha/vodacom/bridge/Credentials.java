package com.simha.vodacom.bridge;

public class Credentials {

  private String originId;
  private String userName;
  private String password;

  public Credentials(String originId, String userName, String password) {
    this.originId = originId;
    this.userName = userName;
    this.password = password;
  }

  public String getOriginId() {
    return this.originId;
  }

  public String getUserName() {
    return this.userName;
  }

  public String getPassword() {
    return this.password;
  }

  public String toString() {
      return "[originid=" + this.getOriginId() + ",username="+ this.getUserName() + ",password="+ this.getPassword() + "]";
  }
}
