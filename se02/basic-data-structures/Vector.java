import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        List<Integer> V = new ArrayList<>();
        System.out.println(V.size());

        // adding elements...
        for (int i = 3; i >= 0; i--)
            V.add(i);

        System.out.println(V.size());

        // removing from index

        // To NOT confuse: when dealing with a collection of integers,
        // it's easy to see something unexpected on methods based on index
        // because we might want to refer to the element stored but the JVM
        // understans that we want to refer to an index. To avoid misunderstanding,
        // use Integer.valueOf(int v) to refer to the actual element!
        System.out.println(V);
        V.remove(3);
        System.out.println(V);

        System.out.println(V);
        Collections.sort(V);
        System.out.println(V);
    }
}
