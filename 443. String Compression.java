class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        int index = 0;
        while(index < chars.length){
            int count = 0;
            char curr = chars[index];
            while(index < chars.length && curr == chars[index]){
                count++;
                index++;
            }
            chars[ans] = curr;
            ans++;
            if(count != 1){
                String countString = Integer.toString(count);
                for(char c: countString.toCharArray()){
                    chars[ans++] = c;
                }
            }
        }
        return ans;
    }
}