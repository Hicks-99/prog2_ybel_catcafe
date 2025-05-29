package catcafe;

import tree.Empty;
import tree.Node;
import tree.TreeVisitor;

public class PostOrderVisitor<T extends Comparable<T>> implements TreeVisitor<T> {

    @Override
    public String visit(Empty<T> node) {
        return "";
    }

    @Override
    public String visit(Node<T> node) {
        String leftSubtree = node.leftChild().accept(this);
        String rightSubtree = node.rightChild().accept(this);
        String currentNodeData = node.data().toString();

        String leftPart = leftSubtree.isEmpty() ? "" : leftSubtree + " ";
        String rightPart = rightSubtree.isEmpty() ? "" : rightSubtree + " ";

        return leftPart + rightPart + currentNodeData;
    }
}
