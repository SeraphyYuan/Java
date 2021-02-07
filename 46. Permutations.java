class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums.length;
        boolean[] used = new boolean[m];
        dfs(res, used, nums, new ArrayList<>());
        return res;
    }
    
    public void dfs(List<List<Integer>> res, boolean used[], int[] nums, List<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            dfs(res, used, nums, temp);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
        
    }
    
    
}