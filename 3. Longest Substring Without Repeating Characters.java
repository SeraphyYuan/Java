class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0; int j = 0;
        int max = 0;
        while(j < s.length()){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i++));
            }
            else {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
}