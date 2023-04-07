package 정리;

import java.util.Arrays;

//NextPermutation
public class NextPerm {
    static int[] nums = {1, 2, 3, 4, 5};
    static int count;

    public static void main(String[] args) {
        do {
            count++;
            System.out.println(Arrays.toString(nums));
        }while(nextPerm(nums));
        System.out.println(count);
    }

    private static boolean nextPerm(int[] nums) {
        int N = nums.length-1;
        int i = N;
        while(i > 0 && nums[i-1] >= nums[i]) i--;
        if(i==0){
            return false;
        }
        int j = N;
        while(nums[i-1] >= nums[j]) j--;
        swap(nums, i-1, j);
        int k = N;
        while(i < k){
            swap(nums, i++, k--);
        }
        return true;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
