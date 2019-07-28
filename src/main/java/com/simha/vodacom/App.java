package com.simha.vodacom;

import com.simha.vodacom.bridge.*;
import com.simha.vodacom.exceptions.*;
import com.simha.vodacom.test.*;


public class App {

    public static void main( String[] args ) throws Exception {
      System.out.println("--------------");
      new Registration();
      System.out.println("--------------");
      new Subscriber();
      System.out.println("--------------");
    }

}
