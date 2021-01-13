class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time: times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        //distance, node into pq
        //int[0] = distance;
        //int[1] = node;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> (a[0]-b[0]));
        pq.add(new int[]{0, K});
        
        boolean[] visited = new boolean [N+1];
        int res = 0;
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDist = current[0];
            int currNode = current[1];
            
            if(visited[currNode]){
                continue;
            }
            visited[currNode] = true;
            res = currDist;
            N--;
            if(map.containsKey(currNode)){
                for(int next: map.get(currNode).keySet()){
                    pq.add(new int[]{currDist+ map.get(currNode).get(next), next});
                }
            }
        }
        return N==0? res: -1;
    }
}