class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        int result = helper(dp, 1, n);
        return result;
    }
    
    public int helper(int[][] dp, int s, int e){
        if(s >= e) {
            return 0;
        }
        if(dp[s][e] != 0){
            return dp[s][e];
        }
        int res = Integer.MAX_VALUE;
        for(int i = s; i <= e; i++){
            int temp = i + Math.max(helper(dp, s, i-1), helper(dp, i+1, e));
            res = Math.min(temp, res);
        }
        dp[s][e] = res;
        return dp[s][e];
    }
}