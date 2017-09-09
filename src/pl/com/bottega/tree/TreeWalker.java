package pl.com.bottega.tree;

import pl.com.bottega.tree.treeNode.TreeNode;

public class TreeWalker<E>{

    private final TreeNode<E> root;

    public TreeWalker(TreeNode<E> node){
        this.root = node;
    }

    public void walk(TreeNodeVisitor<E> visitor){

    }

    private void walkRecursion(TreeNode<E> node, TreeNodeVisitor<E> visitor, int level){
        visitor.visit(node.element(), level);
        for (TreeNode<E> child: node.children())
            walkRecursion(child, visitor, level+1);
    }
}
