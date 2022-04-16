package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class base64_1928 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= test; testCase++) {

            byte[] bytes = br.readLine().getBytes();
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] decode = decoder.decode(bytes);

            System.out.println("#" + testCase + " " + new String(decode));

        }
    }

    public static void base64() { String text = "ktko"; byte[] targetBytes = text.getBytes(); // Base64 인코딩 ///////////////////////
        // //////////////////////////
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(targetBytes);
        // Base64 디코딩 ///////////////////////////////////////////////////
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(encodedBytes);
        System.out.println("인코딩 전 : " + text);
        System.out.println("인코딩 text : " + new String(encodedBytes));
        for (int i = 0; i < decodedBytes.length; i++) {
            System.out.println("decodedBytes = " + decodedBytes[i]);
        }

        System.out.println("디코딩 text : " + new String(decodedBytes)); }

}
