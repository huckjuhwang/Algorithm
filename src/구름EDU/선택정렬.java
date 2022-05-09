package 구름EDU;

import java.util.Scanner;

public class 선택정렬 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 주어진 범위의 최소값의 위치를 반환하는 함수
     * @param data  데이터 배열
     * @param begin 탐색 할 가장 첫(왼쪽) 인덱스
     * @param end   탐색 할 가장 마지막(오른쪽) 인덱스
     * @return  data[begin] ~ data[end] 중 가장 작은 원소의 인덱스
     */
    public static int getMinIndexInRange(int[] data, int begin, int end)
    {
        // data[begin] ~ data[end] 사이의 최솟값을 구해서 그 인덱스 반환
        int minIndex = begin;
        for (int i = begin; i <= end; i++) {
            if (data[i] < data[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void selectionSort(int[] data, int n)
    {
        for(int i = 0 ; i < n-1 ; i++)
        {
            // data[i] ~ data[n-1]에서 최소값을 찾은다음
            int minIndex = getMinIndexInRange( data, i, n-1 );

            // data[i]로 이동 시키기기
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            data[i] = scanner.nextInt();
        }

        selectionSort(data, n);

        for(int i = 0; i < n ; i ++)
        {
            if( i > 0 )
            {
                System.out.print(" ");
            }
            System.out.print(data[i]);
        }
    }

}
