package baekjun.backtracking;

import java.io.*;
import java.util.Arrays;

public class MakePassword1759 {
    static String[] targetArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] intData = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] password = br.readLine().split(" ");
        int L = intData[0];
        int C = intData[1];

        targetArr = new String[C];
        visited = new boolean[C];

        for (int i = 0; i < password.length; i++) {
            targetArr[i] = password[i];
        }

        Arrays.sort(targetArr);

        dfs(0, 0, L, C);



    }

    private static void dfs(int start, int depth, int L, int C) {
        if(depth == L){
            int consonant =0;
            int vowel  =0;
            StringBuffer sb =new StringBuffer();
            for (int i = 0; i < C; i++) {
                if(visited[i]){
                    sb.append(targetArr[i]);
                    if(targetArr[i].equals("a")
                            || targetArr[i].equals("e")
                            || targetArr[i].equals("i")
                            || targetArr[i].equals("o")
                            || targetArr[i].equals("u")) {
                        vowel++;
                    } else {
                        consonant++;
                    }
                }
            }
            if( vowel>=1 && consonant>=2){
                System.out.println(sb.toString());
            }
        }
        for (int i = start; i < C; i++) {
            visited[i] = true;
            dfs(i+1, depth+1, L, C);
            visited[i] = false;

        }
    }
}
