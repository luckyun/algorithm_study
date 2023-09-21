package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2133타일 채우기
 * https://www.acmicpc.net/problem/2133
 */
public class FillTile2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 1;
        if(n >= 2){
            dp[2] = 3;
            for (int i = 4; i <= n ; i=i+2) {
                dp[i] = dp[i-2]  * 3;
                for (int j = i-4; j > -1; j=j-2) {
                    dp[i] = dp[i] + dp[j] * 2;
                }
            }
        }

        System.out.println(dp[n]);
        br.close();
    }


}
