import java.util.Set;

class Solution {
    private static final Set<Character> VOWELS = Set.of(
        'a', 'e', 'i', 'o', 'u',
        'A', 'E', 'I', 'O', 'U'
    );

    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        
        // Suffix of 'a's that grows per word index
        StringBuilder aSuffix = new StringBuilder("a");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);

            if (VOWELS.contains(firstChar)) {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(firstChar);
            }

            result.append("ma").append(aSuffix);

            if (i < words.length - 1) {
                result.append(" ");
            }

            aSuffix.append('a');
        }

        return result.toString();
    }
}