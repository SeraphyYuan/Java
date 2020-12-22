class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int total = 0;
        for(int i: A){
            sum += i;
            if(map.containsKey(sum-S)){
                total += map.get(sum-S);
            }
            if(sum == S){
                total++;
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return total;
    }
}