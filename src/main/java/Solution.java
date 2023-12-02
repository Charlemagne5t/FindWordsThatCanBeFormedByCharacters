import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < chars.length(); i++){
            char ch = chars.charAt(i);
            int count = map.getOrDefault(chars.charAt(i), 0);
            count++;
            map.put(ch, count);
        }
        int sumLength = 0;
        for(String word : words){
            if(backtrack(map, word, 0)){
                sumLength += word.length();
            }
        }
        return sumLength;
    }
    private boolean backtrack(Map<Character, Integer> map, String word, int j){
        if(j == word.length()){
            return true;
        }
        char ch = word.charAt(j);
        boolean result = false;
        if(map.getOrDefault(ch, 0) > 0){
            int count = map.get(ch);
            count--;
            map.put(ch, count);
            result = backtrack(map, word, j + 1);
            int countBack  = map.get(ch);
            countBack++;
            map.put(ch, countBack);
        }
        return result;
    }
}
