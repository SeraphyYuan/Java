class Solution {
    public String[] expand(String S) {
        String[] array = S.split("\\{|\\}");
        List<String> result = new ArrayList<>();
        dfs(result, array, 0, "");
        return result.toArray(new String[result.size()]);
    }

    private void dfs(List<String>res, String[] array, int curr, String word){
        if(curr >= array.length){
            res.add(word);
            return;
        }
        String[] possibilities = array[curr].split(",");
        Arrays.sort(possibilities);
        for(String s: possibilities){
            dfs(res, array, curr+1, word+s);
        }
    }
}