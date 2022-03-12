package liveCoding;

import java.util.Scanner;

public class landSnail {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int m = scan.nextInt();
        int arr[][] = new int[n][m];


        int size = n*m;
        int now = 1;
        int x = 0;
        int y = 1;

        int maxX = n;
        int maxy = m;

        arr[0][0] = 1;

        // 오 -> 아래 -> 왼 -> 위

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println("arr[" + 0 + " ][" + i + " ] = " + arr[0][i]);
//        }


        while (now <= size){

            // 오 -> 아래 -> 왼 -> 위
            for (int i = 1; i < maxy; i++) {
                arr[x][y++] = ++now;
            }maxy--;maxX--; y--;

            for (int i = 0; i < maxX ; i++) {
                arr[++x][y] = ++now;
            }maxy--;

            for (int i = 0; i < maxy; i++) {
                arr[x][--y] = ++now;
            }maxX--;

            for (int i = 0; i < maxX; i++) {
                arr[--x][y] = ++now;
            }maxy--;
        }
    }
}
