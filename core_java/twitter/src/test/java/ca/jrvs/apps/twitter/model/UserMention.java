package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

public class UserMention {
  @JsonProperty("id")
  private long id;
  @JsonProperty("id_str")
  private String id_str;
  @JsonProperty("indices")
  private int[] indices;
  @JsonProperty("name")
  private String name;
  @JsonProperty("screen_name")
  private String screen_name;

  public UserMention() {
    super();
  }

  public UserMention(long id, String id_str, int[] indices, String name, String screen_name) {
    this.id = id;
    this.id_str = id_str;
    this.indices = indices;
    this.name = name;
    this.screen_name = screen_name;
  }

  @Override
  public String toString() {
    return "UserMention{" +
        "id=" + id +
        ", id_str='" + id_str + '\'' +
        ", indices=" + Arrays.toString(indices) +
        ", name='" + name + '\'' +
        ", screen_name='" + screen_name + '\'' +
        '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int[] getIndices() {
    return indices;
  }

  public void setIndices(int[] indices) {
    this.indices = indices;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getScreen_name() {
    return screen_name;
  }

  public void setScreen_name(String screen_name) {
    this.screen_name = screen_name;
  }

  public String getId_str() {
    return id_str;
  }

  public void setId_str(String id_str) {
    this.id_str = id_str;
  }
}
