/**
 * @param {number[]} nums
 * @return {number[][]}
 */

 var permute = function(nums) {
  let candidate = []
  let result = []
  
  dfs(nums, candidate, result)
  return result;
};

var dfs = function(nums, candidate, result) {
  if (candidate.length == nums.length) {
      result.push([...candidate])
      return
  }
  
  for (let i = 0; i < nums.length; i++) {
      if (!candidate.includes(nums[i])) {
          candidate.push(nums[i])
          dfs(nums, candidate, result)
          candidate.pop()
      }
  }
}
