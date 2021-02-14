class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, target, 0, res, new ArrayList<>());
        return res;
    }
    
    public void dfs(int[] can, int target, int remain, int start, List<List<Integer>> res, List<Integer>temp) {
        if(remain < 0){
            return;
        }
        else if(remain == 0){
            res.add(new ArrayList<>(temp));
        }
        else {
            for (int i = start; i < can.length; i++){
                if(i > start && can[i] == can[i-1]){
                    continue;
                }
                temp.add(can[i]);
                
                dfs (can, target, remain-can[i], i+1, res, temp);
                
                temp.remove(temp.size()-1);
            }
        }
    }
}