package pl.com.bottega.tree;


public interface TreeNodeVisitor<E> {

    void visit(E element, int level);
}
