package ca.jrvs.apps.twitter.service;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.utils.CrdDao;
import ca.jrvs.apps.twitter.utils.Service;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.introspector.PropertyUtils;

public class TwitterService implements Service {
  private final Logger logger = LoggerFactory.getLogger(TwitterService.class);
  private CrdDao dao;

  public TwitterService(CrdDao dao) {
    this.dao = dao;
  }

  /**
   * Validate and post a user input Tweet
   *
   * @param tweet tweet to be created
   * @return created tweet
   * @throws IllegalArgumentException if text exceed max number of allowed characters or lat/long
   *                                  out of range
   */
  @Override
  public Tweet postTweet(Tweet tweet) throws UnsupportedEncodingException, URISyntaxException {
    try {
      validatePostTweet(tweet);
    } catch (IllegalArgumentException e) {
      throw new RuntimeException("Invalid tweet input", e);
    }
      return (Tweet) dao.create(tweet);
  }

  public static void validatePostTweet(Tweet tweet) {
    if (tweet.getText() == null) {
      throw new RuntimeException("Empty text body");
    }
    if (tweet.getCoordinates().getCoordinates()[0] > 180.0000f || tweet.getCoordinates().getCoordinates()[0] < -180.0000f
        || tweet.getCoordinates().getCoordinates()[1] > 90.0000f || tweet.getCoordinates().getCoordinates()[1] < -90.0000f) {
      throw new RuntimeException("Coordinates are out of range");
    }
  }
  /**
   * Search a tweet by ID
   *
   * @param id     tweet id
   * @param fields set fields not in the list to null
   * @return Tweet object which is returned by the Twitter API
   * @throws IllegalArgumentException if id or fields param is invalid
   */
  @Override
  public Tweet showTweet(String id, String[] fields)
      throws URISyntaxException, NoSuchFieldException, IllegalAccessException {
      Class<Tweet> tweetClass = Tweet.class;
      Tweet tweet = new Tweet();
      validateShowTweet(id);
      Tweet showedTweet = (Tweet) dao.findById(id);
      if (fields.length > 0) {
        for (int i = 0; i < fields.length; i++) {
          String fieldName = fields[i];
          Field field_to = tweetClass.getDeclaredField(fieldName);
          field_to.setAccessible(true);
          Field field_from = showedTweet.getClass().getDeclaredField(fieldName);
          field_from.setAccessible(true);
          Object o = field_from.get(showedTweet);
          field_to.set(tweet, o);
        }
      } else {
        tweet = showedTweet;
      }
      return tweet;
  }

  public static void validateShowTweet(String id) {
    try {
      long id_long = Long.parseLong(id);
    } catch (NumberFormatException nfe) {
      throw new RuntimeException("Invalid id format", nfe);
    }
  }

  /**
   * Delete Tweet(s) by id(s).
   *
   * @param ids tweet IDs which will be deleted
   * @return A list of Tweets
   * @throws IllegalArgumentException if one of the IDs is invalid.
   */
  @Override
  public List<Tweet> deleteTweets(String[] ids) {
    List<Tweet> tweets = new ArrayList<>();
    Tweet tweet = new Tweet();
    long id_long;
    for (String id: ids) {
      try {
        id_long = Long.parseLong(id);
      } catch (NumberFormatException nfe) {
        throw new RuntimeException("Invalid id format", nfe);
      }
      tweet.setId(id_long);
      tweet.setId_str(id);
      tweets.add(tweet);
    }

    return tweets;
  }
}
