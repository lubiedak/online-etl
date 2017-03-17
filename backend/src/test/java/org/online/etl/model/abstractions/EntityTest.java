package org.online.etl.model.abstractions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.online.etl.model.builder.CSVEntititiesBuilder;
import org.online.etl.model.processors.ToCSV;

public class EntityTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testCSVStructure() {
    CSVEntititiesBuilder csvBuilder = new CSVEntititiesBuilder();
    String csv = "id1;id2;id3\n1;2;3\n4;5";
    System.out.println(csv);
    Data data = csvBuilder.build(csv);
    System.out.println(data);
    ETLItem toCSV = new ToCSV();
    toCSV.extract(data);
    System.out.println(toCSV.asOutput());
  }

  @Test
  public void testJSONStructure() {
    fail("Not yet implemented");
  }

  @Test
  public void testXMLStructure() {
    fail("Not yet implemented");
  }

}
