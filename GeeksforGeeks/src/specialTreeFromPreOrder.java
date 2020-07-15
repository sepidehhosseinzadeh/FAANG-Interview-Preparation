import java.util.*;

/*
Construct a special tree from given preorder traversal
Given an array ‘pre[]’ that is Preorder traversal of a binary tree where
 every node has either 0 or 2 children. And an array ‘preLN[]’ with values ‘L’ and ‘N’.
 ‘L’ indicates that the corresponding node in Binary Tree is a leaf node and ‘N’ is non-leaf node.
 Construct the tree from the given two arrays.

Input:  pre[] = {10, 30, 20, 5, 15},  preLN[] = {'N', 'N', 'L', 'L', 'L'}
Output: Root of following tree
          10
         /  \
        30   15
       /  \
      20   5
 */
public class specialTreeFromPreOrder {
    class Node{
    int data;
    Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }

    static int lsize;
    Node constructTree(int n, int pre[], char preLN[])
    {
        lsize=0;
        return traverse(0,n,pre,preLN);
    }
    Node traverse(int at, int n, int[] pre, char[] preLN)
    {
        if(at == n)
            return null;

        Node root = new Node(pre[at]);
        lsize++;
        if(preLN[at] == 'N')
        {
            root.left = traverse(lsize, n, pre, preLN);
            root.right = traverse(lsize, n, pre, preLN);
        }
        return root;
    }
}
