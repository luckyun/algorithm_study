package leetcode.easy;

/**
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/solution/
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abccccdd") == 7);
        System.out.println(longestPalindrome.longestPalindrome("abccccdd") == 7);
        System.out.println(longestPalindrome.longestPalindrome("a") == 1);
        System.out.println(longestPalindrome.longestPalindrome("bb") == 2);

    }
    public int longestPalindrome(String s) {
        //범위 A-Z,a-z
        //중간에 아스키코드 6개 있음 (Z ㅇㅇㅇㅇㅇㅇ a)
        int[] memory = new int[58];

        for (char c : s.toCharArray()) {
            memory[c - 'A']++;
        }

        int ans = 0;

        for (int cnt : memory) {
            // 2 = 2*2/2 = 2
            // 3 = 3*2/2 = 2
            ans = ans + (cnt / 2 * 2);

            //최초의 홀수중 하나만 가운데 들어갈수 있다.
            // aaabbbbbcc   = cabbbbbac
            if(ans % 2 == 0 && cnt % 2 == 1){
                ans++;
            }
        }

        return ans;
    }
}
