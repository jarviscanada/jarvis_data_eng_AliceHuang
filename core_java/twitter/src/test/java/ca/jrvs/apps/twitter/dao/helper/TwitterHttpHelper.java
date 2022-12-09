package ca.jrvs.apps.twitter.dao.helper;

import java.io.IOException;
import java.net.URI;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.springframework.http.HttpMethod;

public class TwitterHttpHelper implements HttpHelper {

  private OAuthConsumer consumer;
  private HttpClient httpClient;

  public TwitterHttpHelper(String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {
    consumer = new CommonsHttpOAuthConsumer(consumerKey,consumerSecret);
    consumer.setTokenWithSecret(accessToken,tokenSecret);
  }

  /**
   * Execute a HTTP Post call
   *
   * @param uri
   * @return
   */
  @Override
  public HttpResponse httpPost(URI uri) {
    try {
      return executeHttpRequest(HttpMethod.POST, uri, null);
    } catch (OAuthException | IOException e) {
      throw new RuntimeException("Failed to execute", e);
    }
  }

  private HttpResponse executeHttpRequest(HttpMethod method, URI uri, StringEntity stringEntity)
      throws OAuthException, IOException {
      if (method == HttpMethod.GET) {
        HttpGet request = new HttpGet(uri);
        consumer.sign(request);
        return httpClient.execute(request);
      } else if (method == HttpMethod.POST) {
        HttpPost request = new HttpPost(uri);
        if (stringEntity != null) {
          request.setEntity(stringEntity);
        }
        consumer.sign(request);
        return httpClient.execute(request);
      } else {
        throw new IllegalArgumentException("Unknown HTTP method: " + method.name());
      }
  }

  /**
   * Execute a HTTP Get call
   *
   * @param uri
   * @return
   */
  @Override
  public HttpResponse httpGet(URI uri) {
    return null;
  }
}
