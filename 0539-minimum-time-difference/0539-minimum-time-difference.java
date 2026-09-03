class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        int[] min=new int[n];
        for(int i=0;i<n;i++){
            String[] time=timePoints.get(i).split(":");
            int h=Integer.parseInt(time[0]);
            int m=Integer.parseInt(time[1]);
            min[i]=h*60+m;
            
        }
        java.util.Arrays.sort(min);
         int minimum=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
           
            minimum=Math.min(minimum,min[i]-min[i-1]);
        }

        int minMid=min[n-1];

        minimum=Math.min(minimum,1440-minMid+min[0]);

        return minimum;
    }
}