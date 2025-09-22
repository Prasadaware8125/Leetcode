import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Find maximum frequency
        int maxFreq = 0;
        for (int f : freqMap.values()) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Sum all occurrences of elements that have max frequency
        int total = 0;
        for (int f : freqMap.values()) {
            if (f == maxFreq) {
                total += f;
            }
        }

        return total;
    }
}
