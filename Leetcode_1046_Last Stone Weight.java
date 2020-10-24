import java.util.PriorityQueue;
class Leetcode_1046 {
    public static void main(String[] args) {
        int [] stones = {2,7,4,1,8,1};
        int result = lastStoneWeight(stones);
        System.out.println("result = " + result);
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int stone: stones){
            maxHeap.add(-stone);
        }
        while(maxHeap.size() >1){
            int stoneOne = -maxHeap.poll();
            int stoneTwo = -maxHeap.poll();
            if(stoneOne != stoneTwo){
                maxHeap.add(-(stoneOne-stoneTwo));
            }
        }
        if(maxHeap.size() ==1){
            return -maxHeap.poll();
        }
        else{
            return 0;
        }
    }
}