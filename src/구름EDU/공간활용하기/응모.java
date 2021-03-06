package 구름EDU.공간활용하기;

import java.io.*;
import java.lang.*;
import java.util.*;


public class 응모 {
    public static final Scanner scanner = new Scanner(System.in);

    public static final int MAX_SERIAL_NUMBER = 100000;


    /**
     * data[0] ~ data[n-1]에서 중복이 존재하지 않는 원소들을 반환한다.
     * 단, 각 원소들은 오름차순으로 정렬되어 있어야 한다.
     * @param data  data[0] ~ data[n-1]에는 10만 이하의 자연수다.
     * @param n
     * @return
     */
    public static ArrayList<Integer> getUniqueElements(int[] data, int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : data){
            if (map.get(num) == null) {
                map.put(num, 1);
            }else {
                map.put(num, map.get(num) + 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : map.keySet()) {
            if (map.get(num) == 1) result.add(num);
        }

        Collections.sort(result);
        return result;
    }


    public static void main(String[] args) throws Exception {
        //이 문제는 출력할 데이터가 많기때문에 BufferedWriter를 사용하여 출력해야 한다.
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        //N개의 시리얼 번호를 차례로 입력 받는다
        int n = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i ++)
        {
            data[i] = scanner.nextInt();
        }

        //중복없는 원소들을 계산한다.
        ArrayList<Integer> answers = getUniqueElements(data, n);

        //각 원소들을 출력한다.
        for(int i = 0 ; i < answers.size() ; i++)
        {
            int element = answers.get(i);
            if( i > 0 )
            { //첫 번째 원소가 아니라면 앞에 공백을 하나 추가한다.
                writer.write(" ");
            }
            writer.write(String.valueOf(element));
        }

        //BufferedWriter를 비우고 해제한다.
        writer.flush();
        writer.close();
    }

}

