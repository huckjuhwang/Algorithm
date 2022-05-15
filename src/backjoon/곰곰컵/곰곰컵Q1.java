package backjoon.곰곰컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곰곰컵Q1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chicken = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cola = Integer.parseInt(st.nextToken());
        int beer = Integer.parseInt(st.nextToken());

        int count = (cola / 2) + beer;

        if (chicken <= count) {
            System.out.println(chicken);
        }else{
            System.out.println(count);
        }
    }
}
