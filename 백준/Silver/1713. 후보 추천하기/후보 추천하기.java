import java.util.*;
import java.io.*;

public class Main {
    private static class Student implements Comparable<Student> {
        int num;
        int cnt;
        int time;

        public Student(int num, int cnt, int time) {
            super();
            this.num = num;
            this.cnt = cnt;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            int resultCnt = o.cnt - cnt;
            if (resultCnt == 0) {
                return o.time - time;
            }
            return resultCnt;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());

        List<Student> photos = new ArrayList<>();
        Student[] students = new Student[101];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < M; ++i) {
            int num = Integer.parseInt(st.nextToken());

            if (students[num] != null) {
                students[num].cnt++;
            } else {
                Collections.sort(photos);

                if (photos.size() == N) {
                    Student del = photos.remove(N - 1);
                    students[del.num] = null;
                }

                students[num] = new Student(num, 1, i);
                photos.add(students[num]);
            }
        }

        photos.sort(Comparator.comparingInt(o -> o.num));
        
        for (Student s : photos) 
            System.out.print(s.num + " ");
        
    }

}
