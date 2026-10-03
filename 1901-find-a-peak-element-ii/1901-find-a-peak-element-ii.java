class Solution {
    public int[] findPeakGrid(int[][] nums) {
       int m=nums.length;
       int n=nums[0].length;

       int low=0;
       int high=n-1;

       while(low<=high){
        int mid=low+(high-low)/2;
        int index=0;
        for(int i=0;i<m;i++){
            if(nums[i][mid] > nums[index][mid]){
                index=i;
            }
        }

        int current=nums[index][mid];
        int left=(mid-1 >= 0)? nums[index][mid-1] : -1;
        int right=(mid+1 < n)? nums[index][mid+1] : -1;


        if(current > left && current > right){
            return new int[]{index,mid};
        }

        if(left > current){
           high=mid-1;
        }else{
            low=mid+1;
        }
       }

       return new int[]{-1,-1};
    }
}