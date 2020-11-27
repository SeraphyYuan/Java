class Solution {
    public int minInsertions(String s) {
        int len = s.length();
        int [][] dp = new int[len+1][len+1];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                char c1 = s.charAt(i);
                char c2 = s.charAt(len-1-j);
                if(c1 == c2) {
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return len - dp[len][len];
    }
}