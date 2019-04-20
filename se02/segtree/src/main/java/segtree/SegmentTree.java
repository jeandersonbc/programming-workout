package segtree;

import java.util.Arrays;

public class SegmentTree implements Queryable<Integer> {

    private int leaves;
    private int[] tree;

    public SegmentTree(int[] inputData) {
        this.tree = new int[inputData.length << 2];
        this.leaves = inputData.length;
        build(0, this.leaves - 1, 0, inputData);
    }

    @Override
    public Integer query(int i, int j) {
        return query(i, j - 1, 0, this.leaves - 1, 0);
    }

    private Integer query(int leftQuery, int rightQuery, int intervalLeft, int intervalRight, int pos) {
        if (leftQuery == intervalLeft && rightQuery == intervalRight) {
            return this.tree[pos];
        }

        int intervalMid = (intervalLeft + intervalRight) >> 1;
        if (rightQuery <= intervalMid) {
            return query(leftQuery, rightQuery, intervalLeft, intervalMid, left(pos));
        }
        if (leftQuery > intervalMid) {
            return query(leftQuery, rightQuery, intervalMid + 1, intervalRight, right(pos));
        }
        int left = query(leftQuery, intervalMid, intervalLeft, intervalMid, left(pos));
        int right = query(intervalMid + 1, rightQuery, intervalMid + 1, intervalRight, right(pos));
        return left + right;
    }

    /**
     * Builds the internal representation of the seg tree.
     *
     * @param left  Left index (inclusive)
     * @param right Right index (inclusive)
     * @param pos   The current position in the seg tree
     * @param data  The data to be processed
     */
    private void build(int left, int right, int pos, int[] data) {
        if (left == right)
            this.tree[pos] = data[left];
        else {
            int mid = (left + right) >> 1;
            build(left, mid, left(pos), data);
            build(mid + 1, right, right(pos), data);
            this.tree[pos] = this.tree[left(pos)] + this.tree[right(pos)];
        }
    }

    public int[] internalRepresentation() {
        return Arrays.copyOf(this.tree, this.tree.length);
    }

    // Access and utility methods for the tree representation using arrays

    private int parent(int i) {
        return isEven(i) ? ((i - 2) >> 1) : i >> 1;
    }

    private int right(int i) {
        return (i << 1) + 2;
    }

    private int left(int i) {
        return (i << 1) + 1;
    }

    private boolean isEven(int value) {
        return (value & 1) == 0;
    }

}
