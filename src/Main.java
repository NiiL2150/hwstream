import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static Stream<String> stream1(){
        List<String> list = new ArrayList<>();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a1");
        list.add("a4");
        list.add("a5");
        list.add("a1");
        return list.stream();
    }

    static Stream<Integer> stream2(){
        Integer[] array = {1, 2, 3, 4, 5};
        return Arrays.stream(array);
    }

    static Stream<String> stream3(){
        return Stream.of("Nail", "Kanan", "Dmitry", "Javid", "Kanan");
    }

    public static void main(String[] args) {
        System.out.println(stream1().filter(e -> e.equals("a1")).count());

        System.out.println();

        if (stream1().anyMatch(i -> Objects.equals(i, "a3"))) {
            IntStream.range(0, stream1().toArray().length).forEach(i -> {
                if (stream1().toArray()[i] == "a3") {
                    System.out.println(i);
                }
            });
        } else {
            System.out.println("Not found");
        }

        System.out.println();

        System.out.println(stream1().reduce((first, second) -> second).orElse("empty"));
        System.out.println(stream1().skip(stream1().count()-1).findFirst().orElse("empty"));

        System.out.println(stream1().skip(1).limit(2).collect(Collectors.toList()));

        System.out.println(stream3().distinct().mapToInt(String::length).average().orElse(0));

        System.out.println(stream3().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList()));

        System.out.println(stream2().filter(n -> n % 2 != 0).reduce(Integer::sum).orElse(0));
    }
}