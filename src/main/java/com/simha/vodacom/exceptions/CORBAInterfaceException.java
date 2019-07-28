package com.simha.vodacom.exceptions;


public class CORBAInterfaceException extends BridgeException {

   public CORBAInterfaceException(Isis.InterfaceError ife) {
     super(ife.errorGroup.value()  + ife.errorCode + ":Message[" + ife.errorMsg +"]");
   }

}
