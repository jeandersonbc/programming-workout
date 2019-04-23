package segtree.sum;

import segtree.Queryable;
import segtree.Representable;

public class SumNodeSegmentTree implements Queryable<Integer>, Representable<int[]> {

    private final Node root;

    private class Node {
        Node left;

        Node right;
        int data;
        int rangeRight;
        int rangeLeft;

        Node(int rangeLeft, int rangeRight) {
            this.rangeRight = rangeRight;
            this.rangeLeft = rangeLeft;
        }

    }

    public SumNodeSegmentTree(int[] inputData) {
        this.root = new Node(0, inputData.length - 1);
        build(this.root, inputData);
    }

    @Override
    public int[] internalRepresentation() {
        int size = this.root.rangeRight + 1;
        int[] treeAsArray = new int[size << 2];
        buildInternalArray(this.root, 0, treeAsArray);
        return treeAsArray;
    }

    private void buildInternalArray(Node node, int pos, int[] tree) {
        if (node != null) {
            tree[pos] = node.data;
            buildInternalArray(node.left, (pos * 2 + 1), tree);
            buildInternalArray(node.right, (pos * 2 + 2), tree);
        }
    }

    @Override
    public Integer query(int i, int j) {
        return query(i, --j, this.root);
    }

    private void build(Node node, int[] data) {
        if (node.rangeLeft == node.rangeRight) {
            node.data = data[node.rangeLeft];
            return;
        }
        int mid = (node.rangeLeft + node.rangeRight) >> 1;

        Node left = new Node(node.rangeLeft, mid);
        build(left, data);
        node.left = left;

        Node right = new Node(mid + 1, node.rangeRight);
        build(right, data);
        node.right = right;

        node.data = left.data + right.data;
    }

    private Integer query(int i, int j, Node node) {
        if (i == node.rangeLeft && j == node.rangeRight) {
            return node.data;
        }
        int mid = (node.rangeLeft + node.rangeRight) >> 1;
        if (j <= mid) {
            return query(i, j, node.left);
        } else if (i > mid) {
            return query(i, j, node.right);
        }
        int left = query(i, mid, node.left);
        int right = query(mid + 1, j, node.right);
        return left + right;
    }
}
