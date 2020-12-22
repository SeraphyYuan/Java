class Solution {
    public int longestOnes(int[] A, int K) {
        int result = Integer.MIN_VALUE;
        if(A == null || A.length == 0){
            return 0;
        }
        int slowPoint = 0;
        int zeroCount = 0;
        for(int i = 0; i<A.length; i++){
            if(A[i] == 0){
                zeroCount++;  // move forward slowPointer, if current is 0, increase the zeroCount
            }
            // when current window has more than K, the window is not valid any more
            // we need to loop the slow pointer until the current window is valid
            while(zeroCount > K){
                if(A[slowPoint] == 0){
                    zeroCount--;
                }
                slowPoint++;
            }
            result = Math.max(result, i-slowPoint+1);
        }
        return result;
    }
}