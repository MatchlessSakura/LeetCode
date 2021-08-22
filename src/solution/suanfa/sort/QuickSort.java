package solution.suanfa.sort;

//不稳定
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {11,11, 2, 2, 2, 1, 2, 2, 2, 3, 4, 4, 4, 5,-1};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left > right)
            return;
        int l = left;
        int r = right;
        int key = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= key)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= key)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = key;
        quickSort(nums, left, l - 1);
        quickSort(nums, r + 1, right);
    }
}
