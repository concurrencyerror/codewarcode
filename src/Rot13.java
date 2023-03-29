import java.util.Arrays;

/**
 * Rot13编码解码
 */
public class Rot13 {
    public static String rot13(String message) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if ((c >= 'a' && c < 'n') || (c >= 'A' && c < 'N')) {
                c = (char) (c + 13);
            } else if ((c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z')) {
                c = (char) (c - 13);
            }
            builder.append(c);
        }
        return builder.toString();
    }

}
