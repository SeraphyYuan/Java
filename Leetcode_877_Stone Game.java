class Solution {
    public boolean stoneGame(int[] piles) {
        int [][] memo = new int[piles.length][piles.length];
        return helper(piles, 0, piles.length-1, memo) >= 0;
    }
    
    private int helper(int[]piles, int l, int r, int[][]memo){
        if(l == r){
            return piles[l];
        }
        if(memo[l][r] != 0){
            return memo[l][r];
        }
        int r1 = piles[l] - helper(piles, l+1, r, memo);
        int r2 = piles[r] - helper(piles, l, r-1, memo);
        memo[l][r] = Math.max(r1, r2);
        return memo[l][r];
    }
}