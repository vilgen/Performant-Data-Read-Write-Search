package com.evilemi.performant.data.processing.io;

import com.evilemi.performant.data.processing.model.MsisdnMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.util.ResourceUtils;

public class ReadFile implements Runnable {

  private final String MSISDN_REGEX = "^([0-9]+),([0-9]+)*$";
  private final Pattern pattern = Pattern.compile(MSISDN_REGEX, Pattern.MULTILINE);

  public void readDataFile() throws IOException {

    File file = ResourceUtils.getFile("classpath:msisdn.csv");

    BufferedReader bufferedReader;
    FileReader fileReader;

    fileReader = new FileReader(file);
    bufferedReader = new BufferedReader(fileReader);

    String line;

    synchronized (this) {
      while ((line = bufferedReader.readLine()) != null) {
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
          MsisdnMap.fillMsisdnMap(Long.parseLong(matcher.group(1)), matcher.group(2));
        }
        //MsisdnMap.fillMsisdnMap(Long.parseLong(line.split(",")[0].trim()), line.split(",")[1].trim());
      }
    }

    bufferedReader.close();

  }

  @Override
  public void run() {
    try {
      readDataFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
