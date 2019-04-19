package segtree;

public class NaiveSumQuery implements Queryable<Integer> {

    private final int[] values;

    public NaiveSumQuery(int[] values) {
        this.values = values;
    }

    @Override
    public Integer query(int i, int j) {
        int sum = 0;

        // Simple solution but performs badly for a huge amount of queries (number of times this methods is called)
        for (int k = i; k < j; k++) {
            sum += this.values[k];
        }
        return sum;
    }
}
