class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int localSum = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i< nums.length; i++){
            localSum += nums[i];
            while(localSum >= s){
                minLen = Math.min(minLen, i-start+1);
                localSum -= nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE? 0 : minLen;

    }
}