package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.List;

public class Coordinates {
  @JsonProperty("coordinates")
  private Double[] coordinates;

  private String type;

  public Coordinates(){
    super();
  }

  public Coordinates(Double[] coordinates, String type) {
    this.coordinates = coordinates;
    this.type = type;
  }

  @Override
  public String toString() {
    return "Coordinates{" +
        ", coordinates=" + Arrays.toString(coordinates) +
        ", type='" + type + '\'' +
        '}';
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public Double[] getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Double[] coordinates) {
    this.coordinates = coordinates;
  }
}
