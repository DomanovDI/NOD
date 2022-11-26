import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] d = {5, 10};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = d[0]; i <= d[1]; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i % j) == 0) {
                    list.add(j);
                }
            }
        }

        Map<Integer,Long> nodMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        nodMap.entrySet().stream()
                .filter(e -> e.getValue() == d[1] - d[0] + 1)
                .max(Comparator.comparingInt(Map.Entry::getKey)).ifPresent(e -> System.out.println(e.getKey()));
    }
}
