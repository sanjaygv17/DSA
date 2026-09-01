import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n=temp.length;
        int[] ans=new int[n];

        Deque<Integer> stack=new ArrayDeque<>();

        for(int i=0;i<n ; i++){
            while(!stack.isEmpty() && temp[i]> temp[stack.peek()]){
                int indextoUpdate=stack.pop();

                ans[indextoUpdate]=i-indextoUpdate;
            }
            stack.push(i);
        }
        return ans;
    }
}