package programmers.bfs;

public class net {
    int answer;
    boolean visited[];
    public int solution(int n, int[][] computers) {
        initVariable(n);
        callDFS(n, computers);
        return answer;
    }


    public static void main(String[] args) {
        System.out.println("test");

        String str = null;

        Double b = Double.parseDouble(str);
        System.out.println(b);
    }
    private void initVariable(int n) {
        answer = 0;
        visited = new boolean[n];
    }

    private void callDFS(int n, int[][] computers) {
        for(int i = 0; i< n; i++ ){
            if( !visited[i] ) {
                dfs(i, computers, visited);
                answer++;
            }
        }
    }

    private void dfs(int now, int[][] computers, boolean visited[] ){
        visited[now] = true;
        for(int i=0; i<computers.length; i++) {
            if( !visited[i] && now != i && computers[now][i]==1){
                dfs(i, computers, visited);
            }
        }
    }
}
