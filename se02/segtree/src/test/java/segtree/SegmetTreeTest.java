package segtree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmetTreeTest {

    @Test
    void shouldBuildInternalRepresentation() {
        int[] input = new int[5];
        Arrays.fill(input, 1);

        SegmentTree segTree = new SegmentTree(input);

        int[] expectedInternalRepr = {
                      5,
                   3,    2,
                  2, 1, 1, 1,
                1, 1
        };

        int[] actualRepr = segTree.internalRepresentation();
        for (int i = 0; i < expectedInternalRepr.length; i++) {
            assertEquals(expectedInternalRepr[i], actualRepr[i],
                    String.format("Unexpected i-th (%d) element. Bad split?", i));
        }
    }
}
