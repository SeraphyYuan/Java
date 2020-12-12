class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        //[3,1,4,2]
        //[3,1,1,1]
        for(int i = 1; i < nums.length; i++){
            min[i] = Math.min(nums[i], min[i-1]);
        }
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        for(int k = length-1; k>=0; k--){
            if(nums[k] > min[k]){
                while(!stack.isEmpty() && stack.peek() <= min[k]){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() < nums[k]){
                    return true;
                }
                stack.push(nums[k]);
            }
        }
        return false;
    }
}