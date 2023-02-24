package AC2_Course.Trie;

public class MaxXOR {
    public static void main(String[] args) {
        //1033222
        int[] nums = {181262, 369842, 1036879, 546331, 868986, 496157, 646816, 459571, 215643, 448018};
        int max = 0;

//        int[] nums = {1, 2, 3, 4, 5};

        for (int i = 0; i < nums.length; i++) {
            addToTrie(nums[i]);
            int res = 0;
            Node node = head;
            for (int j = 31; j >= 0; j--) {
                if (node == null) break;
                int bit = (nums[i] >> j) & 1;
                if (bit == 0 && node.high != null) {
                    res += (1 << j);
                    node = node.high;
                } else if (bit == 1 && node.low != null) {
                    res += (1 << j);
                    node = node.low;
                } else {
                    node = bit == 0 ? node.low : node.high;
                }

            }
            max = Math.max(max, res);
        }
        System.out.println(max);
    }

    public static void addToTrie(int num) {
        Node node = head;
        int i = 31;
        while (i >= 0) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (node.low == null) {
                    node.low = new Node();
                }
                node = node.low;
            } else {
                if (node.high == null) {
                    node.high = new Node();
                }
                node = node.high;
            }
            i--;
        }
    }

    static Node head = new Node();

    static class Node {
        Node low;
        Node high;

        public Node() {
        }
    }
}

