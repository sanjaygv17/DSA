class Solution {
    public int findNumbers(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            int count=0;
            int a=nums[i];
            while(a>=1){
                count++;
                int b=a/10;
                a=b;
                
            }
            if(count%2==0){
                total++;
            }
        }
        return total;
        
    }
}