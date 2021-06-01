import javax.lang.model.element.Element;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};
        int ptr = 0;
        boolean started = false;


        while (ptr < nums.length) {
            if (nums[ptr] == target && started == false) {
                range[0] = ptr;
                range[1] = ptr;
                ptr += 1;
                started = true;
            } else if (nums[ptr] != target && started == true) {
                range[1] = ptr - 1;
                ptr += 1;
                break;
            } else if (nums[ptr] == target && started == true) {
                range[1] = ptr;
                ptr += 1;
            } else {
                ptr += 1;
            }
        }

        return range;
    }
}
