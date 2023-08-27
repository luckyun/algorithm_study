package baekjun.dp;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/9095
 * 9095 1, 2, 3 더하기
 */
public class Plus123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] tempValue = new int[n+3];
            tempValue[1] = 1;
            tempValue[2] = 2;
            tempValue[3] = 4;
            if(n > 3){
                for (int j = 4; j <= n; j++) {
                    tempValue[j] = tempValue[j-3] + tempValue[j-2] + tempValue[j-1];
                }
            }
            ans[i] = tempValue[n];
        }

        for (int val : ans) {
            System.out.println(val);
        }
        br.close();


    }
}
