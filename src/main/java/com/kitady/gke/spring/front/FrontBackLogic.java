package com.kitady.gke.spring.front;

import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FrontBackLogic {

  public Map<String, String> execute(String method, String hostname, String port) {

    String url = method + "://" + hostname + ":" + port + "/hostinfo";
    RestTemplate restTemplate = new RestTemplate();
    Map<String, String> json = restTemplate.getForObject(url, Map.class);
    return json;
  }
}
