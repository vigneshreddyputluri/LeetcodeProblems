import java.util.*;

    class Solution {

        class Node {
            
            Node[] links;

            Node() {
                links = new Node[2];
            }

            void put(int bit) {
                if (! this.containsKey(bit))
                    this.links[bit] = new Node();
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

                    if (! n.containsKey(bit)){
                        n.put(bit);
                    }

                    n = n.get(bit);
                }
            }

            int findMaxXor(int num) {
                Node n = root;
                int maxXor = 0;

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

        public int[] maximizeXor(int[] nums, int[][] queries) {

            // storing offline queries and initiating index
            int[][] offlineQueries = new int[queries.length][3];
            int index = 0;

            // filling queries into offline queries array as (m, a, i)
            for (int[] query : queries) {
                offlineQueries[index] = new int[]{query[1],query[0],index++};
            }

            // sorting 2d offline queries with m values increasing in order
            // and nums array so that we insert one by one
            Arrays.sort(offlineQueries, (a, b) -> Integer.compare(a[0], b[0]));
            Arrays.sort(nums);

            // declaring and initiating results array to store the result values
            int[] results = new int[queries.length];
            index = 0; 

            // initiating a Trie
            Trie trie = new Trie();
            // trie.insert(0);

            // insertion and finding maximum xor values
            for (int[] query : offlineQueries) {
            
                // inserting numbers till the m in a query
                while (index < nums.length && nums[index] <= query[0]){
                    trie.insert(nums[index]);
                    index++;
                }

                // results[i] = maxXOR(a), where queries are like (m, a, i)
                if (index != 0) results[query[2]] = trie.findMaxXor(query[1]);
                else results[query[2]] = -1;

            }

            // System.out.println(Arrays.toString(nums));

            // for (int[] i : offlineQueries) {
            //     System.out.println(Arrays.toString(i));
            // }

            // replacing 0's with -1 for desired output
            // for (int i = 0; i < results.length; i++) {
            //     if (results[i] == 0) {
            //         results[i] = -1;
            //     }
            // }

            return results;
        }
    }