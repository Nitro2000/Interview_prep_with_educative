package GrokkingTheCodingInterview.SlidingWindow;

import java.util.*;

public class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    if (str == null || str.length() == 0)
      throw new IllegalArgumentException();

    Map<Character, Integer> freq = new HashMap<>();
    int start = 0, end = 0, count = 0;
    int max = 0;
    while (end < str.length()) {
      if (freq.getOrDefault(str.charAt(end), 0) == 0) {
        if (k > 0) {
          k--;
          count = end - start + 1;
          freq.put(str.charAt(end), 1);
          end++;
        } else {
          freq.put(str.charAt(start), freq.getOrDefault(str.charAt(start), 0) - 1);
          if (freq.getOrDefault(str.charAt(start), 0) == 0) end++;
          start++;

        }
      } else {
        count = end - start + 1;
        freq.put(str.charAt(end), freq.getOrDefault(str.charAt(end), 0) + 1);
        end++;
      }
      max = Math.max(count, max);
    }

    return max;
  }
}
