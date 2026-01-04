import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /**
     * Adding all the characters of t to the map.
     * Then we check if character from S is in the map, by reducing the count of the character in the map.
     * If count matches the length of t, we have found a valid window.
     * We try to reduce the window to find min length.
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = 0;
        int required = t.length();
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    count++;
                }
            }

            // Try to shrink window
            while (count == required) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                char lch = s.charAt(l);
                if (map.containsKey(lch)) {
                    map.put(lch, map.get(lch) + 1);
                    if (map.get(lch) > 0) {
                        count--;
                    }
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
