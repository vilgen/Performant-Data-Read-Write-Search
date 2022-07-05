package com.evilemi.performant.data.processing;

import com.evilemi.performant.data.processing.io.ReadFile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PerformantDataProcessingApplication {

  public static void main(String[] args) {
    SpringApplication.run(PerformantDataProcessingApplication.class, args);
  }

  @Component
  public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
      ReadFile readFile = new ReadFile();

      Thread thread1 = new Thread(readFile);
      thread1.start();
/*
      Thread thread2 = new Thread(readFile);
      thread2.start();

      Thread thread3 = new Thread(readFile);
      thread3.start();

      Thread thread4= new Thread(readFile);
      thread4.start();

      Thread thread5 = new Thread(readFile);
      thread5.start();

      Thread thread6 = new Thread(readFile);
      thread6.start();

      Thread thread7 = new Thread(readFile);
      thread7.start();

      Thread thread8 = new Thread(readFile);
      thread8.start();*/
    }
  }
}
