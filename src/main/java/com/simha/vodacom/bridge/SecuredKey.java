package com.simha.vodacom.bridge;

public class SecuredKey {

  private String originId;
  private int userId;
  private String secureKey;

  public SecuredKey(String originId, int userId, String secureKey) {
    this.originId = originId;
    this.userId = userId;
    this.secureKey = secureKey;
  }

  public String getOriginId() {
    return this.originId;
  }

  public int getUserId() {
    return this.userId;
  }

  public String getKey() {
    return this.secureKey;
  }

  public String toString() {
    return "[originid=" + this.getOriginId() +",userid="+ this.getUserId() + ",securekey="+  this.getKey() + "]";
  }

}
