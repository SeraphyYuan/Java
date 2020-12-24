class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0;
        int r = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            if(map.size() <= k){
                map.put(c, r);
                r++;
            }
            if(map.size() > k){
                int leftMost = s.length();
                for(int index: map.values()){
                    leftMost = Math.min(leftMost, index);
                }
                char charToBeRemove = s.charAt(leftMost);
                map.remove(charToBeRemove);
                l = leftMost + 1;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }
}