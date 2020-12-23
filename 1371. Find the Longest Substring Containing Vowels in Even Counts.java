class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> bitMap = new HashMap<>();
        bitMap.put('a', 1);
        bitMap.put('e', 2);
        bitMap.put('i', 4);
        bitMap.put('o', 8);
        bitMap.put('u', 16);
        
        HashMap<Integer, Integer> stateToIndex = new HashMap<>();
        stateToIndex.put(0, -1);
        int state = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(bitMap.containsKey(c)){
                int bitToFlip = bitMap.get(c);
                state ^= bitToFlip;
            }
            if(!stateToIndex.containsKey(state)){
                stateToIndex.put(state, i);
            }
            result = Math.max(result, i - stateToIndex.get(state));
        }
        return result;
        
    }
}