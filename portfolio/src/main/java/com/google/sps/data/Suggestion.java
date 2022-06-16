package com.google.sps.data;

//A suggestion from an user 
public final class Suggestion {

  private final long id;
  private final String value;
  private final long timestamp;

  public Suggestion(long id, String value, long timestamp) {
    this.id = id;
    this.value = value;
    this.timestamp = timestamp;
  }
}