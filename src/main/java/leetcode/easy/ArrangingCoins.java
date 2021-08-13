package leetcode.easy;

/**
 * 441. Arranging Coins
 * https://leetcode.com/problems/arranging-coins/
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        System.out.println(arrangingCoins.arrangeCoins(5) == 2);
        System.out.println(arrangingCoins.arrangeCoins(8) == 3);
    }

    // 이진탐색으로 찾기
    // 전체동전의 합 = n(n+1) / 2
    public int arrangeCoins(int n) {

        int left = 0, right = n;
        int answer = 0;
        while (left <= right) {
            //중간값
            int mid = (left + right) / 2;
            // 중간값이 가질수 있는 최대 동전 수
            long maxCoins = (long) mid * (mid + 1) / 2;


            if (maxCoins <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return answer;
    }
}
