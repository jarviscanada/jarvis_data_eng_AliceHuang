package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.utils.CrdDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.utils.JsonParser;
import com.google.gdata.util.common.base.PercentEscaper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TwitterDao implements CrdDao<Tweet,String> {

  private final Logger logger = LoggerFactory.getLogger(TwitterDao.class);
  //URI constants
  private static final String API_BASE_URI = "https://api.twitter.com";
  private static final String POST_PATH = "/1.1/statuses/update.json";
  private static final String SHOW_PATH = "/1.1/statuses/show.json";
  private static final String DELETE_PATH = "/1.1/statuses/destroy/";
  //URI symbols
  private static final String QUERY_SYM = "?";
  private static final String AMPERSAND = "&";
  private static final String EQUAL = "=";

  //Response Code
  private static final int HTTP_OK = 200;

  @Autowired
  private HttpHelper httpHelper;

  public TwitterDao(HttpHelper httpHelper) {
    this.httpHelper = httpHelper;
  }

  public Tweet create(Tweet tweet) {
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
      tweet = JsonParser.toObjectFromJson(jsonStr, Tweet.class);
    } catch (IOException e) {
      throw new RuntimeException("Unable to convert JSON str to Object", e);
    }
    return tweet;
  }

  private URI getPostUri(Tweet tweet) throws URISyntaxException, UnsupportedEncodingException{
    PercentEscaper percentEscaper = new PercentEscaper("", false);
    // "https://api.twitter.com/1.1/statuses/update.json?status="
    return new URI(API_BASE_URI +  POST_PATH + QUERY_SYM +
        "status" + EQUAL + percentEscaper.escape(tweet.getText()));
  }

  public Tweet findById(String s) throws URISyntaxException {
    //https://api.twitter.com/1.1/statuses/show.json?id=
    URI uri = new URI(API_BASE_URI + SHOW_PATH + QUERY_SYM + "id" + EQUAL + s);
    HttpResponse response = httpHelper.httpGet(uri);
    return parseResponseBody(response, HTTP_OK);
  }

  public Tweet deleteById(String s) throws URISyntaxException {
    URI uri = new URI(API_BASE_URI +  DELETE_PATH + s + ".json");
    HttpResponse response = httpHelper.httpPost(uri);
    return parseResponseBody(response, HTTP_OK);
  }
}
