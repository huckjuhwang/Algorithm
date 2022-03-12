package programmers.greedy;

import java.util.*;

/**
 * 문제명 : 문자열 재정렬
 * 입력조건
 *  - 첫째 줄에 하나의 문자열 S가 주어집니다.
 * 출력조건
 *  - 첫째 줄에 문제에서 요구하는 정답을 출력합니다.
 */

public class reSort {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        List<Character> arr = new ArrayList<Character>();
        int sum =0;

        for( int i=0; i<str.length(); i++ ){
            int a = str.charAt(i) - '0';
            if( a >=0 && a<= 9){
                sum += a;
            }else {
                arr.add(str.charAt(i));
            }
        }

        Collections.sort(arr);

        for( int i=0; i<arr.size(); i++ ){
            System.out.print(arr.get(i));
        }

        if( sum != 0 ){
            System.out.println(sum);
        }

    }
}
