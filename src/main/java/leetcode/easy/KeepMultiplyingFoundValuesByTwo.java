package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2154. Keep Multiplying Found Values by Two
 * https://leetcode.com/problems/keep-multiplying-found-values-by-two/description/
 */
public class KeepMultiplyingFoundValuesByTwo {
    public static void main(String[] args) {
        KeepMultiplyingFoundValuesByTwo kmfvt = new KeepMultiplyingFoundValuesByTwo();
//        System.out.println(kmfvt.findFinalValue(new int[]{5,3,6,1,12}, 3));
//        System.out.println(kmfvt.findFinalValue(new int[]{2,7,9}, 2));
        System.out.println(kmfvt.findFinalValue(new int[]{ 8,19,4,2,15,3}, 2));

    }

    public int findFinalValue(int[] nums, int original) {

        int searchNum = original;
        Set<Integer> numSet =new HashSet();
        for (int num : nums) {
            numSet.add(num);
        }
        while (numSet.contains(searchNum)){
            searchNum = searchNum * 2;
        }

        return searchNum;



//        int searchNum = original;
//        Arrays.sort(nums);
//        for (int num : nums) {
//            if(num == searchNum){
//                searchNum = searchNum * 2;
//            }
//        }
//        return searchNum;

    }
}
