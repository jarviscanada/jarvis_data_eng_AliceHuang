package ca.jrvs.apps.twitter;

import com.google.gdata.util.common.base.PercentEscaper;
import java.util.Arrays;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwitterApiTest {
  private static String CONSUMER_KEY = System.getenv("consumerKey");
  private static String CONSUMER_SECRET = System.getenv("consumerSecret");
  private static String ACCESS_TOKEN = System.getenv("accessToken");
  private static String TOKEN_SECRET = System.getenv("tokenSecret");

  private final Logger logger = LoggerFactory.getLogger(TwitterApiTest.class);
  public static void main(String[] args) throws Exception{

    TwitterApiTest twitterApiTest = new TwitterApiTest();
    // Setup
    OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
    consumer.setTokenWithSecret(ACCESS_TOKEN,TOKEN_SECRET);

    // Create an HTTP GET request
    String status = "today is a good day to die!";
    PercentEscaper percentEscaper = new PercentEscaper("", false);
    HttpPost request = new HttpPost(
        "https://api.twitter.com/1.1/statuses/update.json?status=" + percentEscaper.escape(status)
    );

    // Sign the request
    consumer.sign(request);

    twitterApiTest.logger.info("Http Request Headers:");
    Arrays.stream(request.getAllHeaders()).map(Object::toString).forEach(twitterApiTest.logger::info);

    // Send the request

    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpResponse response = httpClient.execute(request);
    twitterApiTest.logger.info(EntityUtils.toString(response.getEntity()));
  }
}
