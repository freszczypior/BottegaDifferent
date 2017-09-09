package pl.com.bottega.tree.app;


import pl.com.bottega.tree.TreeNodeVisitor;
import pl.com.bottega.tree.TreePresenter;
import pl.com.bottega.tree.TreeWalker;
import pl.com.bottega.tree.treeNode.StandardTreeNode;
import pl.com.bottega.tree.treeNode.TreeNode;

public class StandardTreeNodeApp {

    private static int count;

    public static void main(String[] args) {
        TreeNode<String> root = new StandardTreeNode<>("Kategoria");
        TreeNode<String> komputery = new StandardTreeNode<>("Komputery");
        TreeNode<String> smartfony = new StandardTreeNode<>("Smartfony");
        TreeNode<String> tablety = new StandardTreeNode<>("Tablety");

        root.add(komputery);
        root.add(smartfony);
        root.add(tablety);

        TreeNode<String> stacjonarne = new StandardTreeNode<>("Stacjonarne");
        TreeNode<String> laptopy = new StandardTreeNode<>("Laptopy");
        TreeNode<String> podzespoły = new StandardTreeNode<>("Podzespoły");

        komputery.add(stacjonarne);
        komputery.add(laptopy);
        komputery.add(podzespoły);

        TreeNode<String> android = new StandardTreeNode<>("Android");
        TreeNode<String> apple = new StandardTreeNode<>("Apple");
        TreeNode<String> windows = new StandardTreeNode<>("Windows");

        smartfony.add(android);
        smartfony.add(apple);
        smartfony.add(windows);

        TreePresenter treePresenter = new TreePresenter(root);
        treePresenter.showTree();


        TreeWalker<String> walker = new TreeWalker<>(root);


        //to poniżej chyba nic nie robi
        walker.walk(new TreeNodeVisitor<String>() {
            @Override
            public void visit(String element, int level) {
                System.out.println(element);
            }

            private String spaces(int level) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < level; i++) {
                    sb.append("\t");
                }
                return sb.toString();
            }
        });

        TreeNodeVisitor<String> countingVisitor = new TreeNodeVisitor<String>() {
            @Override
            public void visit(String element, int level) {
                count++;
            }

        };
        walker.walk(countingVisitor);
        System.out.println(count);
    }

}
