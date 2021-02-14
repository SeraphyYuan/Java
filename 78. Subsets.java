class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>>res, List<Integer>temp, int[]nums, int start){
        res.add(new ArrayList<>(temp));
        for(int i=start; i< nums.length; i++){
            temp.add(nums[i]);
            dfs(res, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}