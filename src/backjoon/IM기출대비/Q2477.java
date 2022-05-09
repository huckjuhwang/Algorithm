package backjoon.IM기출대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2477 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int wMax = 0;
        int hMax = 0;

        int scdWMax = 0;
        int scdHMax = 0;

        int arr[] = new int[6];
        int wIDX = 0;
        int hIDX = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int route = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr[i] = value;

            if (route == 1 || route == 2) {
                if (value > wMax) {
                    wMax = value;
                    wIDX = i;
                }
                wMax = Math.max(wMax, value);
            } else if (route == 3 || route == 4) {
                if (value > hMax) {
                    hMax = value;
                    hIDX = i;
                }
            }
        }

        int right, left;
        if(wIDX+1 == 6) right = 0;
        else right = wIDX+1;

        if(wIDX == 0) left = 5;
        else left = wIDX-1;

        scdHMax = Math.abs(arr[right] - arr[left]);


        if(hIDX+1 == 6) right = 0;
        else right = hIDX+1;

        if(hIDX == 0) left = 5;
        else left = hIDX-1;

        scdWMax= Math.abs(arr[right] - arr[left]);



        System.out.println(((wMax*hMax)-(scdHMax*scdWMax)) * n ) ;
    }
}
