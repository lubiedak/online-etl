package org.online.etl.controller;

import org.online.etl.model.abstractions.Data;
import org.online.etl.model.builder.CSVEntititiesBuilder;
import org.online.etl.model.builder.EntityBuilder;
import org.online.etl.model.processors.ToCSV;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutputController {

  @RequestMapping("/output/mocked")
  public Data mock() {
    String inputCsv = "id1;id2;id3\n1;2;3\n4;5;";
    ToCSV toSCV = new ToCSV();
    EntityBuilder builder = new CSVEntititiesBuilder();
    
    toSCV.extract(builder.build(inputCsv));
    
    return builder.build(inputCsv);
  }
}
