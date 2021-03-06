class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (word1.equals(word2)) {
        return 0;
    }
    if (word1.length() == 0 || word2.length() == 0) {
        return Math.abs(word1.length() - word2.length());
    }
        int[][] dp = new int[len1+1][len2+1];
        for (int i=0; i<=len1; i++){
            dp[i][0] = i;
        }
        for (int j=0; j<= len2; j++){
            dp[0][j] = j;
        }
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int left = dp[i-1][j];
                    int up = dp[i][j-1];
                    int corner = dp[i-1][j-1];
                    int result = Math.min(Math.min(left, up), corner) + 1;
                    dp[i][j] = result;
                }
            }
        }
        return dp[len1][len2];     
    }
}