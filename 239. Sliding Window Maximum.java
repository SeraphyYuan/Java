class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k == 0){
            return new int[0];
        }
        int len = nums.length;
        int[] result = new int[len - k + 1];
        int ri = 0 ;
        LinkedList<Integer> dp = new LinkedList<>();
        for (int i = 0; i < len; i++){
            if(!dp.isEmpty() && dp.peek() < i-k+1){
                dp.poll();
            }
            while(!dp.isEmpty() && nums[dp.peekLast()] < nums[i]){
                dp.pollLast();
            }
            dp.offer(i);
            if(i-k+1 >= 0){
                result[ri++] = nums[dp.peek()];
            }
        }
        return result;
        
    }
    
    
}