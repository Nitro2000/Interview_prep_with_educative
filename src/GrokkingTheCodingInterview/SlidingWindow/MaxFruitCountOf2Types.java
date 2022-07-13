package GrokkingTheCodingInterview.SlidingWindow;

import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    
    int start = 0, count = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int end = 0; end < arr.length; end++) {
      map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

      while (map.size() > 2) {
        map.put(arr[start], map.get(arr[start]) - 1);
        if (map.get(arr[start]) == 0) {
          map.remove(arr[start]);
          start++;
        }
      }
      count = Math.max(count, end - start + 1);
    }
    return count;
  }
}
