package com.kitady.gke.spring;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class MyRuntimeHints implements RuntimeHintsRegistrar{

  @Override
  public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
    // Register method for reflection
    // Register resources
    // Register serialization
    hints.serialization().registerType(com.fasterxml.jackson.databind.ser.std.SqlDateSerializer.class);
    // Register proxy
  }
}
