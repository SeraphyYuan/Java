class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, n, n, res, new ArrayList<>(), 1);
        return res;
    }
    
    public void dfs(int k, int target, int reminder, List<List<Integer>> res, List<Integer>temp, int start){
        if(reminder == 0 && temp.size() == k){
            res.add(new ArrayList<>(temp));
        }
        else if(reminder < 0){
            return;
        }
        else {
            for(int i = start; i <= 9; i++){
                temp.add(i);
                dfs(k, target, reminder - i, res, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}