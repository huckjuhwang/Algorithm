package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 조교의성적매기기_1983 {

    static String real_grade[] = {"A+", "A0", "A-","B+", "B0", "B-","C+", "C0", "C-", "D0"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= test; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int student_num =  Integer.parseInt(st.nextToken());
            int rank =  Integer.parseInt(st.nextToken());

            Double grade[] = new Double[student_num];

            for (int i = 0; i < student_num; i++) {
                StringTokenizer calc = new StringTokenizer(br.readLine(), " ");

                grade[i] = (Integer.parseInt(calc.nextToken()) * 0.35)
                        + (Integer.parseInt(calc.nextToken()) * 0.45)
                        + (Integer.parseInt(calc.nextToken()) * 0.20);
            }

            double rankVal = grade[rank-1];
//            System.out.println("rankVal = " + rankVal);
            Arrays.sort(grade, Collections.reverseOrder());

//            for (int i = 0; i < grade.length; i++) {
//                System.out.println("grade[i] = " + grade[i]);
//            }
            int number = 0;

            for (int i = 1; i <= grade.length; i++) {
                if (grade[i-1] == rankVal) {
                    number = i;
                    break;
                }
            }

            int idx = (int)Math.ceil( (double) number/(student_num/10));
//            System.out.println("idx = " + idx);

            System.out.println("#" + testCase + " " + real_grade[idx-1]);

        }
    }
}
