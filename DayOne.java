import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

class DayOne {

    public static void main(String[] args) {
        HashSet<Integer> records = processFile();
        int targetSum = 2020;
        
        firstPart(records, targetSum);
        secondPart(records, targetSum);
    }

    private static void firstPart(HashSet<Integer> records, int targetSum){
        int[] twoNumbers = findTwoNumsMatchTargetSum(records, targetSum);
        int result = getMultiplicationResultFromNumbers(twoNumbers);
        System.out.println("result is for two numbers "+result);
    }

    private static void secondPart(HashSet<Integer> records, int targetSum){
        int[] threeNumbers = findThreeNumsMatchTargetSum(records, targetSum);
        int result2 = getMultiplicationResultFromNumbers(threeNumbers);
        System.out.println("result is for three numbers "+result2);
    }

    

    private static HashSet<Integer> processFile() {
        HashSet<Integer> nums = new HashSet<>();
        try {
            File myObj = new File("DayOneInput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              int num = Integer.parseInt(data);
              nums.add(num);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return nums;
    }

    private static int[] findTwoNumsMatchTargetSum(HashSet<Integer>records, int targetSum) {
        int [] result = new int[2];
        for(int number: records){
            int reminder = targetSum - number;
            System.out.println("number/reminder =" + number + "/" + reminder);
            if(records.contains(reminder)){
                System.out.println("Find a pair");
                result[0] = number;
                result[1] = reminder;
                break;
            }
        }
        return result;
    }

    private static int[] findThreeNumsMatchTargetSum(HashSet<Integer>records, int targetSum){
        int[] result = new int[3];
        for(int n1: records){
            for(int n2: records){
                int reminder = targetSum - (n1 + n2);
                System.out.println("n1/n2/reminder =" + n1 + "/"+  n2 + "/" + reminder);
                if(records.contains(reminder)){
                    System.out.println("Find three numbers");
                    result[0] = n1;
                    result[1] = n2;
                    result[2] = reminder;
                    break;
                }
            }
        }
        return result;
    }

    private static int getMultiplicationResultFromNumbers(int[] numbers){
        int result = 1;
        for (int number: numbers) {
            result *=  number;
        }
        
        return result;
    }
}