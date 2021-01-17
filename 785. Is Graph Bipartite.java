class Solution {
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] color = new int[size];
        for (int i = 0; i < size; i++){
            Queue<Integer> q = new LinkedList<>();
            if(color[i] == 0){
                color[i] = 1;
                q.add(i);
                while(!q.isEmpty()){
                    int current = q.poll();
                    for(int next: graph[current]){
                        if(color[next] == 0){
                            color[next] = -color[current];
                            q.add(next);
                        }
                        else {
                            if(color[next] == color[current]){
                                return false;
                            }
                            else {
                                continue;
                            }
                        }
                    }
                }
            }
        
        }
        return true;
        
    }
}