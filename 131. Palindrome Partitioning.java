class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, s, 0, new ArrayList<>());
        return res;
    }
    
    public void helper(List<List<String>>res, String s, int pos, List<String> temp){
        if(pos == s.length()){
            res.add(new ArrayList<>(temp));
        }
        else {
            for(int i = pos; i<s.length(); i++){
                if(isPalindrome(s, pos, i)){
                    temp.add(s.substring(pos, i+1));
                    helper(res, s, i+1, temp);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    
    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}