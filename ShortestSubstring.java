import java.util.*;

public class ShortestSubstring {
    public static int shortestSubstringLength(String s) {
        // Step 1: Get all unique characters
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        int required = uniqueChars.size();

        // Step 2: Sliding window
        Map<Character, Integer> windowCounts = new HashMap<>();
        int left = 0, formed = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (windowCounts.get(c) == 1) { // newly added unique char
                formed++;
            }

            // Shrink window until it's invalid
            while (formed == required && left <= right) {
                minLen = Math.min(minLen, right - left + 1);
                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (windowCounts.get(leftChar) == 0) {
                    formed--;
                }
                left++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "dabbcabcd";
        System.out.println(shortestSubstringLength(s1)); // Output: 4

        // Example 2
        String s2 = "asdfkjeghfalawefhaef";
        System.out.println(shortestSubstringLength(s2)); // Output: 13
    }
}
