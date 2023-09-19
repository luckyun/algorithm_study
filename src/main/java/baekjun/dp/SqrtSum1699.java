package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1699 제곱수의 합
 * https://www.acmicpc.net/problem/1699
 */
public class SqrtSum1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int finNum = (int) Math.sqrt(n);

        int[] dp = new int[n+1];


        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= finNum; i++) {
            for (int j = i*i ; j <= n; j++) {
                if(j-i*i >=0){
                    dp[j] = Math.min(dp[j], dp[j-i*i]+1);
                }

            }
        }

       System.out.println(dp[n]);
    }
}
