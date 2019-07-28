package com.simha.vodacom.test;

import java.util.*;
import com.simha.vodacom.bridge.*;
import com.simha.vodacom.exceptions.*;

public abstract class AbstractVodacomAPI {

private Authenticator auth;
private SecuredKey secured;
private Client client;

public AbstractVodacomAPI() throws BridgeException {
        auth = Factory.newInstance().getAuthenticator(newCreds());
        secured = logon();
        System.out.println("   ✔ Logged in! " + secured.getUserId() +":"+ secured.getKey()+"\n");
        client = Factory.lazy().newClient(secured);
}

private Credentials newCreds() {
        return new Credentials("PY","svc_ereg_ipay", "Morpheussvc2016^");
}

protected SecuredKey logon() throws BridgeException {
        return auth.logon();
}

protected void logoff() throws BridgeException {
        System.out.println("  ✔ Logoff! " + secured.getUserId() +":"+ secured.getKey()  + " "+ auth.logoff(secured).toJson() +"\n");
}

protected Result perform(String function, Map<String, String> attrMap) throws BridgeException {
        return client.perform(new Input(function, attrMap));
}

}
