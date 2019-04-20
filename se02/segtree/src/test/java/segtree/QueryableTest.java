package segtree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryableTest {

    private static Random gen;
    private int[] inputData;

    @BeforeAll
    static void setupGenerator() {
        gen = new Random(1234);

        throw new RuntimeException("You need to read 'dataset1.txt' and load" +
                "it to test the implementation with differential testing");
    }

    @BeforeEach
    void initializeTestData() {
        inputData = new int[1_000_000];
        Arrays.fill(inputData, 1);
    }

    @Test
    void naiveShouldComputeSumsGivenRanges() {
        Queryable<Integer> algorithm = new NaiveSumQuery(inputData);

        final int QUERIES = 1_000_000;

        for (int run = 0; run < QUERIES; run++) {

            int left = gen.nextInt(inputData.length);
            int rangeSize = gen.nextInt(inputData.length - left);
            rangeSize = rangeSize == 0 ? 1 : rangeSize;
            int right = left + rangeSize;

            int expectedSum = right - left;
            assertEquals(expectedSum, algorithm.query(left, right));
        }
    }

    @Test
    void segTreeShouldComputeSumsGivenRanges() {
        Queryable<Integer> algorithm = new SegmentTree(inputData);

        final int QUERIES = 1_000_000;

        for (int run = 0; run < QUERIES; run++) {

            int left = gen.nextInt(inputData.length);
            int rangeSize = gen.nextInt(inputData.length - left);
            rangeSize = rangeSize == 0 ? 1 : rangeSize;
            int right = left + rangeSize;

            int expectedSum = right - left;
            assertEquals(expectedSum, algorithm.query(left, right));
        }
    }
}
