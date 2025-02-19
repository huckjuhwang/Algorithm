package wented.to;

import java.util.ArrayList;
import java.util.List;

class Q4 {
    public int[][] solution(int servers, boolean sticky, int[] requests) {
        if (sticky) {
            return stickyTrue(servers, requests);
        } else {
            return stickyFalse(servers, requests);
        }
    }

    public int[][] stickyFalse(int servers, int[] requests) {
        int totalRequests = requests.length;
        // 각 서버당 할당될 최대 요청 수
        int maxPerServer = (totalRequests + servers - 1) / servers;

        // 각 서버에 할당될 요청을 담을 리스트
        List<List<Integer>> result = new ArrayList<>();

        int requestIndex = 0; // 요청 배열에서의 인덱스

        // 요청을 서버에 순서대로 할당
        for (int server = 0; server < servers; server++) {
            List<Integer> serverRequests = new ArrayList<>(); // 각 서버에 할당될 요청 리스트

            // 각 서버에 최대 요청 수만큼 요청 할당
            for (int i = 0; i < maxPerServer && requestIndex < totalRequests; i++) {
                serverRequests.add(requests[requestIndex]); // 요청 할당
                requestIndex++;
            }

            result.add(serverRequests); // 서버에 할당된 요청 리스트를 결과 리스트에 추가
        }


        return convertListToArray(result);
    }

    private static int[][] convertListToArray(List<List<Integer>> list) {
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> sublist = list.get(i);
            array[i] = new int[sublist.size()];
            for (int j = 0; j < sublist.size(); j++) {
                array[i][j] = sublist.get(j);
            }
        }
        return array;
    }


    public int[][] stickyTrue(int servers, int[] requests) {
        int totalRequests = requests.length;
        // 각 서버에 할당될 요청을 담을 리스트
        List<List<Integer>> result = new ArrayList<>();

        int[] temp = new int[100000];





        for (int i = 0; i < requests.length; i++) {

            int nowServerIdx = i%servers;

            // 최초 진입
            if(temp[requests[i]] == 0) {
            }
        }

        int[][] array = new int[servers][];
        return array;
    }
}