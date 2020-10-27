class Leetcode_486 {
    public static void main(String[] args) {
        int [] nums = {1, 5, 233, 7};
        boolean result = PredictTheWinner(nums);
        System.out.println("Result =" + result);
    }
    public static boolean PredictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return getResult(nums, 0, nums.length-1, memo) >= 0;
    }
    
    private static int getResult(int[] nums, int l, int r, Integer[][] memo){
        if(l == r){
            return nums[l];
        }
        if(memo[l][r] != null){
            return memo[l][r];
        }
        int r1 = nums[l] - getResult(nums, l+1, r, memo);
        int r2 = nums[r] - getResult(nums, l, r-1, memo);
        memo[l][r] = Math.max(r1, r2);
        return Math.max(r1, r2);
    }
}