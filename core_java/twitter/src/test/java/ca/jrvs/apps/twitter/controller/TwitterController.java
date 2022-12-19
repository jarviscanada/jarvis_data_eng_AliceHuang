package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.utils.Controller;
import ca.jrvs.apps.twitter.utils.Service;
import ca.jrvs.apps.twitter.utils.TweetUtil;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.util.StringUtils;

public class TwitterController implements Controller {
  private static final String COORD_SEP = ":";
  private static final  String COMMA = ",";

  private Service service;

  public TwitterController(Service service) {
    this.service = service;
  }

  /**
   * Parse user argument and post a tweet by calling service classes
   *
   * @param args
   * @return a posted tweet
   * @throws IllegalArgumentException if args are invalid
   */
  @Override
  public Tweet postTweet(String[] args) throws UnsupportedEncodingException, URISyntaxException {
    if (args.length != 3) {
      throw new IllegalArgumentException("Usage: TwitterCLIApp post \"tweet_text\" \" latitude:longitude\"");
    }

    String text = args[1];
    String coords = args[2];
    String[] coordsArray = coords.split(COORD_SEP);

    if (coordsArray.length != 2 || StringUtils.isEmpty(text)) {
      throw new IllegalArgumentException("Invalid location format! "
          + "\n Usage: TwitterCLIApp post \"tweet_text\" \" latitude:longitude\"");
    }

    Float lat = null;
    Float lon = null;
    try {
        lat = Float.parseFloat(coordsArray[0]);
        lon = Float.parseFloat(coordsArray[1]);
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid location format! "
          + "\n Usage: TwitterCLIApp post \"tweet_text\" \" latitude:longitude\"");
    }
    Tweet tweet = TweetUtil.buildTweet(text, lon, lat);
    return service.postTweet(tweet);
  }

  /**
   * Parse user argument and search a tweet by calling service classes
   *
   * @param args
   * @return a tweet
   * @throws IllegalArgumentException if args are invalid
   */
  @Override
  public Tweet showTweet(String[] args) throws URISyntaxException {
    if (args.length < 2) {
      throw new IllegalArgumentException("Usage: TwitterCLIApp show \"tweet id\" \"field1, fields2\"");
    }
    String id = args[1];
    String[] fields = null;
    if (args.length > 3) {

      String fields_arg = args[2];
      fields = fields_arg.split(":");
    } else {
      fields = new String[0];
    }
    return service.showTweet(id, fields);
  }

  /**
   * Parse user argument and delete tweets by calling service classes
   *
   * @param args
   * @return a list of deleted tweets
   * @throws IllegalArgumentException if args are invalid
   */
  @Override
  public List<Tweet> deleteTweet(String[] args) {
    return null;
  }
}
