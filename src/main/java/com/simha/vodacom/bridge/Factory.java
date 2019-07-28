package com.simha.vodacom.bridge;

import HighSpeed.*;

import com.simha.vodacom.exceptions.*;
import org.omg.CORBA.ORB;
import java.io.*;

public class Factory {

private static Factory factory = null;
private static Authenticator authenticator = null;
private static Client client = null;

private HighSpeed.Manager proxy = null;

private Factory() throws BridgeException {
        load(new String[] {});
}

private HighSpeed.Manager getProxy() throws BridgeException {
        if (this.proxy == null) {
                throw new IORNotMarshalled("VODACOM.ior not loaded.");
        }
        return this.proxy;
}

public static Factory newInstance() throws BridgeException {
        factory = new Factory();
        return factory;
}

public static Factory lazy()  throws BridgeException {
        if (factory == null) {
                factory = new Factory();
        }
        return factory;

}

public Authenticator getAuthenticator(Credentials creds) throws BridgeException {
        if (this.authenticator == null) {
                this.authenticator = new Authenticator(getProxy(), creds);
        }
        return this.authenticator;
}

public Client newClient(SecuredKey key) throws BridgeException {
        this.client = new ICAPClient(getProxy(), key);
        return this.client;
}


public Client lazyClient(SecuredKey key) throws BridgeException {
        if (this.client == null) {
                this.client = new ICAPClient(getProxy(), key);
        }
        return this.client;
}

private void load(String[] args) throws BridgeException  {
        try {
                ORB orb = ORB.init(args, null);
                org.omg.CORBA.Object obj = orb.string_to_object(IORLoader.getInstance().ior());
                this.proxy = HighSpeed.ManagerHelper.narrow(obj);
        }catch(IOException ioe) {
                throw new BridgeException(ioe.getMessage());
        } catch(Exception ee) {
                throw new BridgeException(ee.getMessage());
        }
}
}
