class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int num = 0;
        int result = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                 num = num*10 + (int)(c-'0');
            }
            else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }
            else if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if(c==')'){
                result += sign * num;
                num = 0;
                result *= stack.pop(); // pop sign before parenthesis
                result += stack.pop();   // pop temp result before parenthesis
            }
        }
        if(num != 0){
            result += num * sign;
        }
        return result;
    }
}