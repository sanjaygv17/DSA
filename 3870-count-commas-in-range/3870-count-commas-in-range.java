class Solution {
    public int countCommas(int n) {
        int count=0;

        int digits=0;

        int num=n;
        while(num>0){
            digits++;
            num=num/10;
        }

        if(digits<=3){
            return 0;
        }

        for(int i=1000;i<=n;i++){
            count++;
                    }

        return count;
    
    }
}