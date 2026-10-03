class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int i:weights){
            low=Math.max(low,i);
            high+=i;
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(weights,days,mid)){
                 ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }
        public boolean possible(int[] w,int days,int mid){
            int daysneed=1;
            int currentweight=0;

            for(int i:w){
                
                if(currentweight + i  > mid){
                    daysneed++;
                    currentweight=i;
                }else{
                    currentweight+=i;
                }
            }
            return daysneed <= days;
        }

    
}