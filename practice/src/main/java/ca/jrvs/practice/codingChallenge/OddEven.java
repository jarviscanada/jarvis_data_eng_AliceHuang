import static org.junit.Assert.assertEquals;

import java.util.Scanner;
import org.junit.*;

/**
 * ticket: https://www.notion.so/jarviscanada/Check-if-a-number-is-even-or-odd-4cbdd9acd9504c04b9b4ef0213f8084d
 */

public class OddEven {

  private OddEven oddEven;

  @Before
  public void setUp() throws Exception {
    oddEven = new OddEven();
  }

  @Test
  public void testModBaseCase() {
    assertEquals(oddEven.oddEvenMod(1), "odd");
  }
  @Test
  public void testModMultipleCase() {
    assertEquals(oddEven.oddEvenMod(2), "even");
    assertEquals( oddEven.oddEvenMod(100235), "odd");
    assertEquals(oddEven.oddEvenMod(3132131),"odd");
    assertEquals(oddEven.oddEvenMod(22222), "even");
  }

  @Test
  public void testBitBaseCase() {
    assertEquals(oddEven.oddEvenBit(1), "odd");
  }
  @Test
  public void testBitMultipleCase() {
    assertEquals(oddEven.oddEvenBit(2), "even");
    assertEquals(oddEven.oddEvenBit(100235), "odd");
    assertEquals(oddEven.oddEvenBit(3132131),"odd");
    assertEquals(oddEven.oddEvenBit(22222), "even");
  }
  /**
   * Big-O: O(1)
   * Justification: it's an arithmetic operation
   */
  public String oddEvenMod(int i){
    return i % 2 == 0 ? "even" : "odd";
  }

  /**
   * Big-O: O(1)
   * Justification: it's a bitwise operation
   */
  public String oddEvenBit(int i){
    return (i & 1) == 0? "even" : "odd";
  }
}
