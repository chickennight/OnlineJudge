import java.util.*;

class Solution {
    
    private class Task {
        String name;
        int start;
        int left;

        Task(String name, int start, int left) {
            this.name = name;
            this.start = start;
            this.left = left;
        }
    }
    
    public String[] solution(String[][] plans) {
        LinkedList<Task> tasks = new LinkedList<>();
        for (String[] plan : plans) {
            tasks.offer(new Task(plan[0], convert(plan[1]), Integer.parseInt(plan[2])));
        }
        tasks.sort((t1, t2) -> t1.start - t2.start);

        Stack<Task> stop = new Stack<>();
        List<String> end = new ArrayList<>();
        Task now = tasks.poll();
        int time = now.start;
        while (!tasks.isEmpty()) {
            time += now.left;
            Task next = tasks.peek();

            if (time > next.start) {
                now.left = time - next.start;
                stop.push(now);
            } else {
                end.add(now.name);
                if (!stop.empty()) {
                    now = stop.pop();
                    continue;
                }
            }
            now = tasks.poll();
            time = now.start;
        }

        end.add(now.name);
        while (!stop.empty()) {
            end.add(stop.pop().name);
        }

        return end.toArray(new String[0]);
    }

    private int convert(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

}