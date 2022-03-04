package programmers.bfs;

import groovy.transform.ASTTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class network {
    int netCnt;
    boolean[] check;

    private network(){
        netCnt=0;
    }

    public static void main(String[] args) {

    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[computers.length];

        for(int i=0; i<n; i++){
            if( !check[i] ){
                dfs( i, computers, check);
                netCnt++;
            }
        }

        return answer;
    }

    public void dfs(int i, int[][] computers, boolean[] check){
        check[i] = true;

        for (int j=0; j<computers[0].length; j++){
            if( check[j] == false && i!=j && computers[i][j] ==1){
                dfs(j, computers, check);
            }
        }

    }
}
