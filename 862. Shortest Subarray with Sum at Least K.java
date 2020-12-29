class Solution {
    public int shortestSubarray(int[] A, int K) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] prefixSum = new int[A.length + 1];
        //when add 0 in front of preSum, then right pointer will get range sum that represent the actual range
        // when prefixSum[j]- prefix[i] == K, we can update result.
        for (int i = 0; i < A.length; i++){
            prefixSum[i+1] = prefixSum[i] + A[i]; 
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i <= A.length; i++){
            while(!q.isEmpty() && prefixSum[i] - prefixSum[q.peekFirst()] >= K){
                result = Math.min(result, i-q.pollFirst());
            }
            // if upcoming prefixSum is less than current last prefixSum, poll last element because we can have better candidate from upcoming prefixSum
            while(!q.isEmpty() && prefixSum[i] <= prefixSum[q.peekLast()]){
                q.pollLast();
            }
            q.offerLast(i);
        }
        return result == Integer.MAX_VALUE ? -1: result;
    }
}