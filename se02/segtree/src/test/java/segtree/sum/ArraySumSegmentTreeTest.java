package segtree.sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraySumSegmentTreeTest {

    private ArraySumSegmentTree segTree;

    /*

    For the input [1, 1, 1, 1, 1],
    this is the expected tree representation (for the summation problem):

               5
            3     2
          2  1  1  1
        1  1

     */
    @BeforeEach
    void initializeData() {
        int[] input = new int[5];
        Arrays.fill(input, 1);
        segTree = new ArraySumSegmentTree(input);
    }

    @Test
    void shouldBuildInternalRepresentation() {

        int[] expectedInternalRepr = {
                5,
                3, 2,
                2, 1, 1, 1,
                1, 1
        };

        int[] actualRepr = segTree.internalRepresentation();
        for (int i = 0; i < expectedInternalRepr.length; i++) {
            assertEquals(expectedInternalRepr[i], actualRepr[i],
                    String.format("Unexpected i-th (%d) element. Bad split?", i));
        }
    }

    /**
     * A "matching interval" occurs when the given interval is exactly covered by a given node.
     */
    @Test
    void shouldBeAbleToQueryWithMatchingInterval() {

        // Case 1: root node
        int expectedSum = 5;
        assertEquals(expectedSum, segTree.query(0, 5));

        // Case 2: leaf node
        expectedSum = 1;
        assertEquals(expectedSum, segTree.query(0, 1));
        assertEquals(expectedSum, segTree.query(4, 5));

        // Case 3: internal node
        expectedSum = 2;
        assertEquals(expectedSum, segTree.query(0, 2));
        assertEquals(expectedSum, segTree.query(3, 5));

    }

    /**
     * In case the query doesn't fall completely into a node, it is necessary to compute the partial sums,
     * i.e., check both children and combine the partial sums.
     */
    @Test
    void shouldComputeAndCombinePartialSums() {

        int expectedSum = 4;
        assertEquals(expectedSum, segTree.query(0, 4));

        expectedSum = 2;
        assertEquals(expectedSum, segTree.query(2, 4));

    }
}
