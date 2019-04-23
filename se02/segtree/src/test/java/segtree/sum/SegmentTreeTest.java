package segtree.sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segtree.Queryable;
import segtree.Representable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SegmentTreeTest {

    private ArrayBasedSegTree arraySegTree;
    private NodeBasedSegTree nodeSegTree;

    @BeforeEach
    void initializeData() {
        /*

        This is the expected tree representation for the input [1, 1, 1, 1, 1] (for the summation problem):

                   5
                3     2
              2  1  1  1
            1  1

         */
        int[] input = new int[5];
        Arrays.fill(input, 1);

        arraySegTree = new ArrayBasedSegTree(input);
        nodeSegTree = new NodeBasedSegTree(input);
    }

    @Test
    void shouldBuildInternalRepresentation1() {
        Representable<int[]> representable = arraySegTree;


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

    @Test
    void shouldBuildInternalRepresentation2() {
        Representable<int[]> representable = nodeSegTree;


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
    @Test
    void shouldBeAbleToQueryWithMatchingInterval1() {

        Queryable<Integer> queryable = arraySegTree;

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
    @Test
    void shouldComputeAndCombinePartialSums1() {
        Queryable<Integer> queryable = arraySegTree;

        int expectedSum = 4;
        assertEquals(expectedSum, queryable.query(0, 4));

        expectedSum = 2;
        assertEquals(expectedSum, queryable.query(2, 4));

    }

    /**
     * A "matching interval" occurs when the given interval is exactly covered by a given node.
     */
    @Test
    void shouldBeAbleToQueryWithMatchingInterval2() {

        Queryable<Integer> queryable = nodeSegTree;

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
    @Test
    void shouldComputeAndCombinePartialSums2() {
        Queryable<Integer> queryable = nodeSegTree;

        int expectedSum = 4;
        assertEquals(expectedSum, queryable.query(0, 4));

        expectedSum = 2;
        assertEquals(expectedSum, queryable.query(2, 4));

    }
}
