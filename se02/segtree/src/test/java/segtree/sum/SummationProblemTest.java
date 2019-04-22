package segtree.sum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segtree.Queryable;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummationProblemTest {

    private static Random gen;
    private int[] inputData;
    private int[] inputRandomData;

    @BeforeAll
    static void setupGenerator() {
        gen = new Random(1234);
    }

    @BeforeEach
    void initializeTestData() throws IOException {
        inputData = new int[1_000_000];
        Arrays.fill(inputData, 1);
        inputRandomData = loadRandomNumbers();
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
    void treeSumlShouldComputeSumsGivenRanges() {
        Queryable<Integer> algorithm = new TreeSumSegTree(inputData);

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
    void arraySumShouldComputeSumsGivenRanges() {
        Queryable<Integer> algorithm = new ArraySumSegmentTree(inputData);

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
    void shouldProduceSameResultWithRandomData() {
        Queryable<Integer> naive = new NaiveSumQuery(inputRandomData);
        Queryable<Integer> arraySum = new ArraySumSegmentTree(inputRandomData);
        Queryable<Integer> segTree = new TreeSumSegTree(inputRandomData);

        final int QUERIES = 1_000_000;

        for (int run = 0; run < QUERIES; run++) {

            int left = gen.nextInt(inputRandomData.length);
            int rangeSize = gen.nextInt(inputRandomData.length - left);
            rangeSize = rangeSize == 0 ? 1 : rangeSize;
            int right = left + rangeSize;

            int expectedSum = naive.query(left, right);
            assertEquals(expectedSum, arraySum.query(left, right));
            assertEquals(expectedSum, segTree.query(left, right));
        }

    }

    private int[] loadRandomNumbers() throws IOException {
        URL dataLocation = getClass().getClassLoader().getResource("sum/dataset1.txt");
        if (dataLocation == null)
            throw new RuntimeException("dataset1.txt could not be found");

        final int DATASET1_SIZE = 100_000;
        Scanner in = new Scanner(Path.of(dataLocation.getPath()), StandardCharsets.UTF_8);
        int[] temp = new int[DATASET1_SIZE];
        for (int i = 0; i < DATASET1_SIZE; i++) {
            temp[i] = Integer.parseInt(in.nextLine());
        }
        return temp;
    }
}
