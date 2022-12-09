package ca.jrvs.apps.twitter.model;

import java.util.List;

public class Tweet {
  private String created_at;
  private int id;
  private String id_str;
  private String text;
  private Coordinates coordinates;
  private int retweet_count;
  private int favorite_count;
  private boolean favorited;
  private boolean retweeted;
  private List<Entities> entities;

  public Tweet(String created_at, int id, String text, Coordinates coordinates, int retweet_count,
      int favorite_count, boolean favorited, boolean retweeted, List<Entities> entities) {
    this.created_at = created_at;
    this.id = id;
    this.id_str = String.valueOf(id);
    this.text = text;
    this.coordinates = coordinates;
    this.retweet_count = retweet_count;
    this.favorite_count = favorite_count;
    this.favorited = favorited;
    this.retweeted = retweeted;
    this.entities = entities;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public String getId_str() {
    return id_str;
  }

  public void setId_str(String id_str) {
    this.id_str = id_str;
    this.id = Integer.valueOf(id_str);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
    this.id_str = String.valueOf(id);
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public int getRetweet_count() {
    return retweet_count;
  }

  public void setRetweet_count(int retweet_count) {
    this.retweet_count = retweet_count;
  }

  public int getFavorite_count() {
    return favorite_count;
  }

  public void setFavorite_count(int favorite_count) {
    this.favorite_count = favorite_count;
  }

  public boolean isFavorited() {
    return favorited;
  }

  public void setFavorited(boolean favorited) {
    this.favorited = favorited;
  }

  public boolean isRetweeted() {
    return retweeted;
  }

  public void setRetweeted(boolean retweeted) {
    this.retweeted = retweeted;
  }

  public List<Entities> getEntities() {
    return entities;
  }

  public void setEntities(List<Entities> entities) {
    this.entities = entities;
  }
}
