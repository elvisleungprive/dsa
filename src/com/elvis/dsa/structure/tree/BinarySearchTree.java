package com.elvis.dsa.structure.tree;

import com.elvis.dsa.structure.element.TreeNode;

public class BinarySearchTree {
    public TreeNode root;

    public TreeNode find(int x) {
        TreeNode ptr = root;
        while (ptr != null) {
            if (ptr.value == x)
                return ptr;
            else if (x < ptr.value && ptr.left != null) {
                ptr = ptr.left;
                continue;
            } else if (x > ptr.value && ptr.right != null) {
                ptr = ptr.right;
                continue;
            }
            if (ptr.left == null && ptr.right == null)
                return null;
        }
        return null;
    }

    public int findMin() {
        TreeNode ptr = root;
        while (ptr.left != null)
            ptr = ptr.left;
        return ptr.value;
    }

    public int findMax() {
        TreeNode ptr = root;
        while (ptr.right != null)
            ptr = ptr.right;
        return ptr.value;
    }

    public void insert(int x) {
        TreeNode newNode = new TreeNode(x);
        if (root == null) {
            root = newNode;
            return;
        }
        boolean inserted = false;
        TreeNode ptr = root;
        while (!inserted) {
            if (x <= ptr.value) {
                if (ptr.left == null) {
                    ptr.left = newNode;
                    inserted = true;
                } else {
                    ptr = ptr.left;
                    continue;
                }
            } else {
                if (ptr.right == null) {
                    ptr.right = newNode;
                    inserted = true;
                } else {
                    ptr = ptr.right;
                    continue;
                }
            }
        }
    }

    public void delete(int x) {
        // TODO: handle remove root case, taking left node to be root. If left is null, then right
        TreeNode ptr = root;
        TreeNode prev = null;

        while (ptr != null) {
            if (ptr.value == x) {

            }
        }
        return;
    }
}
