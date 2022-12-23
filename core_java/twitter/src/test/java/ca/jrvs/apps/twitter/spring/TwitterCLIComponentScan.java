package ca.jrvs.apps.twitter.spring;

import ca.jrvs.apps.twitter.TwitterCLIApp;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "ca.jrvs.apps.twitter")
public class TwitterCLIComponentScan {

  public static void main(String[] args)
      throws UnsupportedEncodingException, URISyntaxException, NoSuchFieldException, IllegalAccessException {
    ApplicationContext context = new AnnotationConfigApplicationContext(TwitterCLIComponentScan.class);
    TwitterCLIApp app = context.getBean(TwitterCLIApp.class);
    app.run(args);
  }
}
