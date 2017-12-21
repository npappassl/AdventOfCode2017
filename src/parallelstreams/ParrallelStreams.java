package parallelstreams;

import java.util.*;
import java.util.stream.IntStream;

public class ParrallelStreams {

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        Generator generator = new Generator();

        Optional<Integer> max = getMaxFromRandomIntegers(10, generator);
        Optional<String> maxString = max.map(i -> i.toString());

        System.out.println("max value is " + maxString.orElse("[no values]"));

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: "+(endTime-startTime));
    }

    private static Optional<Integer> getMaxFromRandomIntegers(int n, Generator g) throws Exception {
        return IntStream.range(0,10).parallel().mapToObj(x->g.getNextInt()).max(Comparator.naturalOrder());
    }

}
class Generator {

    private Random r = new Random(234L);

    Integer getNextInt() {
        try {
            Thread.sleep(1000L);
            return r.nextInt(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
