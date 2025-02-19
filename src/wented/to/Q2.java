package wented.to;

class Q2 {

    public static boolean hasExactlyThreeConsecutiveSameDigits(String str) {
        if (str == null || str.length() < 3) {
            return false;
        }

        char[] chars = str.toCharArray();

        for (int i = 2; i < chars.length; i++) {
            if (chars[i] == chars[i - 1] && chars[i] == chars[i - 2]) {
                return true; // 연속된 숫자가 정확히 3번 나오면 true 반환
            }
        }

        return false; // 연속된 숫자가 정확히 3번 나오지 않은 경우
    }

    public int solution(String s) {
        int answer = 0;
        int max = -1;

        char[] chars = s.toCharArray();
        for (int i = 2; i < chars.length; i++) {
            if (chars[i] == chars[i - 1] && chars[i] == chars[i - 2]) {
                int value = Integer.parseInt(s.substring(i-2, i+1));
                if(max < value) {
                    max = value;
                }
            }
        }
        return max;
    }
}