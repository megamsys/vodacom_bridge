package com.simha.vodacom.bridge;

import java.io.*;

public class IORLoader {

  private String ior;
  private String VODACOM = "vodacom.ior";

  private static IORLoader loader;

  private IORLoader() throws IOException {
    load();
  }

  public static IORLoader  getInstance() throws IOException  {
    if (loader == null) {
      loader = new IORLoader();
    }
    return loader;
  }

  public String ior() {
    return this.ior;
  }

  private void load()  throws IOException {
    File iorPath = new File(VODACOM);
    System.out.println("> LOAD  :" +  iorPath.getAbsolutePath());

    FileReader fr = new  FileReader(iorPath);
    BufferedReader br = new BufferedReader(fr);
    this.ior = br.readLine();

    br.close();
  }
}
