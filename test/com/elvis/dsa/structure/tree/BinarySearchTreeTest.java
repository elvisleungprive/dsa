package com.elvis.dsa.structure.tree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @BeforeEach
    void treeCreation() {
        bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(3);
        bst.insert(1);
        bst.insert(6);
        bst.insert(7);
        bst.insert(10);
        bst.insert(14);
        bst.insert(4);
    }

    @AfterEach
    void treeTermination() {
        bst = null;
    }

    @Test
    void findMinTest() {
        assertEquals(1, bst.findMin());
    }

    @Test
    void findMaxTest() {
        assertEquals(14, bst.findMax());
    }

    @Test
    void findTest() {
        assertEquals(8, bst.find(8).value);
        assertEquals(1, bst.find(1).value);
        assertEquals(14, bst.find(14).value);
        assertEquals(4, bst.find(4).value);
        assertNull(bst.find(-1));
        assertNull(bst.find(20));
        assertNull(bst.find(2));
    }

    @Test
    void deleteTest() {
        assertEquals(1, bst.findMin());
        assertEquals(14, bst.findMax());
        assertEquals(8, bst.root.value);

        // delete min
        bst.delete(1);
        assertEquals(3, bst.findMin());
        assertEquals(14, bst.findMax());
        assertEquals(8, bst.root.value);

        // delete max
        bst.delete(14);
        assertEquals(3, bst.findMin());
        assertEquals(10, bst.findMax());
        assertEquals(8, bst.root.value);

        // delete root -> left to be root
        bst.delete(8);
        assertEquals(3, bst.findMin());
        assertEquals(10, bst.findMax());
        assertEquals(7, bst.root.value);
    }

    @Test
    void deleteRootAndPreorderTest() {
        bst.delete(8);
        assertEquals("7, 3, 1, 6, 4, 10, 14, ", bst.preorderTraverse());
    }

    @Test
    void deleteLeafAndPreorderTest2() {
        bst.delete(1);
        assertEquals("8, 3, 6, 4, 7, 10, 14, ", bst.preorderTraverse());
    }

    @Test
    void deleteMiddleAndPreorderTest3() {
        bst.delete(6);
        assertEquals("8, 3, 1, 4, 7, 10, 14, ", bst.preorderTraverse());
        bst.delete(10);
        assertEquals("7, 3, 1, 6, 4, 14, ", bst.preorderTraverse());
        bst.delete(6);
        assertEquals("7, 3, 1, 4, 14, ", bst.preorderTraverse());
        bst.delete(3);
        assertEquals("7, 1, 4, 14, ", bst.preorderTraverse());
        bst.delete(14);
        assertEquals("7, 1, 4, ", bst.preorderTraverse());
        bst.delete(1);
        assertEquals("7, 4, 14, ", bst.preorderTraverse());
        bst.delete(7);
        assertEquals("1, 14, ", bst.preorderTraverse());
        bst.delete(14);
        assertEquals("1, ", bst.preorderTraverse());
    }

    @Test
    void preorderTest() {
        String expected = "8, 3, 1, 6, 4, 7, 10, 14, ";
        assertEquals(expected, bst.preorderTraverse());
    }

    @Test
    void inorderTest() {
        String expected = "1, 3, 4, 6, 7, 8, 10, 14, ";
        assertEquals(expected, bst.inorderTraverse());
    }

    @Test
    void postorderTest() {
        String expected = "1, 4, 7, 6, 3, 14, 10, 8, ";
        assertEquals(expected, bst.postorderTraverse());
    }

    // @Test
    void prettyPrintTree() {
        Solution s = new Solution();
        TreeNode a = new TreeNode(30);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(40);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(25);
        TreeNode f = new TreeNode(35);
        TreeNode g = new TreeNode(50);
        TreeNode h = new TreeNode(5);
        TreeNode i = new TreeNode(15);
        TreeNode j = new TreeNode(28);
        TreeNode k = new TreeNode(41);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        e.right = j;
        g.left = k;

        s.prettyPrintTree(a);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public void prettyPrintTree(TreeNode root) {
        if (root == null) {
            return;
        }

        int[] size = new int[1];
        size[0] = 0;
        int height = height(root, size) - 1;
        int total = 2 * (int) Math.pow(2, height) - 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        for (int i = 0; i <= height; i++) {
            int front = (int) (Math.pow(2, (height - i))) - 1;
            int num = (int) (Math.pow(2, i));
            int interval = num > 1 ? (total - front * 2 - num) / (num - 1) : 0;

            for (int j = 0; j < num; j++) {
                TreeNode peek = queue.poll();

                if (j == 0) {
                    print(front, size, peek);
                } else {
                    print(interval, size, peek);
                }

                if (peek == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    queue.offer(peek.left);
                    queue.offer(peek.right);
                }
            }

            System.out.println();
        }
    }

    private int height(TreeNode root, int[] size) {
        if (root == null) {
            return 0;
        }

        size[0] = Math.max(size[0], Integer.toString(root.val).length());
        return Math.max(height(root.left, size), height(root.right, size)) + 1;
    }

    private void print(int count, int[] size, TreeNode root) {
        for (int i = 0; i < count * size[0]; i++) {
            System.out.print(" ");
        }

        if (root != null) {
            for (int j = 0; j < size[0] - Integer.toString(root.val).length(); j++) {
                System.out.print(" ");
            }

            System.out.print(root.val);
        } else {
            for (int j = 0; j < size[0]; j++) {
                System.out.print(" ");
            }
        }
    }
}
