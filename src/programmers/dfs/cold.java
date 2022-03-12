package programmers.dfs;

import java.util.Scanner;

/**
 * 음료수 얼려먹기
 *
 * 입력조건
 *  - 첫번째 줄에 얼음틀의 세로 길이 N과 가로길이 M이 주어집니다.
 *  - 두번째 줄부터 N+1번째 줄까지 얼음의 틀의 형태가 주어집니다.
 *  - 이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1
 *
 *  출력조건
 *   - 한번에 만들수 있는 아이스크림의 개수를 출력합니다.
 */
public class cold {

    public static boolean visited[][];
    public static int answer = 0;
    static int N = 4;
    static int M = 5;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int arr[][] = {{0,0,1,1,0},{0,0,0,1,1},{1,1,1,1,1},{0,0,0,0,0}};
        visited = new boolean[N][M];

        for( int i=0; i<N; i++ ){
            for( int j=0; j<M; j++ ){
                if( dfs(arr, i, j) ) {
                    answer++;
                }
            }
        }
        System.out.println("answer = " + answer);



    }

    public static boolean dfs(int arr[][], int x, int y){
        // 범위를 벗어나는 경우
        if( x < 0 || x > N-1 || y <0 || y > M-1 ||  arr[x][y] == 1){
            return false;
        }

        if( !visited[x][y] ){
            visited[x][y] = true;
            // x값이 0이거나 M-1이면 안됨.
            // Y값이 0이거나 N-1이면 안됨
            dfs(arr, x-1 , y);
            dfs(arr, x+1 , y);
            dfs(arr, x , y-1);
            dfs(arr, x , y+1);
            return true;
        }
        return false;
    }
}
