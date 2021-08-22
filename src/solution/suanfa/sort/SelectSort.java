package solution.suanfa.sort;
//不稳定
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        selectSort(nums);
        for (int num : nums)
            System.out.print(num + " ");
    }

    private static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index])
                    index = j;
            }
            swap(nums,i, index);
        }
    }

    private static void swap(int[] nums, int num, int num1) {
        int temp = nums[num];
        nums[num] = nums[num1];
        nums[num1] = temp;
    }
}
