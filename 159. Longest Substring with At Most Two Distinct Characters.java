class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < s.length()){
           if(map.size() <=2 ){
               char c = s.charAt(j);
               map.put(c, j);
               j++;
           }
            if(map.size() > 2) {
                int leftMost = s.length();
                for(int index: map.values()){
                    leftMost = Math.min(leftMost, index);
                }
                char c = s.charAt(leftMost);
                map.remove(c);
                i = leftMost + 1;
            }
            max = Math.max(max, j - i );
        }
        return max;
    }
}