class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }
        for(int i=0; i<nums1.length; i++){
            int num1 = nums1[i];
            int index = map.get(num1);
            if(index == nums2.length - 1){
                result[i] = -1;
            }
            else {
                result[i] = getNextBiggerNumber(index+1, nums2, num1);
            }
        }
        
        
        return result;
    }
    
    private int getNextBiggerNumber(int startIndex, int[] nums2, int num1){
        int result = -1;
        for(int i = startIndex; i<nums2.length; i++){
            if(nums2[i] > num1){
                result = nums2[i];
                break;
            }
        }
        return result;
    }
}

/**Better solution **/
class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
         Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
         Stack<Integer> stack = new Stack<>();
         for (int num : nums) {
             while (!stack.isEmpty() && stack.peek() < num)
                 map.put(stack.pop(), num);
             stack.push(num);
         }   
         for (int i = 0; i < findNums.length; i++)
             findNums[i] = map.getOrDefault(findNums[i], -1);
         return findNums;
     }
 }