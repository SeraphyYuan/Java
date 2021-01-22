class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        boolean [][] visited = new boolean[m][n];
        int[][] dirs = {{1,0}, {-1,0},{0,1},{0,-1}}; 
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            if(visited[curr[0]][curr[1]]){
                continue;
            }
            visited[curr[0]][curr[1]] = true;                   
            for(int[] dir: dirs){
                int x = curr[0];
                int y = curr[1];
                while(x >=0 && x < m && y>=0 && y < n && maze[x][y] == 0){
                     x = x + dir[0];
                     y = y + dir[1];
                }
                // back to valid point
                x = x - dir[0];
                y = y - dir[1];
                q.add(new int[]{x,y});
            }
        }
        return false;
    }
}