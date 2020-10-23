class Leetcode_494 {
    static int count = 0;
    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1};
        int target = 3;
        count = findTargetSumWays(nums, target); 
        System.out.println("count = "+ count);

    }

    public static int findTargetSumWays(int[] nums, int S) {
        helper(nums, S, 0, 0);
        return count;
    }
    
    private static void helper(int[] nums, int target, int index, int sum){
        if(index == nums.length){
            if(sum == target){
                count++;
            }
        }
        else {
            helper(nums, target, index+1, sum+nums[index]);
            helper(nums, target, index+1, sum-nums[index]);
        }
    }
    
  }