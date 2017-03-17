package org.online.etl.model.abstractions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.online.etl.model.builder.CSVEntititiesBuilder;
import org.online.etl.model.processors.ToCSV;

import static org.junit.Assert.*;

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
    String inputCsv = "id1;id2;id3\n1;2;3\n4;5;";
    
    Data data = csvBuilder.build(inputCsv);
    ETLItem toCSV = new ToCSV();
    toCSV.extract(data);
    String outputCsv = toCSV.asOutput();
    
    assertEquals(inputCsv, outputCsv);
    
    // System.out.println(inputCsv);
    // System.out.println(data);
    // System.out.println(outputCsv);
  }

  @Test
  public void testJSONStructure() {
    // fail("Not yet implemented");
  }

  @Test
  public void testXMLStructure() {
    // fail("Not yet implemented");
  }

}
