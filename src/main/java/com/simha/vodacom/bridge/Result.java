package com.simha.vodacom.bridge;

import java.util.*;
import com.google.gson.Gson;
import Isis.*;

public class Result {

private Map<String, String> attrMap = new HashMap<String, String>();

public Result(List<Attrib>  attribList){
        attrMap = Utils.toMap(attribList);
}

public Map<String, String> getAttributeMap() {
        return attrMap;
}

public boolean isSuccessful() {
        return (getAttributeMap().containsKey(Constants.RESP) && getAttributeMap().get(Constants.RESP).trim().equals(Constants.SUCCESS));
}

public String toJson() {
        return (new Gson()).toJson(attrMap);
}

public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("> RESULT:"+  isSuccessful());
        s.append("> JSON  :" +this.toJson());
        return s.toString();
}

}
