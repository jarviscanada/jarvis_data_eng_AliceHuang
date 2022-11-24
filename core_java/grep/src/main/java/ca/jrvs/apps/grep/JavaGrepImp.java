package ca.jrvs.apps.grep;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JavaGrepImp implements JavaGrep {

  @Override
  public String getRegex() {
    return regex;
  }

  @Override
  public void setRegex(String regex) {
    this.regex = regex;
  }

  @Override
  public String getRootPath() {
    return rootPath;
  }

  @Override
  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }

  @Override
  public String getOutFile() {
    return outFile;
  }

  @Override
  public void setOutFile(String outFile) {
    this.outFile = outFile;
  }

  final Logger logger = LoggerFactory.getLogger(JavaGrep.class);

  private String regex;
  private String rootPath;
  private String outFile;

  public void process() throws IOException {
    List<String> matchedLines = new ArrayList<String>();
    for (File file: listFiles(getRootPath())) {
      for (String line: readLInes(file)) {
          if (containsPattern(line)) {
            matchedLines.add(line);
          }
      }
    }
    writeToFile(matchedLines);
  }

  @Override
  public List<File> listFiles(String rootDir) {
    File directoryPath = null;
    List<File> fileArrayList = new ArrayList<>();
    try {
      directoryPath = new File(rootDir);
    } catch (Exception e)  {
      logger.info("Unable to find path", e);
    } finally {
      File fileList[] = directoryPath.listFiles();
      for (File file: fileList) {
        if (file.isFile()) {
          fileArrayList.add(file);
        } else {
          fileArrayList.addAll(listFiles(file.getAbsolutePath()));
        }
      }
      return fileArrayList;
    }
  }

  @Override
  public List<String> readLInes(File inputFile) {
    List<String> stringList = new ArrayList<>();
    try {
      Scanner scanner = new Scanner(inputFile);
      while (scanner.hasNextLine()) {
        stringList.add(scanner.nextLine());
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return stringList;
  }

  @Override
  public boolean containsPattern(String Line) {
    Pattern pattern = Pattern.compile(getRegex(),Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(Line);
    return matcher.find();
  }

  @Override
  public void writeToFile(List<String> lines) throws IOException {
    FileWriter myWriter = new FileWriter(getOutFile());
    for (String line: lines) {
      myWriter.write(line);
    }
    myWriter.close();
  }

  public static void main(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException("USAGE: JavaGrep regex rootPath outFile");
    }

    JavaGrepImp javaGrepImp = new JavaGrepImp();
    javaGrepImp.setRegex(args[0]);
    javaGrepImp.setRootPath(args[1]);
    javaGrepImp.setOutFile(args[2]);

    try {
      javaGrepImp.process();
    } catch (Exception e) {
      javaGrepImp.logger.error("Error: Unable to process", e);
    }
  }
}
