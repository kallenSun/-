package Sort;

import java.util.Arrays;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/10 <br>
 * @since V9.0 <br>
 */
public class QuickSort {

    public static void main(String[] args) {

    }

    /**
     * 1、任取一个元素pivot作为中心
     * 2、分治，将比这个数小的放左边，比这个数大的放右边
     * 3、递归左右字表直到每个字表只剩下一个
     * 时间 最差O(n^2) 平均O(n*logn)
     * 空间
     * @param nums
     * @param left
     * @param right
     */
    public void quickSort(int[] nums,int left,int right){
        if (left >= right) return;
        int mid = partition(nums, left, right);
        quickSort(nums,left,mid-1);
        quickSort(nums,mid+1,right);
    }

    public int partition(int[] nums, int left, int right) {
        int privot = nums[right];
        int i = left;
        int j = right - 1;
        while (i<=j){
            while (i <= j && nums[i] <= privot) {
                i++;
            }
            while (i<=j&&nums[j]>privot)j--;
            if (i<=j)swap(nums,i,j);
        }
        swap(nums,i,right);
        return i;
    }


    public void swap(int []num,int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }


}
