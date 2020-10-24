import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

class Leetcode_805 {
    public static void main(String[] args) {
        int [] A = {1,2,3,4,5,6,7,8};
        boolean result = splitArraySameAverage(A);
        System.out.println("Result = " + result);
    }
    public static boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        int length = A.length;
        for(int a: A){
            sum += a;
        }
        if(!isPossible(sum, length)){
            return false;
        }
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i<=length/2; i++){
            list.add(new HashSet<>());
        }
        list.get(0).add(0);
        for(int num : A){
            for(int i=list.size()-1; i>0; i--){
                if(list.get(i-1).size() > 0){
                    for(int s: list.get(i-1)){
                        list.get(i).add(s+num);
                    }
                }
            }
        }
        for(int i=1; i<list.size(); i++){
            if(sum * i % length == 0 && list.get(i).contains(sum*i/length)){
                return true;
            }
        }
        return false;
    }
    
    private static boolean isPossible(int sum, int length){
        for(int i=0; i < length; i++){
            if(sum *i % length == 0){
                return true;
            }
        }
        return false;
    }
}