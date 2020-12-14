class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char currentChar = s.charAt(i);
            int currentCount = 1;
            if(stack.isEmpty()){
                stack.push(currentChar);
                count.push(currentCount);
            }
            else {
                if(stack.peek() == currentChar){
                    int lastCount = count.pop();
                    int updateCount = lastCount + currentCount;
                    if(updateCount == k){
                        stack.pop();
                    }
                    else {
                        count.push(updateCount);
                    }
                }
                else {
                    stack.push(currentChar);
                    count.push(currentCount);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            int times = count.pop();
            Character s1 = stack.pop();
            for(int i=1; i<=times; i++){
                sb.append(s1);
            }
        }
        String result = sb.reverse().toString();
        return result;
    }
}