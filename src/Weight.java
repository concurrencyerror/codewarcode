import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Weight {
    public static String orderWeight(String strng) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        Arrays.stream(strng.split(" ")).forEach(item -> {
            AtomicInteger integer = new AtomicInteger();
            for (int i = 0; i < item.length(); i++) {
                integer.addAndGet(Integer.parseInt(String.valueOf(item.charAt(i))));
            }
            if (map.containsKey(integer.get())) {
                map.computeIfPresent(integer.get(), (k, v) -> {
                    v.add(item);
                    v.sort((s1, s2) -> {
                        int length = Math.min(s1.length(), s2.length());
                        for (int i = 0; i < length; i++) {
                            int v1 = Integer.parseInt(String.valueOf(s1.charAt(i)));
                            int v2 = Integer.parseInt(String.valueOf(s2.charAt(i)));
                            int compare = Integer.compare(v1, v2);
                            if (compare != 0) {
                                return compare;
                            }
                        }
                        return Integer.compare(s1.length(), s2.length());
                    });
                    return v;
                });
            } else {
                map.computeIfAbsent(integer.get(), k -> {
                    LinkedList<String> list = new LinkedList<>();
                    list.add(item);
                    return list;
                });
            }
        });
        return map.values().stream().flatMap(Collection::stream).reduce((v1, v2) -> v1 + " " + v2).orElse("");
    }

    public static void main(String[] args) {
//        System.out.println(orderWeight("200 2 4 4 6 7 7 22 123"));
        Stream.of("200", "2", "2").sorted((s1, s2) -> {
            int length = Math.min(s1.length(), s2.length());
            for (int i = 0; i < length; i++) {
                int v1 = Integer.parseInt(String.valueOf(s1.charAt(i)));
                int v2 = Integer.parseInt(String.valueOf(s2.charAt(i)));
                int compare = Integer.compare(v1, v2);
                if (compare != 0) {
                    return compare;
                }
            }
            return Integer.compare(s1.length(), s2.length());
        }).forEach(System.out::println);
    }
}
