package ca.jrvs.apps.twitter.model;

import java.util.List;

public class Hashtag {

  private int[][] indices;
  private String text;

  public Hashtag(int[][] indices, String text) {
    this.indices = indices;
    this.text = text;
  }

  public int[][] getIndices() {
    return indices;
  }

  public void setIndices(int[][] indices) {
    this.indices = indices;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
