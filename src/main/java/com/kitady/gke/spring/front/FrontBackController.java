package com.kitady.gke.spring.front;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.kitady.gke.spring.common.BaseController;

/**
 * GET Frontend and Backend HOSTNAME
 */
@RestController
public class FrontBackController extends BaseController {

  @Autowired
  protected FrontBackLogic logic;

  @GetMapping("/front-back/{hostname}")
  public Map<String, Object> execute(@PathVariable final String hostname) {
    final String method = System.getenv("METHOD") != null ? System.getenv("METHOD") : "http";
    final String port = System.getenv("PORT") != null ? System.getenv("PORT") : "8080";

    // call backend API
    final Map<String, String> json = logic.execute(method, hostname, port);

    final Map<String, Object> map = new HashMap<>();
    map.put("frontend", gethostInfo());
    map.put("backend", json);

    return map;
  }
}
