package com.simha.vodacom.test;

import java.util.*;
import com.simha.vodacom.bridge.*;
import com.simha.vodacom.exceptions.*;

public class Registration extends AbstractVodacomAPI {


public Registration() throws BridgeException {
        super();
        try {
                System.out.println("=> START: Register subscriber(SNDSRD)\n");
                System.out.println(sndsrdGood() +"\n");
                System.out.println(sndsrdBad() +"\n");
        } catch(BridgeException be) {
                System.out.println(be.getMessage() +"\n");
        } finally {
              logoff();
              System.out.println("=> END: Register subscriber(SNDSRD)\n");
        }
}


private String sndsrdGood()  throws BridgeException {
        Map<String, String> attrMap = new HashMap<String, String>();
        System.out.println("  ✔ Good: SUB ID: 0759596178");
        attrMap.put("SUB ID", "0759596178");
        attrMap.put("SUB ID TYPE", "M");
        attrMap.put("FIRST NAME", "Akachi");
        attrMap.put("LAST NAME", "Ayo");
        attrMap.put("ID TYPE", "Voters ID");
        attrMap.put("ID NUMBER", "X123456");
        attrMap.put("REG_STATE", "FREG");
        attrMap.put("AGENT NAME", "Sayayi Sengerema");
        attrMap.put("AGENT CODE", "13243");
        attrMap.put("DOB", "08/02/2001");
        return perform("SNDSRD", attrMap).toString();
}

//no REG_STATE
private String sndsrdBad()  throws BridgeException {
        Map<String, String> attrMap = new HashMap<String, String>();
        System.out.println("   ✘ Invalid: SUB ID: 0000096178");
        attrMap.put("SUB ID", "0000096178");
        attrMap.put("SUB ID TYPE", "M");
        attrMap.put("FIRST NAME", "Akachi");
        attrMap.put("LAST NAME", "Ayo");
        attrMap.put("ID TYPE", "Voters ID");
        attrMap.put("ID NUMBER", "X123456");
        attrMap.put("AGENT NAME", "Sayayi Sengerema");
        attrMap.put("AGENT CODE", "13243");
        attrMap.put("DOB", "08/02/2001");
        return perform("SNDSRD", attrMap).toString();
}


}
