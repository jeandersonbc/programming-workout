package segtree;

/**
 * Defines the problem of querying for a result of type T within a range.
 *
 * @param <T> The type of the result to be queried
 * @author Jeanderson Candido (https://github.com/jeandersonbc)
 */
public interface Queryable<T> {

    /**
     * Perform a query within the given range [i...j) for i < j.
     *
     * @param i initial range (including)
     * @param j final range (excluding)
     * @return The result.
     */
    T query(int i, int j);
}
