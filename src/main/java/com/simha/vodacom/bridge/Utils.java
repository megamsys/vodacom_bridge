package com.simha.vodacom.bridge;

import java.util.*;
import Isis.Attrib;
import Isis.AttributeListHolder;

public class Utils {

public static AttributeListHolder  toAttrList(Map<String, String> attrMap)    {
        Attrib initialValue[] = new Attrib[attrMap.size()];
        int i = 0;
        for (Map.Entry<String, String> entry: attrMap.entrySet())  {
                initialValue[i] = new Attrib(entry.getKey(), entry.getValue());
                i++;
        }
        return new AttributeListHolder (initialValue);
}

public static Map<String, String>  toMap(List<Attrib> attribList)    {
        Map<String, String> attrMap = new HashMap<String, String>();
        for (Attrib attr: attribList)  {
                attrMap.put(attr.attributeName, attr.attributeValue);
        }
        return attrMap;
}
}
