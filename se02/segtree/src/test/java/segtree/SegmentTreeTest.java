package segtree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentTreeTest {

    private SegmentTree segTree;

    @BeforeEach
    void initializeData() {
        int[] input = new int[5];
        Arrays.fill(input, 1);
        segTree = new SegmentTree(input);
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
}
