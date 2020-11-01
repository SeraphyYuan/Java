class Solution {
    int [][] memo;
    int [] sums; // the sum from pile[i] to the end
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        memo = new int[n][n];
        sums = new int[n];
         sums[n-1] = piles[n-1];
        for(int i = n -2; i>=0;i--) {
            sums[i] = sums[i+1] + piles[i]; //the sum from piles[i] to the end
        }
        int score = helper(0, 1, piles);
        return score;
    }
    
    // helper return the max score player one can get
    private int helper(int s, int M, int[] piles){
        if(s >= piles.length){
            return 0;
        }
        if(2*M + s > piles.length){
            return sums[s];
        }
        if(memo[s][M] != 0){
            return memo[s][M];
        }
        int min = Integer.MAX_VALUE;
        for(int x=1; x<=2*M; x++){
            // get the min score the player two can get
            min = Math.min(min, helper(s+x, Math.max(x, M), piles));
        }
        memo[s][M] = sums[s] - min;
        return memo[s][M];
        
    }
}