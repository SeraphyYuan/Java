class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int ans = 0;
        int low = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count[c-'a']++;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                ans += s.length() - i;
                low++;
                char charAtLowPointer = s.charAt(low);
                count[charAtLowPointer-'a']--;
            }
        }
        return ans;
    }
}