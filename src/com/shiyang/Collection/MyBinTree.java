package com.shiyang.Collection;

import java.util.*;

/*
 * 满二叉树：高度为k,且拥有(2^k)-1个节点的二叉树。一颗满二叉树每个节点，要么没有子树，要么都有两个子树；且每一层结点之间必须要么都有两颗子树，要么都没子树
 * 完全二叉树：假设完全二叉树高度为k;必须遵循1.所有叶子结点都出现在k层或k-1层，并且从1-k-1层必须达到最大结点数；2.第k层可以不满，但第k层所有结点必须都集中在最左侧
 */
public class MyBinTree {
    public BinTreeNode root;
    public int N; // 记录结点个数


    /*
     * 二叉树创建 一般分两种情况：初始化一个根结点或者初始化一颗空二叉树
     */
    public MyBinTree() {
        super();
    }

    public MyBinTree(BinTreeNode root) {
        this.root = root;
    }

    /*
     * 二叉树的插入 插入分为：插入某个节点的左子节点，插入某个节点的右子结点
     */
    public static void insertLeft(BinTreeNode parent, BinTreeNode node) {
        parent.setLchild(node);
    }

    public static void insertRight(BinTreeNode parent, BinTreeNode node) {
        parent.setRchild(node);
    }

    /*
     * 图形搜索算法：广度优先搜索BFS与深度优先DFS
     * 适用于图与树
     */
//	广度优先搜索，先遍历根结点，再依次遍历他的子节点。非迭代，while循环
    public ArrayList<Character> BFS(BinTreeNode root) {
        ArrayList<Character> lists = new ArrayList<Character>();
        if (root == null) {
            return lists;
        }
        Queue<BinTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinTreeNode node = queue.poll();
            if (node.lchild != null) {
                queue.offer(node.lchild);
            }
            if (node.rchild != null) {
                queue.offer(node.rchild);
            }
            lists.add(node.data);
        }
        return lists;

    }

    /**
     * 深度优先遍历：非递归实现
     *
     * @param root
     * @return 遍历数组
     */
    public ArrayList<Character> DFS(BinTreeNode root) {
        ArrayList<Character> lists = new ArrayList<Character>();
        if (root == null)
            return lists;
        Stack<BinTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinTreeNode node = stack.pop();
            if (node.rchild != null) {
                stack.push(node.rchild);
            }
            if (node.lchild != null) {
                stack.push(node.rchild);
            }
            lists.add(node.data);
        }
        return lists;
    }

    /**
     * 深度优先搜索;递归实现
     *
     * @param node 根结点
     * @param list 遍历数组
     */
    public void DFS(BinTreeNode node, List<Character> list) {

        if (node != null) {
            list.add(node.data);
            if (node.getLchild() != null) {
                list.add(node.lchild.data);
                DFS(node.lchild, list);
            }
            if (node.getRchild() != null) {

                list.add(node.rchild.data);
                DFS(node.rchild, list);
            }
        }
    }

    /*
     * 二叉树的清空 首先提供一个清空以某个节点为根结点的子树的方法，即递归的删除每个节点； 接着提供一个删除树的方法，直接通过第一种方法删除根结点即可
     */
    // 清除某个子树的所有结点
    public void clear(BinTreeNode node) {
        if (node != null) {
            clear(node.getLchild());
            clear(node.getRchild());
            node = null;
        }
    }

    // 清空树
    public void clear() {
        clear(root);
    }

    /*
     * 判断二叉树是否为空
     */
    public boolean isEmpty() {
        return root == null;
    }

    /*
     * 球二叉树的高度 首先要一种获取某个节点为子树的高度的方法，使用递归调用 如果一个节点为空，那么这个结点肯定是一个空树，高度为0；
     * 如果不为空，那么我们要遍历地比较他的左子树高度和右子树高度，高的那个为这个子树的最大高度，然后加上自己本身高度
     */
    // 获取以某结点为子树的长度
    public int heigh(BinTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int l = heigh(node.getLchild());
            int r = heigh(node.getRchild());
            return l > r ? (l + 1) : (r + 1);
        }
    }

    public int heigh() {
        return heigh(root);
    }

    /*
     * 球二叉树的节点数 结点为空，则个数为0； 如果不为空，那就算上该节点之后继续递归所有左右子树的子节点数
     */
    public int size(BinTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.getLchild()) + size(node.getRchild());
        }
    }

    public int size() {
        return size(root);
    }

    /*
     * 返回某结点的父节点
     */
    // node结点在subTree子树中的父节点
    public BinTreeNode getParent(BinTreeNode subTree, BinTreeNode node) {
        if (subTree == null) {
            return null;
        }
        if (subTree.getLchild() == node || subTree.getRchild() == node) {
            return subTree;
        }
        BinTreeNode parent = null;
        if (getParent(subTree.getLchild(), node) != null) {
            parent = getParent(subTree.getLchild(), node);
            return parent;
        } else {
            return getParent(subTree.getRchild(), node);
        }
    }

    // 查找node结点在二叉树中的父节点
    public BinTreeNode getParent(BinTreeNode node) {
        return (root == null || root == node) ? null : getParent(root, node);
    }

    /*
     * 返回左右子树
     */
    public BinTreeNode getLeftTree(BinTreeNode node) {
        return node.getLchild();
    }

    public BinTreeNode getRightTree(BinTreeNode node) {
        return node.getRchild();
    }

    public BinTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinTreeNode root) {
        this.root = root;
    }

    /*
     * 前序:根左右
     */
    public void preOrder(BinTreeNode rt) {
        if (rt != null) {
            System.out.println(rt.getData());
            preOrder(rt.getLchild());
            preOrder(rt.getRchild());
        }
    }

    /*
     * 中序：左根右
     */
    public void inOrder(BinTreeNode rt) {
        if (rt != null) {
            inOrder(rt.getLchild());
            System.out.println(rt.data);
            inOrder(rt.getRchild());
        }
    }

    /*
     * 后序：左右根
     */
    public void postOrder(BinTreeNode rt) {
        if (rt != null) {
            postOrder(rt.getLchild());
            postOrder(rt.getRchild());
            System.out.println(rt.getData());
        }

    }
}