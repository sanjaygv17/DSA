class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

           
            while (currentSum >= target) {
                int currentWindowSize = right - left + 1;
                minLength = Math.min(minLength, currentWindowSize);
                
                currentSum -= nums[left];
                left++;                  
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
