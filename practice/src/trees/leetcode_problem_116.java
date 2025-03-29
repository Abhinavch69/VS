package trees;

import java.util.*;

class Node {
    public int val;
    public Node left, right, next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

public class leetcode_problem_116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMost = root;
        while (leftMost.left != null) {
            Node curr = leftMost;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    // Helper function to print next pointers at each level
    public static void printNextPointers(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node curr = levelStart;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
            System.out.println("NULL");
            levelStart = levelStart.left; // Move to next level
        }
    }

    public static void main(String[] args) {
      leetcode_problem_116  solution = new leetcode_problem_116 ();

        // Constructing a perfect binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Connect nodes
        solution.connect(root);

        // Print next pointers
        printNextPointers(root);
    }
}
