package solution.suanfa.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        bucketSort(nums);
        for (int num : nums)
            System.out.print(num + " ");
    }

    private static void bucketSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
//        计算桶中最大值于最小值
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
//        计算桶的数量
        int length = (max-min)/nums.length+1;
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>(length);
//        这里是把每个桶都赋上一个列表空间
        for (int i = 0; i < length; i++) {
            arrays.add(new ArrayList<>());
        }
//        数据分桶
        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i]-min)/nums.length;
            arrays.get(num).add(nums[i]);
        }
//        对桶排序
        for (int i = 0; i < arrays.size(); i++) {
            Collections.sort(arrays.get(i));//这里采用什么排序 就是什么排序的稳定性
        }
        int index = 0;
        for(int i = 0; i < arrays.size(); i++){
            for(int j = 0; j < arrays.get(i).size(); j++){
                nums[index++] = arrays.get(i).get(j);
            }
        }
    }
}
