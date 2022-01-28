/**
 * @param {number[]} nums
 * @return {number[][]}
 */
 var permuteUnique = function(nums) {
  if (nums.length === 1) return [nums];
  
  let result = []
  let candidate = []
  let st = new Array(nums.length).fill(0)
  nums.sort()
  
  dfs(nums, candidate, st, result)
  
  return result
};

var dfs = function(nums, candidate, st, result) {
  if (candidate.length === nums.length) {
      result.push([...candidate])
      return
  }
  
  for (let i = 0; i < nums.length; i++) {
      // cut the extra branches
      if (i > 0 && nums[i - 1] === nums[i] && st[i - 1] == 0) continue
      if (st[i] == 0) {
          st[i] = 1;
          candidate.push(nums[i])
          dfs(nums, candidate, st, result)
          st[i] = 0;
          candidate.pop();
      }
  }
}
