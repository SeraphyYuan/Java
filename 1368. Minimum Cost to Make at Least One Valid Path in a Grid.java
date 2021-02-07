class Solution {
    public int minCost(int[][] grid) {
        int[][] dirs = new int[][] {{0,1},{0,-1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[m][n];
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int cost = curr[2];
            if(visited[x][y]){
                continue;
            }
            visited[x][y] = true;
            if(x == m -1 && y == n-1){
                return cost;
            }
            for(int i= 0; i <=3; i++){
                int dx = x + dirs[i][0];
                int dy = y + dirs[i][1];
                if(dx >= m || dx< 0 || dy >=n || dy < 0){
                    continue;
                }
                if(i+1 == grid[x][y]){
                    q.addFirst(new int[]{dx, dy, cost});
                }
                else {
                    q.addLast(new int[]{dx, dy, cost+1});
                }
            }
        }
        return -1;
        
    }
}