class Solution {
    private Set<Integer> col = new HashSet<>();
    private Set<Integer> dia1 = new HashSet<>();
    private Set<Integer> dia2 = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(n, res, new ArrayList<>(), 0);
        return res;
    }
    
    public void dfs(int n, List<List<String>> res, List<String>currList, int row) {
        if(row == n) {
            res.add(new ArrayList<>(currList));
            return;
        }
        for(int i=0; i<n; i++){
            if(col.contains(i) || dia1.contains(row+i) || dia2.contains(row-i)) {
                continue;
            }
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            col.add(i);
            dia1.add(row+i);
            dia2.add(row-i);
            String rowString = new String(charArray);
            currList.add(rowString);
            
            dfs(n, res, currList, row+1);
            currList.remove(currList.size()-1);
            col.remove(i);
            dia1.remove(row+i);
            dia2.remove(row-i);
        }
    }
}