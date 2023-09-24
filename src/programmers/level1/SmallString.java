package programmers.level1;


class SmallString {
    public static void main(String[] args) {
        System.out.println(solution("1221351118575141528544", "12511"));
    }

    public static int solution(String t, String p) {
        int answer = 0;

        int size = p.length();
        Long target = Long.parseLong(p);

        for(int i=0; i< t.length()-size+1; i++){
            Long number = Long.parseLong(t.substring(i, i+size));

            if(number <= target) {
                answer++;
            }
        }

        return answer;
    }
}