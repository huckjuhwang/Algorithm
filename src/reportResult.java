/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static ArrayList<Integer> number;
    public static Scanner scan;

    public static void main(String[] args) throws IOException {

        scan = new Scanner(System.in);
        int t = 10;

        for (int testCase = 1; testCase <= t; testCase++) {
            // 암호문의 길이
            int N = scan.nextInt();
            number = new ArrayList<>();

            for (int i = 0; i < N; i++)   number.add(scan.nextInt());
            int M = scan.nextInt();
            for (int i = 0; i < M; i++) {
                char ch = scan.next().charAt(0);

                if (ch == 'I') {
                    insert();
                }else if (ch == 'D') {
                    delete();
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#" + testCase + " ");

            int idx = 0;
            for (Integer num : number) {
                sb.append(num + " ");
                if (++idx == 10)   break;
            }
            System.out.println(sb);
        }
    }

    private static void append() {
        int idx= scan.nextInt();
        int len = scan.nextInt();

        if (len > 10) {
            len = 10;
        }
        for (int j = 0; j < len; j++) {
            number.add(idx);
        }
    }

    private static void delete() {
        int idx= scan.nextInt();
        int len = scan.nextInt();
        if (len > 10) {
            len = 10;
        }
        for (int j = 0; j < len; j++) {
            number.remove(idx);
        }
    }

    private static void insert() {
        int idx= scan.nextInt();
        int len = scan.nextInt();
        if (len > 10) {
            len = 10;
        }
        for (int j = 0; j < len; j++) {
            number.add(idx++, scan.nextInt());
        }
    }
}