import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    // Given a string s, find the length of the longest substring without repeating characters.
    //Store the character and the index of the character in the map
    //if the character is already in the map, then move the left pointer to the right of the character
    public int lengthOfLongestSubstring(String s) {

        int left = 0 ; int maxlength = 0 ; 
        Map<Character,Integer> hash = new HashMap<>();

        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            if(hash.containsKey(c)){
                left = Math.max(left, hash.get(c)+1);
            }
            hash.put(c,right);
            maxlength = Math.max(maxlength,right - left + 1 );
        }

        return maxlength;
        
    }
}
