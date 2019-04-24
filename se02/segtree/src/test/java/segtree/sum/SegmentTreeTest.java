package segtree.sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import segtree.Queryable;
import segtree.Representable;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SegmentTreeTest {

    static Stream<Representable<int[]>> representableFactory() {
        int[] input = new int[5];
        Arrays.fill(input, 1);
        return Stream.of(new ArrayBasedSegTree(input), new NodeBasedSegTree(input));
    }

    static Stream<Queryable<Integer>> queryableFactory() {
        int[] input = new int[5];
        Arrays.fill(input, 1);
        return Stream.of(new ArrayBasedSegTree(input), new NodeBasedSegTree(input));
    }

    @ParameterizedTest
    @MethodSource("representableFactory")
    void shouldBuildInternalRepresentation(Representable<int[]> representable) {

        int[] expectedInternalRepr = {
                5,
                3, 2,
                2, 1, 1, 1,
                1, 1
        };

        int[] actualRepr = representable.internalRepresentation();
        for (int i = 0; i < expectedInternalRepr.length; i++) {
            assertEquals(expectedInternalRepr[i], actualRepr[i],
                    String.format("Unexpected i-th (%d) element. Bad split?", i));
        }
    }

    /**
     * A "matching interval" occurs when the given interval is exactly covered by a given node.
     */
    @ParameterizedTest
    @MethodSource("queryableFactory")
    void shouldBeAbleToQueryWithMatchingInterval(Queryable<Integer> queryable) {
        // Case 1: root node
        int expectedSum = 5;
        assertEquals(expectedSum, queryable.query(0, 5));

        // Case 2: leaf node
        expectedSum = 1;
        assertEquals(expectedSum, queryable.query(0, 1));
        assertEquals(expectedSum, queryable.query(4, 5));

        // Case 3: internal node
        expectedSum = 2;
        assertEquals(expectedSum, queryable.query(0, 2));
        assertEquals(expectedSum, queryable.query(3, 5));

    }

    /**
     * In case the query doesn't fall completely into a node, it is necessary to compute the partial sums,
     * i.e., check both children and combine the partial sums.
     */
    @ParameterizedTest
    @MethodSource("queryableFactory")
    void shouldComputeAndCombinePartialSums(Queryable<Integer> queryable) {

        int expectedSum = 4;
        assertEquals(expectedSum, queryable.query(0, 4));

        expectedSum = 2;
        assertEquals(expectedSum, queryable.query(2, 4));

    }
}
