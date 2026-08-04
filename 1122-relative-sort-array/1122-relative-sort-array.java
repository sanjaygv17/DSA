class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index=0;
        int count=0;
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr1.length;j++){
                if(arr1[j]==arr2[i]){
                    count++;
                    int temp=arr1[j];
                    arr1[j]=arr1[index];
                    arr1[index]=temp;
                    index++;
                }
            }
            
        }
        System.out.println(count);
        
        for(int i=count;i<arr1.length;i++){
            for(int j=count;j<arr1.length-(i-count)-1;j++){
                if(arr1[j]>arr1[j+1]){
                    int temp=arr1[j];
                    arr1[j]=arr1[j+1];
                    arr1[j+1]=temp;
                }
            }
        }
        
       
        return arr1;
    }
}