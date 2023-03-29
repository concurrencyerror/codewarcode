import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 回溯算法遍历组合
 */
public class Permutations {
    public static List<String> singlePermutations(String s) {
        HashSet<String> set = new HashSet<>();
        backTrace(new StringBuilder(), s, set, 0);
        return new ArrayList<>(set);
    }

    private static void backTrace(StringBuilder builder, String s, Set<String> set, int index) {
        if (builder.length() == s.length()) {
            set.add(builder.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == index) {
                continue;
            }
            char c = s.charAt(i);
            builder.append(c);
            backTrace(builder, s, set, i);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
