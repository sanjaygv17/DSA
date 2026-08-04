class Solution {
    public int findKthLargest(int[] nums, int k) {
          int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }
        
        int remaining = k;
        for (int i = count.length - 1; i >= 0; i--) {
            remaining -= count[i];
            if (remaining <= 0) {
                return i + min;
            }
        }
        
        return -1;
    }

}