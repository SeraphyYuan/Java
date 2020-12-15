class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number * 10 + (int)(c-'0');
            }
           if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==s.length()-1){
                if(sign == '+') {
                    stack.push(number);
                }
                if (sign== '-') {
                    stack.push(-number);
                }
                if(sign=='*') {
                    stack.push(stack.pop() * number);
                }
                if(sign=='/') {
                    stack.push(stack.pop()/number);
                }
                sign = s.charAt(i);
                number = 0;
            }
        }
        for(int i: stack){
            result += i;
        }
        return result;
    }
}