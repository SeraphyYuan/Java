class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] hash = new int[26];
        int len = s.length();
        for(int i=0; i<len; i++){
            hash[s.charAt(i)-'a']++;
        }
        boolean fullString = true;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(hash[c-'a'] > 0 && hash[c-'a']<k){
                fullString = false;
            }
        }
        if(fullString){
            return s.length();
        }
        int start = 0;
        int end = 0;
        int result = 0;
        while(end < len){
            char c = s.charAt(end);
            if(hash[c-'a'] < k){
                String subString = s.substring(start, end);
                result = Math.max(result, longestSubstring(subString, k));
                start = end + 1;
            }
            end++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}