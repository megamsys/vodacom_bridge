package com.simha.vodacom.test;

import java.util.*;
import com.simha.vodacom.bridge.*;
import com.simha.vodacom.exceptions.*;

public class ActivationMPESA extends AbstractVodacomAPI {

public ActivationMPESA() throws BridgeException {
      super();
      try {
                System.out.println("= START: {SNDSRD}");
                System.out.println(sndsrdBad());
                System.out.println(sndsrdGood());
                System.out.println("= END: {SNDSRD}");
        } catch(BridgeException be) {
                System.out.println(be.getMessage());
        }
}


private String sndsrdGood()  throws BridgeException {
        Map<String, String> attrMap = new HashMap<String, String>();
        System.out.println("== Good: 0759596178");
        attrMap.put("SUB ID", "0759596178");
        attrMap.put("SUB ID TYPE", "M");
        attrMap.put("FIRST NAME", "Akachi");
        attrMap.put("LAST NAME", "Ayo");
        attrMap.put("ID TYPE", "Voter ID");
        attrMap.put("ID NUMBER", "X123456");
        attrMap.put("REG_STATE", "FREG");
        attrMap.put("AGENT NAME", "Sayayi Sengerema");
        attrMap.put("AGENT CODE", "13243");
        attrMap.put("DOB", "08/02/2001");
        return perform("SNDSRD", attrMap).toJson();
}

//no REG_STATE
private String sndsrdBad()  throws BridgeException {
        Map<String, String> attrMap = new HashMap<String, String>();
        System.out.println("== Good: 0000096178");
        attrMap.put("SUB ID", "0000096178");
        attrMap.put("SUB ID TYPE", "M");
        attrMap.put("FIRST NAME", "Akachi");
        attrMap.put("LAST NAME", "Ayo");
        attrMap.put("ID TYPE", "Voter ID");
        attrMap.put("ID NUMBER", "X123456");
        attrMap.put("AGENT NAME", "Sayayi Sengerema");
        attrMap.put("AGENT CODE", "13243");
        attrMap.put("DOB", "08/02/2001");
        return perform("SNDSRD", attrMap).toJson();
}


}
