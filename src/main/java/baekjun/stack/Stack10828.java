package baekjun.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 10828 스택
 * https://www.acmicpc.net/problem/10828
 */
public class Stack10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        List<String> operations = new ArrayList<>();
        List<String> st = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            String op = br.readLine();
            operations.add(op);
        }

        for (int i = 0; i < n; i++) {

            String op = operations.get(i);

            if(op.equals("pop")){
                if(st.isEmpty()){
                    sb.append("-1").append("\n");
                } else {
                    sb.append(st.get(st.size()-1)).append("\n");
                    st.remove(st.size()-1);
                }
            } else if(op.equals("size")){
                sb.append(st.size()).append("\n");
            } else if(op.equals("empty")){
                if(st.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }

            } else if(op.equals("top")){
                if(st.isEmpty()){
                    sb.append("-1").append("\n");
                } else {
                    sb.append(st.get(st.size()-1)).append("\n");
                }

            } else {
                st.add(op.split(" ")[1]);
            }


        }
        System.out.println(sb.toString());

    }
}
