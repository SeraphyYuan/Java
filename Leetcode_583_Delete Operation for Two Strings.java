class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i<=len1; i++){
            for(int j =1; j<=len2; j++){
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                dp[i][j] = c1 == c2 ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int longestCommonStringLength = dp[len1][len2];
        int minDistance = len1 + len2 - 2* longestCommonStringLength;
        return minDistance;
    }
}