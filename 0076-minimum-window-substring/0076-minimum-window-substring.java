import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> targetCounts = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCounts.put(c, targetCounts.getOrDefault(c, 0) + 1);
        }

        
        Map<Character, Integer> windowCounts = new HashMap<>();
        
        int left = 0, right = 0;
        int requiredUniqueChars = targetCounts.size();
        int formedUniqueChars = 0;
        
        int[] minWindowMetrics = {-1, 0, 0};

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowCounts.put(rightChar, windowCounts.getOrDefault(rightChar, 0) + 1);

            if (targetCounts.containsKey(rightChar) && 
                windowCounts.get(rightChar).equals(targetCounts.get(rightChar))) {
                formedUniqueChars++;
            }

            while (left <= right && formedUniqueChars == requiredUniqueChars) {
                char leftChar = s.charAt(left);

                int currentWindowLength = right - left + 1;
                if (minWindowMetrics[0] == -1 || currentWindowLength < minWindowMetrics[0]) {
                    minWindowMetrics[0] = currentWindowLength;
                    minWindowMetrics[1] = left;
                    minWindowMetrics[2] = right;
                }

               
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                
                
                if (targetCounts.containsKey(leftChar) && 
                    windowCounts.get(leftChar) < targetCounts.get(leftChar)) {
                    formedUniqueChars--;
                }
                
                left++;
            }
            right++;
        }

        return minWindowMetrics[0] == -1 ? "" : s.substring(minWindowMetrics[1], minWindowMetrics[2] + 1);
    }
}
