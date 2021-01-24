class Solution {
    public int trapRainWater(int[][] heightMap) {
        int result = 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] dirs = {{1,0},{-1,0}, {0,1}, {0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0; i <m; i++){
            for (int j = 0; j < n; j++){
                if(i == 0 || i == m-1 ||j==0 || j == n -1){
                    pq.add(new int[]{heightMap[i][j], i, j});
                    heightMap[i][j] = -1;
                }
            }
        }
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            for(int[] dir: dirs){
                int h = curr[0];
                int x = curr[1] + dir[0];
                int y = curr[2] + dir[1];
                if(x >= m || x < 0 || y >= n || y < 0 || heightMap[x][y] == -1){
                    continue;
                }
                int newHeight = heightMap[x][y];
                result += Math.max(0, h - newHeight);
                int[] next = {Math.max(h, newHeight), x, y};
                pq.add(next);
                heightMap[x][y] = -1;
            }
        }
        return result;
    }
}