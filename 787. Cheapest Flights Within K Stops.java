class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
          //Build graph -> source, [end, cost]
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] flight: flights){
            int s = flight[0];
            int e = flight[1];
            int price = flight[2];
            if(!prices.containsKey(s)){
                prices.put(s, new HashMap<>());
            }
            prices.get(s).put(e, price);
        }
        //int[] in priority queue store: cost, src, k
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.add(new int[]{0, src, K});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int currNode = curr[1];
            int k = curr[2];
            if(currNode == dst){
                return cost;
            }
            if(k >= 0){
                Map<Integer, Integer> nexts = prices.getOrDefault(currNode, new HashMap<>());
                for (int nextStop: nexts.keySet()){
                    int nextStopCost = nexts.get(nextStop);
                    pq.add(new int[]{cost+nextStopCost, nextStop, k-1});
                }
            }
        }
        return -1;
    }
}