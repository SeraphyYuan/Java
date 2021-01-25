class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        //Sort all the tree in pq, from low to high
        // use BFS search find the shortest path from tree1 to tree2
        int m = forest.size();
        int n = forest.get(0).size();
        //x, y, treeHeight 
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        pq.offer(new int[]{0,0,-1});
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(forest.get(i).get(j) > 1) {
                    pq.offer(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        
        int steps = 0;
        int[] pre = new int[]{0,0,-1};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int step = minStep(forest, m, n, pre, curr);
            pre = curr;
            if(step < 0) {
                return -1;
            }
            steps += step; 
        }
        return steps;
    }
    
    public int minStep(List<List<Integer>> forest, int m, int n, int[] source, int[] dest) {
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        visited[source[0]][source[1]] = 1;
        queue.offer(new int[]{source[0], source[1]});
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                if(curr[0] == dest[0] && curr[1] == dest[1]){
                    return step;
                }
                for(int[] dir: dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x >= 0 && x < m && y >=0 && y < n && forest.get(x).get(y) != 0 && visited[x][y] == 0){
                        queue.offer(new int[]{x,y});
                        visited[x][y] = 1;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}