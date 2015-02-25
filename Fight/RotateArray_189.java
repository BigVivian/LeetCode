package Fight;

/**
 * reverse and rotate
 * k might be larger than array's length
 */
public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public void reverse(int[] nums, int start, int end) {
        int temp;

        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 2;
        RotateArray_189 test = new RotateArray_189();
        test.rotate(nums, k);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
