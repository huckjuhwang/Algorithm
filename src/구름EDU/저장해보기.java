package 구름EDU;
import java.io.*;
import java.util.*;
import java.lang.*;


public class 저장해보기 {

    public static final int MAX_N = 1000;
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        // 어레이 리스트에 원소를 입력받아 보세요

        for(int i =0; i<n; i++)
            arr.add(scanner.nextInt());

        for(int i = arr.size()-1; i>=0; i--)
            System.out.print(arr.get(i) + " ");




    }
}
