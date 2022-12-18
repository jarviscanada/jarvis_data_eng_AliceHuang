package ca.jrvs.apps.twitter.service;

import static org.junit.Assert.*;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.utils.CrdDao;
import ca.jrvs.apps.twitter.utils.TweetUtil;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TwitterServiceIntTest {
  private TwitterService service;
  private CrdDao dao;
  private HttpHelper httpHelper;

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Before
  public void Setup(){
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");
    httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
    this.dao = new TwitterDao(httpHelper);
    this.service = new TwitterService(dao);
  }

  @Test
  public void postTweet() throws UnsupportedEncodingException, URISyntaxException {
    exceptionRule.expect(RuntimeException.class);
    exceptionRule.expectMessage("Coordinates are out of range");
    String text = "test";
    float lat = -190.0f;
    float lon = 190.0f;
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);
    service.postTweet(postTweet);
    exceptionRule.expect(RuntimeException.class);
    exceptionRule.expectMessage("Empty text body");
    text = "";
    lat = -81.31011004242582f;
    lon = 42.98693964646016f;
    postTweet = TweetUtil.buildTweet(text, lon, lat);
    service.postTweet(postTweet);
  }


  @Test
  public void showTweet() throws URISyntaxException {
    String id = "21321jk3bjhkj";
    String[] fiels = new String[0];
    exceptionRule.expect(RuntimeException.class);
    exceptionRule.expectMessage("Invalid id format");
    service.showTweet(id, fiels);
  }

  @Test
  public void deleteTweets() {
    String[] ids = new String[] {
        "1603947319367434240", "21321jk3bjhkj"
    };

    exceptionRule.expect(RuntimeException.class);
    exceptionRule.expectMessage("Invalid id format");
    service.deleteTweets(ids);
  }
}