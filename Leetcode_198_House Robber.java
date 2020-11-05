class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] maxAmount = new int[length+1]; //0->n maxAmount
        if(length == 0){
            return 0;
        }
        maxAmount[0] = 0;
        maxAmount[1] = nums[0];
        int max = Integer.MIN_VALUE;
        for(int i=1; i < nums.length; i++){
            int val = nums[i];
            maxAmount[i+1] = Math.max(maxAmount[i], maxAmount[i-1]+val);
        }
        return maxAmount[length];
    }
}