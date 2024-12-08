import java.util.*;

public class TopView {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        Node node;
        int hl; // horizontal level

        Pair(Node node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }

    public static void findTopView(Node root) {
        if (root == null) return;

        // Map to store the first node seen at each horizontal level
        Map<Integer, Integer> map = new TreeMap<>(); // TreeMap to sort by horizontal level
        Queue<Pair> queue = new LinkedList<>();

        // Add the root with horizontal level 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            // If the horizontal level is not already in the map, add it
            if (!map.containsKey(current.hl)) {
                map.put(current.hl, current.node.data);
            }

            // Add the left and right children with updated horizontal levels
            if (current.node.left != null) {
                queue.add(new Pair(current.node.left, current.hl - 1));
            }
            if (current.node.right != null) {
                queue.add(new Pair(current.node.right, current.hl + 1));
            }
        }

        
        for (int key : map.values()) {
            System.out.print(key + " ");
        }
    }

    public static void main(String[] args) {
        
        Node n6 = new Node(6);
        Node n5 = new Node(5, null, n6);
        Node n4 = new Node(4, null, n5);
        Node n2 = new Node(2, null, n4);
        Node n3 = new Node(3);
        Node n1 = new Node(1, n2, n3);

        findTopView(n1);
    }
}
