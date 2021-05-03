class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && c == ')' || !stack.isEmpty() && c == '}' || !stack.isEmpty() && c == ']'){
                if(stack.peek()-0 == c-1 ||  stack.peek()-0 == c-2){
                    stack.pop();
                    continue;
                }
                return false;
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
