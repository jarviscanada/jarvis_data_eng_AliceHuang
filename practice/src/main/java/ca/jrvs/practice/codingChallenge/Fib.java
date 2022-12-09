import static org.junit.Assert.assertEquals;

import java.util.Scanner;
import org.junit.*;

/**
 * ticket: https://www.notion.so/jarviscanada/Check-if-a-number-is-even-or-odd-4cbdd9acd9504c04b9b4ef0213f8084d
 */

public class Fib {

  private Fib fib;
  @Before
  public void setUp() throws Exception {
    fib = new Fib();
  }

  @Test
  public void testBaseCase() {
    assertEquals(fibRec(0), 0);
    assertEquals(fibRec(1), 1);
    assertEquals(fibRec(2), 1);
    assertEquals(fibDP(0), 0);
    assertEquals(fibDP(1), 1);
    assertEquals(fibDP(2), 1);
  }

  @Test
  public void testBigFib() {
    assertEquals(fibRec(11), 89);
    assertEquals(fibRec(19), 4181);
    assertEquals(fibRec(25), 75025);

    assertEquals(fibDP(11), 89);
    assertEquals(fibDP(19), 4181);
    assertEquals(fibDP(25), 75025);
  }
  /**
   * Big-O: O(2^n)
   * Justification: using recursion function
   */
  public int fibRec(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    return fibRec(n - 2) + fibRec(n -1);
  }

  /**
   * Big-O: O(n)
   * Justification: using dynamic programming
   */
  public int fibDP(int n){
    int[] memo = new int[n + 2];
    memo[0] = 0;
    memo[1] = 1;

    for (int i = 2; i <= n; i++) {
      memo[i] = memo[i - 1] + memo[i - 2];
    }
    return memo[n];
  }
}