package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11054 가장 긴 바이토닉 부분 수열
 * https://www.acmicpc.net/problem/11054
 */
public class BitonicSequence11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n+2];
        int[] dp = new int[n+2];
        int[] dp2 = new int[n+2];
        int[] result = new int[n+1];


        int ans = 0;
        
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // 증가하는 순열
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i ; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }

        // 감소하는 순열
        for (int i = n+1; i >= 0; i--) {
            for (int j = n+1; j > i ; j--) {
                if(arr[i] > arr[j] && dp2[i] < dp2[j]+1){
                    dp2[i] = dp2[j]+1;
                }
            }
        }
        

        for (int i = 1; i <= n; i++) {
            ans = Math.max(dp[i] + dp2[i] -1, ans);
        }


        System.out.println(ans);
    }

}
