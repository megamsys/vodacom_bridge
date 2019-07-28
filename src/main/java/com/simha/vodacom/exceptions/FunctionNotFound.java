package com.simha.vodacom.exceptions;

public class FunctionNotFound extends BridgeException {

   public FunctionNotFound(){
     super("Function string needed. eg: QSINFO, SNDSRD.");
   }

}
