package ca.jrvs.apps.twitter.controller;

import static org.junit.Assert.*;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.utils.CrdDao;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TwitterControllerIntTest {
  private TwitterController twitterController;
  private TwitterService twitterService;
  private CrdDao dao;
  private HttpHelper httpHelper;
  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();
  @Before
  public void setUp() {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");
    httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
    this.dao = new TwitterDao(httpHelper);
    this.twitterService = new TwitterService(dao);
    this.twitterController = new TwitterController(twitterService);
  }

  @Test
  public void postTweet() throws UnsupportedEncodingException, URISyntaxException {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("Usage: TwitterCLIApp post \"tweet_text\" \" latitude:longitude\"");
    String[] args = new String[] {
        "post", "haha"
    };
    twitterController.postTweet(args);
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("Invalid location format! "
        + "\n Usage: TwitterCLIApp post \"tweet_text\" \" latitude:longitude\"");
    args = new String[] {
        "post", "haha", "47.000 85.0000"
    };
    twitterController.postTweet(args);
  }

  @Test
  public void showTweet()
      throws URISyntaxException, NoSuchFieldException, IllegalAccessException {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("Usage: TwitterCLIApp show \"tweet id\" \"field1, fields2\"");
    String[] args = new String[] {
        "show"
    };
    twitterController.showTweet(args);
  }

  @Test
  public void deleteTweet() {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("Usage: TwitterCLIApp delete \"id1, id2, id3\"");
    String[] args = new String[] {
        "delete"
    };
    twitterController.deleteTweet(args);
  }
}