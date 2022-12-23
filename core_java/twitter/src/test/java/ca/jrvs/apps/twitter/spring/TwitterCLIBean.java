package ca.jrvs.apps.twitter.spring;

import ca.jrvs.apps.twitter.TwitterCLIApp;
import ca.jrvs.apps.twitter.controller.TwitterController;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.utils.Controller;
import ca.jrvs.apps.twitter.utils.CrdDao;
import ca.jrvs.apps.twitter.utils.Service;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

//@Configuration
public class TwitterCLIBean {

  public static void main(String[] args)
      throws UnsupportedEncodingException, URISyntaxException, NoSuchFieldException, IllegalAccessException {
    ApplicationContext context = new AnnotationConfigApplicationContext(TwitterCLIBean.class);
    TwitterCLIApp app = context.getBean(TwitterCLIApp.class);
    app.run(args);
  }

  @Bean
  public TwitterCLIApp twitterCLIApp(Controller controller) {
    return new TwitterCLIApp(controller);
  }

  @Bean
  public  Controller controller(Service service) {
    return new TwitterController(service);
  }

  @Bean
  public Service service(CrdDao dao) {
    return new TwitterService(dao);
  }

  @Bean
  public CrdDao crdDao(HttpHelper httpHelper) {
    return new TwitterDao(httpHelper);
  }

  @Bean
  HttpHelper helper() {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");
    return new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
  }
}
