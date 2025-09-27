class Solution {

    class Node {
        Node[] bits;

        Node() {
            bits = new Node[2];
        }

        void put(int bit) {
            this.bits[bit] = new Node();
        }

        Node get(int bit) {
            return this.bits[bit];
        }

        boolean containsKey(int bit) {
            return this.bits[bit] != null;
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
                if (!n.containsKey(bit)) n.put(bit);
                n = n.get(bit);
            }
        }

        int findMaxXor(int num) {
            int maxXor = 0;
            Node n = root;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (n.containsKey(1 - bit)) {
                    maxXor |= (1 << i);
                    n = n.get(1 - bit);
                }
                else {
                    n = n.get(bit);
                }
            }

            return maxXor;
        }
    }
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int maxXor = 0;

        for (int i = 0; i < nums.length; i++) {
            Trie trie = new Trie();
            for (int j = i; j < nums.length && (2*nums[i] >= nums[j]); j++) {
                trie.insert(nums[j]);
                System.out.print(nums[j] + " ");
            }
            
            maxXor = Math.max(trie.findMaxXor(nums[i]), maxXor);

            System.out.println("=" + maxXor);
        }
        
        return maxXor;
    }
}