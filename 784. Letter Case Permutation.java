class Solution {
    public List<String> letterCasePermutation(String S) {
         if (S == null) {
            return new LinkedList<>();
        }
        List<String> res = new ArrayList<String>();
        dfs(S.toCharArray(), 0, res);
        return res;
    }
    
    public void dfs(char[] a, int start, List<String>res){
        if(start == a.length){
            res.add(new String(a));
        }
        else {
            // if it is digits: go to next index, 
            //if it is letter: one option is nothing to change, go to next index, other option is change to its upper/lower case go to next index
             if(Character.isLetter(a[start])){
                a[start] = Character.toUpperCase(a[start]);
                dfs(a, start+1, res);
                a[start] = Character.toLowerCase(a[start]);
               
            }
             dfs(a, start+1, res);
        }
    }
}