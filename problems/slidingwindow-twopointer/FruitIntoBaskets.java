import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> count = new HashMap<>();
        int maxlength = 0;
        int l = 0;
        int k = 2; // k is the number of baskets you can have
        for (int i = 0; i < fruits.length; i++) {
            count.put(fruits[i], count.getOrDefault(fruits[i], 0) + 1);

            if (count.size() > k) { // this If can be used as while. 
                count.put(fruits[l], count.get(fruits[l]) - 1);
                if (count.get(fruits[l]) == 0) {
                    count.remove(fruits[l]);
                }
                l++;
            }
            if (count.size() <= k) {
                maxlength = Math.max(maxlength, i - l + 1);
            }

        }
        return maxlength;
    }
}
