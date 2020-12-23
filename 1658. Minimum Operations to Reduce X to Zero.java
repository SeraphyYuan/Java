class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            map.put(sum, i);
        }
        int target = sum - x;
        if(target < 0) {
            return -1;
        }
        sum = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int temp = sum - target;
            if(map.containsKey(temp)){
                result = Math.max(result , i - map.get(temp));
            }
        }
        return result == Integer.MIN_VALUE ? -1: (nums.length-result);
    }
}