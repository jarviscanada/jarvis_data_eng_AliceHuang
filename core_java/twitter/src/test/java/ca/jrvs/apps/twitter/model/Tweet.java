package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tweet {
  @JsonProperty("created_at")
  private String created_at;
  @JsonProperty("id")
  private long id;
  @JsonProperty("id_str")
  private String id_str;
  @JsonProperty("text")
  private String text;
  @JsonProperty("coordinates")
  private Coordinates coordinates;
  @JsonProperty("retweet_count")
  private int retweet_count;
  @JsonProperty("favorite_count")
  private int favorite_count;
  @JsonProperty("favorited")
  private boolean favorited;
  @JsonProperty("retweeted")
  private boolean retweeted;
  @JsonProperty("entities")
  private Entities entities;

  public Tweet() {
    super();
  }
  public Tweet(String created_at, long id, String id_str, String text, Coordinates coordinates,
      int retweet_count, int favorite_count, boolean favorited, boolean retweeted,
      Entities entities) {
    this.created_at = created_at;
    this.id = id;
    this.id_str = id_str;
    this.text = text;
    this.coordinates = coordinates;
    this.retweet_count = retweet_count;
    this.favorite_count = favorite_count;
    this.favorited = favorited;
    this.retweeted = retweeted;
    this.entities = entities;
  }

  @Override
  public String toString() {
    return "Tweet{" +
        "created_at:'" + created_at + '\'' +
        ", id:" + id +
        ", id_str:'" + id_str + '\'' +
        ", text:'" + text + '\'' +
        ", coordinates:" + coordinates.toString() +
        ", retweet_count:" + retweet_count +
        ", favorite_count:" + favorite_count +
        ", favorited:" + favorited +
        ", retweeted:" + retweeted +
        ", entities:" + entities.toString() +
        '}';
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
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public Entities getEntities() {
    return entities;
  }

  public void setEntities(Entities entities) {
    this.entities = entities;
  }
}
