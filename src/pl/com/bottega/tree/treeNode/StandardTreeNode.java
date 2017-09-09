package pl.com.bottega.tree.treeNode;

import pl.com.bottega.tree.treeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class StandardTreeNode<E> implements TreeNode {

    private E element;
    private List<TreeNode<E>> children = new LinkedList<>();

    public StandardTreeNode(E element) {
        this.element = element;
    }

    @Override
    public void add(TreeNode child) {
        children.add(child);
    }

    @Override
    public List<TreeNode<E>> children() {
        return children;
    }

    @Override
    public E element() {
        return element;
    }
}
