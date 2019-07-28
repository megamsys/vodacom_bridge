package com.simha.vodacom.bridge;
import java.util.*;

public class Input {

  private Isis.AttributeListHolder attr;
  private String function;

  public Input(String function, Map<String, String> attributeMap){
    this.function  = function;
    this.attr = Utils.toAttrList(attributeMap);
  }

  public String getFunction() {
    return this.function;
  }

   public Isis.AttributeListHolder getAttributeListHolder()    {
     return this.attr;
   }

   public boolean exists() {
     return (getFunction().trim().length() >0);
   }

   public String toString() {
     return "[" + this.getFunction() + ":"+ this.getAttributeListHolder()+"]";
   }

}
