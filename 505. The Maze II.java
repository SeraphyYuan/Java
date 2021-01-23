class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        //int[] store steps, x position , y position
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
        pq.add(new int[]{0, start[0], start[1]});
        int[][] distance = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currSteps = curr[0];
            int currX = curr[1];
            int currY = curr[2];
            if(currX == destination[0] && currY == destination[1]){
                return currSteps;
            }
            if (visited[currX][currY]) continue;
            visited[currX][currY] = true;
            for(int[] dir: dirs){
                currSteps = curr[0];
                currX = curr[1];
                currY = curr[2];
                while(currX >=0 && currX < m && currY >=0 && currY < n && maze[currX][currY] == 0){
                    currX += dir[0];
                    currY += dir[1];
                    currSteps++;
                }
                currX -= dir[0];
                currY -= dir[1];
                currSteps--;
                if(distance[currX][currY] == 0 ||distance[currX][currY] > currSteps){
                    distance[currX][currY] = currSteps;
                    pq.add(new int[]{currSteps, currX, currY});
                }
               
                
            }
        }
        return -1;
    }
}