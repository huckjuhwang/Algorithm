package programmers.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class wordTrans {
    int cnt = 0;

    class bfsObject{
        String text;
        int cnt;

        public bfsObject(String text, int cnt){
            this.text = text;
            this.cnt = cnt;
        }
    }


    // TEST
    public static void main(String[] args) {
        wordTrans wt = new wordTrans();
        System.out.println(
                wt.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));

//        System.out.println(
//                wt.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));

    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<bfsObject> queue = new LinkedList<>();

        // 타켓이 문자들에 포함되어있는지 유무
        if( !includeTargetInWords(words, target) ) return 0;

        queue.offer(new bfsObject(begin, 0));

        while(!queue.isEmpty()){
            bfsObject poll = queue.poll();
            if( poll.text.equals(target) ){
                return poll.cnt;
            }

            for( int i=0; i<words.length; i++ ){
                if ( check(poll.text, words[i] ) ){
                    queue.offer(new bfsObject(words[i], poll.cnt+1));
                }

            }

        }
        return answer;
    }

    /**
     * 탐색한 글자가 다음글자로 바껴도 되는지
     */
    private boolean check(String word, String nextWord) {
        int num = 0;
        for (int i = 0; i< word.length(); i++) {
            if ( word.charAt(i) != nextWord.charAt(i) ){
                num++;
            }
        }
        return num == 1 ? true : false;
    }

    /**
     * target이 바꿀수 있는 word에 있는지
     */
    private boolean includeTargetInWords(String[] words, String target){
        for( String word : words ){
            if ( target.equals(word) ) {
                return true;
            }
        }
        return false;
    }
}
