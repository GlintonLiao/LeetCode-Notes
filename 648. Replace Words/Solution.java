class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort((a, b) -> a.length() - b.length());
        String[] words = sentence.split("\\s+");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (String root : dictionary) {
                if (word.startsWith(root)) {
                    words[i] = root;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }
}