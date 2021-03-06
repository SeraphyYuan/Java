class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int pre = 0;
        int[] result = new int[n];
        for(String log: logs){
            String[] arr = log.split(":");
            if(arr[1].equals("start")) {
                if(!stack.isEmpty()){
                    result[stack.peek()] += Integer.parseInt(arr[2]) - pre;
                }
                pre = Integer.parseInt(arr[2]);
                stack.push(Integer.parseInt(arr[0]));
            }
            else {
                result[stack.pop()] += Integer.parseInt(arr[2]) - pre + 1;
                pre = Integer.parseInt(arr[2]) + 1;
            }
        }
        return result;
    }
}