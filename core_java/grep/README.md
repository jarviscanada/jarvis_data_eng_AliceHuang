# Introduction
Our team is going to develop a trading platform REST API. Hence, grep would be one of the most necessary function to help user search  match string from file. Grep, as it mimics linux command grep, is used to help user find match string from file. It would be useful when the users want to search through API. We will use Intellij to implement this project. This project is developed in Core Java, built in Maven. We can manage and run this app through docker.

# Quick Start
There are three input parameters for this application:

- regex:the regular expression to search through text
- input_file_path: the path of the input file that you want to search for
- output_file_path: the path of the matched text inside an output file.

Two ways to launch on JVM(Java virtual machine):
- launch with class path and file:
```bash
java -classpath target/classes ca.jrvs.apps.grep.JavaGrepImp regex input_file_path output_file_path
```
- launch with the jar file
```bash
java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp regex input_file_path output_file_path
```

# Implementation
## Pseudocode
```text
  matchedLines = []
  for file in listFilesRecursively(rootDir)
      for line in readLines(file)
          if containsPattern(line)
              matchedLines.add(line)
  writeToFile(matchedLines)
```
## Performance Issue
We tried out with 5M of minimum heap size and 5M of maximum heap size, we got an error that suggested that it was out of heap memory. It indicates that it may occupy too much heap memory as a small Java app. Hence, we implement functions again by using lambda stream, reduce the use of initializing objects and arraylists so that it will occupy less heap memory.

# Test
We prepared a txt file which is a section from Romeo and Julia, we used the grep Linux common to gain the expected result:
```bash
regex_pattern=".*Romeo.*Juliet.*" 
src_dir="./data" 
egrep -r ${regex_pattern} ${src_dir}
```
Then, we tested this on our Java app, we got exactly the same result.

# Deployment
We package our Java app by using Maven, and then build an image which simulates our current develop environment. We create a container to run our Java app and push remotely on docker in order to inspect and manage.

# Improvement
- **the start command may be too complicated for users who are not having developer experience:** We can instruct user to save their input file in specific folder, then design a function that consume user's input, find matched text from their input then output to command line.