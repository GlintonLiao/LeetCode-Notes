class Solution {
public:
    int lengthOfLastWord(string s) {
        int j = s.size() - 1;
        while (j >= 0 && s[j] == ' ') j--;
        int i = j - 1;
        while (i >= 0 && s[i] != ' ') i--;
        return j - i;
    }
};