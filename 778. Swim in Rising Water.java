class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int waitTime = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        pq.add(new int[]{grid[0][0], 0, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            waitTime = Math.max(waitTime, curr[0]);
             if(curr[1] == n-1 && curr[2] == n-1){
                return waitTime;
            }
            for (int i = 0; i < 4; i++){
                int x = curr[1]+ dir[i][0];
                int y = curr[2]+ dir[i][1];
                if(x >= n || x < 0 || y >= n || y < 0){
                    continue;
                }
                if(!visited[x][y]){
                    pq.add(new int[]{grid[x][y], x, y});
                    visited[x][y] = true;
                }
            }
           
        }
       return waitTime;
        
    }
}