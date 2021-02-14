class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, res, target, new ArrayList<>(), 0, target);
        return res;
    }
    
    private void dfs(int[] can, List<List<Integer>>res, int target, List<Integer>tempList, int start, int remain) {
        if(remain == 0){
            res.add(new ArrayList<>(tempList));
        }
        else if(remain < 0) {
            return;
        } else {
             for(int i = start; i < can.length; i++){
                tempList.add(can[i]);

                dfs(can, res, target, tempList, i,remain - can[i]);

                tempList.remove(tempList.size()-1);
            }
        }
       
    }
}