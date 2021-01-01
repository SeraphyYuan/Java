class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        //Pair: (y-x, x)
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b)->(a.getKey() == b.getKey() ? a.getValue()-b.getValue() : b.getKey()-a.getKey()));
        int res = Integer.MIN_VALUE;
        for (int[] point: points) {
            while(!pq.isEmpty() && point[0] - pq.peek().getValue() > k){
                pq.poll();
            }
            int x = point[0];
            int y = point[1];
            if(!pq.isEmpty()){   
                int equationResult = pq.peek().getKey() + x + y;
                res = Math.max(res, equationResult);
            }
            pq.offer(new Pair<>(y-x, x));
        }
        return res;
    }
}