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

    public String preorderTraverse() {
        return preorderTraverse(root);
    }

    private String preorderTraverse(TreeNode node) {
        if (node == null) return "";

        String out = "";
        out += String.format("%s, ", node.value);
        out += preorderTraverse(node.left);
        out += preorderTraverse(node.right);
        return out;
    }

    public String inorderTraverse() {
        return inorderTraverse(root);
    }

    private String inorderTraverse(TreeNode node) {
        if (node == null) return "";

        String out = "";
        out += inorderTraverse(node.left);
        out += String.format("%s, ", node.value);
        out += inorderTraverse(node.right);
        return out;
    }


    public String postorderTraverse() {
        return postorderTraverse(root);
    }

    private String postorderTraverse(TreeNode node) {
        if (node == null) return "";

        String out = "";
        out += postorderTraverse(node.left);
        out += postorderTraverse(node.right);
        out += String.format("%s, ", node.value);
        return out;
    }

    public TreeNode delete(int x) {
        if (root.value == x) {
            // delete root
            TreeNode oldRoot = root;
            if (root.left != null) {
                root = deleteMax(root.left);
                root.right = oldRoot.right;
                root.left = oldRoot.left;
            } else if (root.right != null) {
                root = deleteMin(root.right);
                root.right = oldRoot.right;
                root.left = oldRoot.left;

            } else {
                root = null;
            }
            return oldRoot;
        } else {
            TreeNode prev = null;
            TreeNode ptr = root;

            while (ptr != null) {

                if (x == ptr.value) {
                    if (ptr.left == null && ptr.right == null) {
                        // delete leaf
                        if (x < prev.value) prev.left = null;
                        else prev.right = null;
                    } else {
                        // delete node which is not root and has child nodes
                        if (ptr.value > prev.value) {
                            prev.right = deleteMin(ptr);
                            prev.right.right = ptr.right;
                            prev.right.left = ptr.left;
                        } else if (ptr.value < prev.value) {
                            prev.left = deleteMax(ptr);
                            prev.left.right = ptr.right;
                            prev.left.left = ptr.left;
                        }
                    }
                    return ptr;
                } else if (x < ptr.value) {
                    prev = ptr;
                    ptr = ptr.left;
                    continue;
                } else if (x > ptr.value) {
                    prev = ptr;
                    ptr = ptr.right;
                    continue;
                }
            }
        }
        return null;
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null && node.right == null) return node;

        TreeNode ptr = node;
        TreeNode prev = null;

        while (ptr.left != null) {
            prev = ptr;
            ptr = ptr.left;
        }

        if (prev != null) {
            prev.left = null;
            return ptr;
        }
        return null;
    }

    private TreeNode deleteMax(TreeNode node) {
        if (node.left == null && node.right == null) return node;

        TreeNode ptr = node;
        TreeNode prev = null;

        while (ptr.right != null) {
            prev = ptr;
            ptr = ptr.right;
        }

        if (prev != null) {
            prev.right = null;
            return ptr;
        }
        return null;
    }
}
