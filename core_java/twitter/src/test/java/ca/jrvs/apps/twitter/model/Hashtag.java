package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.List;

public class Hashtag {
  @JsonProperty("indices")
  private int[] indices;
  @JsonProperty("text")
  private String text;
  public Hashtag() {
    super();
  }
  public Hashtag(int[] indices, String text) {
    this.indices = indices;
    this.text = text;
  }

  @Override
  public String toString() {
    return "Hashtag{" +
        "indices=" + Arrays.toString(indices) +
        ", text='" + text + '\'' +
        '}';
  }

  public int[] getIndices() {
    return indices;
  }

  public void setIndices(int[] indices) {
    this.indices = indices;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
