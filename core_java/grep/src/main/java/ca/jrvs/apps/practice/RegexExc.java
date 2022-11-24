package ca.jrvs.apps.practice;

public interface RegexExc {

  /**
   * true if filename extension is jpg or jpeg (class insensitive)
   * @param filename
   * @return
   */
  public boolean matchJpeg(String filename);

  /**
   * return true if ip is valid
   * @param ip
   * @return
   */
  public boolean matchIp(String ip);

  /**
   * return true if line is empty (e.g empty, white space, tabs, etc...)
   * @param line
   * @return
   */
  public boolean isEmptyLine(String line);
}
