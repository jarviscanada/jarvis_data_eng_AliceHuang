package ca.jrvs.apps.grep;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaGrepLambdaImp implements JavaGrep {

  public static void main(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException("USAGE: JavaGrep regex rootPath outFile");
    }

    JavaGrepLambdaImp javaGrepLambdaImp = new JavaGrepLambdaImp();
    javaGrepLambdaImp.setRegex(args[0]);
    javaGrepLambdaImp.setRootPath(args[1]);
    javaGrepLambdaImp.setOutFile(args[2]);

    try {
      javaGrepLambdaImp.process();
    } catch (Exception e) {
      javaGrepLambdaImp.logger.error("Error: Unable to process", e);
    }
  }
  @Override
  public void process() throws IOException {
    List<String> matchedLines = new ArrayList<>();
    listFiles(getRootPath()).stream().forEach(f->{
      readLInes(f).stream().filter(this::containsPattern).forEach(matchedLines::add);
    });
    writeToFile(matchedLines);
  }

  @Override
  public List<File> listFiles(String rootDir) {
    File directoryPath = null;
    List<File> fileArrayList = new ArrayList<>();
    try {
      directoryPath = new File(rootDir);
    } catch (Exception e)  {
      logger.error("Unable to load files", e);
    } finally {
      File fileList[] = directoryPath.listFiles();
      assert fileList != null;
      Stream.of(fileList).forEach(f-> {
        if (f.isFile()) {
          fileArrayList.add(f);
        } else {
          fileArrayList.addAll(listFiles(f.getAbsolutePath()));
        }
      });
      return fileArrayList;
    }
  }

  @Override
  public List<String> readLInes(File inputFile) {
    List<String> stringList;
    Stream<String> lines = null;
    try {
      lines = Files.lines(inputFile.toPath());

    } catch (Exception e) {
      logger.error("Unable to read file", e);
    }

    assert lines != null;
    stringList = lines.collect(Collectors.toList());
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
    lines.stream().map(String::valueOf).forEach(l-> {
      try {
        myWriter.write(l);
      } catch (Exception e) {
        logger.error("Unable to write file", e);
      }
    });
    myWriter.close();
  }

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

}
