package org.online.etl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputController {

  @RequestMapping("/input/mocked")
  public String mock() {
    String inputCsv = "id1;id2;id3\n1;2;3\n4;5;";
    return inputCsv;
  }
}
