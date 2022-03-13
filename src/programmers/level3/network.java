package programmers.level3;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
 * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 *
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 *
 * n	computers	                        return
 * 3	[[1, 1, 0],
 *      [1, 1, 0],
 *      [0, 0, 1]]	                         2
 *
 * 3	[[1, 1, 0],
 *      [1, 1, 1],
 *      [0, 1, 1]]	                          1
 *
 *
 */
public class network {

    static int answer = 0;
    static boolean visited[];
    static int[] dx = {-1, 1, 0, 0};        // 상하
    static int[] dy = {0, 0, -1, 1};        // 좌우



    public static void main(String[] args) {
        solution(3, new int[][]{{1,1,0}, {1,1,1}, {0,1,1}});
    }


    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
//                System.out.println("answer = " + answer);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs( int x ,int[][] computers){
        visited[x] = true;

        for (int y = 0; y < computers.length; y++) {
            if( !visited[y] && x != y && computers[y][y]==1){
                dfs(y, computers);
            }
        }

    }


}
