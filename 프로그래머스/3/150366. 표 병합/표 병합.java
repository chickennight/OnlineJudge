import java.util.*;
class Solution {
    public int[] parent = new int[2501];
    public String[] value = new String[2501];

    public String[] solution(String[] commands){
        for(int i=1; i<=2500; ++i){
            parent[i] = i;
            value[i] = "";
        }

        List<String> result = new ArrayList<>();
        
        StringTokenizer st;
        for(String line: commands){
            st = new StringTokenizer(line);
            String command = st.nextToken();

            if(command.equals("UPDATE")){
                if(st.countTokens() == 2){
                    String before = st.nextToken();
                    String after = st.nextToken();
                    for(int j=1; j<=2500; ++j)
                        if(before.equals(value[j]))
                            value[j] = after;
                }else{
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    String after = st.nextToken();
                    int num = convert(x, y);
                    value[find(num)] = after;
                }
            }else if(command.equals("MERGE")){
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int n1 = convert(x1, y1);
                int n2 = convert(x2, y2);
                int root1 = find(n1);
                int root2 = find(n2);
                
                if (root1 == root2) continue;
                
                String rootString = value[root1].isBlank() ? value[root2] : value[root1];
                value[root1] = "";
                value[root2] = "";
                union(root1, root2);
                value[root1] = rootString;
            } else if (command.equals("UNMERGE")) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = convert(x, y);
                int root = find(num);
                String rootString = value[root];
                value[root] = "";
                value[num] = rootString;
                List<Integer> deleteList = new ArrayList<>();
                for (int j = 1; j <= 2500; ++j) 
                    if (find(j) == root)
                        deleteList.add(j);
                for (Integer t : deleteList)
                    parent[t] = t;
            } else if ("PRINT".equals(command)) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = convert(x, y);
                int root = find(num);
                if (value[root].isBlank())
                    result.add("EMPTY");
                else
                    result.add(value[root]);
            }
        }
        
        return result.toArray(new String[0]);
    }

    public int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    public int convert(int x, int y) {
        int result = 50 * (x - 1);
        return result + y;
    }

}