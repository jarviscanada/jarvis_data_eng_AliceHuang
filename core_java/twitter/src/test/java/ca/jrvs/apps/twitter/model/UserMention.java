package ca.jrvs.apps.twitter.model;

public class UserMention {
  private int id;
  private String id_str;
  private int[][] indices;
  private String name;
  private String screen_name;

  public UserMention(int id, int[][] indices, String name, String screen_name) {
    this.id = id;
    this.indices = indices;
    this.name = name;
    this.screen_name = screen_name;
    this.id_str = String.valueOf(id);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int[][] getIndices() {
    return indices;
  }

  public void setIndices(int[][] indices) {
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
