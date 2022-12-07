import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

/**
 * ticket: https://www.notion.so/jarvisdev/How-to-compare-two-maps-916dd00f9a16437d9dfbed06a7012506
 */

public class CompareTwoMap {

  private CompareTwoMap compareTwoMap;
  /**
   * Big-O: O(n)
   * Justification: compare maps using Java Collection .equals API
   */
  public <K,V> boolean compareMapsCol(Map<K,V> m1, Map<K,V> m2){
    return m1.equals(m2);
  }

  /**
   * Big-O: O(n^2)
   * Justification: Implement equals in HashJMap
   */
  public <K,V> boolean compareMapsImp(Map<K,V> m1, Map<K,V> m2){
    return false;
  }
  @Before
  public void setUp() {
    compareTwoMap = new CompareTwoMap();
  }

  @Test
  public void TestBaseCase() {
    Map m1 = new HashMap();
    Map m2 = new HashMap();
    assertEquals(compareTwoMap.compareMapsCol(m1, m2), true);
  }

  @Test
  public void TestTrueCase() {
    Map m1 = new HashMap();
    Map m2 = new HashMap();
    m1.put(1,"yes");
    m2.put(1,"yes");
    m1.put(2,"No");
    m2.put(2,"No");
    m1.put(3,"Same");
    m2.put(3,"Same");
    assertEquals(compareTwoMap.compareMapsCol(m1, m2), true);
  }

  @Test
  public void TestFalseCase() {
    Map m1 = new HashMap();
    Map m2 = new HashMap();
    m1.put(1,"yes");
    m1.put(2,"No");
    m2.put(1,"No");
    m2.put(2,"Same");
    assertEquals(compareTwoMap.compareMapsCol(m1, m2), false);
  }

}
