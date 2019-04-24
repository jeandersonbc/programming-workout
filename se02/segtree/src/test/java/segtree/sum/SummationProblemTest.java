package segtree.sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import segtree.Queryable;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SummationProblemTest {

    private static final Random GEN = new Random(1234);

    static Stream<Arguments> paramFactory() throws IOException {
        int[] simpleData = new int[1_000_000];
        Arrays.fill(simpleData, 1);
        int[] randomData = loadRandomNumbers();

        Queryable<Integer> naiveSimple = new NaiveSolution(simpleData);
        Queryable<Integer> naiveRandom = new NaiveSolution(randomData);
        Queryable<Integer> nodeBasedSimple = new NodeBasedSegTree(simpleData);
        Queryable<Integer> nodeBasedRandom = new NodeBasedSegTree(randomData);
        Queryable<Integer> arrayBasedSimple = new ArrayBasedSegTree(simpleData);
        Queryable<Integer> arrayBasedRandom = new ArrayBasedSegTree(randomData);

        return Stream.of(
                arguments(naiveSimple, nodeBasedSimple, simpleData, 1_000_000),
                arguments(naiveSimple, arrayBasedSimple, simpleData, 1_000_000),
                arguments(naiveRandom, nodeBasedRandom, randomData, 100_000),
                arguments(naiveRandom, arrayBasedRandom, randomData, 100_000)
        );
    }

    @ParameterizedTest
    @MethodSource("paramFactory")
    void shouldProduceSameResultWithRandomData(Queryable<Integer> reference,
                                               Queryable<Integer> underTest,
                                               int[] data,
                                               int queries) {

        for (int run = 0; run < queries; run++) {

            int left = GEN.nextInt(data.length);
            int rangeSize = GEN.nextInt(data.length - left);
            rangeSize = rangeSize == 0 ? 1 : rangeSize;
            int right = left + rangeSize;

            int expectedSum = reference.query(left, right);
            assertEquals(expectedSum, underTest.query(left, right));
        }

    }

    private static int[] loadRandomNumbers() throws IOException {
        URL dataLocation = SummationProblemTest.class.getClassLoader().getResource("sum/dataset1.txt");
        if (dataLocation == null)
            throw new RuntimeException("dataset1.txt could not be found");

        final int ROWS = 100_000;
        Scanner in = new Scanner(Path.of(dataLocation.getPath()), StandardCharsets.UTF_8);
        int[] temp = new int[ROWS];
        for (int i = 0; i < ROWS; i++) {
            temp[i] = Integer.parseInt(in.nextLine());
        }
        return temp;
    }
}
