class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        Set<String> bSet = new HashSet<>();
        Set<String> eSet = new HashSet<>();
        bSet.add(beginWord);
        eSet.add(endWord);
        int step = 1;
        HashSet<String> visited = new HashSet<String>();
        while(!bSet.isEmpty() && !eSet.isEmpty()){
            if(bSet.size() > eSet.size()){
                Set<String> set = bSet;
                bSet = eSet;
                eSet = set;
            }
            
            Set<String> temp = new HashSet<>();
            for(String word: bSet){
                char[] cArray = word.toCharArray();
                for(int i = 0; i < cArray.length; i++){
                    for(char t='a'; t<='z';t++){
                        char old = cArray[i];
                        cArray[i] = t;
                        String target = String.valueOf(cArray);
                        if(eSet.contains(target)){
                            return step+1;
                        }
                        if(!visited.contains(target) && dict.contains(target)){
                            visited.add(target);
                            temp.add(target);
                        }
                        cArray[i] = old;
                    }
                }
            }
            bSet = temp;
            step++;
        }
        return 0;
    }
}