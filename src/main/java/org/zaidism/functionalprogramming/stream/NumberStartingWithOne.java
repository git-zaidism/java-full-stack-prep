import java.util.Arrays;
import java.util.List;

public class NumberStartingWithOne {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 10, 15, 8, 49, 25, 98, 32);

        integerList
                .stream()
                .map(s -> s + "") // convert integer to string
                .filter(s -> s.startsWith("1"))
                .map(Integer::parseInt) // convert string back to integer
                .forEach(System.out::println);
    }
}
