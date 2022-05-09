package backjoon.IM기출대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q2628 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        List<Integer> widthList = new ArrayList<>();
        widthList.add(0);
        widthList.add(x);

        List<Integer> lengthList = new ArrayList<>();
        lengthList.add(0);
        lengthList.add(y);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            // 0이면 가로, 1이면 세로
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            if (v == 0) {
                widthList.add(val);
            } else {
                lengthList.add(val);
            }
        }

        Collections.sort(widthList);
        Collections.sort(lengthList);

        int xMax = getMaxXY(widthList);
        int yMax = getMaxXY(lengthList);

        System.out.println(xMax * yMax);

    }

    public static int getMaxXY(List<Integer> List){
        int max = 0;

        for (int i = 0; i < List.size()-1; i++) {
            int now = List.get(i + 1) - List.get(i);
            if (max < now) max = now;
        }
        return max;
    }

}
