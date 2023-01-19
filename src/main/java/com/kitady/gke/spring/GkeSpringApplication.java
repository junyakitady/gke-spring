package com.kitady.gke.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(MyRuntimeHints.class)
public class GkeSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(GkeSpringApplication.class, args);
  }

}
