package 구름EDU;
import java.util.*;
import java.io.*;

public class 반복해보기 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        //값을 저장할 변수를 만들고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n; //n을 입력받아 보세요

        n = Integer.parseInt(br.readLine());
        // "Goorm"을 n번 출력하세요
        // 각 문자열 사이는 ", "로 구분되어야 합니다
        for(int i=0; i<n; i++){
            if( i == n-1 )
                System.out.print("Goorm");
            else
                System.out.print("Goorm, ");
        }



    }
}
