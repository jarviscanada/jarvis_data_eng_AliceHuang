package ca.jrvs.apps.twitter.controller;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.utils.CrdDao;
import ca.jrvs.apps.twitter.utils.TweetUtil;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterControllerUnitTest {
  @Mock
  private TwitterService twitterService;
  @InjectMocks
  private TwitterController twitterController;

  @Test
  public void postTweet() throws UnsupportedEncodingException, URISyntaxException {
    when(twitterService.postTweet(any())).thenReturn(new Tweet());
    twitterController.postTweet(new String[]{"post", "hahaha", "47.0000:85.0000"});
  }

  @Test
  public void showTweet() throws URISyntaxException, NoSuchFieldException, IllegalAccessException {
    when(twitterService.showTweet(any(),any())).thenReturn(new Tweet());
    twitterController.showTweet(new String[]{"show", "1604175331652698112", "text,id"});
    twitterController.showTweet(new String[]{"show", "1604175331652698112"});
  }

  @Test
  public void deleteTweet() {
    when(twitterService.deleteTweets(any())).thenReturn(new ArrayList<Tweet>());
    twitterController.deleteTweet(new String[]{"delete", "1604175331652698112"});
    twitterController.deleteTweet(new String[]{"delete", "1604175331652698112,1604175331652698111"});
  }
}