class Solution {
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] color = new int[size];
        for (int i =0; i< size; i++){
            Queue<Integer> q = new LinkedList<>();
            if(color[i] == 0){
                color[i] = 1;
                q.add(i);
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int neigh: graph[curr]){
                        if(color[neigh] == 0){
                            color[neigh] = -color[curr];
                            q.add(neigh);
                        }
                        else {
                            if(color[neigh] == color[curr]){
                                return false;
                            }
                            else{
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