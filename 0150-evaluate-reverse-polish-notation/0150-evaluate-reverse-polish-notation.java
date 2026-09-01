import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();
        int s=0;

        for(String token: tokens){
            if(Character.isDigit(token.charAt(token.length() - 1))){
                int num = Integer.parseInt(token);
                stack.push(num);
            }
            else if(token.equals("+")){
                int first=stack.pop();
                int second=stack.pop();
                int sum= second + first;
                stack.push(sum);
            
            }
            else if(token.equals("-")){
                int first=stack.pop();
                int second=stack.pop();
                int sum=  second - first;
                stack.push(sum);
            
            }
            else if(token.equals("*")){
                int first=stack.pop();
                int second=stack.pop();
                int sum= second * first;
                stack.push(sum);
            
            }
            else if(token.equals("/")){
                
                int first=stack.pop();
                int second=stack.pop();
                int sum= second / first;
                stack.push(sum);
            
            }
            }
            
        return stack.peek();
    }
}