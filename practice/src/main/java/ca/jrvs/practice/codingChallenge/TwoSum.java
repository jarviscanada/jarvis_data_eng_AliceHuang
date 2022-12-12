import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwoSum {


  private TwoSum twoSum;

  @Before
  public void setUp() throws Exception {
    twoSum = new TwoSum();
  }

  @Test
  public void testExampleCases() {
    int[] nums1 = {2,7,11,15};
    int[] nums2 = {3,2,4};
    int[] nums3 = {3, 3};

    assertArrayEquals(twoSum.twoSumBrute(nums1, 9), new int[]{0, 1});
    assertArrayEquals(twoSum.twoSumBrute(nums2, 6), new int[]{1, 2});
    assertArrayEquals(twoSum.twoSumBrute(nums3, 6), new int[]{0, 1});
    assertArrayEquals(twoSum.twoSumMap(nums1, 9), new int[]{0, 1});
    assertArrayEquals(twoSum.twoSumMap(nums2, 6), new int[]{1, 2});
    assertArrayEquals(twoSum.twoSumMap(nums3, 6), new int[]{0, 1});
  }
  @Test
  public void testTPExampleCases() {
    int[] nums1 = {2,7,11,15};
    int[] nums2 = {2,3,4};
    int[] nums3 = {3, 3};

    assertArrayEquals(twoSum.twoSumDoublePointer(nums1, 9), new int[]{0, 1});
    assertArrayEquals(twoSum.twoSumDoublePointer(nums2, 6), new int[]{0, 2});
    assertArrayEquals(twoSum.twoSumDoublePointer(nums3, 6), new int[]{0, 1});
  }
  /**
   * Big-O: O(n^2)
   * Justification: it's a brute force (two loop)
   */

  public int[] twoSumBrute (int[] nums, int target) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int curr = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        if (curr + nums[j] == target) {
          result[0] = i;
          result[1] = j;
        }
      }
    }
    return result;
  }

  /**
   * Big-O: O(n)
   * Justification: it's a double pointer solution, it's good for when the array is sorted
   */

  public int[] twoSumDoublePointer (int[] nums, int target) {
    int i = 0;
    int j = nums.length - 1;


    while (i < j) {
      int sum = nums[i] + nums[j];
      if (sum == target) {
        return new int[] {i ,j};
      } else if (sum < target){
        i++;
      } else {
        j--;
      }
    }

    return null;
  }

  /**
   * Big-O: O(n)
   * Justification: it's a hash map solution
   */

  public int[] twoSumMap (int[] nums, int target) {
    HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
    for(int i = 0; i < nums.length; i++){

      Integer diff = (Integer)(target - nums[i]);
      if(hash.containsKey(diff)){
        int toReturn[] = {hash.get(diff), i};
        return toReturn;
      }

      hash.put(nums[i], i);

    }

    return null;

  }
}
