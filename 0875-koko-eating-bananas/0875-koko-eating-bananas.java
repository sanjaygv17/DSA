class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;

        for(int pile:piles){
            if(pile>right){
                right=pile;
            }
        }
        int result=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(can(piles,h,mid)){
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }

        }
        return result;
     
}
private boolean can(int[] pile,int h,int k){
    long total=0;
    for(int p:pile){
        total+=(p+k-1)/k;
    }
    if(total>h){
        return false;

    }
    return total<=h;
}
}