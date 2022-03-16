class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int n : pushed) {
            stack.push(n);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}