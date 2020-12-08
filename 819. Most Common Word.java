class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().replaceAll("\\W+"," ").split("\\s+");
        Set<String> banSet = new HashSet<>();
        for(String s: banned){
            banSet.add(s);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(String w: words){
            if(!banSet.contains(w)){
                map.put(w, map.getOrDefault(w,0)+1);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        
    }
}