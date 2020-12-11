import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class DayTwo {
    public static void main(String[] args) {
        ArrayList<String> inputs = processFile();
        int result = getValidPasswordCount(inputs);
        System.out.println("Valid password count "+ result);
    }

    public static int getValidPasswordCount(ArrayList<String> inputs){
        int count = 0;
        for (String data: inputs){
           MyPassword myPassword = construckMyPassword(data);
           if(myPassword.isPasswordValidRule2()){
                count++;
           }
        }
        return count;
    }

    private static MyPassword construckMyPassword(String data){
        String[] list = data.split(" ");
        String minMax = list[0];
        char requiredChar = list[1].charAt(0);
        String candidate = list[2];
        String[] minMaxList = minMax.split("-");
        int min = Integer.parseInt(minMaxList[0]);
        int max = Integer.parseInt(minMaxList[1]);
        System.out.println("Min/Max/Required/Candidate = " + min + "/"+max+"/" +requiredChar + "/"+ candidate);
        MyPassword myPassword = new MyPassword(min, max, requiredChar, candidate);
        return myPassword;
    }

    private static ArrayList<String> processFile() {
        ArrayList<String> inputs = new ArrayList<>();
        try {
            File myObj = new File("DayTwoInput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              inputs.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          return inputs;
    }
}

