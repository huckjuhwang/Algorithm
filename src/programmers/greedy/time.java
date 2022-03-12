package programmers.greedy;

import java.util.Scanner;

public class time {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int count = 0;


        for( int hour = 0; hour<=N; hour++ ) {
            for( int minute=0 ; minute<60; minute++ ){
                for( int second=0; second<60; second++ ){
                    if(check(hour, minute, second)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

    }

    private static boolean check(int hour, int minute, int second) {
        return hour %10 == 3 || minute %10==3 || minute /10==3 ||  second %10==3 || second /10==3;
    }
}
