package ca.jrvs.apps.twitter.service;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.utils.CrdDao;
import ca.jrvs.apps.twitter.utils.TweetUtil;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceTest {
  @Mock
  CrdDao dao;

  @InjectMocks
  TwitterService service;

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void postTweet() throws UnsupportedEncodingException, URISyntaxException {
    when(dao.create(any())).thenReturn(new Tweet());
    service.postTweet(TweetUtil.buildTweet("test", 50.0f, 0.0f));
  }

  @Test
  public void showTweet() throws URISyntaxException, NoSuchFieldException, IllegalAccessException {
    String id = "1604175331652698112";
    when(dao.findById(any())).thenReturn(new Tweet());
    service.showTweet(id, null);
  }

  @Test
  public void deleteTweets() throws URISyntaxException {
    String[] ids = new String[] {
        "1603947319367434240"
    };
    when(dao.deleteById(any())).thenReturn(new Tweet());
    service.deleteTweets(ids);
  }
}