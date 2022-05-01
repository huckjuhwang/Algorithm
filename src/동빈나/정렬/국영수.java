package 동빈나.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 국영수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Student_s> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Student_s(st.nextToken(), Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);


        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i).getName());
        }
    }
}

class Student_s implements Comparable<Student_s>{
    private String name;
    private int korean;
    private int english;
    private int math;

    public Student_s(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }


    @Override
    public int compareTo(Student_s other) {
        if (this.korean == other.korean && this.english == other.english && this.math == other.math) {
            // 오름차순
            return this.name.compareTo(other.name);
        }
        if (this.korean == other.korean && this.english == other.english) {
            // 내림차순
            return Integer.compare(other.math, this.math);
        }
        if (this.korean == other.korean) {
            // 오름차순
            return Integer.compare(this.english, other.english);
        }
        // 내림차순
        return Integer.compare(other.korean, this.korean);
    }
}
