import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
  public static void main(String[] args) {
    int[] arr = {-2,1,-3,4,1,2,1,-5,4};
//    int[][] mat = {{1, 2, 3}, {4, 5, 6}, {8, 9, 10}};
//    int[][] mat = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//    int[][] mat = {{1},{3}};
//    int[][] mat = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
    System.out.println(subarraySum(arr, 5));
  }


  public static int subarraySum(int[] nums, int k) {
    int count = 0, sum = 0;
    HashMap < Integer, Integer > map = new HashMap < > ();
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k))
        count += map.get(sum - k);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static boolean searchMatrix(int[][] matrix, int target) {
    int row = searchRow(matrix, target, 0, matrix.length - 1);
    return searchColumn(matrix[row], target, 0, matrix[row].length -1);
  }

  private static int searchRow(int[][] matrix, int target, int lo, int hi) {
    if (lo >= hi) return lo;
    int mid = lo + (hi - lo) / 2;
if (matrix[mid][matrix[mid].length - 1] == target) return mid;
    if (matrix[mid][matrix[mid].length - 1] > target) {
      return searchRow(matrix, target, lo, mid );
    } else {
      return searchRow(matrix, target, mid + 1, hi);
    }
  }


  private static boolean searchColumn(int[] row, int target, int lo, int hi) {
    if (lo >= hi) return row[lo] == target;
    int mid = lo + (hi - lo) / 2;
    if (row[mid] == target) return true;
    if (row[mid] > target) {
      return searchColumn(row, target, lo, mid);
    } else {
      return searchColumn(row, target, mid + 1, hi);
    }
  }
}
