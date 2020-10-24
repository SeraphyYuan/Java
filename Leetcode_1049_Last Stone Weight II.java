class Leetcode_1049 {
   public static void main(String[] args) {
       int [] stones = {2,7,4,1,8,1};
       int result = lastStoneWeightII(stones);
       System.out.println("result = " + result);
   }
   public static int lastStoneWeightII(int[] stones) {
       int sum = 0;
       for (int stone: stones){
           sum+=stone;
       }
       boolean[] sumExist = new boolean[sum+1];
       sumExist[0] = true;
       for(int i=0; i<stones.length; i++){
           for(int j=sum/2; j>= stones[i]; j--){
               sumExist[j] = sumExist[j]||sumExist[j-stones[i]];
           }
       }
       for(int k=sum/2; k>=0; k--){
           if(sumExist[k]){
               return sum-k-k;
           }
       }
       return sum;
   }
}