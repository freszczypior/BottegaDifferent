package pl.com.bottega.tree.treeNode;

import java.util.List;

public interface TreeNode<E> {

    // dodaje element jako dziecko węzła
    void add(TreeNode<E> child);

    // zwraca listę dzieci tego węzła
    List<TreeNode<E>> children();

    // zwraca element przechowywany w tym węźle
    E element();

}
