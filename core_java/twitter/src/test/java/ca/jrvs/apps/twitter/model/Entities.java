package ca.jrvs.apps.twitter.model;

import java.util.List;

public class Entities {
  private List<Hashtag> hashtags;
  private List<UserMention> user_mentions;

  public Entities(List<Hashtag> hashtags, List<UserMention> user_mentions) {
    this.hashtags = hashtags;
    this.user_mentions = user_mentions;
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
