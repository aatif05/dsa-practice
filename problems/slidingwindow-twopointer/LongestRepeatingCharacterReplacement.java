import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        int length = s.length();
        int l = 0;
        int maxlength = 0;
        int maxfreq = 0;

        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);

            count.put(ch, count.getOrDefault(ch, 0) + 1);
            maxfreq = Math.max(maxfreq, count.get(ch));

            //(i - l + 1) - maxfreq is number of changes 
            while ((i - l + 1) - maxfreq > k) {
                char leftChar = s.charAt(l);
                count.put(leftChar, count.get(leftChar) - 1);

                l++;
            }

            maxlength = Math.max(maxlength, i - l + 1);
        }

        return maxlength;
    }
}
