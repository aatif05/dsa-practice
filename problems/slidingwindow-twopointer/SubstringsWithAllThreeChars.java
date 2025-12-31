import java.util.HashMap;
import java.util.Map;

public class SubstringsWithAllThreeChars {

    public int numberOfSubstrings(String s) {
        int l = s.length();
        int count = 0;
        int left= 0 ;
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0 ; i < l ; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
            while(map.size()==3){
                count = count + l - i; //Since the window already contains 3 characters, we can count all the substrings that can be formed with the current character as the rightmost character.
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
        }
        return count;
        
    }
}
