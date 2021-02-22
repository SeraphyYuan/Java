class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", 0, 0 ,n);
        return result;
    }
    
    public void helper(List<String> result, String currStr, int leftBracketCount, int rightBracketCount, int n){
        if(rightBracketCount == n){
            result.add(currStr);
        }
        if(leftBracketCount < n) {
            helper(result, currStr + "(", leftBracketCount+1, rightBracketCount, n);
        }
        if(leftBracketCount > rightBracketCount){
            helper(result, currStr+")", leftBracketCount, rightBracketCount+1, n);
        }
    }
}