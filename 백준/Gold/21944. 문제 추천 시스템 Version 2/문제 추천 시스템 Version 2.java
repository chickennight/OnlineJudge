import java.util.*;
import java.io.*;

public class Main {

    public static class Problem implements Comparable<Problem> {
        int idx;
        int level;
        int algo;

        public Problem(int idx, int level, int algo) {
            this.idx = idx;
            this.level = level;
            this.algo = algo;
        }

        public int compareTo(Problem o) {
            if (level - o.level == 0) {
                return idx - o.idx;
            } else {
                return level - o.level;
            }
        }

        public String toString() {
            return "idx : " + idx + " level : " + level + " algo : " + algo;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        TreeSet<Problem> set = new TreeSet<>();
        Map<Integer, TreeSet<Problem>> algoTreeSet = new HashMap<>();
        Map<Integer, Integer> levelmap = new HashMap<>();
        Map<Integer, Integer> algomap = new HashMap<>();

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(in.readLine());
            order(set, algoTreeSet, levelmap, algomap, st);
        }

        int M = Integer.parseInt(in.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(in.readLine());
            String command = st.nextToken();
            switch (command) {
                case "recommend" -> {
                    int n_algo = Integer.parseInt(st.nextToken());
                    int pos = Integer.parseInt(st.nextToken());
                    if (pos == 1) {
                        sb.append(algoTreeSet.get(n_algo).last().idx).append('\n');
                    } else {
                        sb.append(algoTreeSet.get(n_algo).first().idx).append('\n');
                    }
                }
                case "recommend2" -> {
                    int pos = Integer.parseInt(st.nextToken());
                    if (pos == 1) {
                        sb.append(set.last().idx).append('\n');
                    } else {
                        sb.append(set.first().idx).append('\n');
                    }
                }
                case "recommend3" -> {
                    int pos = Integer.parseInt(st.nextToken());
                    int stand = Integer.parseInt(st.nextToken());
                    if (pos == 1) {
                        if (set.ceiling(new Problem(0, stand, 0)) == null) {
                            sb.append(-1).append('\n');
                        } else {
                            sb.append(Objects.requireNonNull(set.ceiling(new Problem(0, stand, 0))).idx).append('\n');
                        }
                    } else {
                        if (set.floor(new Problem(0, stand, 0)) == null) {
                            sb.append(-1).append('\n');
                        } else {
                            sb.append(Objects.requireNonNull(set.floor(new Problem(0, stand, 0))).idx).append('\n');
                        }
                    }
                }
                case "add" -> order(set, algoTreeSet, levelmap, algomap, st);
                default -> {
                    int n_idx = Integer.parseInt(st.nextToken());
                    int n_level = levelmap.get(n_idx);
                    int n_algo = algomap.get(n_idx);
                    set.remove(new Problem(n_idx, n_level, n_algo));
                    algoTreeSet.get(n_algo).remove(new Problem(n_idx, n_level, n_algo));
                    levelmap.remove(n_idx);
                    algomap.remove(n_idx);
                }
            }
        }

        System.out.println(sb);
    }

    private static void order(TreeSet<Problem> set, Map<Integer, TreeSet<Problem>> algoTreeSet, Map<Integer, Integer> levelmap, Map<Integer, Integer> algomap, StringTokenizer st) {
        int n_idx = Integer.parseInt(st.nextToken());
        int n_level = Integer.parseInt(st.nextToken());
        int n_algo = Integer.parseInt(st.nextToken());
        set.add(new Problem(n_idx, n_level, n_algo));
        if (algoTreeSet.containsKey(n_algo)) {
            TreeSet<Problem> temp = algoTreeSet.get(n_algo);
            temp.add(new Problem(n_idx, n_level, n_algo));
            algoTreeSet.replace(n_algo, temp);
        } else {
            TreeSet<Problem> temp = new TreeSet<>();
            temp.add(new Problem(n_idx, n_level, n_algo));
            algoTreeSet.put(n_algo, temp);
        }

        levelmap.put(n_idx, n_level);
        algomap.put(n_idx, n_algo);
    }

}