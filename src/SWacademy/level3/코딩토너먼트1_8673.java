package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 코딩토너먼트1_8673 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int k = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < Math.pow(2, k); i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }


            int sum = 0;
            for (int i = 0; i < k; i++) {

                for (int j = 0; j < list.size()-1; j+=1) {
                    sum += Math.abs(list.get(j) - list.get(j + 1));
                    if (list.get(j) > list.get(j + 1)) {
                        list.remove(j + 1);
                    }else{
                        list.remove(j);
                    }
                }
            }
            System.out.println("#" + testCase + " " + sum);
        }
    }
}
