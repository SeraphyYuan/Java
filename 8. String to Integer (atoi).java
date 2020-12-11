class Solution {
    public int myAtoi(String s) {
        int base = 0;
        int i = 0;
        int sign = 1;
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        if(i >= s.length()){
            return 0;
        }
        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            if(base > Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && (s.charAt(i)-'0') > 7)){
                if(sign == 1){
                    return Integer.MAX_VALUE;
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }
            else {
                base = s.charAt(i) -'0' + base * 10;
                i++;
            }
        }
        return sign*base;
    }
}