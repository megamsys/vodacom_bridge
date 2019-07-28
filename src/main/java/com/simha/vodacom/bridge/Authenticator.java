package com.simha.vodacom.bridge;

import java.util.*;
import HighSpeed.*;
import com.simha.vodacom.exceptions.*;

public class Authenticator {

  private HighSpeed.Manager  proxy;
  private Credentials creds;

   Authenticator(HighSpeed.Manager proxy, Credentials creds) {
      this.proxy = proxy;
      this.creds = creds;
  }

  public SecuredKey logon() throws BridgeException {
    try {
      org.omg.CORBA.IntHolder userId = new org.omg.CORBA.IntHolder();
      org.omg.CORBA.StringHolder key = new org.omg.CORBA.StringHolder();
      this.proxy.PerformLogOn(this.creds.getOriginId(), this.creds.getUserName(), this.creds.getPassword(),
      userId, key);
      return new SecuredKey(this.creds.getOriginId(),userId.value, key.value);
    } catch(Isis.InterfaceError err) {
      throw new CORBAInterfaceException(err);
    }

  }

  public Result isValidKey(SecuredKey secured) throws BridgeException {
    try {
      boolean exists = this.proxy.ValidateSecurityKey(secured.getOriginId(),secured.getUserId(), secured.getKey());
      String result = exists ?  Constants.SUCCESS : Constants.FAIL;
      List attribList = new ArrayList<Isis.Attrib>();
      attribList.add(new Isis.Attrib(Constants.RESP, result));
      return new Result(attribList);
    }catch (Isis.InterfaceError err) {
      throw new CORBAInterfaceException(err);
    }
  }

  public Result logoff(SecuredKey secured) throws BridgeException {
    try {
      this.proxy.PerformLogOff(secured.getOriginId(), secured.getUserId(), secured.getKey());
      List attribList = new ArrayList<Isis.Attrib>();
      attribList.add(new Isis.Attrib(Constants.RESP, Constants.SUCCESS));
      return new Result(attribList);
    } catch (Isis.InterfaceError err) {
      throw new CORBAInterfaceException(err);
    }

  }
}
