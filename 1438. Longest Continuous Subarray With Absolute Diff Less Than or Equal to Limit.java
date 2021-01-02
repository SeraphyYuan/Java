class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //Solution one use tree map
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0; 
        int j;
        for(j = 0; j < nums.length; j++) {
            map.put(nums[j], 1+map.getOrDefault(nums[j], 0));
            if (map.lastEntry().getKey() - map.firstEntry().getKey() > limit) {
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
        }
        return j-i;
        
        //Solution two use monotone queue
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        int l = 0;
        int r;
        int result = 1;
        for (r = 0; r < nums.length; r++){
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < nums[r]){
                maxQueue.pollLast();
            }
            maxQueue.offerLast(nums[r]);
            while(!minQueue.isEmpty() && minQueue.peekLast() > nums[r]){
                minQueue.pollLast();
            }
            minQueue.offerLast(nums[r]);
            while(maxQueue.peekFirst() - minQueue.peekFirst() > limit){
                if(maxQueue.peekFirst() == nums[l]) {
                    maxQueue.pollFirst();
                }
                if(minQueue.peekFirst() == nums[l]) {
                    minQueue.pollFirst();
                }
                ++l;
            }
            result = Math.max(result, (r-l+1));
        }
        return result;
    }
}