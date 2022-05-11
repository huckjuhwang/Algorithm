package 구름EDU.공간활용하기;

import java.io.*;
import java.lang.*;
import java.util.*;


public class 세카드 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 중복을 포함해 세 카드의 합으로 만들 수 있는 당첨번호들의 리스트를 반환하는 함수
     * @param n     카드의 수
     * @param m     검사하려는 당첨번호의 수
     * @param cards   각 카드에 적힌 숫자들
     * @param target  검사하려는 각 당첨번호 리스트
     * @return      세 카드의 합으로 표현될 수 있는 당첨번호들의 오름차순 리스트
     */
    public static ArrayList<Integer> getPossibleTargets(int n, int m, int[] cards, int[] target)
    {
        ArrayList<Integer> possibleTargets = new ArrayList<>(); //만들 수 있는 당첨번호들

        Arrays.sort(cards);

        // r = k - p - q
        // n이 1000이기 때문에, n^2은 수행 가능
        for(int tar : target){
            boolean check = false;
            for(int p : cards){
                for(int q : cards){
                    int r = tar - p - q;
                    if( Arrays.binarySearch(cards, r) >= 0 ){
                        possibleTargets.add(tar);
                        check = true;
                        break;
                    }
                }
                if( check ) break;
            }
        }
        Collections.sort(possibleTargets);
        return possibleTargets;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();  // 카드의 수
        int m = scanner.nextInt();  // 검사 할 후보 당첨번호의 수

        int[] cards = new int[n];
        int[] targets = new int[m];

        // 각 카드 정보를 입력받는다
        for(int i = 0 ; i < n ; i ++)
        {
            cards[i] = scanner.nextInt();
        }

        // 각 당첨번호를 입력받는다
        for(int i = 0 ; i < m ; i ++)
        {
            targets[i] = scanner.nextInt();
        }

        ArrayList<Integer> answers = getPossibleTargets(n, m, cards, targets);

        if(answers.size() == 0)
        {
            System.out.print("NO");
        }else{
            for(int i = 0 ; i < answers.size() ; i++)
            {
                if( i > 0 )
                {
                    System.out.print(" ");
                }
                System.out.print(answers.get(i));
            }
        }
    }

}
