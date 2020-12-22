class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        int count = 0;
        int slowPoint = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%2 == 1){
                k--;
                count = 0;
            }
            while(k==0){
                int temp = nums[slowPoint++] & 1;
                k += temp;
                ++count;
            }
            result += count;
            
        }
        return result;
        
    }
}