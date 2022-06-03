class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        Deque<Integer> stack = new LinkedList<>();
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry += arr1[i--];
            if (j >= 0) carry += arr2[j--];
            stack.push(carry & 1);
            carry = -(carry >> 1);
        }
        
        while (!stack.isEmpty() && stack.peek() == 0) stack.pop();
        
        if (stack.isEmpty()) return new int[]{0};
        
        int[] res = new int[stack.size()];
        int idx = 0;
        
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }
        
        return res;
    }
}
