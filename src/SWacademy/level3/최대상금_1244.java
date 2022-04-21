package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * *  dfs로 변경
 */
public class 최대상금_1244 {
    static int max;
    //  3
    //	123 1
    //	2737 1
    //	32888 2

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt( br.readLine() );

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            char ch[] = st.nextToken().toCharArray();
            int count = Integer.parseInt(st.nextToken());
            max = 0;

            dfs(ch, count, 0);

            System.out.println("#" + testCase + " " + max);
        }

    }



    public static void dfs(char[] ch, int count, int start){
        // 종료조건
        if( count == 0 ){
            int num = getCharToInteger(ch);
            // 최댓값과 비교 후 insert
            if( max < num ){
                System.out.println(num);
                max = num;
            }
            return;

        }else {
            for( int i =start; i<ch.length-1; i++){
                for( int j = i+1; j<ch.length; j++){
                    ch = swap(ch, i, j);
                    dfs(ch, count-1, i);
                    ch = swap(ch, i, j);
                }
            }
        }
    }


    /**
     *   swap함수
     */
    public static char[] swap(char[] ch, int i, int j){
        char temp = ' ';
        temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }


    /**
     * char배열 -> int형태로 convert
     */
    public static int getCharToInteger(char[] ch){
        return Integer.parseInt(new String(ch));
    }
}
