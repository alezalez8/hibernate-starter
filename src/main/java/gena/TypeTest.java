package gena;

import java.util.Collections;
import java.util.Comparator;

public class TypeTest {
    public static void main(String[] args) {
        Comparator<String> c1 = Comparator.comparing(String::length).reversed();
       // Comparator<String> c2 = Comparator.comparing(s -> s.length()).reversed();
        Comparator<String> c3 = Collections.reverseOrder(Comparator.comparing(s -> s.length()));
    }
}
