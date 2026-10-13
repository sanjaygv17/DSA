class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index=0;
        for(int i=0;i<arr2.length;i++){
            for(int j=index;j<arr1.length;j++){
                if(arr2[i] == arr1[j]){
                    int temp=arr1[j];
                    arr1[j]=arr1[index];
                    arr1[index]=temp;
                    index++;
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr1.length-index;i++){
            for(int j=index;j<arr1.length-i-1;j++){
                if(arr1[j] > arr1[j+1]){
                    int temp=arr1[j];
                    arr1[j]=arr1[j+1];
                    arr1[j+1]=temp;
                }
            }
            
        }

        return arr1;
    }
}