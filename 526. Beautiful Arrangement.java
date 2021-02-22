class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        helper(1, n, visited);
        return count;
    }
    
    public void helper (int index, int n, boolean[] visited){
        if(index > n){
            count++;
            return;
        }
        for(int i = 1; i <=n; i++){
            if(!visited[i] && (i%index == 0 || index %i ==0)){
                visited[i] = true;
                helper(index+1, n, visited);
                visited[i] = false;
            }
        }
    }
}