class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, nums, 0, new ArrayList<>());
        return res;
    }
    
    public void dfs(List<List<Integer>> res, int[]nums, int start, List<Integer>temp){
        res.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++){
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            dfs(res, nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}