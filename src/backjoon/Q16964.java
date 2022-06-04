package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q16964 {

    static int arr[];
    static boolean visited[];
    static boolean flag;  // yes-> 1, no -> 0
    static  ArrayList<ArrayList<Integer>> list;
    static int count;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        count = n;
        idx = 1;

        arr = new int[n];
        visited = new boolean[n+1];
        flag = true;

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);     // ?
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (arr[0] != 1) {
            System.out.println(0);
            return;
        }

        dfs(1);



        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }



    }


    public static void dfs(int x){
        if (visited[x]) return;
        // 방문처리
        visited[x] = true;

        HashSet<Integer> set = new HashSet<>();
        for (int next : list.get(x)) {
            if (!visited[next]) {
                set.add(next);
            }
        }


        if(set.size() == 0) return;

        if (set.contains(arr[idx])) {
            dfs( arr[idx++]);
        }else {
            flag = false;
        }


    }
}
