class Solution {
    public int[] sortEvenOdd(int[] nums) {
        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> even = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0)
                even.offer(nums[i]);
            else
                odd.offer(nums[i]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) 
                nums[i] = even.poll();
            else
                nums[i] = odd.poll();
        }
        return nums;
    }
}
