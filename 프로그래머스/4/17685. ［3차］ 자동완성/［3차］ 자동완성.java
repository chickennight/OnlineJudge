class Solution {
    private class Trie{
        boolean isleaf;
        Trie[] child;
        
        Trie(){
            this.isleaf = true;
            this.child = new Trie[26];
        }

        void insert(String key) {
            int idx = 0;
            Trie trie;
            if(this.child[key.charAt(idx)-'a'] == null) {
                trie = this.child[key.charAt(idx)-'a'] = new Trie();
            }else {
                trie = this.child[key.charAt(idx)-'a'];
                trie.isleaf = false;
            }
            idx++;

            while(idx < key.length()) {
                int next = key.charAt(idx)-'a';
                if(trie.child[next] == null) {
                    trie.child[next] = new Trie();
                }else {
                    trie.child[next].isleaf = false;
                }
                trie = trie.child[next];
                idx++;
            }
        }
        
        int query(String key) {
            int cnt = 1, idx = 0;
            Trie trie = this.child[key.charAt(idx)-'a'];
            idx++;
            while(idx < key.length()) {
                int next = key.charAt(idx)-'a';

                if(trie.isleaf) break;

                cnt++;
                trie = trie.child[next]; 
                idx++;
            }
            return cnt;
        }

    }
    
    public int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie();
        for(String word: words) 
            trie.insert(word);
        
        for(String word: words) 
            answer += trie.query(word);
        
        return answer;
    }
}