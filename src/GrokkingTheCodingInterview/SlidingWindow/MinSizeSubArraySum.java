package GrokkingTheCodingInterview.SlidingWindow;

class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int windowSum = 0;
    int windowStart = 0;
    int minLength = Integer.MAX_VALUE;
    for(int windowEnd = 0;windowEnd<arr.length;windowEnd++){
      windowSum+=arr[windowEnd];
      while(windowSum>=S){
        minLength = Math.min(minLength,windowEnd - windowStart + 1);
        windowSum-=arr[windowStart];
        windowStart++;
      }
    }
    return minLength;
  }
}
