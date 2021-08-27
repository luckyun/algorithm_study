package leetcode.medium;

/**
 * 97. Interleaving String
 * https://leetcode.com/problems/interleaving-string/
 */

public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac") == true);
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];

        // S1 "", S2 "", S3 "a"
        if(s3.length() != s1.length()+s2.length()){
            return false;
        }

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if(i==0 && j==0){
                    dp[i][j]=true;
                } else if(i==0) {      // 왼쪽값이 T이고, 현재 값이 같으면 T
                    dp[i][j] = dp[i][j-1] && dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                } else if(j==0){      //  윗쪽값이 T이고, 현재 값이 같으면 T
                    dp[i][j] = dp[i-1][j] && dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                } else {             // 왼쪽값이 T이고, 현재 값이 같으면 T  이거나 윗쪽값이 T이고, 현재 값이 같으면 T 이면 T
                    dp[i][j] = ( dp[i][j-1] && dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1) || dp[i-1][j] && dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
            }
        }
        //결과적으로 최종 값이 T이면 참
        return dp[s1.length()][s2.length()];
    }
}

