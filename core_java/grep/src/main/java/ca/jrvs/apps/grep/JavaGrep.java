package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.*;

public interface JavaGrep {

  /**
   * Top level search workflow
   * @throws IOException
   */
  void process() throws IOException;

  /**
   * Traverse a given directory and return all files
   * @param rootDir input directory
   * @return the file under the rootDir
   */
  List<File> listFiles(String rootDir);

  /**
   *
   * Read a file and return all the lines
   * @param inputFile the file to read
   * @return lines
   * @throws IllegalArgumentException if a given inputFile is not a file
   */
  List<String> readLInes(File inputFile);

  /**
   * check if a line contains the regex pattern (passed by user)
   * @param Line
   * @return true if there is a match, false otherwise
   */
  boolean containsPattern(String Line);

  /**
   * Write Lines to a file
   * @param lines matched line
   * @throws IOException if write fail
   */
  void writeToFile(List<String> lines) throws IOException;

  /**
   * Get root path
   * @return the root path
   */
  String getRootPath();

  /**
   * Set root path
   * @param rootPath the root path need to be set
   */
  void setRootPath(String rootPath);

  /**
   * get the regex
   * @return the regex from input
   */
  String getRegex();

  /**
   * set the regex
   * @param regex the regex from input
   */
  void setRegex(String regex);

  /**
   * get the output file directory
   * @return the output file directory
   */
  String getOutFile();

  /**
   * set the output file directory
   * @param outFile the output file directory
   */
  void setOutFile(String outFile);
}
