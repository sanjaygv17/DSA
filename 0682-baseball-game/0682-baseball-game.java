import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> score=new ArrayDeque<>();
       
        int sum=0;

        for(String token:operations){

            if(Character.isDigit(token.charAt(token.length() - 1))){
                int num = Integer.parseInt(token);
                score.push(num);
                
            }
            else if(token.equals("+")){
               int top=score.pop();
               int secondTop=score.peek();
               int n= top + secondTop;
               score.push(top);
               score.push(n);
            }
            else if( token.equals("D")){
                int a=score.peek();
                score.push(a*2);
            }
            else if( token.equals("C")){
                score.pop();
            }else{
                continue;
            }
        }
        
        while(!score.isEmpty()){
            sum+=score.pop();
        }
        return sum;
        
    }
}