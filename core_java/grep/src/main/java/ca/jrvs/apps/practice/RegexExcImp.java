package ca.jrvs.apps.practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExcImp implements RegexExc{

  @Override
  public boolean matchJpeg(String filename) {
    Pattern pattern = Pattern.compile(".+\\.(jpg|jpeg)$", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(filename);
    return matcher.find();
  }

  @Override
  public boolean matchIp(String ip) {
    Pattern pattern = Pattern.compile("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(ip);
    return matcher.find();
  }

  @Override
  public boolean isEmptyLine(String line) {
    Pattern pattern = Pattern.compile("^\\s*$", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(line);
    return matcher.find();
  }

  public static void main(String[] args) {

    String string = null;
    RegexExcImp regexExcImp= new RegexExcImp();

    string = "ss.jpeg";
    System.out.println(string + " " + (regexExcImp.matchJpeg(string)? "is jpeg file": "is not jpeg file"));
    string = "ss.jpg";
    System.out.println(string + " " + (regexExcImp.matchJpeg(string)? "is jpeg file": "is not jpeg file"));
    string = "ss.jg";
    System.out.println(string + " " + (regexExcImp.matchJpeg(string)? "is jpeg file": "is not jpeg file"));

    string = "0.0.0.0";
    System.out.println(string + " " + (regexExcImp.matchIp(string)? "is ip address": "is not Ip address"));
    string = "255.0.197.255";
    System.out.println(string + " " + (regexExcImp.matchIp(string)? "is ip address": "is not Ip address"));
    string = ".0.0.0";
    System.out.println(string + " " + (regexExcImp.matchIp(string)? "is ip address": "is not Ip address"));
    string = "400.0.0.0";
    System.out.println(string + " " + (regexExcImp.matchIp(string)? "is ip address": "is not Ip address"));

    string = "  ";
    System.out.println(string + " " + (regexExcImp.isEmptyLine(string)? "is empty": "is not empty"));

  }
}
