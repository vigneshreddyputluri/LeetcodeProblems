class Solution {

    class Node {
        Node[] links;
        int[] freq;

        Node() {
            links = new Node[26];
            freq = new int[26];
        }

        void put(char ch) {
            this.links[ch - 'a'] = new Node();
        }

        Node get(char ch) {
            return this.links[ch - 'a'];
        }

        int getFreq(char ch) {
            return this.freq[ch - 'a'];
        }

        boolean containsChar(char ch) {
            return this.links[ch - 'a'] != null;
        }

        void inc(char ch) {
            freq[ch - 'a']++;
        }
    }

    class Trie {
        private Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node n = root;

            for (int i = 0; i < word.length(); i++) {
                
                char ch = word.charAt(i);

                if (!n.containsChar(ch)) 
                    n.put(ch);

                n.inc(ch);
                n = n.get(ch);
            }
        }
    }

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();

        for (String str : strs) {
            trie.insert(str);
        }

        StringBuilder result = new StringBuilder("");
        Node n = trie.root;

        for (int i = 0; i < strs[0].length(); i++) {
            
            char ch = strs[0].charAt(i);

            if (n.getFreq(ch) == strs.length) {
                result.append(ch);
            }

            n = n.get(ch);
        }

        return new String(result);
    }
}