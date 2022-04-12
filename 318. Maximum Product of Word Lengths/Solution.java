class Solution {
	public static int maxProduct(String[] words) {
	    int n = words.length;
	    int[] value = new int[n];
	    for (int i = 0; i < n; i++) {
		    String tmp = words[i];
		    value[i] = 0;
		    for (int j = 0; j < tmp.length(); j++) {
			    value[i] |= 1 << (tmp.charAt(j) - 'a');
		    }
	    }
        
	    int res = 0;
	    for (int i = 0; i < n; i++)
		    for (int j = i + 1; j < n; j++) {
			    if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > res))
				    res = words[i].length() * words[j].length();
		    }
	    return res;
    }
}
