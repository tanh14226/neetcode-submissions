class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix_product_left = new int[nums.length];
        int[] prefix_product_right = new int[nums.length];
        prefix_product_left[0] = nums[0];
        prefix_product_right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefix_product_left[i] = prefix_product_left[i - 1] * nums[i];
        }
        for(int i = nums.length - 2; i >= 0; i--){
            prefix_product_right[i] = prefix_product_right[i + 1] * nums[i];
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0) {
                res[i] = prefix_product_right[i + 1];
            }
            else if(i == nums.length - 1) {
                res[i] = prefix_product_left[i - 1];
            }
            else {
                res[i] = prefix_product_left[i - 1] * prefix_product_right[i + 1];
            }
        }
        return res;
    }
}  
