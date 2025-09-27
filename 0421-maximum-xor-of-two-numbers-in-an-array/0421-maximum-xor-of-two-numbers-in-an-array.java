import java.lang.Math;

class Solution {

    class Node {
        
        Node[] links;

        Node() {
            links = new Node[2];
        }

        void put(int bit) {
            if (! this.containsKey(bit)){
                Node temp = new Node();
                this.links[bit] = temp;
            }
        }

        boolean containsKey(int bit) {
            return (this.links[bit] != null);
        }

        Node get(int bit) {
            return this.links[bit];
        }

    }

    class Trie {

        private Node root;

        Trie() {
            root = new Node();
        }

        void insert(int num) {
            
            Node n = root;
            
            for (int i = 31; i >= 0; i--) {
                
                int bit = (num >> i) & 1;
                
                if (! n.containsKey(bit)) {
                    n.put(bit);
                }

                n = n.get(bit);
            }
        }

        int getMaxXOR(int num) {
            
            int maxXor = 0;
            Node n = root;

            for (int i = 31; i >= 0; i--) {

                int bit = (num >> i) & 1;

                if (n.containsKey(1 - bit)) {
                    maxXor = maxXor | (1 << i);
                    n = n.get(1 - bit);
                }
                else {
                    n = n.get(bit);
                }
            }
            
            return maxXor;

        }

        
    }

    public int findMaximumXOR(int[] nums) {
        
        Trie trie = new Trie();

        for (int num : nums) {
            trie.insert(num);
        }

        int maxXor = 0;

        for (int num : nums) {
            
            maxXor = Math.max(maxXor, trie.getMaxXOR(num));

        }

        return maxXor;
    }
}