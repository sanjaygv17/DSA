class Solution {
    public int fib(int n) {
        return fibb(n);
    }
    private int fibb(int n){
        if(n==0){
            return 0;

        }
        if(n==1) return 1;

        return fibb(n-1)+fibb(n-2);
    }
}