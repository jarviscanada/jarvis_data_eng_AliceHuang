package ca.jrvs.apps.twitter.model;

import java.util.List;

public class Coordinates {
  private float longitude;
  private float latitude;
  private float[] coordinates = new float[2];

  private String type;

  public Coordinates(float longitude, float latitude, String type) {
    this.longitude = longitude;
    this.latitude = latitude;
    this.coordinates[0] = longitude;
    this.coordinates[1] = latitude;
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
    this.coordinates[0] = longitude;
  }

  public float getLatitude() {
    return latitude;
  }

  public void setLatitude(float latitude) {
    this.latitude = latitude;
    this.coordinates[1] = latitude;
  }

  public float[] getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(float[] coordinates) {
    this.coordinates = coordinates;
    this.longitude = coordinates[0];
    this.latitude = coordinates[1];
  }
}
