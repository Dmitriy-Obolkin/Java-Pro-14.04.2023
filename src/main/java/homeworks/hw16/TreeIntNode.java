package homeworks.hw16;

import java.util.ArrayList;
import java.util.List;

public class TreeIntNode {

    private final int value;
    private TreeIntNode parent;
    List<TreeIntNode> children;

    public TreeIntNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public void addChild(TreeIntNode child) {
        if (this == child || this.equals(child)) {
            throw new IllegalArgumentException("A node cannot be a child to itself.");
        }
        if (isDescendant(child)) {
            throw new IllegalArgumentException("The provided child node is a parent or ancestor of this node.");
        }
        if (child.isDescendant(this)) {
            throw new IllegalArgumentException("The provided child node already has this node as a descendant.");
        }

        children.add(child);
        child.parent = this;
    }
    public boolean isDescendant(TreeIntNode node) {
        TreeIntNode current = parent;
        while (current != null) {
            if (current == node || current.equals(node)) {
                return true;
            }
            current = current.parent;
        }
        return false;
    }

    public void iterate() {
        iterate(this);
    }
    private void iterate(TreeIntNode node) {
        System.out.println(node.getValue());
        for (TreeIntNode child : node.children) {
            iterate(child);
        }
    }

    public int sum() {
        return sum(this);
    }
    private int sum(TreeIntNode node) {
        int total = node.getValue();
        for (TreeIntNode child : node.children) {
            total += sum(child);
        }
        return total;
    }


}
