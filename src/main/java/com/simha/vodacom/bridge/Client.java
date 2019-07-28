package com.simha.vodacom.bridge;

import com.simha.vodacom.exceptions.*;

public interface Client {

   Result perform(Input input) throws BridgeException;

   Result query(Input input) throws BridgeException;

   Result execute(Input input) throws BridgeException;

}
