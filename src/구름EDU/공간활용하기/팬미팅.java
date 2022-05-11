package 구름EDU.공간활용하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 팬미팅 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        int uniqueCount = 0;

        // hashMap을 사용하여 중복 값을 체크함,
        // 처음 값을 세팅하기위해 K개의 값을 map에 넣음
        // 넣는 과정에서 중복값이 발생하지 않았다면 count++;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
                uniqueCount++;
            }else{
                map.put(arr[i], map.get(arr[i]) + 1);
                uniqueCount--;
            }
        }
        if (uniqueCount==k)  count++;


        // 이전 값을 하나 지우고, 다음값을 넣는 식으로 진행
        // 삽입하는 과정에서 중복이 발생할 경우
        for (int i = k + 1; i <= n; i++) {
            // 이전 값을 지움, 지우는 과정에서 값의 개수를 보고.
            // 1개남았을 경우 지움, 그이상은 -1
            if (map.get(arr[i - k]) != null) {
                if (map.get(arr[i - k]) == 1) {
                    map.remove(arr[i-k]);
                    uniqueCount--;
                }else{
                    if(map.get(arr[i - k]) == 2) {
                        uniqueCount++;
                    }

                    map.put(arr[i - k], map.get(arr[i - k]) - 1);
                }
            }

            // 다음 값을 넣어 줌,
            // 다음 값을 넣는 과정에서 중복되지 않았을 경우 count++;
            if (map.get(arr[i]) == null){
                map.put(arr[i], 1);
                uniqueCount++;
                if( uniqueCount == k)  count++;
            }else{
                map.put(arr[i], map.get(arr[i]) + 1);
                uniqueCount--;
            }
        }
        System.out.println(count);
    }
}
