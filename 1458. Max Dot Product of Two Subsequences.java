/*
 * @lc app=leetcode id=1458 lang=java
 *
 * [1458] Max Dot Product of Two Subsequences
 */

// @lc code=start
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
       int n = nums1.length;
       int m = nums2.length;
       int [][] dp = new int[n+1][m+1];
       for (int i=0; i <= n; i++){
           dp[i][0] = Integer.MIN_VALUE/2;
       }
       for(int j = 0; j<= m; j++){
           dp[0][j] = Integer.MIN_VALUE/2;
       }
       for (int i = 1; i <= n; i++){
           for(int j = 1; j <= m; j++){
               int soFar = Math.max(dp[i-1][j], dp[i][j-1]);
               int curr = nums1[i-1] * nums2[j-1];
               int maxCurr = Math.max(curr, dp[i-1][j-1] + curr);
               dp[i][j] = Math.max(soFar, maxCurr);
           }
       }
       return dp[n][m];
   }
}