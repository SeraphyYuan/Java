class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = -1;
            for(int j=1; j<nums.length; j++){
                int nextNum = nums[(i+j) % nums.length];
                if (nextNum > nums[i]) {
                    result[i] = nextNum;
                    break;
                }
            }
        }
        return result;
    }
}
/** Time Complexity: O(n*n)**/


/** Solution 2: using a stack to keep tracking decrease number's index **/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 2*nums.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i%nums.length]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i%nums.length] = -1;
            }
            else {
                result[i%nums.length] = nums[stack.peek()];
            }
            stack.push(i%nums.length);
        }
        return result;
    }
}

/** Time Complexity: O(n)**/
/** Space Complexity: O(n)**/
