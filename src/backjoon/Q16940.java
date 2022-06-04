package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16940 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        boolean visited[] = new boolean[n + 1];
        boolean result = true;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int idx = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();
            visited[temp] = true;

            HashSet<Integer> set = new HashSet<>();
            for (int num : list.get(temp)) {
                if (!visited[num]) {
                    set.add(num);
                    visited[num] = true;
                }
            }

            int size = set.size();
            for (int i = idx; i < idx + size; i++) {
                if( set.contains(arr[i])) q.add(arr[i]);
                else result = false;
            }

            idx+=size;
        }

        if (result) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }


    }
}
