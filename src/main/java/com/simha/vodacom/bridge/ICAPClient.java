package com.simha.vodacom.bridge;

import java.util.*;
import com.simha.vodacom.exceptions.*;
import HighSpeed.*;
import Isis.*;

public class ICAPClient implements Client {

private HighSpeed.Manager proxy;
private SecuredKey secured;

public ICAPClient(HighSpeed.Manager proxy, SecuredKey secured) {
        this.proxy = proxy;
        this.secured = secured;
}

@Override
public Result perform(Input input)  throws BridgeException {
        try {
                if (!input.exists())  { throw new FunctionNotFound();}

                this.proxy.PerformFunction(secured.getOriginId(), secured.getUserId(), secured.getKey(), input.getFunction(),input.getAttributeListHolder());
        } catch(InterfaceError err) {
                throw new CORBAInterfaceException(err);
        }
        /*Array to ArrayList conversion*/
        List<Attrib> attribList=  asList(input.getAttributeListHolder());
        attribList.add(new Attrib(Constants.RESP, Constants.SUCCESS));
        return new Result(attribList);
}



@Override
public Result query(Input input)  throws BridgeException {
        try {
                if (!input.exists())  { throw new FunctionNotFound();}
                HighSpeed.ServiceActionListHolder serv = new HighSpeed.ServiceActionListHolder();
                HighSpeed.ActionAttributeListHolder actr = new HighSpeed.ActionAttributeListHolder();
                HighSpeed.SubAttributeListHolder subtr = new  HighSpeed.SubAttributeListHolder();
                HighSpeed.PartyHolder party = new  HighSpeed.PartyHolder();
                HighSpeed.RequestResultListHolder reqr = new  HighSpeed.RequestResultListHolder();
                this.proxy.QueryFunction(secured.getOriginId(), secured.getUserId(), secured.getKey(), input.getFunction(),
                                         input.getAttributeListHolder(),serv,actr,subtr,party, reqr);
        } catch(InterfaceError err) {
                throw new CORBAInterfaceException(err);
        }
        return new Result(asList(input.getAttributeListHolder()));
}

@Override
public Result execute(Input input)  throws BridgeException {
        try {
                if (!input.exists())  { throw new FunctionNotFound();}
                HighSpeed.ServiceActionListHolder serv = new HighSpeed.ServiceActionListHolder();
                HighSpeed.ActionAttributeListHolder actr = new HighSpeed.ActionAttributeListHolder();
                HighSpeed.PartyHolder party = new  HighSpeed.PartyHolder();
                HighSpeed.RequestResultListHolder reqr = new  HighSpeed.RequestResultListHolder();
                this.proxy.ExecFunction(secured.getOriginId(), secured.getUserId(), secured.getKey(), input.getFunction(),
                                        input.getAttributeListHolder(),serv,actr,party, reqr);
        } catch(InterfaceError err) {
                throw new CORBAInterfaceException(err);
        }
        return new Result(asList(input.getAttributeListHolder()));
}

private List<Attrib> asList(AttributeListHolder attrListHolder) {
        return new ArrayList<Attrib>(Arrays.asList(attrListHolder.value));
}
}
