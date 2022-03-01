package Sort;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/11 <br>
 * @since V9.0 <br>
 */
public class BinarySearch {

    public static void main(String[] args) {

    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                left = mid;
            } else if (nums[mid] < target){
                right = mid - 1;
            }
        }
        return left;
    }
}
