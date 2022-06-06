public class Solution {
    public void wiggleSort(int[] nums) {
        int[] bucket = new int[5010];
        for (int n : nums) {
            bucket[nums]++;
        }
        int len = nums.length;

        int small, big; // boundary
        // total length is odd: s b s b s
        // total length is even: s b s b
        if ((len & 1) == 1) {
            small = len - 1;
            big = len - 2;
        } else {
            small = len - 2;
            big = len - 1;
        }

        int j = 5009;
        for (int i = 1; i <= big; i++) {
            while (bucket[j] == 0) j--;
            nums[i] = j;
            bucket[j]--;
        }

        for (int i = 0; i <= small; i++) {
            while (bucket[j] == 0) j--;
            nums[i] = j;
            bucket[j]--;
        }
    }
  
}