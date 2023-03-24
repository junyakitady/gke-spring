package com.kitady.gke.spring.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.kitady.gke.spring.common.BaseController;

/**
 * GET data from Spanner
 */
@RegisterReflectionForBinding({com.fasterxml.jackson.databind.ser.std.SqlDateSerializer.class})
@RestController
public class GetItemController extends BaseController {

  @Autowired
  protected ItemRepository repository;

  @GetMapping("/item")
  public Map<String, Object> getItemList() {

    // call Spanner
    final Iterable<Item> items = repository.findAll();

    final Map<String, Object> map = new HashMap<>();
    map.put("hostinfo", gethostInfo());
    map.put("query", items);

    return map;
  }

  @GetMapping("/item/{uuid}")
  public Map<String, Object> getItem(@PathVariable final String uuid) {

    // call Spanner
    final Optional<Item> item = repository.findById(uuid);

    final Map<String, Object> map = new HashMap<>();
    map.put("hostinfo", gethostInfo());
    map.put("query", item);

    return map;
  }
}
