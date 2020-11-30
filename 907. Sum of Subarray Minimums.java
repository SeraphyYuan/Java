class Solution {
    public int sumSubarrayMins(int[] arr) {
        /*
        我们考虑对于每个元素A[i]，如果以它作为最小值，那么这样的subarray能有多大？显然，我们找在i之前的第一个比A[i]小的数，
        比如说j；再找i之后第一个比A[i]小的数，比如说k，那么从[j+1,k-1]就是最大的subarray。
        并且，以任意[j+1,i]为左边界、任意[i,k-1]为右边界的subarray，也都是以A[i]为最小值。所以，以A[i]为最小的subarray的个数就有(i-j)*(k-i)个。
        
        这个问题可以变成球每个元素的next smaller element和previous smaller element.
      
        另外，特别注意：如果一个数没有next smaller element，那么意味着它的左边界是可以到n；
        如果一个数没有prev smaller/equal element，那么意味着它的左边界是可以到-1.
       
       */
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] left = new int[n];
        /** Explore left boundary **/
        for (int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = -1;
            }
            else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        
        int[] right = new int[n];
        /** Explore right boundary **/
        for(int i= n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = n;
            }
            else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        long result = 0;
        long mod = (long)1e9 + 7;
        for(int i = 0; i < n; i++){
             result += arr[i] * ((i-left[i]) * (right[i]-i) %mod);
             result = result % mod;
        }
        return (int)result;
    }
}