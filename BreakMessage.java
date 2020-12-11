// Write a function that takes a big message and splits it into minimum number of smaller messages adhering to given limit. 
// While splitting the function should not split a word into two messages. In the output messages please add tag ( x/y ). 
// The total length (including the tag) should not exceed 160.

import java.util.HashMap;
class breakMessage {
    public String[] breakMessage(String message, int size) {
        
        HashMap<String, Integer> map = new HashMap<>();
        String[] messages = message.split();
        int number = 0;
        String currentMessage = "";
        for(String m: messages){
            String tempString = currentMessage + " " + m;
            if(tempString.length() > size){
                map.put(currentMessage, number);
                number++;
                currentMessage = m;
            }
            else {
                currentMessage += " "+ m;
            }
        }
        String[] res = new String[map.size()];
        int i = 0;
        for (String m: map.keySet()){
            res[i] = m;
            i++;
        }
        return res;
    }
}
