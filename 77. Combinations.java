class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, res, new ArrayList<>(), 1);
        return res;
    }
    
    public void dfs(int n, int k, List<List<Integer>> res, List<Integer> tempList, int start){
        if(tempList.size() == k){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=start; i<=n; i++){
            if(tempList.contains(i)){
                continue;
            }
            tempList.add(i);
            dfs(n, k, res, tempList, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}