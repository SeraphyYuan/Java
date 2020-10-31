class Solution {
    public boolean stoneGame(int[] piles) {
        int [][] memo = new int[piles.length][piles.length];
        return helper(piles, 0, piles.length-1, memo) >= 0;
    }
    /**
     * Get max score diff from myScore and other player Score
     * @param piles
     * @param l
     * @param r
     * @param memo
     * @return
     */
    private int helper(int[]piles, int l, int r, int[][]memo){
        if(l == r){
            return piles[l];
        }
        if(memo[l][r] != 0){
            return memo[l][r];
        }
        /**There are two option for me, if I pick left side pile, score diff would be pile[l] - other player score */
        /** If I pick right side pile, score diff would be pile[r] - other player score */
        int r1 = piles[l] - helper(piles, l+1, r, memo);
        int r2 = piles[r] - helper(piles, l, r-1, memo);
        memo[l][r] = Math.max(r1, r2);
        return memo[l][r];
    }
}