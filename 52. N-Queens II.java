class Solution {
    private Set<Integer> col = new HashSet<>();
    private Set<Integer> dia1 = new HashSet<>();
    private Set<Integer> dia2 = new HashSet<>();
    public int totalNQueens(int n) {
        return dfs(n, 0, 0);
    }
    
    public int dfs(int n, int count, int row){
        if(row == n) {
            count++;
        }
        for(int i = 0; i<n; i++) {
            if(col.contains(i) || dia1.contains(row+i) || dia2.contains(row-i)){
                continue;
            }
            col.add(i);
            dia1.add(row+i);
            dia2.add(row-i);
            count = dfs(n,count, row+1);
            col.remove(i);
            dia1.remove(row+i);
            dia2.remove(row-i);
        }
        return count;
    }
}