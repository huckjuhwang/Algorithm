package backjoon.분리집합;

import java.lang.*;
import java.io.*;
import java.util.*;

public class Q9938{
    static int root[];
    static boolean check[];

    public static int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }
    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        root[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // 술병의 개수
        int L = Integer.parseInt(st.nextToken());   // 서랍의 개수

        root = new int[L + 1];
        check = new boolean[L + 1];

        for (int i = 0; i <= L; i++) {
            root[i] = i;
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String result = "LADICA";

            // 서랍 Ai가 비어있다면 보관하기
            if (!check[a]) {
                check[a] = true;
                union(a, b);
            } else if (!check[b]) {
                check[b] = true;
                union(b, a);
            } else if (!check[find(a)]) {
                check[find(a)] = true;
                union(a, b);
            } else if (!check[find(b)]) {
                check[find(b)] = true;
                union(b, a);
            }else{
                result = "SMECE";
            }

            System.out.println(result);
        }
    }
}
