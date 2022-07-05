package com.evilemi.performant.data.processing.model;

public class Msisdn {

  private int id;
  private String msisdn;

  public Msisdn(int id, String msisdn) {
    this.id = id;
    this.msisdn = msisdn;
  }

  public int getId() {
    return id;
  }

  public String getMsisdn() {
    return msisdn;
  }
}
