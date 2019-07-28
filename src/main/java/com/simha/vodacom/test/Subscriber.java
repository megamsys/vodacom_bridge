package com.simha.vodacom.test;

import java.util.*;
import com.simha.vodacom.bridge.*;
import com.simha.vodacom.exceptions.*;

public class Subscriber extends AbstractVodacomAPI {

public Subscriber()  throws BridgeException {
        super();
        try {
                System.out.println("=> START: Query subscriber(QSINFO)\n");
                System.out.println(qsinfoGood()+"\n");
                System.out.println(qsinfoBad() +"\n");
        } catch(BridgeException be) {
                System.out.println(be.getMessage() + "\n");
        } finally {
                logoff();
                System.out.println("=> END: Query subscriber(QSINFO)");
        }
}


private String qsinfoGood()  throws BridgeException {
        Map<String, String> attrMap = new HashMap<String, String>();
        System.out.println("   ✔ Good: SUB ID: 0759596178");
        attrMap.put("SUB ID", "0759596178");
        attrMap.put("SUB ID TYPE", "M");
        return perform("QSINFO", attrMap).toString();
}

private String qsinfoBad() throws BridgeException {
        Map<String, String> attrMap = new HashMap<String, String>();
        System.out.println("  ✘ Invalid: SUB ID: 0000096178");
        attrMap.put("SUB ID", "0000096178");
        attrMap.put("SUB ID TYPE", "M");
        return perform("QSINFO", attrMap).toString();
}

}
