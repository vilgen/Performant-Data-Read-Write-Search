package com.evilemi.performant.data.processing.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MsisdnMap {

  private static Map<Long, String> msisdnMap = new ConcurrentHashMap<>();

  private MsisdnMap() {
  }

  public static void fillMsisdnMap(Long id, String data) {
    //System.out.println(id + data);
    msisdnMap.put(id, data);
  }

  public static Map<Long, String> getMsisdnMap() {
    return msisdnMap;
  }
}
