class Solution {
    public int minFlips(int[][] mat) {
        int step = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[] flatmap = new int[m*n];
        for(int i =0 ; i < m; i++){
            for(int j = 0; j <n ; j++){
                flatmap[i*n+j] = mat[i][j];
            }
        }
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(flatmap);
        visited.add(Arrays.toString(flatmap));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                if(isAllZero(curr)){
                    return step;
                }
                List<int[]> stops = generateStops(curr, m, n);
                for(int[] stop: stops){
                    String s = Arrays.toString(stop);
                    if(!visited.contains(s)){
                        q.add(stop);
                        visited.add(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }
   
    
    public List<int[]> generateStops(int[] temp, int m, int n){
        List<int[]> list = new ArrayList<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < m; i++){
            for(int j =0; j < n; j++) {
                int[] copy = Arrays.copyOf(temp, m*n);
                copy[i*n+j] ^= 1;
                for(int[] dir: dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x < 0 || x >= m || y < 0 || y >=n){
                        continue;
                    }
                    copy[x*n+y] ^= 1;

                }
                list.add(copy);
            }
            
        }
        return list;
    }
    
     
    public boolean isAllZero(int[] temp){
        int len = temp.length;
        for(int k = 0; k < len; k++){
            if(temp[k] == 1){
                return false;
            }
        }
        return true;
    }
}