package backjoon.곰곰컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 곰곰컵Q4 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // (n - 4) % 7 == 0 가능하다
        int arr[] = new int[7];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = (Integer.parseInt(st.nextToken()))%7;
            arr[num]++;
            list.add(num);
        }


        int friday = 7;
        boolean check = false;

        Collections.sort(list);

        // 몇개 일을 끝내면 헬스장에 갈수 있는가?
        for (int i = 1; i <= n; i++) {
            int sum = 3;
            for (int j = 0; j < i; j++) {

            }
        }


        if (check) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
