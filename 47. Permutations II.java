class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean [nums.length];
        dfs(res, used, nums, new ArrayList<>());
        return res;
    }
    
    public void dfs(List<List<Integer>>res, boolean[] used, int[]nums, List<Integer>temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        int preNum = nums[0]-1;
        for(int i=0; i<nums.length; i++){
            if(!used[i] && preNum != nums[i]){      // use this here to remove duplicated set
                used[i] = true;
                preNum = nums[i];
                temp.add(nums[i]);
                dfs(res, used, nums, temp);
                temp.remove(temp.size()-1);
                used[i] = false;
            }
        }
    }
    
    
}