package programmers.test;

import java.util.*;

public class Q1 {

    static int target = 0;
    static HashSet<Integer> set = new HashSet<Integer>();
    static int n =0;
    static Map<MapKey, Integer> keyMap;

    static class MapKey {

        public Object key1;
        public Object key2;

        public MapKey(Object key1,Object key2){
            this.key1= key1;
            this.key2= key2;
        }
        @Override
        public boolean equals(Object object) {
            if (!(object instanceof MapKey))
                return false;
            MapKey ref = (MapKey) object;
            return this.key1.equals(ref.key1) && this.key2.equals(ref.key2);
        }
        @Override
        public int hashCode() {
            int hashCode = this.key1 == null ? 0 : this.key1.hashCode();
            hashCode = hashCode + (this.key2 == null ? 0 : this.key2.hashCode());
            return hashCode;
        }
    }


    public static void main(String[] args) {

        Q1 q = new Q1();
        int[] solution = q.solution(6, 17, new int[][]{{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}});
        for (int i = 0; i < solution.length; i++) {
            System.out.println("solution = " + solution[i]);
        }

    }


    public int[] solution(int n, int k, int[][] roads){
        this.target = k;
        this.n = n;
        keyMap = new HashMap<>();

        // 초기 값 세팅
//        for (int i = 0; i < roads.length; i++) {
//            int x = roads[i][0];
//            int y = roads[i][1];
//            int value = roads[i][2];
//
//            keyMap.put(new MapKey(x, y), value);
//            // 반대쪽으로 갈수도 있음
////            keyMap.put(new MapKey(y, x), value);
//        }

        dfs(0, 0, roads);

        // 결과 값을 배열에 넣고 정렬하기 위한 용도
        int result[] = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        if (set.isEmpty()) {
            return new int[]{-1};
        }
        int idx = 0;
        while (iter.hasNext()) {
            result[idx++] = iter.next();
        }

        // 오름차순 정렬
        Arrays.sort(result);

        return result;
    }


    public static void dfs(int nowTime, int nowPosition, int[][] roads){

//        System.out.println("nowTime = " + nowTime);
        // target에 도달한 경우
        if( nowTime == target ){
            set.add(nowPosition);
            return;
        }


        for (int i = 0; i < n; i++) {
            if( i == nowPosition ){
                continue;
            }

            for (int j = 0; j < roads.length; j++) {
                int val = roads[i][2];
                int nextTime = nowTime + val;

                // 현재 자기 위치가 아니면서 초과하지 않는경우
                if( nextTime <= target ){
                    dfs(nextTime, i, roads);
                }
            }
        }

    }
}
