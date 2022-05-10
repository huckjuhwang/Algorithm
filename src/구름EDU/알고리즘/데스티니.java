package 구름EDU.알고리즘;
import java.io.*;
import java.lang.*;
import java.util.*;


public class 데스티니 {
    public static final Scanner scanner = new Scanner(System.in);
    static int count =0;

    public static void main(String[] args)
    {
        int n = scanner.nextInt();
        Point2D[] points = new Point2D[n];

        for(int i = 0 ; i < n ; i++)
        {
            int x=  scanner.nextInt();
            int y=  scanner.nextInt();
            points[i] = new Point2D(x, y);
        }

        int min = Integer.MAX_VALUE;
        int count = 0;


        for(int i =0; i<n; i++){
            for(int j =i+1; j<n; j++){
                int sqd = points[i].getSquaredDistanceTo(points[j]);
                if ( sqd < min ){
                    min = sqd;
                    count = 1;
                }else if ( sqd == min ){
                    count++;
                }
            }
        }

        System.out.print(String.format("%.1f\n", Math.sqrt(min)));
        System.out.println(count);


    }
}

class Point2D{
    int x;
    int y;
    public Point2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * 2차원 평면 상에서 점 this부터 점 target까지 거리의 제곱을 계산하는 함수
     * @param target
     * @return
     */
    public int getSquaredDistanceTo(Point2D target)
    {
        int x = this.x - target.x;
        int y = this.y - target.y;
        return x*x + y*y;
    }

    public double getDistanceTo(Point2D target)
    {
        return Math.sqrt(getSquaredDistanceTo(target));
    }

}
