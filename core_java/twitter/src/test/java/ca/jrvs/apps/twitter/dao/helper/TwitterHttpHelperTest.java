//package ca.jrvs.apps.twitter.dao.helper;
//
//import static org.junit.Assert.*;
//
//import com.google.gdata.util.common.base.PercentEscaper;
//import java.net.URI;
//import org.apache.http.HttpResponse;
//import org.apache.http.util.EntityUtils;
//import org.junit.Test;
//
//public class TwitterHttpHelperTest {
//
//  @Test
//  public void httpPost() throws Exception {
//    String consumerKey = System.getenv("consumerKey");
//    String consumerSecret = System.getenv("consumerSecret");
//    String accessToken = System.getenv("accessToken");
//    String tokenSecret = System.getenv("tokenSecret");
//    HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
//
//    String status = "today is a good day to die!";
//    PercentEscaper percentEscaper = new PercentEscaper("", false);
//    HttpResponse response = httpHelper.httpPost(new URI("https://api.twitter.com/1.1/statuses/update.json?status=" + percentEscaper.escape(status)));
//    System.out.println(EntityUtils.toString(response.getEntity()));
//  }
//}