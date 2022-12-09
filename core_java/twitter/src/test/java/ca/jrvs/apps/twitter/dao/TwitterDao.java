package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.utils.CrdDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.*;
public class TwitterDao implements CrdDao<Tweet,String> {

  private final Logger logger = LoggerFactory.getLogger(TwitterDao.class);
  private final ObjectMapper mapper = new ObjectMapper();
  //URI constants
  private static final String API_BASE_URI = "https://api.twitter.com";
//  private static final String API_BASE_URI = "https://api.twitter.com";
//  private static final String API_BASE_URI = "https://api.twitter.com";
//  private static final String API_BASE_URI = "https://api.twitter.com";
//  //URI symbols
//  private static final String API_BASE_URI = "https://api.twitter.com";
//  private static final String API_BASE_URI = "https://api.twitter.com";
//  private static final String API_BASE_URI = "https://api.twitter.com";

  //Response Code
  private static final int HTTP_OK = 200;

  private HttpHelper httpHelper;

  public Tweet create(Tweet tweet) throws UnsupportedEncodingException, URISyntaxException {
    URI uri;
    try {
      uri = getPostUri(tweet);
    } catch (URISyntaxException | UnsupportedEncodingException e) {
      throw new IllegalArgumentException("Invalid tweet input", e);
    }
    HttpResponse response = httpHelper.httpPost(uri);
    return parseResponseBody(response, HTTP_OK);
  }

  private Tweet parseResponseBody(HttpResponse response, int expectedStatusCode) {
    Tweet tweet = null;
    int status = response.getStatusLine().getStatusCode();
    if (status != expectedStatusCode) {
      try {
        logger.info(EntityUtils.toString(response.getEntity()));
      } catch (IOException e) {
        logger.error("Response has no entity", e);
      }
      throw new RuntimeException("Unexpected HTTP Status: " + status);
    }

    if (response.getEntity() == null) {
      throw new RuntimeException("Empty response body");
    }

    String jsonStr;
    try {
      jsonStr = EntityUtils.toString(response.getEntity());
    } catch (IOException e) {
      throw new RuntimeException("Failed to convert entity to String", e);
    }
    try {
      tweet = mapper.readValue(jsonStr, Tweet.class);
    } catch (IOException e) {
      throw new RuntimeException("Unable to convert JSON str to Object", e);
    }
    return tweet;
  }

  private URI getPostUri(Tweet tweet) throws URISyntaxException, UnsupportedEncodingException{
    return null;
  }

  public Tweet findById(String s) {
    return null;
  }

  public Tweet deleteById(String s) {
    return null;
  }
}
