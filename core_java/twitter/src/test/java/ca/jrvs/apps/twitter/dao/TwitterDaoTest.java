package ca.jrvs.apps.twitter.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.utils.JsonParser;
import ca.jrvs.apps.twitter.utils.TweetUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Before;
import org.junit.Test;
public class TwitterDaoTest {
private TwitterDao dao;
  @Before
  public void Setup() {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");

    HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
    this.dao = new TwitterDao(httpHelper);
  }

  @Test
  public void create() throws IOException {
    String hashTag = "#Overwatch";
    String text = "@saikumuchon Hero never die! " + hashTag + " " + System.currentTimeMillis();
    float lat = -81.31011004242582f;
    float lon = 42.98693964646016f;
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);
    String json = JsonParser.toJson(postTweet, true, false);
    System.out.println(json);
//    ObjectMapper m = new ObjectMapper();
//    Tweet tweet = m.readValue(json, Tweet.class);

    Tweet tweet = dao.create(postTweet);
//    System.out.println(tweet.toString());

    assertEquals(text, tweet.getText());
    assertTrue(hashTag.contains(tweet.getEntities().getHashtags().get(0).getText()));
    assertNotNull(tweet.getEntities().getHashtags());
    assertEquals(tweet.getEntities().getHashtags().get(0).getText(), hashTag.replaceAll("#", ""));
    assertNotNull(tweet.getEntities().getUser_mentions());
    assertEquals(tweet.getEntities().getUser_mentions().get(0).getScreen_name(), "someone");
//    assertNotNull(tweet.getCoordinates());
//    assertEquals(2, tweet.getCoordinates().getCoordinates().length);
//    assertEquals(lon, tweet.getCoordinates().getCoordinates()[0]);
//    assertEquals(lat, tweet.getCoordinates().getCoordinates()[1]);
//

  }

  @Test
  public void show() throws URISyntaxException {
    String hashTag = "#tims";
    String text = "meow " + hashTag + " @saikumuchon";
    String id = "1604175331652698112";
    Tweet tweet = dao.findById(id);

    assertEquals(id, tweet.getId_str());
    assertNotNull(text, tweet.getText());
    assertTrue(hashTag.contains(tweet.getEntities().getHashtags().get(0).getText()));
    assertNotNull(tweet.getEntities().getHashtags());
    assertEquals(tweet.getEntities().getHashtags().get(0).getText(), hashTag.replaceAll("#", ""));
    assertNotNull(tweet.getEntities().getUser_mentions());
    assertEquals(tweet.getEntities().getUser_mentions().get(0).getScreen_name(), "saikumuchon");
  }

  @Test
  public void delete() throws URISyntaxException {
    String id = "1603947319367434240";
    Tweet tweet = dao.deleteById(id);

    assertEquals(id, tweet.getId_str());
  }
}