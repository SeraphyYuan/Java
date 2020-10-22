class Leetcode_518{

    public static void main(String[] args) {

        int [] coins = {1,2,5};
        int amount = 5;
        int result = coinChange(coins, amount);
        System.out.println("result here = " + result);
    }
    public static int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount + 1];
        dp[0] = 1;
        for (int currCoin: coins){
            for (int i = 1; i <= amount; i++){
                if(i - currCoin >= 0){
                    dp[i] += dp[i-currCoin];
                }
            }
        }
        return dp[amount];
    }
}