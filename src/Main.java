import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        System.out.println(rgb(-20, 275, 125));
        System.out.println(Integer.parseInt("0e", 16));
//        System.out.println(Integer.toHexString(275));
    }

    /**
     * end word
     * 判断出第二个参数是否在第一个字符串的最后
     *
     * @param str    第一个原始字符串
     * @param ending 第二个小的结束字符串
     * @return 返回判断结果
     */
    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }

    /**
     * 一句话中最短的单词的字母数量是多少
     *
     * @param s 某一句话
     * @return 字母的数量
     */
    public static int findShort(String s) {
        String[] strings = s.split(" ");
        return Arrays.stream(strings).mapToInt(String::length).min().orElse(0);
    }

    /**
     * 找出一个数组中不同的那个数字
     *
     * @param arr 目标数组
     * @return 不同的那个数字
     */
    public static double findUniq(double[] arr) {
        HashSet<Double> set = new HashSet<>();
        AtomicReference<Double> result = new AtomicReference<>((double) 0);
        Arrays.stream(arr).limit(3).forEach(item -> {
            if (!set.add(item)) {
                result.set(item);
            }
        });
        Double aDouble = result.get();
        return Arrays.stream(arr).distinct().filter(item -> item != aDouble).findAny().orElse(0);
    }

    /**
     * 找出最大的数字
     *
     * @param array 目标数组
     * @return 返回内容
     */
    public static int adjacentElementsProduct(int[] array) {
        return IntStream.range(1, array.length).map(i -> array[i - 1] * array[i]).max().orElse(0);
    }

    /**
     * 去掉多余的单词
     *
     * @param s 目标语句
     * @return 去重后的目标语句
     */
    public static String removeDuplicateWords(String s) {
        return Arrays.stream(s.split(" ")).distinct().reduce((v1, v2) -> v1 + " " + v2).orElse("");
    }

    /**
     * rgb16进制转换
     * @param r
     * @param g
     * @param b
     * @return
     */
    public static String rgb(int r, int g, int b) {
        StringBuilder builder = new StringBuilder();
        change(r, builder);
        change(g, builder);
        change(b, builder);
        return builder.toString().toUpperCase();
    }

    private static void change(int num, StringBuilder builder) {
        if (num <= 0) {
            builder.append("00");
        } else if (num > 255) {
            builder.append("FF");
        } else if (num < 16) {
            builder.append("0").append(Integer.toHexString(num));
        } else {
            builder.append(Integer.toHexString(num));
        }
    }
}