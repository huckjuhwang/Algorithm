package SWacademy.level2;

/**
 * 개선!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최빈수구하기_1204 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {

            Set<Integer> set = new HashSet<>();
            Map<Integer, Integer> hash = new HashMap<>();

            int result = 0;
            int max = 0;

            br.readLine();
            String nums[] = br.readLine().split(" ");
            for (String num : nums) {
                int now = Integer.parseInt(num);
                // 중복값을 제거하며, 추후 정렬을 위한, 최빈값이 동률일 경우 사용
                set.add(now);

                // 해당 값이 존재하지 않는다면
                if (!hash.containsKey(now)) {
                    hash.put(now, 0);
                }else{
                    hash.put(now, hash.get(now) + 1);
                }

                // 최댓 값 계산
                if (hash.get(now) > max) {
                    max = hash.get(now);
                }
            }

            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list, Collections.reverseOrder());

            // 나온 수 중에 큰수부터 돌면서 max와 같은지 분석
            for (int j = 0; j < list.size(); j++) {
                int li = list.get(j);

                if (hash.get(li) == max) {
                    result = li;
                    break;
                }
            }

            System.out.println("#" + (i+1) + " " + result);

        }


    }
}
