package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Q2061 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger K = new BigInteger(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        long s = 0;
        boolean check = false;

        for (long i = 2; i < n; i++) {
            if (K.remainder(BigInteger.valueOf(i)).compareTo(BigInteger.ZERO) == 0 ) {
                s = i;
                break;
            }
        }

        if (s > 0) {
            System.out.println("BAD " + s);
        }else{
            System.out.println("GOOD");
        }


    }

}
