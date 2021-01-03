
// reference from this link: https://www.youtube.com/watch?v=B5fa989qz4U
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        LinkedList<Integer> q = new LinkedList<>();
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(i > k && q.peekFirst() == i-k-1){
                q.pollFirst();
            }
            dp[i] = (q.isEmpty() ? 0: (Math.max(dp[q.peekFirst()], 0))) + nums[i];
            while(!q.isEmpty() && dp[i] > dp[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}