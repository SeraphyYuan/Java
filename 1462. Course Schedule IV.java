class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];
        Map<Integer, Set<Integer>> preReq = new HashMap<>();
        for (int i = 0; i < n; i++){
            preReq.put(i, new HashSet<>());
            map.put(i, new HashSet<>());
        }
        
        for (int[] pre: prerequisites) {
            int c1 = pre[0];
            int c2 = pre[1];
            indegree[c2]++;
            map.get(c1).add(c2);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i= 0; i< n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int c = queue.poll();
            Set<Integer> set = map.get(c);
            for (int next : set) {
                preReq.get(next).add(c);
                preReq.get(next).addAll(preReq.get(c));
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query: queries){
            int start = query[0];
            int end = query[1];
            boolean temp = preReq.get(end).contains(start);
            result.add(temp);
        }
        return result;
    }
}