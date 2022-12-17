package ca.jrvs.apps.twitter.utils;

import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Entities;
import ca.jrvs.apps.twitter.model.Hashtag;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.model.UserMention;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minidev.json.JSONUtil;

public class TweetUtil {

  public static Tweet buildTweet(String text, Float longitude, Float latitude) {
    float[] coord = new float[] {longitude, latitude};
    Coordinates coordinates = new Coordinates(coord, "Point");
    Entities entities = new Entities(extractHashtags(text), extractUserMention(text));
    Tweet tweet = new Tweet(extractTime(text), 0,"0", text, coordinates,0 , 0, false, false, entities);
    return tweet;
  }
  public static List<Hashtag> extractHashtags(String text) {
    List<Hashtag> hg = new ArrayList<>();
    Pattern p = Pattern.compile("\\B(\\#[a-zA-Z]+\\b)(?!;)", Pattern.MULTILINE);
    Matcher m = p.matcher(text);
    while (m.find()) {
      String matchText = m.group(1);
      int[] indices = new int[2];
      indices[0] = text.indexOf(matchText);
      indices[1] = indices[0] + matchText.length();
      Hashtag hashtag = new Hashtag(indices, matchText);
      hg.add(hashtag);
    }
    return hg;
  }

  public static List<UserMention> extractUserMention(String text) {
    List<UserMention> um = new ArrayList<>();
    Pattern p = Pattern.compile("\\B(\\@[a-zA-Z]+\\b)(?!;)", Pattern.MULTILINE);
    Matcher m = p.matcher(text);
    while (m.find()) {
      String matchText = m.group(1);
      int[] indices = new int[2];
      indices[0] = text.indexOf(matchText);
      indices[1] = indices[0] + matchText.length();
      UserMention userMention = new UserMention(0, "0", indices,matchText,matchText);
      um.add(userMention);
    }
    return um;
  }

  public static String extractTime(String text) {
    String[] s = text.split(" ");
    long timeMillis = Long.parseLong(s[s.length - 1]);
    Date currentDate = new Date(timeMillis);
    return currentDate.toString();
  }

  public static void main(String[] args) {
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    float lat = 131.0f;
    float lon = 141.0f;
    System.out.println(text);
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);

    System.out.println(postTweet.toString());
  }
}
