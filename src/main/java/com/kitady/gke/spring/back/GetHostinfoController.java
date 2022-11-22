package com.kitady.gke.spring.back;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kitady.gke.spring.common.BaseController;

/**
 * GET host info
 */
@RestController
public class GetHostinfoController extends BaseController {

  @GetMapping("/hostinfo")
  public Map<String, String> execute() {

    final Map<String, String> map = gethostInfo();

    return map;
  }
}
