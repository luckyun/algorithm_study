package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2011 암호코드
 * https://www.acmicpc.net/problem/2011
 */

public class SecretCode2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();



        int[] dp = new int[str.length() + 1 ];
        if (str.charAt(0)-'0' == 0 ) {
            System.out.println(0);
        } else {
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= str.length(); i++) {
                int oneNum = str.charAt(i - 1) - '0';
                if (oneNum > 0) {
                    dp[i] = (dp[i] + dp[i - 1]) % 1000000;
                }

                int twoNum = (str.charAt(i - 2) - '0') * 10 + (str.charAt(i - 1) - '0');
                if (twoNum >= 10 && twoNum <= 26) {
                    dp[i] = (dp[i] + dp[i - 2]) % 1000000;
                }
            }

            System.out.println(dp[str.length()]);
        }
    }


}
