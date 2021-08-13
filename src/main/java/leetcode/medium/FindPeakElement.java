package leetcode.medium;

/**
 *  162. Find Peak Element
 *  https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(new int[]{1,2,3,1}) == 2);
        System.out.println(findPeakElement.findPeakElement(new int[]{1,2,1,3,5,6,4}) == 5);
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left < right){
            int mid = (left + right) / 2;
            int curNum = nums[mid];
            int nextNum = nums[mid+1];
            if(curNum < nextNum){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
