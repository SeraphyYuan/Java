class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()){
            return "0";
        }
        int length = num.length();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< length; i++){
            int curr = num.charAt(i) - '0';
            while(k>0 &!stack.isEmpty() && stack.peek() > curr){
                stack.pop();
                k--;
            }
            stack.push(curr);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        result.reverse();
        while(result.length() > 1 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}