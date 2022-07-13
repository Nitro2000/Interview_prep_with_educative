package SlidingWindow;

import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {

    int start = 0, count = 0, max = 0;
    Map<Character, Integer> map = new HashMap<>();
    
    // aabccbb
    for (int end = 0; end < str.length(); end++) {

      map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);

      while (map.get(str.charAt(end)) > 1) {
        map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
        start++;
      }
      max = Math.max(max, end - start + 1);
    }
    
    return max;
  }
}
