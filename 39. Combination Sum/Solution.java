import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.lang.model.element.Element;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i += 1) {
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, remain - nums[i], i);  // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
