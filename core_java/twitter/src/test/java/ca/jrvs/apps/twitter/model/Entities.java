package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Entities {
  @JsonProperty("hashtags")
  private List<Hashtag> hashtags;
  @JsonProperty("user_mentions")
  private List<UserMention> user_mentions;

  public Entities() {
    super();
  }
  public Entities(List<Hashtag> hashtags, List<UserMention> user_mentions) {
    this.hashtags = hashtags;
    this.user_mentions = user_mentions;
  }

  @Override
  public String toString() {
    return "Entities{" +
        "hashtags=" + hashtags.toString() +
        ", user_mentions=" + user_mentions.toString() +
        '}';
  }

  public List<Hashtag> getHashtags() {
    return hashtags;
  }

  public void setHashtags(List<Hashtag> hashtags) {
    this.hashtags = hashtags;
  }

  public List<UserMention> getUser_mentions() {
    return user_mentions;
  }

  public void setUser_mentions(List<UserMention> user_mentions) {
    this.user_mentions = user_mentions;
  }
}
