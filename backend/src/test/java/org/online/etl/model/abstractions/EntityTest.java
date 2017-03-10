package org.online.etl.model.abstractions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    Data data = csvBuilder.load(csv);
    System.out.println(data);
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
