class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int i = helperToGetAtMost(A, K);
        int j = helperToGetAtMost(A, K-1);
        return i-j;
    }
    
    private int helperToGetAtMost(int[] A, int K){
        if(A == null || A.length == 0){
            return 0;
        }
        int start = 0;
        int end = 0;
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<String> pairs = new ArrayList<>();
        while(end < A.length){
            int num = A[end];
            map.put(num, map.getOrDefault(num, 0)+1);
            end++;
            while(map.size() > K){
                int startNum = A[start];
                map.put(startNum, map.get(startNum)-1);
                if(map.get(startNum) == 0){
                    map.remove(startNum);
                }
                start++;
            }
            len += end - start + 1;
             
        }
        return len;
    }
}