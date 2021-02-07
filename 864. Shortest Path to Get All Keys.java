class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0,1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length();
        int si = -1;
        int sj = -1;
        int k = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                char c = grid[i].charAt(j);
                if(c == '@'){
                    si = i;
                    sj = j;
                }
                if(isKey(c)) {
                    k++;
                }
            }
        }
        Node startNode = new Node(si, sj, 0);
        Queue<Node> q = new LinkedList<>();
        q.offer(startNode);
        Set<String> visited = new HashSet<>();
        visited.add(si+" " + sj + " "+ 0);
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                Node curr = q.poll();
                if(curr.key == (1<<k)-1) {
                    return steps;
                }
                for(int[] dir: dirs){
                    int x = curr.i + dir[0];
                    int y = curr.j + dir[1];
                    int key = curr.key;
                    if(x >=m || x<0 || y >=n || y <0 || grid[x].charAt(y) == '#'){
                        continue;
                    }
                    char c = grid[x].charAt(y);
                    if(isLock(c) && (key >>(c-'A')&1) == 0){
                        continue;
                    }
                    if(isKey(c)){
                        key |= (1 << (c-'a'));
                    }
                    if(visited.add(x+" "+ y +" "+ key)){
                        q.offer(new Node(x, y, key));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    public boolean isKey(char c){
        return c >='a' && c<='f';
    }
    
    public boolean isLock(char c){
        return c >= 'A' && c <= 'F';
    }
    
    class Node {
        int i,j, key;
        public Node(int i, int j, int key){
            this.i = i;
            this.j = j;
            this.key = key;
        }
    }
}