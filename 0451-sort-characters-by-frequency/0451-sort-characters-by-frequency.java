import java.util.Arrays; //For Array Decleration

class Solution {
    public String frequencySort(String s) {
        final int ALPHABET = 128;

        int[] freq = new int[ALPHABET];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        int[] packed = new int[ALPHABET];
        for (int c = 0; c < ALPHABET; c++) {
            packed[c] = (freq[c] << 7) | c;
        }
        Arrays.sort(packed);

        StringBuilder sb = new StringBuilder(s.length());
        for (int i = ALPHABET - 1; i >= 0; i--) {   
            int f = packed[i] >>> 7;
            if (f == 0) break;                      
            char c = (char) (packed[i] & 0x7F);
            for (int j = 0; j < f; j++) sb.append(c);
        }
        return sb.toString();
    }
}